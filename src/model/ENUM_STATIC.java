package model;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public final class   ENUM_STATIC {
    private final static Scanner INPUT = new Scanner(System.in);
    private final static String path = "dataBase/";
    private final static String fileAccount="ListAccount.csv";
    private final static String COMMA_DELIMITER=",";


    public static Scanner getINPUT() {
        return INPUT;
    }
    public static String getPath() {
        return path;
    }
    public static String getFileAccount() {
        return fileAccount;
    }

    public static String getCommaDelimiter() {
        return COMMA_DELIMITER;
    }

    enum State{
        ON,OFF,DEL,SYS;
    }
}
