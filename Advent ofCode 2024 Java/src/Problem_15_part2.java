import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Problem_15_part2 {
    
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
    public static boolean moveRoboSide(int direction, ArrayList<ArrayList<Character>> map, int x, int y){
        int vx = 0;

        if(direction == 1) vx = 1;
        if(direction == 3) vx = -1;

        if(map.get(y).get(x+vx) == '.'){
            return true;
        }
        if(map.get(y).get(x+vx) == '#'){
            return false;
        }
        if(map.get(y).get(x+vx) == ']' || map.get(y).get(x+vx) == '['){
            int mul = 2;
            while (map.get(y).get(x+vx*mul) != '#' && map.get(y).get(x+vx*mul) != '.') {
                mul++;
            }
            if (map.get(y).get(x+vx*mul) == '#') {
                return false;
            }
            if (map.get(y).get(x+vx*mul) == '.') {
                for (int i = 0; i < mul; i++) {
                    map.get(y).set(x+vx*(mul-i), map.get(y).get(x+vx*(mul-i-1)));
                }
                return true;
            }
        }
        System.out.println("error");
        return false;
    }
    
    public static boolean moveRobo(int direction, ArrayList<ArrayList<Character>> map, int x, int y){
        int vy = 0;

        if(direction == 0) vy = 1;
        if(direction == 2) vy = -1;

        if(map.get(y+vy).get(x) == '.'){
            return true;
        }
        if(map.get(y+vy).get(x) == '#'){
            return false;
        }
        if((map.get(y+vy).get(x) == '[' || map.get(y+vy).get(x) == ']')){
            if (checkPossible(direction, map, x, y)){
                moveBoxes(direction, map, x, y);
                return true;
            }
            else return false;
        }

        System.out.println("error");
        return false;
    }

    public static boolean checkPossible(int direction, ArrayList<ArrayList<Character>> map, int x, int y){
        int vy = 0;

        if(direction == 0) vy = 1;
        if(direction == 2) vy = -1;
        if(map.get(y+vy).get(x) == '#'){
            return false;
        }
        if (map.get(y+vy).get(x) == '[') {
            if (!checkPossible(direction, map, x, y+vy)) return false;
            if (!checkPossible(direction, map, x+1, y+vy)) return false;
        }
        if(map.get(y+vy).get(x) == ']') {
            if (!checkPossible(direction, map, x, y+vy)) return false;
            if (!checkPossible(direction, map, x-1, y+vy)) return false;
        }

        return true;
    }
    public static void moveBoxes(int direction, ArrayList<ArrayList<Character>> map, int x, int y){
        int vy = 0;

        if(direction == 0) vy = 1;
        if(direction == 2) vy = -1;
        if (map.get(y+vy).get(x) == '[') {
            // printMap(map);
            moveBoxes(direction, map, x, y+vy);
            // printMap(map);
            map.get(y+vy*2).set(x, '[');
            map.get(y+vy).set(x, '.');
            // printMap(map);
            moveBoxes(direction, map, x+1, y);
            // printMap(map);
        }
        if(map.get(y+vy).get(x) == ']') {
            // printMap(map);
            moveBoxes(direction, map, x, y+vy);
            // printMap(map);
            map.get(y+vy*2).set(x, ']');
            map.get(y+vy).set(x, '.');
            // printMap(map);
            moveBoxes(direction, map, x-1, y);
            // printMap(map);
        }
    }
    public static void printMap(ArrayList<ArrayList<Character>> map) {
        // for (ArrayList<Character> row : map) {
        //     for (Character cell : row) {
        //         System.out.print(cell); // Print each character
        //     }
        //     System.out.println(); // Move to the next line after each row
        // }
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
                if(c == '.' || c == '#'){
                    row.add(c);
                    row.add(c);
                }
                if(c == '@'){
                    row.add(c);
                    row.add('.');
                    x = line.indexOf("@")*2;
                    y = i;
                }
                if(c == 'O'){
                    row.add('[');
                    row.add(']');
                }
            }
            map.add(row);
        }
        // printMap(map);
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
            System.out.println(i);
            if(i == 60){
                System.out.println("here");
            }
            // System.out.println(map);
            i++;
            if(character.equals('v') && moveRobo(0, map, x, y)){
                map.get(y).set(x, '.');
                y+=1;
                map.get(y).set(x, '@');
            }
            if(character.equals('>') && moveRoboSide(1, map, x, y)){
                map.get(y).set(x, '.');
                x+=1;
                map.get(y).set(x, '@');
            }
            if(character.equals('^') && moveRobo(2, map, x, y)){
                map.get(y).set(x, '.');
                y-=1;
                map.get(y).set(x, '@');
            }
            if(character.equals('<') && moveRoboSide(3, map, x, y)){
                map.get(y).set(x, '.');
                x-=1;
                map.get(y).set(x, '@');
            }
        }
        int sum = 0;
        // System.out.println(map);
        for (int j = 0; j < map.size(); j++) {
            for (int j2 = 0; j2 < map.get(j).size(); j2++) {
                if(map.get(j).get(j2) == '['){
                    sum+=j*100+j2;
                }
            }
        }
        System.out.println(sum);
    }
}
