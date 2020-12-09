package view;

import controller.AccountController;
import controller.ConsoleController;
import model.Account;

import java.io.IOException;

public class Menu {
    private static boolean state=true;

    public static void main(String[] args) throws IOException {
       menuMain();
    }
    private static void menuMain() throws IOException {
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
    private static void menuAdmin() throws IOException {
        do {
            System.out.println("Menu for Admin");
            System.out.println("1. Create Account");
            System.out.println("2. Delete Account");
            System.out.println("3. Edit Account");
            System.out.println("0. Exit");

            int choice= ConsoleController.getInt("Choice: ");
            switch (choice){
                case 0:
                    AccountController.exit();
                    System.out.println("");
                    menuMain();
                    return;
                case 1:
                    AccountController.createAccount();
                    break;
                case 2:
                    int idAccount_delete= ConsoleController.getInt("Please input idAccount delete");
                    AccountController.deleteAccount(idAccount_delete);
                    break;
                case 3:
                    int idAccount_edit= ConsoleController.getInt("Please input idAccount edit");
                    int indexAccount_edit=idAccount_edit*4-1;
                    AccountController.displayAccount(indexAccount_edit);
                    editAccount(indexAccount_edit);
                    break;
            }
        }while (true);
    }
    private static void editAccount(int indexIdAccount) throws IOException {
        do {
            System.out.println("Edit account: ");
            System.out.println("1. Edit nameAccount");
            System.out.println("2. Edit PassWord");
            System.out.println("3. Edit State");
            System.out.println("0. Exit ");
            int choice= ConsoleController.getInt("Choice: ");
            switch (choice){
                case 0:
                    System.out.println("");
                    DisplayConsole.displayAfterChoice("Exit edit account");
                    menuAdmin();
                    return;
                case 1:
                    AccountController.editNameAccount(indexIdAccount);
                    DisplayConsole.displayAfterChoice("Success change name account");
                    break;
                case 2:
                    AccountController.editPasswordAccount(indexIdAccount);
                    DisplayConsole.displayAfterChoice("Success change password account");
                    break;
                case 3:

                    AccountController.editSateAccount(indexIdAccount);
                    DisplayConsole.displayAfterChoice("Success change state account");
                    break;
                default:
                    System.out.println("please try again choice menu");
            }
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
