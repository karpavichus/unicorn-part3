package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class User {
    private String name;
    private Integer age;
    private Boolean gender;
    private Integer height;
    private Integer weight;

    public User() {
        this.name = "";
        this.age = 0;
        this.gender = true;
        this.height = 0;
        this.weight = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public User(String name, Integer age, Boolean gender, Integer height, Integer weight) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }

    public static User getOldest(ArrayList<User> usersList) {
        usersList.sort((o1, o2) -> {
            if (o1.age > o2.age) return 1;
            if (o1.age == o2.age) return 0;
            return -1;
        });
        return usersList.get(usersList.size() - 1);
    }

    public static User getHighest(ArrayList<User> usersList) {
        usersList.sort((o1, o2) -> {
            if (o1.height > o2.height) return 1;
            if (o1.height == o2.height) return 0;
            return -1;
        });
        return usersList.get(usersList.size() - 1);
    }

    public static User getBiggest(ArrayList<User> usersList) {
        usersList.sort((o1, o2) -> {
            if (o1.weight > o2.weight) return 1;
            if (o1.weight == o2.weight) return 0;
            return -1;
        });
        return usersList.get(usersList.size() - 1);
    }

    public static ArrayList<User> getUsersWithNameContainsString(ArrayList<User> userList, String subString) {
        ArrayList<User> resultUsers = new ArrayList<User>(userList.size());
        for (User element : userList)
            if (element.name.contains(subString)) resultUsers.add(element);
        return resultUsers;
    }

    public String toString() {
        String genderString;
        if (gender) genderString = "man";
        else genderString = "woman";

        return "Name: " + this.name + "\n" +
                "Age: " + this.age.toString() + "\n" +
                "Gender: " + genderString + "\n" +
                "Height: " + this.height.toString() + "\n" +
                "Weight: " + this.weight.toString() + "\n";

    }

}
