package com.platzigram.login.presenter;

public interface LoginPresenter {

    //interactor
    void sigIn(String username, String password);
    void logInSucces();
    void logInError(String error);




}
