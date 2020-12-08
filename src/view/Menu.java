package view;

import controller.AccountController;
import model.Account;

import java.io.IOException;

public class Menu {
    private static boolean state=true;

    public static void main(String[] args) throws IOException {
        do {
            System.out.println("Welcome Magic Card");
            System.out.println("1. Login");
            AccountController.login();
            state=AccountController.isCheck();
        }while (!state);
     if (AccountController.getIdAccount()==1){
         menuAdmin();
     }else {
         menuPlayer();
     }
    }
    private static void menuAdmin(){
        do {
            System.out.println("Menu for Admin");
            System.out.println("1. Create Account");
            System.out.println("2. Delete Account");
            System.out.println("0. Exit");
        }while (true);
    }
    private static void menuPlayer(){
        do {
            System.out.println("Menu for Admin");
            System.out.println("1. Play Game");
            System.out.println("2. Information of player");
            System.out.println("0. Exit");
        }while (true);
    }
}
