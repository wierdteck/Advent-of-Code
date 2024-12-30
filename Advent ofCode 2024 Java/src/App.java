import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.BitSet;
import java.util.Map;
import java.util.HashMap;


public class App {
    public static boolean range(int x, int lower, int upper) {
        return x >= lower && x < upper;
    }
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
    
    public static void main(String[] args) throws Exception {
        String fileName = "Advent ofCode 2024 Java\\src\\test.txt";
        String file = readF(fileName);
        int size = file.indexOf("\n");
        int[][] map =  new int[size][size];
        for (int i = 0; i < file.length(); i++) {
            if(file.charAt(i) == '\n') continue;
            map[i%(size+1)][i/(size+1)] = Integer.parseInt(file.substring(i, i+1));
        }
        // for (int i = 0; i < size; i++){
        //     for (int j = 0; j < size; j++){
        //         System.out.print(map[j][i]);
        //     }
        //     System.out.println();
        // }
        
    }
    // public static void main(String[] args) throws Exception{
    //     String fileName = "Advent ofCode 2024 Java\\src\\Problem 9.txt";
    //     String file = readF(fileName);
    //     ArrayList<ArrayList<Integer>> numbers = new ArrayList<ArrayList<Integer>>();
    //     // ArrayList<Integer> nums = new ArrayList<Integer>();
    //     // ArrayList<Integer> blanks = new ArrayList<Integer>();
    //     int cur = 0;

    //     for (int i = 0; i < file.length()-1; i++) {
    //         // if(i == file.length()-3){
    //         //     System.out.println("here");
    //         // }
    //         String sub = file.substring(i, i+1);
    //         int num = Integer.parseInt(sub);
    //         if(i%2==0){
    //             ArrayList<Integer> transfer = new ArrayList<Integer>();
    //             transfer.add(cur);
    //             transfer.add(num);
    //             numbers.add(transfer);
    //             cur++;
    //         }
    //         else {
    //             ArrayList<Integer> transfer = new ArrayList<Integer>();
    //             transfer.add(-1);
    //             transfer.add(num);
    //             numbers.add(transfer);
    //         }
    //     }
    //     int count = (int)Math.ceil(numbers.size()/2.0);
    //     // count--;
    //     while (count > 0) {
    //         count--;

    //         //finds the file that needs to be moved
    //         int i = 0;
    //         while (numbers.get(i).get(0) != count) i++;
    //         ArrayList<Integer> transfer = numbers.get(i);
    //         int size = transfer.get(1);
    //         int place = i;
    //         i = 0;
    //         boolean go = true;
    //         ArrayList<Integer> current = numbers.get(i);
    //         while(go){
    //             if(current.get(0) == transfer.get(0)) break; 
    //             if(current.get(0) == -1 && current.get(1) >= size) break;
    //             i++;
    //             current = numbers.get(i);
    //         }
    //         if(numbers.get(i).get(0) != count){
    //             current.set(1, current.get(1) - size);
    //             numbers.set(i, current);

    //             //turns the place where the origional file was into a continuous blank area
    //             numbers.remove(place);
    //             ArrayList<Integer> placeHolder = new ArrayList<Integer>();
    //             placeHolder.add(-1);
    //             placeHolder.add(transfer.get(1)); 
    //             if(numbers.size() > place && numbers.get(place).get(0) == -1) {
    //                 placeHolder.set(1, placeHolder.get(1) + numbers.get(place).get(1));
    //                 numbers.remove(place);
    //             } 
    //             if(numbers.get(place-1).get(0) == -1){
    //                 placeHolder.set(1, placeHolder.get(1) + numbers.get(place-1).get(1));
    //                 numbers.remove(place-1);
    //                 numbers.add(place-1, placeHolder);
    //             }
    //             else{
    //                 numbers.add(place, placeHolder);
    //             }
    //             numbers.add(i, transfer);
    //         } 
    //     }
    //     // System.out.println(numbers);

    //     ArrayList<Integer> nums = new ArrayList<Integer>();
    //     for(int i = 0; i < numbers.size(); i++){
    //         ArrayList<Integer> current = numbers.get(i);
    //         int num = current.get(0);
    //         for (int j = 0; j < current.get(1); j++){
    //             nums.add(num);                
    //         }
    //     }
    //     // System.out.println(nums);
    //     Long answer = (long) 0;
    //     for(int i = 0; i<nums.size();i++){
    //         if(nums.get(i) >= 0){
    //             answer+=i*nums.get(i);
    //         }
    //     }
    //     System.out.println(answer);

        // for (int i = 0; i < file.length()-1; i++){
        //     if(i == file.length()-3){
        //         System.out.println("here");
        //     }
        //     String sub = file.substring(i, i+1);
        //     int num = Integer.parseInt(sub);
        //     if(i%2==0){
        //         for (int j = 0; j<num; j++) numbers.add(cur);
        //         cur++;
        //     }
        //     else for (int j = 0; j < num; j++) numbers.add(-1);
        // }
        // // System.out.println(numbers);
        // int i = 0;
        
        // while (i < numbers.size()){
        //     if(numbers.get(i) == -1){
        //         while (numbers.get(numbers.size()-1) == -1){
        //             if (i == numbers.size()-1) break;
        //             numbers.remove(numbers.size()-1);
        //         }
        //         numbers.set(i, numbers.get(numbers.size()-1));
        //         numbers.remove(numbers.size()-1);
        //     }
        //     i++;
        // }
        // // System.out.println(numbers);
        // long answer = 0; 
        // ArrayList<Integer> test = new ArrayList<Integer>();
        // for (int j = 0; j < numbers.size(); j++){
        //     test.add(numbers.get(j)*j);
        //     answer+=numbers.get(j)*j;
        // }
        // // System.out.println(test);
        // System.out.println(answer);

    // }

    ///////////////////Problem 8////////////////////////////
    // public static void main(String[] args) throws Exception {
    //     String fileName = "Advent ofCode 2024 Java\\src\\Problem 8.txt"; 
    //     String file = readF(fileName);
    //     int size = file.indexOf('\n');
    //     Map<Integer, ArrayList<Integer>> dict = makeDict(file, size);
    //     System.out.println(dict);
    //     Set<Integer> points = new HashSet<Integer>();

    //     for (Map.Entry<Integer, ArrayList<Integer>> entry : dict.entrySet()) {
    //         //get the x coordinates and get the y coordinates into two different arrays
    //         ArrayList<Integer> xs = new ArrayList<Integer>();
    //         ArrayList<Integer> ys = new ArrayList<Integer>();
    //         boolean even = true;
    //         for (int i : entry.getValue()) {
    //             if (even) xs.add(i);
    //             else ys.add(i);
    //             even = (even==false);
    //         }

    //         //check all possible diagonal lines
    //         for (int i = 0; i < xs.size(); i++){
    //             for(int j = 0; j < xs.size(); j++){
    //                 //check if comparisions over
    //                 if(i == xs.size()-1 && j == xs.size()-1) break;
    //                 if(j == i) j++;
                    

    //                 int x1 = xs.get(i);
    //                 int x2 = xs.get(j);
    //                 int y1 = ys.get(i);
    //                 int y2 = ys.get(j);
    //                 int dx = x2-x1;
    //                 int dy = y2-y1;
    //                 int k = 0;
    //                 while (x2+dx*k < size && y2+dy*k < size && x2+dx*k >= 0 && y2+dy*k >= 0) {
    //                     points.add((y2+dy*k)*size + (x2+dx*k));
    //                     k++;
    //                 }
    //             }
    //         }
    //     }
    //     //////////helps with debugging
    //     // char[][] display = new char[size][size];
    //     // for (int i = 0; i < size; i++) {
    //     //     for (int j = 0; j < size; j++) {
    //     //         display[i][j] = '.';
    //     //     }
    //     // }
    //     // for (Integer integer : points) {
    //     //     display[integer/size][integer%size] = '#';
    //     //     // System.out.println(integer + ": " +integer%size);
    //     // }
    //     // for (int i = 0; i < size;i++){
    //     //     for (int j=0; j < size; j++){
    //     //         System.out.print(display[i][j]);
    //     //     }
    //     //     System.out.println();
    //     // }
        
    //     System.out.println(points.size());
    // }

    // private static Map<Integer, ArrayList<Integer>> makeDict(String file, int size){
    //     Map<Integer, ArrayList<Integer>> dict = new HashMap<>();
    //     for (int i = 0; i < file.length(); i++) {
    //         char c = file.charAt(i);
    //         if (c != '\n' && c != '.'){
    //             if (dict.get((int)file.charAt(i)) != null) {
    //                 dict.get((int)file.charAt(i)).add(i%(size+1));
    //                 dict.get((int)file.charAt(i)).add(i/(size+1));
    //             }
    //             else {
    //                 ArrayList<Integer> newList = new ArrayList<>();
    //                 newList.add(i%(size+1));
    //                 newList.add(i/(size+1));
    //                 dict.put((int)file.charAt(i), newList);
    //             }
    //         }
    //     }
    //     return dict;
    // }

    /////////////////////////////Problem 7////////////////////////
    // public static void main(String[] args) throws Exception {
    //     Long.parseLong("40541461584");
    //     String fileName = "Advent ofCode 2024 Java\\src\\test.txt"; 
    //     long answer1 = 0;
    //     String file = readF(fileName);
    //     ArrayList<ArrayList<Long>> dict = makeDict(file);
    //     for (ArrayList<Long> entry : dict) {
    //         long goal = entry.remove(0);
    //         long transfer = entry.remove(0);
    //         // if (transfer == goal) {
    //         //     System.out.println("hmmmm");
    //         // }
    //         if (works(goal, entry, transfer)) {
    //             answer1 += goal;
    //         }
    //     }
    //     // System.out.println(dict.size());
        


    //     // int answer2 = printQueue2(fileName);
    //     System.out.println("Part 1: " + answer1);
    //     // System.out.println("Part 2: " + (answer2 - answer1));
    // }

    // private static boolean works(Long goal, ArrayList<Long> values, long current){
    //     if (values.size() == 0) {
    //         if (current == goal) return true;
    //         return false;
    //     }
    //     long num = values.remove(0);
    //     current+=num;
    //     if(works(goal, values, current)) return true;
    //     current-=num;

    //     current*=num;
    //     if(works(goal, values, current)) return true;
    //     current/=num;

    //     Long transfer = current;
    //     current=Long.parseLong("" + current + num);
    //     if(works(goal, values, current)) return true;
    //     current-=transfer;

    //     values.add(0, num);
        
    //     return false;
    // }


    // private static ArrayList<ArrayList<Long>> makeDict(String file){
    //     ArrayList<ArrayList<Long>> dict = new ArrayList<ArrayList<Long>>();
    //     String[] lines = file.split("\n");
    //     for (String line : lines) {
    //         String[] parts = line.split(": ");
    //         String[] index = parts[1].split(" ");
    //         ArrayList<Long> values = new ArrayList<>();
    //         // for(int i = 0; i<index.length;i++) System.out.println(index[i]);
    //         values.add(Long.parseLong(parts[0].trim()));
    //         for (String value : index) {
    //             values.add(Long.parseLong(value.trim()));
    //         }
    //         dict.add(values);
    //     }
    //     return dict;
    // }

    //////////////////////Problem 6/////////////////////
    // public static void main(String[] args) throws Exception {
    //     //x0x
    //     //3x1
    //     //x2x
    //     //4 is if in path
    //     //5 is '.'
    //     //6 if '^'
    //     //7 is '#'
    //     String fileName = "Advent ofCode 2024 Java\\src\\Problem 6.txt"; 
    //     int answer1 = pathSquares2(fileName);
    //     // int answer2 = printQueue2(fileName);
    //     System.out.println("Part 1: " + answer1);
    //     // System.out.println("Part 2: " + (answer2 - answer1));
    // }
    // private static int pathSquares2(String fileName) throws Exception {
    //     String file = readF(fileName);
    //     int start = file.indexOf('^');
    //     int s = 130;
    //     int x = start/(s+1);
    //     int y = start%(s+1);
    //     // System.out.println(x + "|" + y);
    //     BitSet[][] m = createMap(file, s);
    //     // System.out.println(map[x][y]);
    //     int condition = 0;
    //     ArrayList<ArrayList<Integer>> squares = new ArrayList<ArrayList<Integer>>();
    //     int answer = 0;
        
    //     while (!m[x][y].get(condition)) {
    //         // map[x][y].set(condition);
    //         // map[x][y].set(4);
    //         boolean blocked = false;
    //         if(condition == 0 && x==0) break;
    //         if(condition == 1 && y==s-1) break;
    //         if(condition == 2 && x==s-1) break;
    //         if(condition == 3 && y==0) break;

    //         if(condition == 0 && m[x-1][y].get(7)) blocked = true;
    //         if(condition == 1 && m[x][y+1].get(7)) blocked = true;
    //         if(condition == 2 && m[x+1][y].get(7)) blocked = true;
    //         if(condition == 3 && m[x][y-1].get(7)) blocked = true;
    //         if(blocked){
    //             condition = (condition + 1)%4;
    //             // m[x][y].set(condition);
    //         }
    //         blocked = false;
    //         if(condition == 0 && m[x-1][y].get(7)) blocked = true;
    //         if(condition == 1 && m[x][y+1].get(7)) blocked = true;
    //         if(condition == 2 && m[x+1][y].get(7)) blocked = true;
    //         if(condition == 3 && m[x][y-1].get(7)) blocked = true;
    //         if(blocked){
    //             condition = (condition + 1)%4;
    //             // map[x][y].set(condition);
    //         }
    //         if(condition == 0) x--;
    //         if(condition == 1) y++;
    //         if(condition == 2) x++;
    //         if(condition == 3) y--;
    //         if (m[x][y].get(4)==false) {
    //             ArrayList<Integer> transfer = new ArrayList<Integer>();
    //             transfer.add(x);
    //             transfer.add(y);
    //             squares.add(transfer);
    //             m[x][y].set(4);
    //         }
    //     }
    //     // for (int i = 0; i < m.length; i++) {
    //     //     for (int j = 0; j < m[i].length; j++) {
    //     //         System.out.print(m[i][j].cardinality());
    //     //     }
    //     //     System.out.println();
    //     // }
    //     // for (int i = 0; i < m.length; i++) {
    //     //     for (int j = 0; j < m[i].length; j++) {
    //     //         m[i][j].set(5, false);
    //     //     }
    //     //     System.out.println();
    //     // }

    //     // for (ArrayList<Integer> arrayList : squares) {
    //     //     System.out.println(arrayList.get(0) + "," + arrayList.get(1));
    //     //     System.out.println();     
    //     // }
        
    //     // System.out.println(squares.size());
    //     // int size = squares.size();
    //     BitSet[][] map = new BitSet[s][s];
    //     for (int i = 0; i < s; i++) {
    //         for (int j = 0; j < s; j++) {
    //             map[i][j] = new BitSet(8);
    //         }
    //     }
    //     for (int i = 0; i < squares.size(); i++) 
    //     {
    //         for (int j = 0; j < s; j++) {
    //             for (int k = 0; k < s; k++) {
    //                 for (int l = 0; l < 8; l++) {
    //                     if (m[j][k].get(l) == true) map[j][k].set(l);
    //                 }
    //             }
    //         }
    //         int xb = squares.get(i).get(0);
    //         int yb = squares.get(i).get(1);
    //         // System.out.println(i);
    //         x = start/(s+1);
    //         y = start%(s+1);
    //         condition = 0;
    //         map[xb][yb].set(7);
    //         int t = 0;
    //         // for (BitSet[] row : map) {
    //         //     for (BitSet bit : row) {
    //         //         t+=bit.cardinality();
    //         //     }
    //         // }
    //         // System.out.println(t);
            
    //         // boolean inloop = true;
    //         while (!map[x][y].get(condition)) {
    //             map[x][y].set(condition);
    //             boolean blocked = false;
    //             if(condition == 0 && x==0) {
    //                 // inloop = false;
    //                 answer--;
    //                 break;
    //             }
    //             if(condition == 1 && y==s-1) {
    //                 // inloop = false;
    //                 answer--;
    //                 break;
    //             }
    //             if(condition == 2 && x==s-1) {
    //                 // inloop = false;
    //                 answer--;
    //                 break;
    //             }
    //             if(condition == 3 && y==0) {
    //                 // inloop = false;
    //                 answer--;
    //                 break;
    //             }
    
    //             if(condition == 0 && map[x-1][y].get(7)) blocked = true;
    //             if(condition == 1 && map[x][y+1].get(7)) blocked = true;
    //             if(condition == 2 && map[x+1][y].get(7)) blocked = true;
    //             if(condition == 3 && map[x][y-1].get(7)) blocked = true;
    //             if(blocked){
    //                 condition = (condition + 1)%4;
    //                 map[x][y].set(condition);
    //             }
    //             blocked = false;
                
    //             if(condition == 0 && x==0) {
    //                 // inloop = false;
    //                 answer--;
    //                 break;
    //             }
    //             if(condition == 1 && y==s-1) {
    //                 // inloop = false;
    //                 answer--;
    //                 break;
    //             }
    //             if(condition == 2 && x==s-1) {
    //                 // inloop = false;
    //                 answer--;
    //                 break;
    //             }
    //             if(condition == 3 && y==0) {
    //                 // inloop = false;
    //                 answer--;
    //                 break;
    //             }
    
    //             if(condition == 0 && map[x-1][y].get(7)) blocked = true;
    //             if(condition == 1 && map[x][y+1].get(7)) blocked = true;
    //             if(condition == 2 && map[x+1][y].get(7)) blocked = true;
    //             if(condition == 3 && map[x][y-1].get(7)) blocked = true;
    //             if(blocked){
    //                 condition = (condition + 1)%4;
    //                 map[x][y].set(condition);
    //             }
    //             if(condition == 0) x--;
    //             if(condition == 1) y++;
    //             if(condition == 2) x++;
    //             if(condition == 3) y--;
    //             // for (BitSet[] bitSets : map) {
    //             //     for (BitSet bSet : bitSets) {
    //             //         System.out.print(bSet.cardinality());
    //             //     }
    //             //     System.out.println();
    //             // }
    //             // System.out.println();
    //         }
    //         for (int j = 0; j < s; j++) {
    //             for (int k = 0; k < s; k++) {
    //                 for (int k2 = 0; k2 < 8; k2++) {
    //                     map[j][k].set(k2, false);
    //                 }
    //             }
    //         }
    //         answer++;
    //     }
    //     return answer;
    // }
    // private static int pathSquares(String fileName) throws Exception {
    //     String file = readF(fileName);
    //     int start = file.indexOf('^');
    //     int s = 130;
    //     int x = start/(s+1);
    //     int y = start%(s+1);
    //     // System.out.println(x + "|" + y);
    //     BitSet[][] map = createMap(file, s);
    //     // System.out.println(map[x][y]);
    //     int condition = 0;
    //     int answer = 0;
    //     Set<ArrayList<Integer>> squares = new HashSet<ArrayList<Integer>>();
    //     int works = 0;
        
    //     while (!map[x][y].get(condition)) {
    //         map[x][y].set(condition);
    //         map[x][y].set(4);
    //         boolean blocked = false;
    //         if(condition == 0 && x==0) break;
    //         if(condition == 1 && y==s-1) break;
    //         if(condition == 2 && x==s-1) break;
    //         if(condition == 3 && y==0) break;

    //         if(condition == 0 && map[x-1][y].get(7)) blocked = true;
    //         if(condition == 1 && map[x][y+1].get(7)) blocked = true;
    //         if(condition == 2 && map[x+1][y].get(7)) blocked = true;
    //         if(condition == 3 && map[x][y-1].get(7)) blocked = true;
    //         if(blocked){
    //             condition = (condition + 1)%4;
    //             map[x][y].set(condition);
    //         }
    //         blocked = false;
    //         if(condition == 0 && map[x-1][y].get(7)) blocked = true;
    //         if(condition == 1 && map[x][y+1].get(7)) blocked = true;
    //         if(condition == 2 && map[x+1][y].get(7)) blocked = true;
    //         if(condition == 3 && map[x][y-1].get(7)) blocked = true;
    //         if(blocked){
    //             condition = (condition + 1)%4;
    //             map[x][y].set(condition);
    //         }
    //         if(condition == 0) x--;
    //         if(condition == 1) y++;
    //         if(condition == 2) x++;
    //         if(condition == 3) y--;
    //         ArrayList<Integer> transfer = new ArrayList<Integer>();
    //         transfer.add(x);
    //         transfer.add(y);
    //         squares.add(transfer);
    //     }
        
    //     for (BitSet[] bitSets : map) {
    //         for (BitSet bSet : bitSets) {
    //             bSet.set(7, false);
    //         }
    //     }
        
    //     for (BitSet[] bitSets : map) {
    //         for (BitSet bSet : bitSets) {
    //             if (bSet.get(4)) {
    //                 answer++;
    //             }
    //         }
    //     }

    //     //size of my problem is 130 by 130
        
    //     return answer;
    // }
    // private static BitSet[][] createMap(String file, int s) {
    //     BitSet[][] map = new BitSet[s][s];
    //     for (int i = 0; i < file.length(); i++) {
    //         if(file.charAt(i) == '\n'){
    //             continue;
    //         }
    //         else{
    //             int x = i/(s+1);
    //             int y = i%(s+1);
    //             map[x][y] = new BitSet(8);
    //             // if (file.charAt(i) == '.') map[x][y].set(5);
    //             if (file.charAt(i) == '#') map[x][y].set(7);
    //             // if (file.charAt(i) == '^') {
    //             //     map[x][y].set(6);
    //             //     System.out.println(x + ',' + y);
    //             // }
    //         }
    //     }
    //     return map;
    // }

    ////////////////////////Problem 5//////////////////////////////
    // public static void main(String[] args) throws Exception {
    //     String fileName = "Advent ofCode 2024 Java\\src\\Problem 5.txt"; 
    //     int answer1 = printQueue(fileName);
    //     int answer2 = printQueue2(fileName);
    //     System.out.println("Part 1: " + answer1);
    //     System.out.println("Part 2: " + (answer2 - answer1));
    // }

    // public static int printQueue2(String fileName){
    //     String file = readF(fileName);
    //     ArrayList<BitSet> map = makeMap(file.substring(0, file.indexOf("\n\n")));
    //     ArrayList<ArrayList<Integer>> cases = testCases(file.substring(file.lastIndexOf("\n\n")+2));
    //     ArrayList<Boolean> checks = new ArrayList<Boolean>();
    //     int sum = 0;

    //     for (int i = 0; i < cases.size(); i++) {
    //         ArrayList<Integer> arrayList = cases.get(i);
    //         boolean caseReady = false;
    //         while (!caseReady){
    //             caseReady = true;
    //             for (int j = 0; j < arrayList.size(); j++) {
    //                 int index = arrayList.get(j);
    //                 BitSet denials = map.get(index);
    //                 for (int k = j-1; k >= 0; k--) {
    //                     if (denials.get(arrayList.get(k))) {
    //                         int temp = arrayList.get(k);
    //                         arrayList.set(k, arrayList.get(j));
    //                         arrayList.set(j, temp);
    //                         caseReady = false;
    //                     }
    //                 }
    //             }
    //         }
    //         // System.out.println(arrayList);
    //         cases.set(i, arrayList);
    //     }
    //     for (int i = 0; i < cases.size(); i++) {
    //         sum+=cases.get(i).get(cases.get(i).size()/2);
    //     }
    //     return sum;
    // }
    

    // public static int printQueue(String fileName){
    //     String file = readF(fileName);
    //     ArrayList<BitSet> map = makeMap(file.substring(0, file.indexOf("\n\n")));
    //     ArrayList<ArrayList<Integer>> cases = testCases(file.substring(file.lastIndexOf("\n\n")+2));
    //     ArrayList<Boolean> checks = new ArrayList<Boolean>();
    //     int sum = 0;

    //     // System.out.println(cases);
    //     for (ArrayList<Integer> arrayList : cases) {
    //         boolean fail = false;
    //         for (int i = 0; i < arrayList.size(); i++){
    //             BitSet denials = map.get(arrayList.get(i));
    //             for (int j = i-1; j >= 0; j--) {
    //                 if (denials.get(arrayList.get(j))) {
    //                     checks.add(false);
    //                     fail = true;
    //                     i = arrayList.size();
    //                     j = 0;
    //                 }
    //             }
    //         }
    //         if(!fail) {
    //             // System.out.println("asdfasd");
    //             checks.add(true);
    //         }
    //     }
    //     for (int i = 0; i < checks.size(); i++) {
    //         if(checks.get(i)){
    //             sum+=cases.get(i).get(cases.get(i).size()/2);
    //         }
    //     }
    //     return sum;
    // }

    // private static ArrayList<BitSet> makeMap(String rules){ 
    //     ArrayList<BitSet> map = new ArrayList<BitSet>();
    //     for (int i = 0; i < 100; i++) {
    //         BitSet transfer = new BitSet(100);
    //         map.add(transfer);
    //     }
    //     for (String rule : rules.split("\n")) {
    //         int left = Integer.parseInt(rule.substring(0, 2));
    //         int right = Integer.parseInt(rule.substring(3));
    //         map.get(left).set(right);
    //     }
    //     System.out.println(map);
    //     return map;
    // }
    // private static ArrayList<ArrayList<Integer>> testCases(String rules){ 
    //     ArrayList<ArrayList<Integer>> cases = new ArrayList<ArrayList<Integer>>();
    //     for (String rule : rules.split("\n")) {
    //         ArrayList<Integer> transfer = new ArrayList<Integer>();
    //         String[] split = rule.split(",");
    //         for (String s : split) {
    //             transfer.add(Integer.parseInt(s));
    //         }
    //         cases.add(transfer);
    //     }
    //     // System.out.println(cases);
    //     return cases;
    // }


    /////////////////////////Problem 4/////////////////////////////
    // public static void main(String[] args) throws Exception {
    //     String fileName = "Advent ofCode 2024 Java\\src\\Problem 4.txt"; 
    //     int answer = XMAS(fileName);
    //     int answer1 = X_MAS(fileName); 
    //     System.out.println("Part 1: " + answer);
    //     System.out.println("Part 2: " + answer1);
    // }
    // public static int XMAS(String fileName){
    //     int[][] numbers = new int[140][140];
    //     int ret = 0;
    //     try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
    //         String line;
    //         int j = 0;
    //         while ((line = reader.readLine())!= null) {
    //             for (int i = 0; i < line.length(); i++) {
    //                 int c = line.charAt(i);
    //                 numbers[j][i] = c;
    //             }
    //             j++;
    //         }
    //     } catch (Exception e) {
    //         System.out.println("Exception occurred: " + e.getMessage());
    //     }
    //     for (int i = 0; i < 140; i++) {
    //         for (int j = 0; j < 140; j++) {
    //             // System.out.print(numbers[i][j]);
    //             if (numbers[i][j] == 88){
    //                 if (direction(numbers, i, j, 1, 1)) ret++;
    //                 if (direction(numbers, i, j, 0, 1)) ret++;
    //                 if (direction(numbers, i, j, -1, 1)) ret++;
    //                 if (direction(numbers, i, j, 1, 0)) ret++;
    //                 if (direction(numbers, i, j, -1, 0)) ret++;
    //                 if (direction(numbers, i, j, 1, -1)) ret++;
    //                 if (direction(numbers, i, j, 0, -1)) ret++;
    //                 if (direction(numbers, i, j, -1, -1)) ret++;
    //             }
    //         }
    //     }
    //     return ret;
    // }
    // public static int X_MAS(String fileName){
    //     int[][] numbers = new int[140][140];
    //     int ret = 0;
    //     try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
    //         String line;
    //         int j = 0;
    //         while ((line = reader.readLine())!= null) {
    //             for (int i = 0; i < line.length(); i++) {
    //                 int c = line.charAt(i);
    //                 numbers[j][i] = c;
    //             }
    //             j++;
    //         }
    //     } catch (Exception e) {
    //         System.out.println("Exception occurred: " + e.getMessage());
    //     }
    //     for (int i = 0; i < 140; i++) {
    //         for (int j = 0; j < 140; j++) {
    //             // even odd
    //             //  odd even
    //             boolean oddM = false;
    //             boolean evenM = false;
    //             boolean oneS = false;
    //             if (numbers[i][j] == 65){
    //                 if (direction2(numbers, i, j, 1, 1, 77)) {
    //                     oddM = true;
    //                 }
    //                 if (direction2(numbers, i, j, -1, 1, 77)) {
    //                     evenM = true;
    //                 }
    //                 if (direction2(numbers, i, j, -1, -1, 77)) {
    //                     if (oddM) continue;
    //                     else oddM = true;
    //                 }
    //                 if (direction2(numbers, i, j, 1, -1, 77)) {
    //                     if (evenM) continue;
    //                     else evenM = true;
    //                 }
    //                 if (!(evenM&&oddM)) continue;
    //                 if (direction2(numbers, i, j, 1, 1, 83)) {
    //                     oneS = true;
    //                 }
    //                 if (direction2(numbers, i, j, -1, 1, 83)) {
    //                     if (oneS) {
    //                         ret++;
    //                         continue;
    //                     }
    //                     else oneS = true;
    //                 }
    //                 if (direction2(numbers, i, j, -1, -1, 83)) {
    //                     if (oneS) {
    //                         ret++;
    //                         continue;
    //                     }
    //                     else oneS = true;
    //                 }
    //                 if (direction2(numbers, i, j, 1, -1, 83)) {
    //                     if (oneS) {
    //                         ret++;
    //                         continue;
    //                     }
    //                     else oneS = true;
    //                 }
    //             }
    //         }
    //     }
    //     return ret;
    // }
    // public static boolean direction2(int[][] grid, int x, int y, int vx, int vy, int c){
    //     boolean ret = false;
    //     x+=vx;
    //     y+=vy;
    //     if (xmasRules(x, y, grid, c)) {
    //         ret = true;
    //     }
    //     return ret;
    // }

    // public static boolean direction(int[][] grid, int x, int y, int vx, int vy){
    //     boolean ret = false;
    //     x+=vx;
    //     y+=vy;
    //     if (xmasRules(x, y, grid, 77)) {
    //         x+=vx;
    //         y+=vy;
    //         if(xmasRules(x, y, grid, 65)){
    //             x+=vx;
    //             y+=vy;
    //             if (xmasRules(x, y, grid, 83)){
    //                 ret = true;
    //             }
    //         }
    //     }
    //     return ret;
    // }

    // public static boolean xmasRules(int x, int y, int[][] grid, int c){
    //     return range(x, 0, 140) && range(y, 0, 140) && grid[x][y] == c;
    // }







    ////////////////////////////////////Problem 3////////////////////////////////
    // public static void main(String[] args) throws Exception {
    //     String fileName = "Advent ofCode 2024 Java\\src\\Problem 3.txt"; 
    //     ArrayList<Integer> answerList = multiplicationReader2(fileName);
    //     int answer = 0;
    //     for (Integer integer : answerList) {
    //         System.out.println(integer);
    //     }
    //     for (Integer integer : answerList) {
    //         answer+=integer;
    //     }

    //     System.out.println("Part 1: " + answer);
    //     // System.out.println("Part 2: " + answer1);
    // }
    // public static ArrayList<Integer> multiplicationReader2(String fileName){
    //     ArrayList<Integer> numbers = new ArrayList<Integer>();
    //     try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
    //         String line;
    //         boolean doRead = true;
    //         while ((line = reader.readLine()) != null) {
    //             int i = 0;
    //             while (i < line.length()) {
    //                 if ((i < line.length() - 8) && line.substring(i, i+7).equals("don't()")) {
    //                     i+=7;
    //                     doRead = false;
    //                     continue;
    //                 }
    //                 if((i < line.length() - 5) && line.substring(i, i+4).equals("do()")){
    //                     doRead = true;
    //                     i+=4;
    //                     continue;
    //                 }
    //                 if(i < line.length()-5 && doRead && line.substring(i, i+4).equals("mul(")){
    //                     i+=4;
    //                     int c = 0;
    //                     int number = 0;
    //                     c = (int)line.charAt(i);
    //                     i++;
    //                     while (c > 47 && c < 58){
    //                         // System.out.println(c);
    //                         number = number*10 + c-48;
    //                         c = (int)line.charAt(i);
    //                         i++;
    //                     }
    //                     if (c == (int)',') {
    //                         int number2 = 0;
    //                         c = (int)line.charAt(i);
    //                         i++;
    //                         while (c > 47 && c < 58){
    //                             number2 = number2*10 + c-48;
    //                             c = (int)line.charAt(i);
    //                             i++;
    //                         }
    //                         if (c == (int)')'){
    //                             System.out.println(number*number2);
    //                             numbers.add(number*number2);
    //                         }
    //                     }
    //                     continue;
    //                 }
    //                 i++;
    //             }
    //         }
            
    //         // System.out.println(numbers.size());
    //         return numbers;

    //     } catch (Exception e) {
    //         System.out.println("Exception while reading " + e.getMessage());
    //     }
        

    //     return numbers;
    // }
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