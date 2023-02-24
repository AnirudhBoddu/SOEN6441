package main.java.controllers;

public class TenantController {

    private static TenantController instance = new TenantController();

    // Singleton
    private TenantController(){}

    public static TenantController getInstance(){
        if(instance == null)
            instance = new TenantController();

        return instance;
    }
}
