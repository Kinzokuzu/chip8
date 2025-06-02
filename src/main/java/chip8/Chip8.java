package chip8;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.util.Arrays;

public class Chip8 {
    private Short opcode = (short) 0;                       // current opcode
    private Byte[] V = new Byte[16];            // 16 8-bit gen registers (V0-VE)
    private Short I = (short) 0;                            // index register
    private Short pc;                           // program counter

    /**
     * Memory map:
     * 0x000-0x1FF - Chip 8 interpreter (contains fontset in emu)
     * 0x050-0x0A0 - Used for the built-in 4x5 pixel font set (0-F)
     * 0x200-0xFFF - Program ROM & work RAM
     */
    private Short[] memory = new Short[4096];   // 4k system memory

    private Byte[] gfx = new Byte[64 * 32];     // pixel state (graphics)

    private Byte delayTimer = (byte) 0;                    // timer registers
    private Byte soundTimer = (byte) 0;

    private Short[] stack = new Short[16];      // program stack
    private Short sp = (short) 0;                           // stack pointer

    private Byte[] key = new Byte[16];          // keypad state (0x0-0xF)

    public Chip8() {
        pc = (short) 0x200;    // start program counter at 0x200

        // Load fontset
        for (int i = 0; i < 80; i++) {
            // memory[i] = chip8Fontset[i];
        }

        Arrays.fill(gfx, Byte.valueOf((byte) 0));
        Arrays.fill(stack, Short.valueOf((short) 0));
        Arrays.fill(V, Byte.valueOf((byte) 0));
        Arrays.fill(memory, Short.valueOf((short) 0));
        Arrays.fill(key, Byte.valueOf((byte) 0));
    }

    public void reset() {
        pc = 0x200;    // start program counter at 0x200

        // Reset
        opcode = (short) 0;
        I = 0x00;
        sp = 0x00;

        // Clear
        Arrays.fill(gfx, Byte.valueOf((byte) 0));
        Arrays.fill(stack, Short.valueOf((short) 0));
        Arrays.fill(V, Byte.valueOf((byte) 0));
        Arrays.fill(memory, Short.valueOf((short) 0));
        Arrays.fill(key, Byte.valueOf((byte) 0));

        // Reset
        delayTimer = (byte) 0;
        soundTimer = (byte) 0;
    }

    public void load(String filename) {
        try {
            InputStream inputStream = new FileInputStream(filename);
            byte[] buffer = inputStream.readAllBytes();

            for (int i = 0; i < buffer.length; i = i + 2) {
                // Concatenate two Bytes
                memory[i/2] = (short) (buffer[i] << 8 | buffer[i+1] & 0xFF);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Short getOpcode() {
        return opcode;
    }

    public Byte[] getV() {
        return V;
    }

    public Byte getRegister(int i) {
        if (i < 0 || i > 15) {
            throw new RuntimeException("Invalid index: " + i);
        }

        return V[i];
    }

    public Short getI() {
        return I;
    }

    public Short getPc() {
        return pc;
    }

    public Short[] getMemory() {
        return memory;
    }

    public Short getMemoryAt(int address) {
        if (address < 0 || address > 4095) {
            throw new RuntimeException("Invalid address: " + address);
        }

        return memory[address];
    }

    public Byte[] getGfx() {
        return gfx;
    }

    public Byte getDelayTimer() {
        return delayTimer;
    }

    public Byte getSoundTimer() {
        return soundTimer;
    }

    public Short[] getStack() {
        return stack;
    }

    public Short getSp() {
        return sp;
    }

    public Byte[] getKey() {
        return key;
    }
}
