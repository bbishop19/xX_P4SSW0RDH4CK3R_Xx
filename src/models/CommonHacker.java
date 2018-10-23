package models;

import java.util.Scanner;

public class CommonHacker implements PasswordGuesser {
    private Scanner everyPasswordEver;

    public CommonHacker(){
        try{
            everyPasswordEver = new Scanner(getClass().getResourceAsStream("10millionpasswords.txt"));
        }catch(Exception e){}

    }

    @Override
    public String getNext() {
        if(everyPasswordEver.hasNext()){
            return everyPasswordEver.next();
        }else{
            return null;
        }
    }

    public void closeScanner(){
        everyPasswordEver.close();
    }
}
