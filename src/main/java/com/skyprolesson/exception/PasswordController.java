package com.skyprolesson.exception;


import com.skyprolesson.exception.exceptions.WrongLoginException;
import com.skyprolesson.exception.exceptions.WrongPasswordException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/check")
@RestController
public class PasswordController {
    public final PasswordInterface passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @GetMapping
    public String checkingPassword(@RequestParam(required = false) String login, @RequestParam(required = false) String password, @RequestParam(required = false) String confirm) throws WrongPasswordException, WrongLoginException{

        try {
            if (!passwordService.checkLogin(login)) {
                throw new WrongLoginException();
            }

            if (!passwordService.checkPassword(password) || !passwordService.checkConfirmPassword(password, confirm)) {
                throw new WrongPasswordException();
            }


        } catch (WrongLoginException e) {

            return "Неверный логин";

        } catch (WrongPasswordException e) {

            return "Проверьте правильность пароля";

        }

        return "Всё хорошо...";


    }
}
