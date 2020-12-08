package controller;

import model.AccountList;

import java.io.IOException;
import java.util.List;

public class AccountController {

    private static List<String> listAccount;
    private static boolean check;
    private static String stateAccount;
    private static String idAccount;

    static {
        try {
            listAccount = AccountList.getListAccount();
        } catch (IOException e) {
            System.out.println("no exits");
        }
    }

    private static void checkAccount(String userName, String password) throws IOException {
        if (!AccountList.isCheckExist()) {
            System.out.println("system error");
            return;
        }
        listAccount = AccountList.getListAccount();
        for (int i = 0; i < listAccount.size(); i = i + 4) {
            String userNameInList = listAccount.get(i);
            String passWorkNameInList = listAccount.get(i + 1);

            if (userNameInList.equals(userName)) {
                if (passWorkNameInList.equals(password)){
                    check= true;

                    stateAccount=listAccount.get(i+2);
                    idAccount=listAccount.get(i+3);
                }
                else check=false;
            }
        }
    };


}
