package view;

import model.ENUM_STATIC;

public class DisplayConsole {
    public static void displayAfterChoice(String mess){
        System.out.println("");
        System.out.println(ENUM_STATIC.getStringLine());
        System.out.println(mess);
        System.out.println(ENUM_STATIC.getStringLine());
        System.out.println("");
    }
    public static void displayAfterChoice(String mess,String nameDisplay){
        System.out.println("");
        System.out.println(ENUM_STATIC.getStringLine());
        System.out.println(nameDisplay);
        System.out.println(mess);
        System.out.println(ENUM_STATIC.getStringLine());
        System.out.println("");
    }
}
