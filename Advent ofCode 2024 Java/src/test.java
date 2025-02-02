import java.util.ArrayList;
import java.util.List;

public class test { 

    private static int[] registers = new int[]{117440, 0, 0}; 
    private static List<Integer> program;
    private static List<Integer> output = new ArrayList<>();

    public test(List<Integer> program) {
        this.program = program;
    }

    public void executeProgram() {
        int instructionPointer = 0;
        while (instructionPointer < program.size()) {
            int opcode = program.get(instructionPointer);
            int operand = (instructionPointer + 1 < program.size()) ? program.get(instructionPointer + 1) : 0;
            int[] reg = registers;
            List<Integer> out = output;
            switch (opcode) {
                case 0: // adv
                    adv(operand);
                    break;
                case 1: // bxl
                    bxl(operand);
                    break;
                case 2: // bst
                    bst(operand);
                    break;
                case 3: // jnz
                    if (registers[0] != 0) {
                        instructionPointer = operand;
                    } else {
                        instructionPointer += 2;
                    }
                    continue;
                case 4: // bxc
                    bxc();
                    break;
                case 5: // out
                    out(operand);
                    break;
                case 6: // bdv
                    bdv(operand);
                    break;
                case 7: // cdv
                    cdv(operand);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid opcode: " + opcode);
            }

            instructionPointer += 2;
        }
    }

    private void adv(int operand) {
        int denominator = (int) Math.pow(2, resolveComboOperand(operand));
        registers[0] = registers[0] / denominator;
    }

    private void bxl(int operand) {
        registers[1] ^= operand; 
    }

    private void bst(int operand) {
        registers[1] = resolveComboOperand(operand) % 8; 
    }

    private void bxc() {
        registers[1] ^= registers[2]; 
    }

    private void out(int operand) {
        output.add(resolveComboOperand(operand) % 8); 
    }

    private void bdv(int operand) {
        int denominator = (int) Math.pow(2, resolveComboOperand(operand));
        registers[1] = registers[0] / denominator;
    }

    private void cdv(int operand) {
        int denominator = (int) Math.pow(2, resolveComboOperand(operand));
        registers[2] = registers[0] / denominator;
    }

    private int resolveComboOperand(int operand) {
        if (operand <= 3) {
            return operand; 
        }
        switch (operand) {
            case 4:
                return registers[0]; 
            case 5:
                return registers[1]; 
            case 6:
                return registers[2];
            default:
                throw new IllegalArgumentException("Invalid combo operand: " + operand);
        }
    }

    public static void main(String[] args) {
        List<Integer> program = List.of(2,4,1,5,7,5,1,6,0,3,4,2,5,5,3,0);
        int length = 1;
        test computer = new test(program);
        for (int i = (int)Math.pow(8, length-1)-1                            ; i < (int)Math.pow(8, length); i++) {
            registers = new int[]{i, 0, 0};
            output = new ArrayList<>();
            computer.executeProgram();

                
            System.out.println("Output: " + output);
            System.out.println(i);
        }
    }
}