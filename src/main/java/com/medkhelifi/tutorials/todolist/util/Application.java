package com.medkhelifi.tutorials.todolist.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.medkhelifi.tutorials.todolist.util.MyClass;


public class Application {


    public static void main (String[] args) {
        //||
        // I/O
        FileInputStream fr = null;
        FileOutputStream fw = null;
        Byte[] bytes = {34, 56, 54};
        try{
            fr = new FileInputStream("src/input.txt");
            int c;
            String content = "";
            while((c = fr.read())!=-1){
                content += (char) c;
            }
            System.out.println(content);
        }catch (IOException ex){}





        MyClass myClass = new MyClass();
        myClass.divide(98,0);
        try {
            myClass.divide(78,98);
        }catch (ArithmeticException ex ){
            System.out.println(ex.getMessage());
        }
        System.out.println("After Throws");
    }


}

