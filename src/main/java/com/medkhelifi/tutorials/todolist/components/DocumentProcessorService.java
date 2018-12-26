package com.medkhelifi.tutorials.todolist.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentProcessorService {

    @Autowired
    DocumentProcessor typeXDocumentProcessor;

    @Autowired
    DocumentProcessor typeYDocumentProcessor;

    @Autowired
    DocumentProcessor typeZDocumentProcessor;

    public DocumentProcessor getDocumentProcessor(DocumentType docType) {
        switch (docType) {
            case TYPE_X:
                return typeXDocumentProcessor;
            case TYPE_Y:
                return typeYDocumentProcessor;
            case TYPE_Z:
                return typeZDocumentProcessor;
            default:
                return null;
        }
    }
}

