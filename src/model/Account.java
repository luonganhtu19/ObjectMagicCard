package model;

import controller.IOFileController;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private String userName;
    private String passWork;
    private int idAccount;
    private volatile String state;
    private static List<String> listAccount=new ArrayList<String>();

    private Account() {};

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWork() {
        return passWork;
    }

    public void setPassWork(String passWork) {
        this.passWork = passWork;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        idAccount = idAccount;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    private static void getList() throws IOException {
        String path=ENUM_STATIC.getPath()+ENUM_STATIC.getFileAccount();
        IOFileController.readerFile(path,listAccount);
    }
    public static List<String> getListAccount() throws IOException {
        getList();
        return listAccount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userName='" + userName + '\'' +
                ", passWork='" + passWork + '\'' +
                '}';
    }
}
