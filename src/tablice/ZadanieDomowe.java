package tablice;

import java.util.Random;
import java.util.Scanner;

/**
 * napisac z tablic z
 * pierwsza dyze litery / mle litery
 * druga male litery
 * trzecia znaki specjalne
 * <p>
 * uzytjkownik podaje jak długie chce hasło
 * i my to losujemy
 * <p>
 * 10 >> program losuje tablice - losujemy w tablicy
 * <p>
 * pomysl - metoda ze switchem ktory posiada dla kazdego case przypisanie do tablicy
 */
class ZadanieDomowe {
    private Dictionary dictionary;

    private int maxLetter;
    private int maxInteger;
    private int maxSpecial;

    private ZadanieDomowe() {
        dictionary = new Dictionary();

        maxLetter = dictionary.upperAndLowerletters.length;
        maxInteger = dictionary.allInteger.length;
        maxSpecial = dictionary.specialSigns.length;
    }

    static class Dictionary {
        char[] upperAndLowerletters = new char[26 * 2];
        char[] allInteger = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        char[] specialSigns = {'!', '@', '#', '$', '%', '&', '*', '?'};

        Dictionary() {
            //// letter
            // upperCase
            int index = 0;
            for (char letter = 'A'; letter <= 'Z'; letter++) {
                upperAndLowerletters[index] = letter;
                index++;
            }
            //upperCase
            for (char letter = 'a'; letter <= 'z'; letter++) {
                upperAndLowerletters[index] = letter;
                index++;
            }
        }

        private String charToString(char[] charTbl) {
            StringBuilder build = new StringBuilder();
            for (char one : charTbl) {
                build.append(one);
            }
            return build.toString();
        }


    }


    public static void main(String[] args) {
        String pass = new ZadanieDomowe().generatePass();
        System.out.println("Pass: " + pass);


    }

    private String generatePass() {

        System.out.println("---- Pass generation ----");
        StringBuilder pass = new StringBuilder();


        int passLength = getPassLength();
        do {
            for (int passIndex = 0; passIndex < passLength; passIndex++) {
                pass.append(getOneRandomChar(new Random().nextInt(3)));
            }
        } while (!checkPassCorrection(pass));

        return pass.toString();
    }

    private boolean checkPassCorrection(StringBuilder pass) {
        boolean correct = true;
        if (!pass.toString().matches(".*[a-z].*")) correct = false;
        if (!pass.toString().matches(".*[A-Z].*")) correct = false;
        if (!pass.toString().matches(".*[0-9].*")) correct = false;
        if (!pass.toString().matches(".*[" + dictionary.charToString(dictionary.specialSigns) + "].*")) correct = false;
        return correct;
    }

    private char getOneRandomChar(int randomTable) {
        int index;
        switch (randomTable) {
            case 0:
                index = new Random().nextInt(maxLetter);
                return dictionary.upperAndLowerletters[index];
            case 1:
                index = new Random().nextInt(maxInteger);
                return dictionary.allInteger[index];
            case 2:
                index = new Random().nextInt(maxSpecial);
                return dictionary.specialSigns[index];
            default:
                throw new IllegalArgumentException("Wrong int randomTable implementation");

        }
    }

    private int getPassLength() {
        Scanner input = new Scanner(System.in);
        int passLength;
        do {
            System.out.println("Please provide length of your password ( min 8 )");
            passLength = input.nextInt();
        } while (passLength < 8);
        return passLength;
    }

}
