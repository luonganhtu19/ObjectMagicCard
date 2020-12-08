package view;

import controller.Login;

import java.io.IOException;

public class Menu {
    private static boolean state=false;

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome Magic Card");
        System.out.println("1. Login");
        Login.login();
    }

}
