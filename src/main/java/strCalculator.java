public class strCalculator {

    public static int add(String numbers){
        int summation = 0;

        // Modifies add method to handle different delimeters
        if(numbers.startsWith("//")){
            String del = numbers.substring(2,3);
            String[] sep = numbers.substring(2).split(del);

            for (String num: sep){
                if (num.contains("\n")){   // Handles new line segments
                    if(num.contains(",")){
                        for(String list: num.split(",")){
                            if(list.contains("\n")){
                                for(String num2: list.split("\n")){
                                    if(Integer.parseInt(num2) >= 1000){continue;}
                                    else{summation += Integer.parseInt(num2);}
                                }
                            }else{
                                if(Integer.parseInt(list) >= 1000){continue;}
                                else{summation += Integer.parseInt(list);}
                            }
                        }
                    }
                    else{
                        for(String list: num.split("\n")){
                            if(Integer.parseInt(list) >= 1000){continue;}
                            else{summation += Integer.parseInt(list);}
                        }
                    }
                }

                else if (num.equals("")){}     //Empty Strings do nothing

                else if(num.contains(",")){     // Handles comma segments
                    String[] Sep = num.split(",");
                    for(String list: Sep){
                        if(Integer.parseInt(list) >= 1000){continue;}
                        else{summation += Integer.parseInt(list);}
                    }
                }else{                            //Trivial segments
                    if(Integer.parseInt(num) >= 1000){continue;}
                    else{summation += Integer.parseInt(num);}
                }
            }

        }
        // Modify add method to handle new lines
        else if (numbers.split(",")[0].contains("\n")){
            String[] sep = numbers.split(",")[0].split("\n");
            for (String num: numbers.split(",")){
                if(num.contains("\n")){
                    String[] line = num.split("\n");
                    for(String num2: line){
                        if(Integer.parseInt(num2) >= 1000){continue;}
                        else{summation += Integer.parseInt(num2);}}
                }else{
                    if(Integer.parseInt(num) >= 1000){continue;}
                    else{summation += Integer.parseInt(num);}
                }
            }
        }
        // Trivial calculator
        else{
            for (String list: numbers.split(",")){
                if(Integer.parseInt(list) >= 1000){continue;}
                else{summation += Integer.parseInt(list);}
            }
        }
        return summation;
    }

    public static void main(String[] args){
        strCalculator Numbers = new strCalculator();
        System.out.print(add("//:1\n2,3:2"));
    }
}
