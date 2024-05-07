package algo.util;

import java.util.Scanner;
import java.util.Set;

public class Validator {
    public static String validateInputString(String prompt, Set<String>[] wordList, Scanner scanner) {
        return validateInputString(prompt, 0, wordList, scanner);
    }

    public static String validateInputString(String prompt, int validLength, Set<String>[] wordList, Scanner scanner) {
        String validWord = "";
        boolean inputValid = false;

        while (!inputValid) {
            System.out.print(prompt);
            String inputWord = scanner.nextLine().trim();
            String[] test = inputWord.split("\\s+");

            try {
                if (inputWord.equals("")) {
                    throw new Exception("Kata tidak boleh kosong!");
                }
                if (test.length > 1) {
                    throw new Exception("Jumlah kata tidak boleh lebih dari satu!");
                }
    
                boolean onlyAlphabets = true;
                for (int i = 0; i < inputWord.length(); i++) {
                    if (!Character.isLetter(inputWord.charAt(i))) {
                        onlyAlphabets = false;
                        break;
                    }
                }
                if (!onlyAlphabets) {
                    throw new Exception("Kata hanya boleh berisi huruf!");
                }

                if (validLength > 0 && inputWord.length() != validLength) {
                    throw new Exception("Kata harus memiliki panjang " + validLength + "!");
                }

                inputWord = inputWord.toLowerCase();
                if (!wordList[inputWord.length()-1].contains(inputWord)) {
                    throw new Exception("Kata tersebut tidak ada dalam kamus!");
                }

                validWord = inputWord;
                inputValid = true;
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        assert !validWord.equals("");
        return validWord;
    }

    public static int validateInputInteger(String prompt, int lowerBound, int upperBound, Scanner scanner) {
        int validInt = -999;
        boolean inputValid = false;

        while (!inputValid) {
            System.out.print(prompt);
            String inputWord = scanner.nextLine().trim();
            String[] test = inputWord.split("\\s+");

            try {
                if (test.length > 1) {
                    throw new Exception("Input tidak boleh memiliki spasi!");
                }
    
                if (!inputWord.matches("\\d+")) {
                    throw new Exception("Input harus berupa angka integer!");
    
                }
    
                int inputInt = Integer.parseInt(inputWord);
                if (inputInt < lowerBound) {
                    throw new Exception("Angka tidak boleh kurang dari " + lowerBound + "!");
                }
                else if (inputInt > upperBound) {
                    throw new Exception("Angka tidak boleh lebih dari " + upperBound + "!");
                }

                validInt = inputInt;
                inputValid = true;
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        assert !(validInt == -999);
        return validInt;
    }
}
