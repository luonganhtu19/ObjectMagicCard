package model;

import controller.CheckExistFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountList {
    private static List<String> listAccount=new ArrayList<String>();
    private static boolean checkExist;

    private static void getList() throws IOException {
        String path = ENUM_STATIC.getPath() + ENUM_STATIC.getFileAccount();
         checkExist = CheckExistFile.checkExistFile(path);
        if (!checkExist) {
            System.out.println("please check file");
            return;
        };
        FileReader fileReaderAccount = new FileReader(new File(path));
        BufferedReader bufferedReaderAccount = new BufferedReader(fileReaderAccount);
        String line=null;
        while ((line=bufferedReaderAccount.readLine())!=null){
            String[] account=line.split(ENUM_STATIC.getCommaDelimiter());
            for (String s : account) {
                listAccount.add(s);
            }
        }
        bufferedReaderAccount.close();
    }
    public static List<String> getListAccount() throws IOException {
        getList();
        return listAccount;
    }

    public static boolean isCheckExist() {
        return checkExist;
    }
}
