package com.company;
import business.abstractt.UserService;
import business.concretes.UserServiceManager;
import dataAccess.concretes.ActivityUserDao;
import entities.concretes.User;
import core.abstractt.GoogleService;
import core.abstractt.VerifyingCodeService;
import core.concretes.CodeServiceManager;
import core.concretes.GoogleServiceManager;
public class Main {

    public static void main(String[] args) {
	    User user_1 = new User(1,"Gülsüm","Vural","gvural@gmail.com","gvural2510");
	    User user_2 = new User(2,"Ferit","Tümer","ftumer@gmail.com","ftumer2510");

	    UserService userManager = new UserServiceManager(new ActivityUserDao(),
				new CodeServiceManager(), new GoogleServiceManager());
	    userManager.register(user_1);

	    System.out.println("----------------");

		userManager.register(user_2);

		System.out.println("----------------");

		userManager.loginWithGoogle("gvural@gmail.com","gvural2510");


	}
}
