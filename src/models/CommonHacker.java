package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class CommonHacker implements PasswordGuesser {
    private BufferedReader everyPasswordEver;

    public CommonHacker(){
        try{
            everyPasswordEver = new BufferedReader(new FileReader(getClass().getClassLoader().getResource("passwords").getFile()));
        }catch(Exception e){}

    }

    public String getNext() {
        try{
            return everyPasswordEver.readLine();
        }catch (Exception e){
            return null;
        }
    }
}
