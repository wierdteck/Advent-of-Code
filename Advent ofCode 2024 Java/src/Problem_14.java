import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Problem_14 {
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
    public static int mod(int a, int b) {
        int result = a % b;
        return (result < 0) ? result + Math.abs(b) : result;
    }
    public static void main(String args[]) throws IOException {
        String file = readF("Advent ofCode 2024 Java\\src\\Problem 14.txt");
        ArrayList<ArrayList<Integer>> robots = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        boolean inNum = false;
        int curNum = 0;
        int xsize = 101;
        int ysize = 103;
        boolean isNeg = false;
        // x y vx vy
        while (file.length()!=0) {
            if (numbers.size() == 4) {
                robots.add(new ArrayList<Integer>());
                for (Integer integer : numbers) {
                    robots.get(robots.size() - 1).add(integer);
                }
                numbers.clear();
            }
            if(inNum){
                if(Character.isDigit(file.charAt(0))){
                    curNum=curNum*10+Integer.parseInt(file.substring(0,1));
                    file = file.substring(1);
                }
                else{
                    if(isNeg) curNum = -curNum;
                    numbers.add(curNum);
                    curNum = 0;
                    inNum = false;
                    isNeg = false;
                }
            }
            else if(Character.isDigit(file.charAt(0))){
                curNum = Integer.parseInt(file.substring(0,1));
                file = file.substring(1);
                inNum = true;
            }
            else if (file.charAt(0) == '-'){
                isNeg = true;
                file = file.substring(1);
            }
            else{
                file = file.substring(1);
            }
        }
        // System.out.println(robots);
        
        for(int i=0; i<10_404; i++){
            boolean[][] image = new boolean[ysize][xsize];
            boolean overlap = false;
            // int q1 = 0;
            // int q2 = 0;
            // int q3 = 0;
            // int q4 = 0;
            for (ArrayList<Integer> robot : robots) {
                int px = robot.get(0)+i*robot.get(2);
                int py = robot.get(1)+i*robot.get(3);
                int x = mod(px, xsize);
                int y = mod(py, ysize);
                // System.out.println(x + "|" + y);
                // if(x > xsize/2){
                //     if (y > ysize/2) q4++;
                //     if (y < ysize/2) q1++;
                // }
                // if(x < xsize/2){
                //     if (y > ysize/2) q3++;
                //     if (y < ysize/2) q2++;
                // }
                if(image[y][x]) overlap = true;
                image[y][x] = true;
                // System.out.println(x + " " + y);
            }
            if(!overlap){
                System.out.println(i);
                for (int y = 0; y < ysize; y++) {
                    for (int x = 0; x < xsize; x++) {
                        if (image[y][x]) {
                            System.out.print("x");
                        } else {
                            System.out.print(".");
                        }
                    }
                    System.out.println();
                }
                System.out.println("---------------------------------------------------------------------------");
            }
        }
        // System.out.println(q1 + " " + q2 + " "  + q3 + " " + q4);
        // System.out.println(q1*q2*q3*q4);
    }
}