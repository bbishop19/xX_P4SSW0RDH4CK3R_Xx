package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Calendar;
import java.util.Scanner;

public class WindwardHacker implements PasswordGuesser{
    private BufferedReader nounlist;
    private char[] specialCharacters;
    private int index;
    private String currentWord;
    private int yearModifier;
    private int baseYear;

    public WindwardHacker(){
        specialCharacters = new char[]{'!', '@', '#', '$', '%', '^', '&', '*'};
        index = 0;
        yearModifier = 0;
        baseYear = Calendar.getInstance().get(Calendar.YEAR) +  (Calendar.getInstance().get(Calendar.MONTH)+5)/11;

        try{
            nounlist = new BufferedReader(new FileReader(getClass().getClassLoader().getResource("words").getFile()));
            currentWord = nounlist.readLine();
        }catch(Exception e){}

    }

    public String getNext(){
        if(currentWord==null){
            return null;
        }

        String password = currentWord + specialCharacters[index] + (baseYear + yearModifier);

        if (++yearModifier == 6){
            yearModifier = 0;
            if(++index == specialCharacters.length){
                index = 0;
                try{
                    currentWord = nounlist.readLine();
                }catch (Exception e){
                    return null;
                }
            }
        }
        return password;
    }
}
