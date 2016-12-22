package com.example.samresendez.boost;

/**
 * Created by SamResendez on 11/13/16.
 */

public class Globals {

    private static Globals instance;

    private String userName;
        // Restrict the constructor from being instantiated
    private Globals(){}

    public void setUser(String name){
        this.userName=name;
    }
    public String getuser() {
            return this.userName;
    }
    public static synchronized Globals getInstance() {
        if (instance == null) {
            instance = new Globals();
        }
        return instance;
    }

}
