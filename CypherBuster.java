import java.util.Arrays;
import java.util.Scanner;

public class CypherBuster {

    //public static ArrayList<String> alphabet = new ArrayList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
    public static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static String ceasarCipher(String cipherString, int shift) {
        char[] resultCharArray = new char[cipherString.length()];
        
        for (int i = 0; i < cipherString.length(); i++){
            int currentCharIndex = Arrays.binarySearch(alphabet, cipherString.charAt(i));
            
            if(alphabet.length - 1 < currentCharIndex + shift) {
                resultCharArray[i] = alphabet[currentCharIndex - alphabet.length + shift];
            }
            else {
                resultCharArray[i] = alphabet[currentCharIndex + shift];
            }
        }
        String resultString = new String(resultCharArray);
        return resultString;
    }

    public static String binaryToASCII(String binaryString) {
        try {
            String[] binaryWords = binaryString.split(" ");
            char[] resultCharArray = new char[binaryWords.length];
        
            for(int j = 0; j < resultCharArray.length; j++) {
                int binaryInteger = Integer.parseInt(binaryWords[j]);
                resultCharArray[j] = (char)binaryToDecimal(binaryInteger);
            }
            String resultString = new String(resultCharArray);
            return resultString;
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: Invalid binaryString Input");
            return "";
        }
    }

    public static String asciiToBinary(String asciiString) {
        char[] charArray = asciiString.toCharArray();
        String resultString = "";

        for(int j = 0; j < charArray.length; j++) {
            int asciiInteger = (int)charArray[j];
            resultString += decimalToBinary(asciiInteger) + " ";
        }
        return resultString;
    }

    public static int binaryToDecimal(int binaryNumber) {
        int decimalNumber = 0;
        int digitsPlace = 1;
 
        for(int i = 0; i < 8; i++) {
            int lastDigit = binaryNumber % 10;
            binaryNumber = binaryNumber / 10;
 
            decimalNumber += lastDigit * digitsPlace;
 
            digitsPlace = digitsPlace * 2;
        }
 
        return decimalNumber;
    }

    public static String decimalToBinary(int decimalNumber) {
        String binaryNumber = "";
 
        for(int i = 0; i < 8; i++) {
            int value = decimalNumber / 2;
            int remainder = decimalNumber % 2;
            
            if (remainder != 0) {
                binaryNumber = "1" + binaryNumber;
            }
            else {
                binaryNumber = "0" + binaryNumber;
            }
            decimalNumber = value;
        }
        return (binaryNumber);
    }
    
    public static void main(String[] args){
        Scanner scannerInput = new Scanner(System.in);
        int option = 1;
        while(option != 0) {
            System.out.println("Press input to continue: \n0 - Exit\n1 - Ceasar Cipher\n2 - Binary To ASCII\n3 - ASCII To Binary");
            option = scannerInput.nextInt();
            scannerInput.nextLine();
            if (option == 0) { // Exit Option
                System.out.println("Closing Program.");
            }
            else if (option == 1) { // Ceasar Cipher
                System.out.print("Ceasar Cipher: \n" + "Input Cipher: ");
                String cipher = scannerInput.nextLine();

                System.out.print("Input Shift: ");
                int shift = scannerInput.nextInt();
                scannerInput.nextLine();

                System.out.println("Result: \n" + ceasarCipher(cipher, shift));
            }
            else if (option == 2) { // Binary ASCII
                System.out.print("Binary ASCII: \n" + "Input Binary String: ");
                String userInput = scannerInput.nextLine();

                System.out.println("Result: \n" + binaryToASCII(userInput));
            }
            else if (option == 3) { // ASCII Binary
                System.out.print("ASCII Binary: \n" + "Input String: ");
                String userInput = scannerInput.nextLine();

                System.out.println("Result: \n" + asciiToBinary(userInput));
            }
            else {
                System.out.println("Invalid Input.");
            }
        }
        scannerInput.close();
    }
}

