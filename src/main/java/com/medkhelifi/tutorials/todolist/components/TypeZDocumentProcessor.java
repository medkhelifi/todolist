package com.medkhelifi.tutorials.todolist.components;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TypeZDocumentProcessor implements DocumentProcessor {
    @Override
    public void hwoImI() {
        System.out.println("Im typeZDocumentProcessor");
    }

}
