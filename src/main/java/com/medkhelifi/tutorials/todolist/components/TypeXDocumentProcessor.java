package com.medkhelifi.tutorials.todolist.components;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TypeXDocumentProcessor implements DocumentProcessor {

    @Override
    @Qualifier("typeXDocumentProcessor")
    public void hwoImI() {
        System.out.println("Im typeXDocumentProcessor");
    }
}
