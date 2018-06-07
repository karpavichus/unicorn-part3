package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<User> users = new ArrayList<>();
        while (true) {
            System.out.println("--------------------------------------------");
            System.out.println("Create user - 1");
            System.out.println("Get oldest user - 2");
            System.out.println("Get highest user - 3");
            System.out.println("Get biggest user - 4");
            System.out.println("Get list of users which contain string in name - 5");
            System.out.println("Exit - q");
            System.out.println("--------------------------------------------");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String choice = bufferedReader.readLine();
            switch (choice) {
                case "1": {
                    User user = new User();
                    System.out.println("Input name");
                    user.setName(bufferedReader.readLine());

                    try {
                        System.out.println("Input age");
                        user.setAge(Integer.parseInt(bufferedReader.readLine()));
                    } catch (Exception e) {
                        System.out.println("Wrong data!");
                        break;
                    }
                    System.out.println("Input gender: m or w");
                    String gender = bufferedReader.readLine();
                    if (gender.equalsIgnoreCase("w")) user.setGender(false);
                    else if (gender.equalsIgnoreCase("m")) user.setGender(true);
                    else {
                        System.out.println("Wrong data!");
                        break;
                    }

                    try {
                        System.out.println("Input height");
                        user.setHeight(Integer.parseInt(bufferedReader.readLine()));
                    } catch (Exception e) {
                        System.out.println("Wrong data!");
                        break;
                    }

                    try {
                        System.out.println("Input weight");
                        user.setWeight(Integer.parseInt(bufferedReader.readLine()));
                    } catch (Exception e) {
                        System.out.println("Wrong data!");
                        break;
                    }
                    users.add(user);
                    break;
                }
                case "2": {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start();
                    if(users.size()!=0) System.out.println(User.getOldest(users).toString());
                    else System.out.println("List of users is empty!");
                    break;
                }
                case "3": {
                    if(users.size()!=0) System.out.println(User.getHighest(users).toString());
                    else System.out.println("List of users is empty!");
                    break;
                }
                case "4": {
                    if(users.size()!=0) System.out.println(User.getBiggest(users).toString());
                    else System.out.println("List of users is empty!");
                    break;
                }
                case "5": {
                    System.out.println("Input substring");
                    String subString = bufferedReader.readLine();
                    ArrayList<User> resultUsers = User.getUsersWithNameContainsString(users, subString);
                    if(resultUsers.size()==0) System.out.println("Result list is empty!");
                    else {
                        for (User element:resultUsers) System.out.println(element.toString());
                    }
                    break;
                }
                case "q": {
                    return;
                }
                default: {
                    System.out.println("Please try again!");
                }
            }
        }
    }
}
