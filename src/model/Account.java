package model;

public class Account {
    private String userName;
    private String passWork;
    private int idAccount;
    private volatile String state;

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

    @Override
    public String toString() {
        return "Account{" +
                "userName='" + userName + '\'' +
                ", passWork='" + passWork + '\'' +
                '}';
    }
}
