package com.skyprolesson.exception;

import com.skyprolesson.exception.exceptions.WrongLoginException;
import com.skyprolesson.exception.exceptions.WrongPasswordException;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PasswordService implements PasswordInterface {

    @Override
    public boolean checkLogin(String login) {

        if (login == null || login.length() > 20) {
            return false;
        }
        String regex = "\\w{0,19}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(login);

        return m.matches();
    }

    @Override
    public boolean checkPassword(String password) {
        if (password == null || password.length() > 20) {
            return false;
        }
        String regex = "\\w{0,19}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(password);

        return m.matches();


    }

    @Override
    public boolean checkConfirmPassword(String password, String confirmPassword) {

        return password.equals(confirmPassword);

    }


}
