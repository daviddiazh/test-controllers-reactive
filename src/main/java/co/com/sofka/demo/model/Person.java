package co.com.sofka.demo.model;

import java.io.Serializable;

public class Person implements Serializable {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
