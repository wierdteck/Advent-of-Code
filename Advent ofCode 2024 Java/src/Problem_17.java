import java.util.ArrayList;
import java.util.List;

public class Problem_17 {

    private static long[] registers = new long[]{117440, 0, 0}; 
    private static List<Long> program;
    private static List<Long> output = new ArrayList<>();

    public Problem_17(List<Long> program) {
        this.program = program;
    }

    public void executeProgram() {
        int instructionPointer = 0;
        while (instructionPointer < program.size()) {
            long opcode = program.get(instructionPointer);
            long operand = (instructionPointer + 1 < program.size()) ? program.get(instructionPointer + 1) : 0;
            long[] reg = registers;
            List<Long> out = output;
            switch ((int)opcode) {
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
                        instructionPointer = (int)operand;
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

    private void adv(long operand) {
        long denominator = (long) Math.pow(2, resolveComboOperand(operand));
        registers[0] = registers[0] / denominator;
    }

    private void bxl(long operand) {
        registers[1] ^= operand; 
    }

    private void bst(long operand) {
        registers[1] = resolveComboOperand(operand) % 8; 
    }

    private void bxc() {
        registers[1] ^= registers[2]; 
    }

    private void out(long operand) {
        output.add(resolveComboOperand(operand) % 8); 
    }

    private void bdv(long operand) {
        long denominator = (long) Math.pow(2, resolveComboOperand(operand));
        registers[1] = registers[0] / denominator;
    }

    private void cdv(long operand) {
        long denominator = (long) Math.pow(2, resolveComboOperand(operand));
        registers[2] = registers[0] / denominator;
    }

    private long resolveComboOperand(long operand) {
        if (operand <= 3) {
            return operand; 
        }
        switch ((int)operand) {
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
        List<Long> program = List.of(2l,4l,1l,5l,7l,5l,1l,6l,0l,3l,4l,2l,5l,5l,3l,0l);
        long length = 1;
        Problem_17 computer = new Problem_17(program);
        ArrayList<Long> search = new ArrayList<Long>();
        search.add(3l);
        for (long j = 1; j < 16; j++){
            ArrayList<Long> t = new ArrayList<Long>();
            for (Long integer : search) t.add(integer);
            search.clear();
            List<Long> sub = program.subList(15-(int)j, 16); 
            for (Long n : t) {
                for (long i = 0; i < 8; i++){
                    registers = new long[]{8*n+i, 0, 0};
                    output = new ArrayList<>();
                    computer.executeProgram();
                    if (output.equals(sub)) {
                        if (output.size() == program.size()) {
                            System.out.println("Output: " + output);
                            System.out.println(8*n+i);
                        }
                        search.add(8*n+i);
                    }
                }
            }
        }
    }
}