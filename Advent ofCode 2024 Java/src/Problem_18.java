import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Problem_18 {
    public static void main(String[] args){
        
        String file = "Advent ofCode 2024 Java\\src\\Problem 18.txt";
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        String[] lines = readF(file).split("\n");
        int[][] maze = new int[71][71];
        for (int i = 0; i < 1024; i++) {
            String l = lines[i];
            String s1 = l.substring(0, l.indexOf(","));
            String s2 = l.substring(l.indexOf(",") + 1);
            ArrayList<Integer> coord = new ArrayList<>();
            coord.add(Integer.parseInt(s1));
            coord.add(Integer.parseInt(s2));
            list.add(coord);
        }
        // System.out.println(list.size());
        for (int i = 0; i < list.size(); i++){
            maze[list.get(i).get(1)][list.get(i).get(0)] = 1;
        }
        // for (int i = 0; i < maze.length; i++){
        //     for (int j = 0; j < maze[i].length; j++){
        //         System.out.print(maze[i][j]);
        //     }
        //     System.out.println();
        // }
        for (int k = 1024; k < lines.length; k++){
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            pq.add(new int[]{0, 0, 0});
            boolean[][] visited = new boolean[71][71];
            boolean done = false;
            String l = lines[k];
            String s1 = l.substring(0, l.indexOf(","));
            String s2 = l.substring(l.indexOf(",") + 1);
            int x = Integer.parseInt(s1);
            int y = Integer.parseInt(s2);
            maze[y][x] = 1;
            while (!done){
                if (pq.size() == 0) {
                    System.out.println("nope");
                    System.out.println(k);
                    System.out.println(x + "," + y);
                    k = 10000000;
                    break;
                }
                // System.out.println(pq.size());
                int[] curr = pq.poll();
                if (curr[1] == 70 && curr[2] == 70){
                    System.out.println(curr[0]);
                    done = true;
                }
                for (int i = -1; i <= 1; i++){
                    for (int j = -1; j <= 1; j++){
                        if (i * j != 0 || (i == 0 && j == 0)) continue;
                        if (curr[1] + i < 0 || curr[1] + i >= maze.length || curr[2] + j < 0 || curr[2] + j >= maze.length) 
                            continue;
                        if (maze[curr[1] + i][curr[2] + j] == 1) continue;
                        if (visited[curr[1] + i][curr[2] + j]) continue;
                        visited[curr[1] + i][curr[2] + j] = true;
                        pq.add(new int[]{curr[0] + 1, curr[1] + i, curr[2] + j});
                    }
                }
            }
        }
    }
    // public static int shortest_path(int[][] maze, int x, int y, int dist) {
        
    //     return -1;
    // }
    public static String readF(String fileName) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append("\n");
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}
