package M3;

/*
Challenge 1: Command-Line Calculator
------------------------------------
- Accept two numbers and an operator as command-line arguments
- Supports addition (+) and subtraction (-)
- Allow integer and floating-point numbers
- Ensures correct decimal places in output based on input (e.g., 0.1 + 0.2 → 1 decimal place)
- Display an error for invalid inputs or unsupported operators
- Capture 5 variations of tests
*/

public class CommandLineCalculator extends BaseClass {
    private static String ucid = "omg6"; // <-- change to your ucid
// omg6, solved with parsing two numbers that checks + or - is used, solves the equation and formats output to match input numbers
    public static void main(String[] args) {
        printHeader(ucid, 1, "Objective: Implement a calculator using command-line arguments.");

        if (args.length != 3) {
            System.out.println("Usage: java M3.CommandLineCalculator <num1> <operator> <num2>");
            printFooter(ucid, 1);
            return;
        }

        try {
            System.out.println("Calculating result...");
            // extract the equation (format is <num1> <operator> <num2>)
            String number1String = args[0];
            String operator = args[1];
            String number2String = args[2];

            // check if operator is addition or subtraction
            if (!operator.equals ("+") && !operator.equals ("-")){

                System.out.println ("Only + and - are accepted");
                return;
            }

            // check the type of each number and choose appropriate parsing

            double number1 = Double.parseDouble (number1String);
            double number2 = Double.parseDouble (number2String);


            // generate the equation result (Important: ensure decimals display as the
            // longest decimal passed)
            // i.e., 0.1 + 0.2 would show as one decimal place (0.3), 0.11 + 0.2 would shows
            // as two (0.31), etc

            int decimals1 = number1String.contains(".") ? number1String.length() - number1String.indexOf (".") -1:0;
            int decimals2 = number2String.contains(".") ? number2String.length() - number2String.indexOf (".") -1:0;
            int maxDecimal = Math.max(decimals1,decimals2);

            Double result = operator.equals("+") ? number1+number2 : number1-number2;
            String Result = String.format("%." + maxDecimal + "f", result);
            System.out.println(number1String + " " + operator + " " + number2String + " = " + Result);

        } catch (Exception e) {
            System.out.println("Invalid input. Please ensure correct format and valid numbers.");
        }

        printFooter(ucid, 1);
    }
}
