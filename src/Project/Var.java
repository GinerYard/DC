package Project;

import java.util.ArrayList;

public class Var {
    public static int x0;
    public static int y0;
    public static int d;
    private static int flagdo;

    public static void setFlagdo(int flagdo) {
        Var.flagdo = flagdo;
    }

    public static int getFlagdo() {
        return flagdo;
    }

    private static int mode;

    public void setMode(int mode) {
        this.mode = mode;
    }

    public static int getMode() {
        return mode;
    }




    private String user;
    private String password;
    private String ensurePassword;





    public static int clock;





    public void setUser(String user){
        this.user = user;
    }
    public String getUser(){
        return user;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return password;
    }
    public void setEnsurePassword(String ensurePassword){
        this.ensurePassword=ensurePassword;
    }
    public String getEnsurePassword(){
        return ensurePassword;
    }

}
