package com.platzigram.login.interactor;

import com.platzigram.login.presenter.LoginPresenter;
import com.platzigram.login.repository.LoginRepository;
import com.platzigram.login.repository.LoginRepositoryImpl;

public class LoginInteractorImpl implements LoginInteractor {

    LoginPresenter loginPresenter;
    LoginRepository loginRepository;

    public LoginInteractorImpl(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;

        loginRepository= new LoginRepositoryImpl(loginPresenter);
    }

    @Override
    public void sigIn(String username, String password) {
        loginRepository.signIn(username, password);
    }
}
