import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {
        String fileName = "Advent of Code 2024 Java\\src\\Problem 1.txt"; 
        int[] numbers = readNumbersFromFile(fileName);
        int answer = 0;
        int answer1 = numbers[numbers.length - 1];
        for (int i : numbers) {
            answer+=i;
        }
        answer-=answer1;
        System.out.println("Part 1: " + answer);
        System.out.println("Part 2: " + answer1);
    }

    public static int[] readNumbersFromFile(String fileName) {
        ArrayList<Integer> numberList = new ArrayList<>();
        ArrayList<Integer> numberList1 = new ArrayList<>();
        ArrayList<Integer> answerList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    line = line.trim();
                    int num1 = Integer.parseInt(line.substring(0, line.indexOf(" ", 0)));
                    int num2 = Integer.parseInt(line.substring(line.indexOf(" ", 0)).trim());
                    numberList.add(num1);
                    numberList1.add(num2);
                } catch (NumberFormatException e) {
                    System.err.println("Skipping invalid number: " + line);
                }
            }
            Collections.sort(numberList);
            Collections.sort(numberList1);
            for (int i = 0; i < numberList.size(); i++) {
                answerList.add(Math.abs(numberList.get(i) - numberList1.get(i)));
            }
            int answer1 = 0;
            for (Integer integer : numberList) {
                answer1 += countInstancesInList(integer, numberList1) * integer;
            }
            answerList.add(answer1);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
    public static int countInstancesInList(int target, ArrayList<Integer> list) {
        int count = 0;
        for (int num : list) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }
}