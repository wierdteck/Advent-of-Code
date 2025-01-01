import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Problem_13 {
    public static String readF(String fileName){
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine())!= null) {
                contentBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
    
    public static void main(String[] args) throws IOException{
        String file = readF("Advent ofCode 2024 Java\\src\\Problem 13.txt");
        ArrayList<ArrayList<Long>> problems = new ArrayList<ArrayList<Long>>();
        ArrayList<Long> numbers = new ArrayList<Long>();
        boolean inNum = false;
        long curNum = 0;
        // put in the numbers into the problem array thingy
        // x1 y1 x2 y2 xf yf
        while (file.length()!=0) {
            if (numbers.size() == 6) {
                problems.add(new ArrayList<Long>());
                for (Long integer : numbers) {
                    problems.get(problems.size() - 1).add(integer);
                }
                numbers.clear();
            }
            if(inNum){
                if(Character.isDigit(file.charAt(0))){
                    curNum=curNum*10+Long.parseLong(file.substring(0,1));
                    file = file.substring(1);
                }
                else{
                    if(numbers.size() >= 4) numbers.add(curNum+10000000000000L);
                    else numbers.add(curNum);
                    curNum = 0;
                    inNum = false;
                }
            }
            else if(Character.isDigit(file.charAt(0))){
                curNum = Long.parseLong(file.substring(0,1));
                file = file.substring(1);
                inNum = true;
            }
            else{
                file = file.substring(1);
            }
        }
        // System.out.println(problems);
        long tokens = 0;
        for (ArrayList<Long> nums : problems) {
            // x is buttun A and y is button B
            long w = nums.get(0);
            long a = nums.get(1);
            long b = nums.get(2);
            long z = nums.get(3);
            long n = nums.get(4);
            long m = nums.get(5);
            if((w*m-a*n)%(w*z-a*b)!=0){
                continue;
            }
            long y = (w*m-a*n)/(w*z-a*b);
            if((n-y*b)%w != 0) continue;
            long x = (n-y*b)/w;
            // if(x>100 || y>100) continue;
            // System.out.println();
            tokens+=x*3+y;
            // System.out.println(nums);
        }
        System.out.println(tokens);
    }
}
