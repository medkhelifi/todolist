package com.medkhelifi.tutorials.todolist.util;

import java.io.IOException;

class MyClass {


    int divide(int a, int b) throws NullPointerException{
        if(a==1)
            throw new NullPointerException("IOException Occurred");
        return a/b;
    }

}
