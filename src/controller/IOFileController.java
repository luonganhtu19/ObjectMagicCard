package controller;

import model.ENUM_STATIC;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IOFileController {
    private static boolean checkFile=true;
    private static void checkExistFile(String path){
        File file=new File(path);
        if (!file.exists()) checkFile=false;
    }
    public static void readerFile(String path,List<String> list ) throws IOException {
        checkExistFile(path);
        if (!checkFile) return;
        FileReader fileReader=new FileReader(new File(path));
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String line=null;
        while ((line= bufferedReader.readLine())!=null){
            String[] account=line.split(ENUM_STATIC.getCommaDelimiter());
            for (String s: account){
                list.add(s);
            }
        }
        bufferedReader.close();
    }
    public static void editFile(String path, List<String> list,String newValue, int positionValue) throws IOException {
        list.remove(positionValue);
        list.add(positionValue,newValue);
        writeFile(path,list);
    }
    private static void writeFile(String  path, List<String> list) throws IOException {
        FileWriter fileWriter= new FileWriter(new File(path));
        for (int i = 0; i < list.size(); i++) {
            if (i%4==3){
                fileWriter.write(list.get(i));
                fileWriter.write(ENUM_STATIC.getNewLineSeparator());
            }else {
                fileWriter.write(list.get(i));
                fileWriter.write(ENUM_STATIC.getCommaDelimiter());
            }
        }
        fileWriter.close();
    }
}
