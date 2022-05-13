package com.maktabsharif74.jdbcexample.util;


import com.maktabsharif74.jdbcexample.domain.User;

public class SecurityContext {

    private User currentUser = null;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void logout() {
        this.currentUser = null;
    }
}
