package com.maktabsharif74.jdbcexample.util;


import com.maktabsharif74.jdbcexample.domain.User;

public class Menu {

    public void showWelcomeMenu() {
        System.out.println("welcome to jdbc_example application");
        System.out.println("plz choose a number:");
        System.out.println("1: login");
        System.out.println("2: signup");
        System.out.println("3: exit");
    }

    public void showIncorrectNumberMessage() {
        System.out.println("plz enter right number");
    }

    public void showFillInformationMessage() {
        System.out.println("plz fill your information");
    }

    public void showEnterFirstNameMessage() {
        System.out.println("plz enter your first name:");
    }

    public void showEnterLastNameMessage() {
        System.out.println("plz enter your last name:");
    }

    public void showEnterUsernameMessage() {
        System.out.println("plz enter your username:");
    }

    public void showEnterPasswordMessage() {
        System.out.println("plz enter your password:");
    }

    public void showLoginSuccessMessage(User currentUser) {
        System.out.println("login successfully done");
        System.out.println(
                "welcome " + currentUser.getFirstName() + " " + currentUser.getLastName()
        );
    }

    public void showLoginFailMessage() {
        System.out.println("username or password is incorrect");
    }

    public void showExitMessage() {
        System.out.println("Bye!!! have nice time");
    }

    public void showUserPanelMenu() {
        System.out.println("plz choose a number:");
        System.out.println("1: show my profile");
        System.out.println("2: show my articles");
        System.out.println("3: add article");
        System.out.println("4: logout");
    }

    public void showLogoutMessage() {
        System.out.println("logout successful");
    }

    public void showUserProfile(User currentUser) {
        System.out.println("firstName: " + currentUser.getFirstName());
        System.out.println("lastName: " + currentUser.getLastName());
        System.out.println("username: " + currentUser.getUsername());
    }

    public void showEmptyArticleMessage() {
        System.out.println("there is no articles!!!");
    }

    public void showEnterArticleTitleMessage() {
        System.out.println("plz enter article title:");
    }

    public void showEnterArticleContentMessage() {
        System.out.println("plz enter article content:");
    }

    public void showNewArticleInsertedMessage() {
        System.out.println("new article inserted!!!");
    }
}
