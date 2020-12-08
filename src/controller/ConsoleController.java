package controller;

import model.ENUM_STATIC;

public class ConsoleController {
    public static String getString(String mess){
        System.out.println(mess);
        String valueInput =ENUM_STATIC.getINPUT().nextLine();
        return valueInput;
    }

    public static Integer getInt(String mess){
        int valueNumber=0;
        while (true) {
            try {
                System.out.println("");
                String number=getString(mess);
                 valueNumber = Integer.parseInt(number);
                 break;
            } catch (Exception e) {
                System.out.println("Please try again");
            }
        }
        return valueNumber;
    }
}
