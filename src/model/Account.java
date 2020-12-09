package model;

import controller.IOFileController;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private String userName;
    private String passWord;
    private int idAccount;
    private volatile String state;
    private static List<String> listAccount = new ArrayList<String>();

    public  Account() {};
    public Account(String userName, String passWord,String state ,String idAccount ) {
        this.userName = userName;
        this.passWord = passWord;
        this.idAccount =Integer.parseInt(idAccount);
        this.state = state;
    };

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    private static void getList() throws IOException {
        String path = ENUM_STATIC.getPath() + ENUM_STATIC.getFileAccount();
        IOFileController.readerFile(path, listAccount);
    }

    public static List<String> getListAccount() throws IOException {
        getList();
        return listAccount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
    public static String toString(int idAccount){
        int indexElement=idAccount*4-1;
        return "UserName: " +listAccount.get(indexElement-3)+ "," +
                "PassWord: " +listAccount.get(indexElement-2)+ "," +
                "State: "    +listAccount.get(indexElement-1)+ "," +
                "idAccount: "+listAccount.get(indexElement)  + "," ;
    }
}
