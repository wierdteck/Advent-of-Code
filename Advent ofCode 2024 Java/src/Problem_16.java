import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Problem_16 {
    // PAIIIIIIIIIINNNNN I HATE THIS PROBLEM
    // WHY IS IT A GRAPH TRAVERSAL PROBLEM WAAAAAAAAHAWAAHAHHWAHHH
    // Update: graph traversal is actually quite interesting

    enum Part {

    }

    public static void main(String args[]) throws IOException {
        String file = readF("Advent ofCode 2024 Java\\src\\Problem 16.txt");
        String[] lines = file.split("\n");
        int size = lines.length;
        int sx = 0;
        int sy = 0;
        char[][] maze = new char[size][size];
        for (int i = 0; i < lines.length; i++) {
            String string = lines[i];
            for (int j = 0; j < string.length(); j++) {
                char character = string.charAt(j);
                if (character == 'S') {
                    sx = j;
                    sy = i;
                }
                maze[i][j] = character;
            }
        }
        int[] current = { 0, sx, sy, 1, 0 };
        Map<List<Integer>, Integer> mazeCosts = new HashMap<>();
        mazeCosts.put(Arrays.stream(current).boxed().toList().subList(1, 5), 0);
        // System.out.println(mazeCosts);
        int bestValue = Integer.MAX_VALUE;
        Set<List<Integer>> end = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[0]));
        minHeap.add(current);
        int[][] nums = new int[3][5];
        Map<List<Integer>, Set<List<Integer>>> backPointers = new HashMap<>();

        while (minHeap.size() > 0) {
            current = minHeap.poll();
            int value = current[0], x = current[1], y = current[2], dx = current[3], dy = current[4];
            // System.out.println(x + " " + y);
            nums[0] = new int[] { value + 1, x + dx, y + dy, dx, dy };
            nums[1] = new int[] { value + 1000, x, y, -dy, dx };
            nums[2] = new int[] { value + 1000, x, y, dy, -dx };
            List<Integer> curr = Arrays.stream(current).boxed().toList();
            curr = curr.subList(1, 5);
            if (mazeCosts.get(curr) != null && mazeCosts.get(curr) < value)
                continue;
            // if (maze[y][x] == '#')
            //     System.out.println("here");
            if (maze[y][x] == 'E') {
                if (value > bestValue)
                    continue;
                bestValue = value;
                end.add(curr);
            }
            for (int[] num : nums) {
                int nx = num[1], ny = num[2], nvalue = num[0];
                List<Integer> part = Arrays.stream(num).boxed().toList();
                part = part.subList(1, 5);
                // if (ny == 138 && nx == 3){
                //     System.out.println("here");
                // }
                if (maze[ny][nx] == '#')
                    continue;
                if (mazeCosts.get(part) == null)
                    mazeCosts.put(part, Integer.MAX_VALUE);
                int best = mazeCosts.get(part);
                if (nvalue > best)
                    continue;
                if (nvalue < best) {
                    backPointers.put(part, new HashSet<List<Integer>>());
                    mazeCosts.put(part, nvalue);
                }
                backPointers.get(part).add(curr);
                minHeap.add(num);
            }

        }
        
        List<Integer> thing = (List<Integer>)(end.toArray()[0]);
        PriorityQueue<List<Integer>> backtrack = new PriorityQueue<>(Comparator.comparingInt(arr -> arr.get(0)));
        backtrack.add(thing);
        Set<List<Integer>> seen = new HashSet<>();
        while (backtrack.size() > 0) {
            thing = backtrack.poll();
            // System.out.println(thing);
            if (backPointers.get(thing) == null) {
                continue;
            }
            for (List<Integer> i : backPointers.get(thing)) {
                if (seen.contains(i)) continue;
                seen.add(i);
                backtrack.add(i);
                maze[i.get(1)][i.get(0)] = 'X';
            }
        }
        int sum = 0;
        System.out.println(seen.size());
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                if (maze[i][j] == '.') maze[i][j] = ' ';
                // if (maze[i][j] == '#') maze[i][j] = '.';
                if (maze[i][j] == 'X') sum++;
            }
        }
        System.err.println(sum);
        printMap(maze);
    }

    public static void printMap(char[][] map) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Advent ofCode 2024 Java/src/test2.txt"))) {
        for (char[] n : map) {
            for (char cs : n) {
                writer.write(cs);
            }
            writer.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
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