package chip8;

import java.util.Arrays;

public class chip8 {
    private short opcode;                       // current opcode
    private byte[] V = new byte[16];            // 16 8-bit gen registers (V0-VE)
    private short I;                            // index register
    private short pc;                           // program counter

    /**
     * Memory map:
     * 0x000-0x1FF - Chip 8 interpreter (contains fontset in emu)
     * 0x050-0x0A0 - Used for the built in 4x5 pixel font set (0-F)
     * 0x200-0xFFF - Program ROM & work RAM
     */
    private short[] memory = new short[4096];   // 4k system memory

    private byte[] gfx = new byte[64 * 32];     // pixel state (graphics)

    private byte delayTimer;                    // timer registers
    private byte soundTimer;

    private short[] stack = new short[16];      // program stack
    private short sp;                           // stack pointer

    private byte[] key = new byte[16];          // keypad state (0x0-0xF)

    public chip8() {
        pc = 0x200;    // start program counter at 0x200

        // Load fontset
        for (int i = 0; i < 80; i++) {
            // memory[i] = chip8Fontset[i];
        }
    }

    public void reset() {
        pc = 0x200;    // start program counter at 0x200

        // Reset
        opcode = 0x00;
        I = 0x00;
        sp = 0x00;

        // Clear
        Arrays.fill(gfx, (byte) 0x0);
        Arrays.fill(stack, (short) 0x00);
        Arrays.fill(V, (byte) 0x0);
        Arrays.fill(memory, (byte) 0x0);

        // Reset
        delayTimer = 0x00;
        soundTimer = 0x00;
    }

    public void load(String filename) {
    }
}
