package com.platzigram.login.presenter;

import android.text.Layout;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.platzigram.login.interactor.LoginInteractor;
import com.platzigram.login.interactor.LoginInteractorImpl;
import com.platzigram.login.view.LoginView;

public class LoginPresenterImpl implements LoginPresenter {

    LoginView loginView;
    LoginInteractor loginInteractor;


    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;

        loginInteractor=new LoginInteractorImpl(this);
    }

    @Override
    public void sigIn(String username, String password) {

        loginView.disabledInputs();
        loginView.showProgressBar();

        loginInteractor.sigIn(username, password);
    }

    @Override
    public void logInSucces() {

        loginView.enabledInputs();
        loginView.hideProgressBar();

        loginView.goHomePage();
    }

    @Override
    public void logInError(String error) {

    }
}
