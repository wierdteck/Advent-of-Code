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
        for (int x = 0; x < visited.length; x++) {
            for (int y = 0; y < visited.length; y++) {
                if(visited[x][y] == false){
                    floodFill(x, y, map, visited);
                }
            }
        }
        // floodFill(0, 0, map, visited);
    }
    public static int floodFill(int x, int y, char[][] map, boolean[][] visited){
        if(x < 0 || x >= map.length) return -1;
        if(y < 0 || y >= map.length) return -1;
        if(visited[x][y]) return -1;

        floodFill(x, y+1, map, visited);
        floodFill(x+1, y, map, visited);
        floodFill(x, y-1, map, visited);
        floodFill(x-1, y, map, visited);
        return -1;
    }
}
