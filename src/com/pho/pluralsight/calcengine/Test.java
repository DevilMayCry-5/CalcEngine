package com.pho.pluralsight.calcengine;
import java.util.Scanner;

public class Test {
    /** method contains switch to choose opCode
     and do the necessary calculations based on
     selected opCode, then reurns the result*/
    public static double execute(char opCode, double leftVal, double rightVal){
        double result;

        switch (opCode) {
            case 'a' -> result = leftVal + rightVal;
            case 's' -> result = leftVal - rightVal;
            case 'm' -> result = leftVal * rightVal;
            case 'd' -> result = rightVal != 0 ? leftVal / rightVal : 0.00d;
            default -> {
                System.out.println("Invalid opCode: " + opCode);
                result = 0.0d;
            }
        }
        return result;
    }

    /** method to handle command-line arguments */
    public static void handleCommandLine(String[] args) {
        char opCode = args[0].charAt(0);
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);

        double result = execute(opCode, leftVal, rightVal);
        System.out.println(result);
    }

    /** method to get operation code character from string */
    public static char opCodeFromString(String operationName){
        char opCode = operationName.charAt(0);
        return opCode;
    }

    /** method to get number value from its words counterpart */
    public static double valueFromWord(String word){
        String[] numberWords = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
        };

        double value = 0d;

        for (int index = 0; index < numberWords.length; index++){
            if (word.equals(numberWords[index])){
                value = index;
                break;
            }
        }

        return value;
    }

    /** method to make program a bit
     *  interactive by allowing user input
     */
    public static void executeInteractively(){
        System.out.println("Enter an operation and two numbers: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperation(parts);
    }

    public static void performOperation(String[] parts){
        char opCode = opCodeFromString(parts[0]);
        double leftVal = valueFromWord(parts[1]);
        double rightVal = valueFromWord(parts[2]);

        double result = execute(opCode, leftVal, rightVal);
        displayResult(opCode, leftVal, rightVal, result);
    }

    public static void displayResult(char opCode, double leftVal, double rightVal, double result) {
        char symbol = symbolFromOpCode(opCode);

        StringBuilder builder = new StringBuilder();
        builder.append(leftVal);
        builder.append(" ");
        builder.append(symbol);
        builder.append(" ");
        builder.append(rightVal);
        builder.append(" = ");
        builder.append(result);
        String output = builder.toString();
        System.out.println(output);
    }


    public static char symbolFromOpCode(char opCode) {
        char[] opCodes = {'a', 's', 'm', 'd'};
        char[] symbols = {'+', '-', '*', '-'};
        char symbol = ' ';
        for (int index = 0; index < opCodes.length; index++) {
            if (opCode == opCodes[index]) {
                symbol = symbols[index];
                break;
            }
        }
        return symbol;
    }
}
