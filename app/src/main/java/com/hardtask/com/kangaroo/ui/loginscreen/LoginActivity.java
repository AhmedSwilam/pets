package com.hardtask.com.kangaroo.ui.loginscreen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hardtask.com.kangaroo.R;
import com.hardtask.com.kangaroo.ui.register.RegisterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {


    public static final String MyPREFERENCES = "MyPrefs";
    @BindView(R.id.et_login_phone)
    EditText etLoginPhone;
    @BindView(R.id.et_login_password)
    EditText etLoginPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.txt_forgot)
    TextView txtForgot;
    @BindView(R.id.txt_click_her)
    TextView txtClickHer;
    @BindView(R.id.txt_register)
    TextView txtRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.txt_register)
    void goToRegisteration(){
        startActivity(new Intent(this, RegisterActivity.class));
        finish();
    }

}
