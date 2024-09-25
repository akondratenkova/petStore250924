package org.petstore.data;

public class Endpoints {
    public static String URL = "https://petstore.swagger.io/v2/";

    //pet module
    public static String post_pet = URL + "pet"; //add a new pet to the store
    public static String put_pet = URL + "pet"; //update an existing pet
    public static String get_pet = URL + "pet/{petId}"; //find pet by ID
    public static String delete_pet = URL + "pet/{petId}"; //delete a pet

    //user module
    public static String post_user = URL + "user"; //create user
    public static String put_user = URL + "user/{username}"; //update user
    public static String get_user = URL + "user/{username}"; //find pet by ID
    public static String delete_user = URL + "user/{username}"; //delete a pet
}
