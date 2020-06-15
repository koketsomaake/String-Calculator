import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int add(String input) throws Error{
        int summation = 0;
        //if input is empty return summation
        if (input.equals("")){
            return summation;
        }

        //throw an error if the character at the end of index input is not a digit.
        if (!Character.isDigit(input.charAt(input.length()-1))){
                throw new Error("INVALID INPUT!");
        }

        //Throw error if the input starts with space.
        if (input.startsWith(" ")){
            throw new Error("INVALID INPUT!");
        }
        // Throw an error message if the input does not start with "//" and contains "//"
        if (!input.startsWith("//") && input.contains("//")){
                throw new Error("INVALID INPUT!");
        }

        //Delimiters
        String delimiter1 = "[,;\\n]";

        //An array for storing delimiters
        String[] delm = new String[2];

        // creating a new String Array of the sumArray , and
        // initializing the splitting delimiter with the limit of two to the array sumArray
        String[] sumArray = input.split("[\\\n]", 2);

        //initializing index 0 value in sumArray starting from index "2" to delemete
        String delimete = sumArray[0].substring(2);

        //creating a pattern to match delimiters
        Pattern pattern = Pattern.compile("(\\[).+(])(\\[).+(])");

        //Matching the variable DLimit1 with the compiled pattern
        Matcher matcher = pattern.matcher(delimete);
        // If the input start with "//" and matcher does not match delimete
        if (input.startsWith("//") && !(matcher.matches())) {

            //replace delimete at sumArray [1] with comma and
            // initialize the value at index 1 in sumArray to input
            input = sumArray[1].replace(delimete,",");
        }

        // if matcher match delimete
        if (matcher.matches()){

            //in delimete replace target "["  with an empty string
            delimete = delimete.replace("[","");

            //in delm array split with delimete "]"
            delm = delimete.split("]");
            input = sumArray[1];

            // for each string element in delm array
            for (String y : delm ) {

                //from the input target each element
                // on the array and replace it with a comma
                input = input.replace(y,",");
            }
        }
        //each element on sumArray2, I'm adding all the elements
        // and returning the sum
        String[] sumArray2 =input.split(delimiter1);
            for (String e : sumArray2) {
                // if element(s) in sumArray2 is/are greater than or equals to 1000, continue
                if (Integer.parseInt(e) >= 1000){
                    continue;
                }
                // if element(s) in sumArray2 is/are less than zero printout an error
                if (Integer.parseInt(e) < 0){
                    System.out.println(" 'ERROR: negatives not allowed "+ Integer.parseInt(e));
                }
                //adding all the values within sumArray with values of variable summation and assign them to be summation
                summation += Integer.parseInt(e);
            }
        return summation;
    }
    public static void main(String[] args)  {
        //I uncommented the last three outputs to ignore invalid inputs.

        String sum0 = "";
        String sum = "1,1,1,5";
        String sum1 = "1,2\n1";
        String sum2 = "//4\n142";
        String sum3 = "-1,-1,-1,-5";
        String sum4 = "//;\n100;1;2";
        String sum5 = "//;\n1000;1;2";
        String sum6 = "//***\n1***2***3";
        String sum7 = "//[:D][%]\n1:D2%3";
        String sum8 = "//[:D][%]\n1:D2%3;";
        String sum9 = "   //[:D][%]\n1:D2%3;";
        String sum10 = "1,2,3//[:D][%]\n1:D2%3;";

        System.out.println(add(sum0));
        System.out.println(add(sum));
        System.out.println(add(sum1));
        System.out.println(add(sum2));
        System.out.println(add((sum3)));
        System.out.println(add((sum4)));
        System.out.println(add((sum5)));
        System.out.println(add((sum6)));
        System.out.println(add((sum7)));
//        System.out.println(add((sum8)));
//        System.out.println(add((sum9)));
//        System.out.println(add((sum10)));

        }
    }
