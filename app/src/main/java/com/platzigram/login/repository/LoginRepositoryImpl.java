package com.platzigram.login.repository;

import com.platzigram.login.presenter.LoginPresenter;

public class LoginRepositoryImpl implements LoginRepository {

    LoginPresenter loginPresenter;

    public LoginRepositoryImpl(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }

    @Override
    public void signIn(String username, String password) {

        boolean success=true;

        if(success){

            loginPresenter.logInSucces();

        }else{

            loginPresenter.logInError("error");
        }

    }
}
