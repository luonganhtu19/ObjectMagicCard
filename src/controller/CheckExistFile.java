package controller;

import java.io.File;

public class CheckExistFile {

    public static boolean checkExistFile(String path){
        File file=new File(path);
        if (!file.exists()) return false;
        return true;
    }
}
