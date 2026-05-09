package com.marcusvynicius.appoinment_management.exceptions;

public class NameAndCategoryNotFoundException extends RuntimeException {
    public NameAndCategoryNotFoundException()
    {
        super("Name or Category not found.");
    }
}
