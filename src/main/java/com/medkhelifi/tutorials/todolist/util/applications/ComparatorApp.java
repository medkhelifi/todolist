package com.medkhelifi.tutorials.todolist.util.applications;


import java.util.Arrays;
import java.util.Comparator;

class Person {
    private int age;
    private String name;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class PersonComparator implements Comparator<Person> {

    public int compare( Person a, Person b ) {
        if (a.getAge() == b.getAge() ) {
            return ( a.getName().compareTo( b.getName() ) );
        }
        return  (a.getAge() < b.getAge()) ? -1 : 1;
    }
}

public class ComparatorApp {
    public static void main (String[] args){
        //ARRAYS SORT
        Person[] people = new Person[]{
                new Person("Mark", 56),
                new Person("Bled", 76),
                new Person("Klair", 23),
                new Person("Jhon", 1),
        };

        Arrays.sort( people, new PersonComparator() );
        for (Person item:people){
            System.out.println(item.getName());
        }

    }
}
