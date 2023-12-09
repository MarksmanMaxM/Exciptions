package com.skyprolesson.exception;

public interface PasswordInterface {
    boolean checkLogin(String login);
    boolean checkPassword(String password);
    boolean checkConfirmPassword(String password, String confirmPassword);



}
