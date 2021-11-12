package com.revature.Bank_App.Screen;

import com.revature.Bank_App.util.ScreenRouter;
import java.io.BufferedReader;

public class LoginScreen extends Screen{

    //LoginScreen constructor
    public LoginScreen(BufferedReader consoleReader, ScreenRouter screenRouter) {
        super("Register Screen","register", consoleReader, screenRouter);
    }

    @Override
    public void render() throws Exception {
        System.out.println("Login");

    }
}
