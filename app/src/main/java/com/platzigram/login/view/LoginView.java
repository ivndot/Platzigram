package com.platzigram.login.view;

import android.view.View;

public interface LoginView {

    void goCreateAccount(View view);
    void goHomePage();
    void goPlatziPage(View view);

    void enabledInputs();
    void disabledInputs();

    void showProgressBar();
    void hideProgressBar();

    void logInError(String error);

}
