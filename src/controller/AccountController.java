package controller;

import model.Account;
import model.ENUM_STATIC;

import java.io.IOException;
import java.util.List;

public class AccountController {

    private static List<String> listAccount;
    private static boolean check = false;
    private static String stateAccount = "";
    private static String idAccount = "0";
    private static String path = ENUM_STATIC.getPath() + ENUM_STATIC.getFileAccount();

    static {
        try {
            listAccount = Account.getListAccount();
            System.out.println(listAccount.size());
        } catch (IOException e) {
            System.out.println("no exits");
        }
    }

    private static void checkAccount(String userName, String password) throws IOException {
        for (int i = 0; i < listAccount.size(); i = i + 4) {
            String userNameInList = listAccount.get(i);
            String passWorkNameInList = listAccount.get(i + 1);

            if (userNameInList.equals(userName)) {
                if (passWorkNameInList.equals(password)) {
                    check = true;
                    stateAccount = listAccount.get(i + 2);
                    idAccount = listAccount.get(i + 3);
                }
            }
        }
    };

    public static void createAccount() throws IOException {
        int length= listAccount.size();

        Account account= new Account();
        account.setUserName(ConsoleController.getString("UserName : "));
        account.setPassWork(ConsoleController.getString("PassWork : "));
        account.setIdAccount(length/4+1);
        account.setState(ConsoleController.getString("State"));
        IOFileController.writeFile(account,path);
    }

    public static int getIdAccount() {
        return Integer.parseInt(idAccount);
    }

    public static boolean isCheck() {
        return check;
    }

    public static void login() throws IOException {
        String userName = ConsoleController.getString(" UserName: ");
        String passWord = ConsoleController.getString(" Password: ");
        checkAccount(userName, passWord);
        boolean login = check;
        if (login) {
            System.out.println("");
            System.out.println("Welcome " + userName);
            Account account = new Account(userName, passWord, stateAccount,idAccount);
            int positionValue = Integer.parseInt(idAccount) * 4 - 2;
            IOFileController.editFile(path, listAccount, "On", positionValue);
        } else {
            System.out.println("please try again");
        }
    }


}
