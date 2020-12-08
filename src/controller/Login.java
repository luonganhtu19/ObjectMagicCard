package controller;

import model.ENUM_STATIC;

import java.io.IOException;

public class Login {
    public static void login() throws IOException {
        System.out.println(" UserName: ");
        String userName= ENUM_STATIC.getINPUT().nextLine();
        System.out.println("Password");
        String passWord= ENUM_STATIC.getINPUT().nextLine();
        boolean login=LoginAccount.getCheck(userName,passWord);
        if (login){
            System.out.println("Welcome");
            String threadName = Thread.currentThread().getName();
            LoginChangeStateAccount.oneAccountIsExist(threadName);
        }else {
            System.out.println("please try again");
        }
    }
}
