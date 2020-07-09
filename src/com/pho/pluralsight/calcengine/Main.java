package com.pho.pluralsight.calcengine;

import static com.pho.pluralsight.calcengine.Test.*;

public class Main {

    public static void main(String[] args) {
        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
        char[] opCodes = {'d', 'a', 's', 'm'};
        double[] results = new double[opCodes.length];

        // runs if no command line arguments received
        if (args.length == 0) {
            for (int i = 0; i < opCodes.length; i++) {
                results[i] = execute(opCodes[i], leftVals[i], rightVals[i]);
            }

            /** prints out each member of the array **/
            for (double currentResult : results) {
                System.out.println(currentResult);
            }

        }

        else if (args.length == 1 && args[0].equals("interactive")){
            executeInteractively();
        }

        // runs when three command line arguments received
        else if (args.length == 3){
            // method accepts command line arguments and does necessary calcs
            handleCommandLine(args);
        }
        else 
            System.out.println("op-code and 2 numeric values needed");
    }




}

