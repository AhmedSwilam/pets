package com.hardtask.com.kangaroo.ui.register;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hardtask.com.kangaroo.R;
import com.hardtask.com.kangaroo.ui.verifyuser.VerifyUserActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    private String codeSent;
    @BindView(R.id.et_register_name)
    EditText etRegisterName;
    @BindView(R.id.et_register_phone)
    EditText etRegisterPhone;
    @BindView(R.id.et_register_password)
    EditText etRegisterPassword;
    @BindView(R.id.btn_register)
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        etRegisterPhone.setText("+2");
        Selection.setSelection(etRegisterPhone.getText(), etRegisterPhone.getText().length());
        etRegisterPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().startsWith("+2")) {
                    etRegisterPhone.setText("+2");
                    Selection.setSelection(etRegisterPhone.getText(), etRegisterPhone.getText().length());
                }
            }
        });
    }

    //put+2 in edit text
    public void countryCode() {

    }

    @OnClick(R.id.btn_register)
    void getAuthNumber() {
        String phoneNumber = etRegisterPhone.getText().toString();
        String userName = etRegisterName.getText().toString();
        String password = etRegisterPassword.getText().toString();

        if (userName.isEmpty()) {
            etRegisterName.setError("Enter your Name");
            etRegisterName.requestFocus();
            return;
        }
        if (phoneNumber.isEmpty()) {
            etRegisterPhone.setError("Enter your Phone Number");
            etRegisterPhone.requestFocus();
            return;
        }
        if (phoneNumber.length() < 11) {
            etRegisterPhone.setError("Enter Valid Phone Number");
            etRegisterPhone.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            etRegisterPassword.setError("Enter your Password");
            etRegisterPassword.requestFocus();
            return;
        }

        Toast.makeText(this, "code has been sent", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, VerifyUserActivity.class);
        intent.putExtra("phoneNumber", phoneNumber);
        intent.putExtra("userName", userName);
        intent.putExtra("password", password);
        intent.putExtra("codeSent", codeSent);
        startActivity(intent);
        finish();
    }


}
