package com.platzigram.login.view;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.platzigram.R;
import com.platzigram.login.presenter.LoginPresenter;
import com.platzigram.login.presenter.LoginPresenterImpl;
import com.platzigram.view.Container;
import com.platzigram.view.Registrer;

public class Login extends AppCompatActivity implements LoginView {

    TextInputEditText edtusername, edtpassword;
    TextInputLayout layoutsername,layoutpassword;
    Button btnlogin;
    ProgressBar progressBarLogin;

    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtusername = findViewById(R.id.edtUsername);
        edtpassword = findViewById(R.id.edtPassword);
        btnlogin = findViewById(R.id.btnLogin);
        progressBarLogin = findViewById(R.id.progresBarLogin);

        layoutsername= findViewById(R.id.layoutUsername);
        layoutpassword=findViewById(R.id.layoutPassword);

        hideProgressBar();

        loginPresenter = new LoginPresenterImpl(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (!edtusername.getText().toString().isEmpty() && !edtpassword.getText().toString().isEmpty()) {

                    loginPresenter.sigIn(edtusername.getText().toString(), edtpassword.getText().toString());
                    //hola mundo
                }


                if (edtusername.getText().toString().isEmpty()) {

                    layoutsername.setError("Llena este campo");



                }else{
                    layoutsername.setErrorEnabled(false);

                }

                if (edtpassword.getText().toString().isEmpty()) {

                    layoutpassword.setError("Llena este campo");

                }else{
                    layoutpassword.setErrorEnabled(false);

                }


            }
        });

    }


    @Override
    public void goCreateAccount(View view) {
        Intent intent = new Intent(this, Registrer.class);
        startActivity(intent);
    }

    @Override
    public void goHomePage() {
        Intent intent = new Intent(this, Container.class);
        startActivity(intent);
    }

    @Override
    public void goPlatziPage(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://platzi.com/"));
        startActivity(intent);
    }

    @Override
    public void enabledInputs() {

        edtusername.setEnabled(true);
        edtpassword.setEnabled(true);
        btnlogin.setEnabled(true);
    }

    @Override
    public void disabledInputs() {

        edtusername.setEnabled(false);
        edtpassword.setEnabled(false);
        btnlogin.setEnabled(false);
    }

    @Override
    public void showProgressBar() {
        progressBarLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBarLogin.setVisibility(View.GONE);
    }

    @Override
    public void logInError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

}
