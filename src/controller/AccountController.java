package controller;

import model.Account;
import model.ENUM_STATIC;
import view.DisplayConsole;

import java.io.IOException;
import java.util.List;

public class AccountController {
    private static List<String> listAccount;
    private static boolean checkAccount = false;
    private static String path = ENUM_STATIC.getPath() + ENUM_STATIC.getFileAccount();
    private static int positionValue=-1;
    private static Account accountLogin=new Account();

    static {
        try {
            listAccount = Account.getListAccount();
        } catch (IOException e) {
            System.out.println("no exits");
        }
    }

    public static List<String> getListAccount() {
        return listAccount;
    }

    private static void checkAccount(String userName, String password) throws IOException {
        for (int i = 0; i < listAccount.size()-1; i = i + 4) {
            String userNameInList = listAccount.get(i);
            String passWordNameInList = listAccount.get(i + 1);

            if (userNameInList.equals(userName)) {
                if (passWordNameInList.equals(password)) {
                    checkAccount = true;
                    accountLogin.setState(  listAccount.get(i + 2));
                    accountLogin.setIdAccount(Integer.parseInt(listAccount.get(i + 3)));
                }
            }
        }
    };
    public static void createAccount() throws IOException {
        int length= listAccount.size();
        boolean checkUserName=false;

        Account accountPlayer= new Account();
        do {
            String userName=ConsoleController.getString("UserName : ");
            checkUserName=checkExistNameAccount(userName);
            if (checkUserName){
                DisplayConsole.displayAfterChoice("Please input name account, it is exist");
                continue;
            }
            accountPlayer.setUserName(userName);
        }while (checkUserName);
        accountPlayer.setPassWord(ConsoleController.getString("PassWord : "));
        accountPlayer.setIdAccount(length/4+1);
        accountPlayer.setState("Off");
        listAccount.add(accountPlayer.getUserName());
        listAccount.add(accountPlayer.getPassWord());
        listAccount.add(accountPlayer.getState());
        listAccount.add(accountPlayer.getIdAccount()+"");
        IOFileController.writeFile(accountPlayer,path);
        DisplayConsole.displayAfterChoice("Create account success ");
    }
    private static boolean checkExistNameAccount(String nameAccount){
        boolean checkExist=false;
            for (int i = 0; i < listAccount.size(); i=i+4) {
                if (nameAccount.equals(listAccount.get(i))){
                    checkExist=true;
                }
            }
            return checkExist;
    }
    public static int getIdAccount() {
        return accountLogin.getIdAccount();
    }
    public static boolean isCheck() {
        return checkAccount;
    }
    public static void login() throws IOException {
        String userName = ConsoleController.getString(" UserName: ");
        String passWord = ConsoleController.getString(" Password: ");
        checkAccount(userName, passWord);
        boolean login = checkAccount;
        if (login) {
            DisplayConsole.displayAfterChoice("Welcome " + userName);
            accountLogin.setUserName(userName);
            accountLogin.setPassWord(passWord);
            positionValue = accountLogin.getIdAccount() * 4 - 2;
            IOFileController.editFile(path, listAccount, "On", positionValue);
        } else {
            DisplayConsole.displayAfterChoice(" Please login try again ");
        }
    }
    public static void exit() throws IOException {
        IOFileController.editFile(path,listAccount,"Off",positionValue);
        DisplayConsole.displayAfterChoice("Bye bye ");
    }
    public static void deleteAccount(int idAccount) throws IOException {
        int indexMax=idAccount*4-1;
        if (idAccount==1) {
            DisplayConsole.displayAfterChoice("Fail because not delete account of admin ");
        }
        for (int i = indexMax; i >indexMax-4; i--) {
            listAccount.remove(i);
        }
        for (int i = idAccount*4-1; i < listAccount.size(); i=i+4) {
            int newIDAccount=Integer.parseInt(listAccount.get(i));
            listAccount.remove(i);
            listAccount.add(i, newIDAccount-1+"");

        }
        IOFileController.writeFile(path,listAccount);
        DisplayConsole.displayAfterChoice("Delete account success");
    }
    public static void displayAccount(int indexAccount_edit){
        Account.updateListString();
        String account=Account.toString(indexAccount_edit);
        DisplayConsole.displayAfterChoice(account," Account edit");
    }
    public static void editNameAccount( int indexAccount_edit) throws IOException {
        String newNameAccount="";
        boolean checkNewNameAccount=true;
        do {
            newNameAccount=ConsoleController.getString("New name account");
            checkNewNameAccount=checkExistNameAccount(newNameAccount);
            if (checkNewNameAccount) System.out.println("Name Account is exist, please try again");
        }while (checkNewNameAccount);
        listAccount.remove(indexAccount_edit-3);
        listAccount.add(indexAccount_edit-3,newNameAccount);
        IOFileController.writeFile(path,listAccount);
    }
    public static void editPasswordAccount( int indexAccount_edit) throws IOException {
        String newPasswordAccount=ConsoleController.getString("New  password account");
        listAccount.remove(indexAccount_edit-2);
        listAccount.add(indexAccount_edit-2,newPasswordAccount);
        IOFileController.writeFile(path,listAccount);
    }
    public static void editSateAccount( int indexAccount_edit) throws IOException {
        String newStateAccount=ConsoleController.getString("New  state account");
        listAccount.remove(indexAccount_edit-1);
        listAccount.add(indexAccount_edit-1,newStateAccount);
        IOFileController.writeFile(path,listAccount);
    }
}
