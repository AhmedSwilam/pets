package com.hardtask.com.kangaroo.ui.verifyuser;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.hardtask.com.kangaroo.POJO.newuser.RegisterNewUser;
import com.hardtask.com.kangaroo.R;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VerifyUserActivity extends AppCompatActivity implements MessageListener {


    @BindView(R.id.etCode)
    EditText etCode;
    @BindView(R.id.txtuserid)
    TextView txtid;
    @BindView(R.id.btn_verify)
    Button btnVerifyUser;
    private static final String TAG = "VerifyUserActivity";
    private FirebaseAuth firebaseAuth;
    private String userName;
    private String phoneNumber;
    private String password;
    private String codeSent;
    private String fcmToken;
    private String userId;
    public static final String prefUserId = "userId";
    private VerifyUserViewModel verifyUserViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_user);
        ButterKnife.bind(this);
        firebaseAuth = FirebaseAuth.getInstance();
        userName = getIntent().getStringExtra("userName");
        phoneNumber = getIntent().getStringExtra("phoneNumber");
        password = getIntent().getStringExtra("password");
        codeSent = getIntent().getStringExtra("codeSent");
        sendVerificationCode(phoneNumber);
        MessageReceiver.bindListener(this);


    }

    private void sendVerificationCode(String number) {

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                number,
                60,
                TimeUnit.SECONDS,
                this,
                mCallBack
        );

    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
            mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            codeSent = s;
            FirebaseInstanceId.getInstance().getInstanceId()
                    .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                        @Override
                        public void onComplete(@NonNull Task<InstanceIdResult> task) {
                            if (!task.isSuccessful()) {
                                Log.w(TAG, "getInstanceId failed", task.getException());
                                return;
                            }
                            fcmToken = task.getResult().getToken();
                        }
                    });
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            if (code != null) {
                messageReceived(code);

            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            e.printStackTrace();
        }
    };

    /**
     * need for Android 6 real time permissions
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void messageReceived(String message) {
        etCode.setText(message);
    }

    @OnClick(R.id.btn_verify)
    public void postNewUser() {
        String verificationCode = etCode.getText().toString();
        RegisterNewUser newUser = new RegisterNewUser(userName,verificationCode,phoneNumber,password,fcmToken);
        verifyUserViewModel = new ViewModelProvider(this).get(VerifyUserViewModel.class);
        verifyUserViewModel.postNewUser(newUser);
        verifyUserViewModel.newUserMutableLiveData.observe(this, new Observer<RegisterNewUser>() {
            @Override
            public void onChanged(RegisterNewUser registerNewUser) {

                userId = String.valueOf(registerNewUser.getId());
//                SharedPreferences.Editor editor = getSharedPreferences(prefUserId, MODE_PRIVATE).edit();
//                editor.putString("userId", userId);
//                editor.apply();
//                startActivity(new Intent(VerifyUserActivity.this, LoginActivity.class));
            }
        });

    }

}
