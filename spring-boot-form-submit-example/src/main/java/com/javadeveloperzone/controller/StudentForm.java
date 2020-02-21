package com.javadeveloperzone.controller;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.SafeHtml;

public class StudentForm {

	@SafeHtml
    @NotNull
    @Size(min=2, max=50)
    private String name;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}