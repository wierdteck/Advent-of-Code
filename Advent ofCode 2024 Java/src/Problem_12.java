import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Problem_12 {
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
        String file = readF("Advent ofCode 2024 Java\\src\\Problem 12.txt");
        String[] lines = file.split("\n");
        char[][] map = new char[lines.length][lines.length];
        int i = 0;
        for (String line : lines){
            map[i] = line.toCharArray();
            i++;
        }
        // for (char[] cs : map) {
        //     for (char cs2 : cs) {
        //         System.out.print(cs2);
        //     }
        //     System.out.println();
        // }
        boolean[][] visited = new boolean[lines.length][lines.length];
        int sum = 0;
        for (int x = 0; x < visited.length; x++) {
            for (int y = 0; y < visited.length; y++) {
                if(visited[x][y] == false){
                    int[] perimeter = {0};
                    int[] area = {0};
                    floodFill(x, y, map, visited, area, perimeter, map[x][y], 0, 0);
                    sum+=area[0]*perimeter[0];
                    // System.out.println(area[0]*perimeter[0]);
                }
            }
        }
        System.out.println(sum);
        // floodFill(0, 0, map, visited);
    }
    public static int floodFill(int x, int y, char[][] map, boolean[][] visited, int[] area, int[] perimeter, char current, int vx, int vy){
        x+=vx; y+=vy;
        // System.out.println(x + " " + y); 
        if(x < 0 || x >= map.length || y < 0 || y >= map.length || map[x][y] != current) { // if it exits the region some really condensed maths i don't want to finger wave calculate again
            int wx = x-vy-vx;
            int wy = y-vy+vx;
            int x2 = x-vy;
            int y2 = y+vx;
            // char test = map[x2][y2];
            if(wx < 0 || wx >= map.length || wy < 0 || wy >= map.length || map[wx][wy] != current) {
                perimeter[0]++;
            }
            else if(x2 >= 0 && x2 < map.length && y2 >= 0 && y2 < map.length && map[x2][y2] == current) {
                // System.out.println(map[x2][y2]);
                perimeter[0]++;
            }
            return -1;
        }
        if(visited[x][y]) return -1;
        visited[x][y] = true;
        area[0]++;
        
        floodFill(x, y, map, visited, area, perimeter, current, 0, 1);
        floodFill(x, y, map, visited, area, perimeter, current, 1, 0);
        floodFill(x, y, map, visited, area, perimeter, current, 0, -1);
        floodFill(x, y, map, visited, area, perimeter, current, -1, 0);
        return -1;
    }
}
