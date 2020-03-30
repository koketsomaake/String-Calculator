public class strCalculator {
    public static int add(String numbers){
        String[] charNumbers = numbers.split(",");

    int sum = 0;
for(int i = 0; i< charNumbers.length; i++){
    sum += Integer.parseInt(charNumbers[i]);
}
    if(numbers.startsWith("//")){
String del = numbers.substring(2,3);

    String[] sep = numbers.substring(2).split(del);
    }
        // Modifies add method to handle different delimeters
        if(numbers.startsWith("//")){
            String del = numbers.substring(2,3);
            String[] sep = numbers.substring(2).split(del);
        }

return sum;
    }

    public static void main(String[] args) {
        strCalculator numsbers = new strCalculator();
        System.out.println(add("1,2"));
    }
}
