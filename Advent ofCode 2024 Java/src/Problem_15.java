import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Problem_15 {
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
    public static boolean moveRobo(int direction, ArrayList<ArrayList<Character>> map, int x, int y){
        int vy = 0;
        int vx = 0;

        if(direction == 0) vy = 1;
        if(direction == 1) vx = 1;
        if(direction == 2) vy = -1;
        if(direction == 3) vx = -1;

        // if(map.get(y+vy).get(x+vx) == '@'){
        //     System.out.println("error");
        // }
        if(map.get(y+vy).get(x+vx) == '.'){
            return true;
        }
        if(map.get(y+vy).get(x+vx) == '#'){
            return false;
        }
        if(map.get(y+vy).get(x+vx) == 'O'){
            int mul = 2;
            while(map.get(y+mul*vy).get(x+mul*vx) == 'O'){
                mul++;
            }
            if (map.get(y+mul*vy).get(x+mul*vx) == '#') {
                return false;
            }
            if (map.get(y+mul*vy).get(x+mul*vx) == '.') {
                map.get(y+mul*vy).set(x+mul*vx, 'O');
                return true;
            }
        }
        System.out.println("Error");
        return false;
    }
    public static void main(String args[]) throws IOException {
        String file = readF("Advent ofCode 2024 Java\\src\\Problem 15.txt");
        String[] input = file.split("\n");
        int x = 0;
        int y = 0;
        ArrayList<ArrayList<Character>> map = new ArrayList<ArrayList<Character>>();
        for (int i = 0; i < 50; i++) {
            String line = input[i];
            ArrayList<Character> row = new ArrayList<Character>();
            for (char c : line.toCharArray()) {
                if(c == '@'){
                    x = line.indexOf("@");
                    y = i;
                }
                row.add(c);
            }
            map.add(row);
        }
        // System.out.println(map);
        ArrayList<Character> moves = new ArrayList<Character>();
        for (int i = 51; i < 71; i++){
            String line = input[i];
            for (Character character : line.toCharArray()) {
                moves.add(character);
            }
        }
        // System.out.println(moves);
        // System.out.println(x + " " + y);
        int i = 0;
        for (Character character : moves) {
            // System.out.println(i);
            // System.out.println(map);
            i++;
            if(character.equals('v') && moveRobo(0, map, x, y)){
                map.get(y).set(x, '.');
                y+=1;
                map.get(y).set(x, '@');
            }
            if(character.equals('>') && moveRobo(1, map, x, y)){
                map.get(y).set(x, '.');
                x+=1;
                map.get(y).set(x, '@');
            }
            if(character.equals('^') && moveRobo(2, map, x, y)){
                map.get(y).set(x, '.');
                y-=1;
                map.get(y).set(x, '@');
            }
            if(character.equals('<') && moveRobo(3, map, x, y)){
                map.get(y).set(x, '.');
                x-=1;
                map.get(y).set(x, '@');
            }
        }
        int sum = 0;
        // System.out.println(map);
        for (int j = 0; j < map.size(); j++) {
            for (int j2 = 0; j2 < map.get(j).size(); j2++) {
                if(map.get(j).get(j2) == 'O'){
                    sum+=j*100+j2;
                }
            }
        }
        System.out.println(sum);
    }
}
