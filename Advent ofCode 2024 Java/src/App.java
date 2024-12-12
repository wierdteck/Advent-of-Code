import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {
        String fileName = "Advent ofCode 2024 Java\\src\\Problem 3.txt"; 
        ArrayList<Integer> answerList = multiplicationReader2(fileName);
        int answer = 0;
        for (Integer integer : answerList) {
            System.out.println(integer);
        }
        for (Integer integer : answerList) {
            answer+=integer;
        }

        System.out.println("Part 1: " + answer);
        // System.out.println("Part 2: " + answer1);
    }
    public static ArrayList<Integer> multiplicationReader2(String fileName){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            boolean doRead = true;
            while ((line = reader.readLine()) != null) {
                int i = 0;
                while (i < line.length()) {
                    if ((i < line.length() - 8) && line.substring(i, i+7).equals("don't()")) {
                        i+=7;
                        doRead = false;
                        continue;
                    }
                    if((i < line.length() - 5) && line.substring(i, i+4).equals("do()")){
                        doRead = true;
                        i+=4;
                        continue;
                    }
                    if(i < line.length()-5 && doRead && line.substring(i, i+4).equals("mul(")){
                        i+=4;
                        int c = 0;
                        int number = 0;
                        c = (int)line.charAt(i);
                        i++;
                        while (c > 47 && c < 58){
                            // System.out.println(c);
                            number = number*10 + c-48;
                            c = (int)line.charAt(i);
                            i++;
                        }
                        if (c == (int)',') {
                            int number2 = 0;
                            c = (int)line.charAt(i);
                            i++;
                            while (c > 47 && c < 58){
                                number2 = number2*10 + c-48;
                                c = (int)line.charAt(i);
                                i++;
                            }
                            if (c == (int)')'){
                                System.out.println(number*number2);
                                numbers.add(number*number2);
                            }
                        }
                        continue;
                    }
                    i++;
                }
            }
            
            // System.out.println(numbers.size());
            return numbers;

        } catch (Exception e) {
            System.out.println("Exception while reading " + e.getMessage());
        }
        

        return numbers;
    }
    // public static ArrayList<Integer> multiplicationReader(String fileName){
    //     ArrayList<Integer> numbers = new ArrayList<Integer>();
    //     try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
    //         int c = 0;
    //         c = reader.read();
    //         // System.out.println(c);
    //         while (c != -1){
    //             if (c == (int)'m'){
    //                 c = reader.read();
    //                 if(c == (int)'u'){
    //                     c = reader.read();  
    //                     if (c == (int)'l') {
    //                         c = reader.read();
    //                         if (c == (int)'(') {
    //                             int number = 0;
    //                             c = reader.read();
    //                             while (c > 47 && c < 58){
    //                                 System.out.println(c);
    //                                 number = number*10 + c-48;
    //                                 c = reader.read();
    //                             }
                                
    //                             if (c == (int)',') {
    //                                 int number2 = 0;
    //                                 c = reader.read();
    //                                 while (c > 47 && c < 58){
    //                                     number2 = number2*10 + c-48;
    //                                     c = reader.read();
    //                                 }
    //                                 if (c == (int)')'){
    //                                     numbers.add(number*number2);
    //                                 }
    //                             }
    //                         }
    //                     }
    //                 }
    //             }
    //             c = reader.read();
    //         }
    //         System.out.println(numbers.size());
    //         return numbers;

    //     } catch (Exception e) {
    //         System.out.println("Exception while reading " + e.getMessage());
    //     }
        

    //     return numbers;
    // }

    
    ////////////////////////////////////Problem 2/////////////////////////////////////////
    // public static void main(String[] args) throws Exception {
    //     String fileName = "src\\Problem 2.txt"; 
    //     ArrayList<Boolean> answerList = readNumbersFromFile2(fileName);
    //     int answer = 0;
    //     for (Boolean b : answerList) if (b) answer++;

    //     System.out.println("Part 1: " + answer);
    //     // System.out.println("Part 2: " + answer1);
    // }

    // public static ArrayList<Boolean> readNumbersFromFile(String fileName) {
    //     ArrayList<Boolean> trues = new ArrayList<Boolean>();
    //     try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
    //         String line;
    //         while ((line = reader.readLine()) != null) {
    //             ArrayList<Integer> numbers = new ArrayList<Integer>();
    //             int lastIndex = 0;
    //             boolean safe = true;
    //             int space = line.indexOf(' ', lastIndex);
    //             while (space != -1){
    //                 String l = line.substring(lastIndex, space);
    //                 numbers.add(Integer.parseInt(l));
    //                 lastIndex = space + 1;
    //                 space = line.indexOf(" ", lastIndex);
    //             }
    //             numbers.add(Integer.parseInt(line.substring(lastIndex)));
    //             // System.out.println(numbers.size()); works fine
    //             int i = 0;
    //             boolean increasing = numbers.get(i) < numbers.get(i+1);
    //             while (i < numbers.size()-1) {
    //                 if (between1and3(numbers.get(i), numbers.get(i+1), increasing)){
    //                     safe = false; 
    //                     break;
    //                 }
    //                 i++;
    //                 // System.out.print(i + " : ");
    //                 // System.out.println(numbers.size());
    //             }
    //             // System.out.println(safe);
    //             trues.add(safe);
    //         }
    //     } catch (IOException e) {
    //         System.err.println("Error reading file: " + e.getMessage());
    //     }
    //     // System.out.println(trues.size());
    //     return trues;
    // }
    // public static ArrayList<Boolean> readNumbersFromFile2(String fileName) {
    //     ArrayList<Boolean> trues = new ArrayList<Boolean>();
    //     try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
    //         String line;
    //         while ((line = reader.readLine()) != null) {
    //             ArrayList<Integer> numbers = new ArrayList<Integer>();
    //             int lastIndex = 0;
    //             boolean safe = false;
    //             int space = line.indexOf(' ', lastIndex);
    //             while (space != -1){
    //                 String l = line.substring(lastIndex, space);
    //                 numbers.add(Integer.parseInt(l));
    //                 lastIndex = space + 1;
    //                 space = line.indexOf(" ", lastIndex);
    //             }
    //             numbers.add(Integer.parseInt(line.substring(lastIndex)));
    //             // System.out.println(numbers.size()); works fine

    //             for (int index = 0; index < numbers.size(); index++) {
    //                 Integer num = numbers.get(index);
    //                 numbers.remove(index);
    //                 if (works(numbers)){
    //                     safe = true;
    //                     break;
    //                 }
    //                 numbers.add(index, num);
    //             }
                
    //             trues.add(safe);
    //         }
    //     } catch (IOException e) {
    //         System.err.println("Error reading file: " + e.getMessage());
    //     }
    //     // System.out.println(trues.size());
    //     return trues;
    // }

    // public static boolean works(ArrayList<Integer> numbers){
    //     boolean safe = true;
    //     int i = 0;
    //     boolean increasing = numbers.get(i) < numbers.get(i+1);
    //     while (i < numbers.size()-1) {
    //         if (between1and3(numbers.get(i), numbers.get(i+1), increasing)){
    //             safe = false; 
    //             break;
    //         }
    //         i++;
    //     }
    //     return safe;
    // }

    // public static boolean between1and3(Integer left, Integer right, Boolean increase){
    //     return !(Math.abs(left - right) <= 3 && Math.abs(left-right) >= 1) || increase != (left < right);
    // }



    ////////////////////////////////Problem 1////////////////////////////////
    // public static void main(String[] args) throws Exception {
    //     String fileName = "src\\Prolem 1.txt"; 
    //     int[] numbers = readNumbersFromFile(fileName);
    //     int answer = 0;
    //     int answer1 = numbers[numbers.length - 1];
    //     for (int i : numbers) {
    //         answer+=i;
    //     }
    //     answer-=answer1;
    //     System.out.println("Part 1: " + answer);
    //     System.out.println("Part 2: " + answer1);
    // }
    // public static int[] readNumbersFromFile(String fileName) {
    //     ArrayList<Integer> numberList = new ArrayList<>();
    //     ArrayList<Integer> numberList1 = new ArrayList<>();
    //     ArrayList<Integer> answerList = new ArrayList<>();
    //     try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
    //         String line;
    //         while ((line = reader.readLine()) != null) {
    //             try {
    //                 line = line.trim();
    //                 int num1 = Integer.parseInt(line.substring(0, line.indexOf(" ", 0)));
    //                 int num2 = Integer.parseInt(line.substring(line.indexOf(" ", 0)).trim());
    //                 numberList.add(num1);
    //                 numberList1.add(num2);
    //             } catch (NumberFormatException e) {
    //                 System.err.println("Skipping invalid number: " + line);
    //             }
    //         }
    //         Collections.sort(numberList);
    //         Collections.sort(numberList1);
    //         for (int i = 0; i < numberList.size(); i++) {
    //             answerList.add(Math.abs(numberList.get(i) - numberList1.get(i)));
    //         }
    //         int answer1 = 0;
    //         for (Integer integer : numberList) {
    //             answer1 += countInstancesInList(integer, numberList1) * integer;
    //         }
    //         answerList.add(answer1);
    //     } catch (IOException e) {
    //         System.err.println("Error reading file: " + e.getMessage());
    //     }
        
    //     return answerList.stream().mapToInt(Integer::intValue).toArray();
    // }
    // public static int countInstancesInList(int target, ArrayList<Integer> list) {
    //     int count = 0;
    //     for (int num : list) {
    //         if (num == target) {
    //             count++;
    //         }
    //     }
    //     return count;
    // }
}