import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Problem_18 {
    public static void main(String[] args){
        String file = "src/Problem 18.txt";
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        String[] lines = readF(file).split("\n");
        int[][] maze = new int[70][70];
        for (String l : lines) {
            String s1 = l.substring(0, l.indexOf(","));
            String s2 = l.substring(l.indexOf(",") + 1);
            ArrayList<Integer> coord = new ArrayList<>();
            coord.add(Integer.parseInt(s1));
            coord.add(Integer.parseInt(s2));
            list.add(coord);
        }
        for (int i = 0; i < list.size(); i++){
            maze[list.get(i).get(0)][list.get(i).get(1)] = 1;
        }
    }
    public static int shortest_path(int[][] maze){
        
        return -1;
    }
    public static String readF(String fileName) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}
