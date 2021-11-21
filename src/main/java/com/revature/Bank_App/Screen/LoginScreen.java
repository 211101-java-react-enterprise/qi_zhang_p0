package com.revature.Bank_App.Screen;

import com.revature.Bank_App.Exceptions.DataPersistenceException;
import com.revature.Bank_App.ObjectModel.AppUser;
import com.revature.Bank_App.Service.UserService;
import com.revature.Bank_App.util.ScreenRouter;
import java.io.BufferedReader;

import static com.revature.Bank_App.util.color.*;

public class LoginScreen extends Screen{
    UserService userService;
    private AppUser sessionUser=new AppUser();

    //LoginScreen constructor
    public LoginScreen(BufferedReader consoleReader, ScreenRouter screenRouter,UserService userService) {
        super("Login Screen","login", consoleReader, screenRouter);
        this.userService=userService;
    }

    @Override
    public void render() throws Exception {
        System.out.println(ANSI_BLUE+"Welcome Back Please enter your Username and password"+ANSI_RESET);
        System.out.println("Username: ");
        String username=consoleReader.readLine();
        System.out.println("Password: ");
        String password=consoleReader.readLine();

        try{
            sessionUser=userService.UserLogin(username,password);
            if(!(sessionUser==null)) System.out.println("Welcome Back Bank App User");
            screenRouter.navigate("dashboard");
        }catch(DataPersistenceException e){
            System.out.println(ANSI_RED+"No user found or password does not match"+ANSI_RESET);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
