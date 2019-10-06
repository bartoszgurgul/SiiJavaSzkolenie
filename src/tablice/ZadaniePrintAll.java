package tablice;

import java.util.Scanner;

public class ZadaniePrintAll {



    public static void main(String[] args){
        char[] literki = new char[2];



        Scanner in = new Scanner(System.in);

        for (int i = 0; i < literki.length; i++) {
            System.out.println("Please type value for element [" + i + "] - ONLY SINGLE CHAR");
            String input = in.next();
            if (input.length() > 1 ) throw new IllegalArgumentException("ZLE");
            else{
                literki[i] = input.charAt(0);
            }
        }

        for (char first : literki) {
            for (char second : literki) {
                System.out.println("Option >> " + first + second);
            }

        }
    }




}
