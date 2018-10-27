package models;

import java.io.BufferedReader;
import java.io.FileReader;

public class CommonHacker implements PasswordGuesser {
    private BufferedReader everyPasswordEver;

    //try common passwords from an internet file
    public CommonHacker(){
        try{
            everyPasswordEver = new BufferedReader(new FileReader(getClass().getClassLoader().getResource("passwords").getFile()));
        }catch(Exception e){System.out.println(e);System.out.println("A NullPointerException here means the text file is not loading correctly on your computer");}

    }

    public String getNext() {
        try{
            return everyPasswordEver.readLine();
        }catch (Exception e){
            return null;
        }
    }
}
