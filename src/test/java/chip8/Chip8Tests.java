package chip8;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Chip8Tests {
    private Chip8 chip8 = new Chip8();

    @Test
    public void setChip8() {
        Assert.assertEquals(chip8.getOpcode(), Short.valueOf((short) 0));
        Assert.assertEquals(chip8.getI(), Short.valueOf((short) 0));
        Assert.assertEquals(chip8.getPc(), Short.valueOf((short) 0x200));
        Assert.assertEquals(chip8.getDelayTimer(), Byte.valueOf((byte) 0));
        Assert.assertEquals(chip8.getSoundTimer(), Byte.valueOf((byte) 0));
        Assert.assertEquals(chip8.getSp(), Short.valueOf((short) 0));

        for (var register : chip8.getV()) {
            Assert.assertEquals(register, Byte.valueOf((byte) 0));
        }

        for (var address : chip8.getMemory()) {
            Assert.assertEquals(address, Short.valueOf((short) 0));
        }

        for (var pixel : chip8.getGfx()) {
            Assert.assertEquals(pixel, Byte.valueOf((byte) 0));
        }

        for (var address : chip8.getStack()) {
            Assert.assertEquals(address, Short.valueOf((short) 0));
        }

        for (var state : chip8.getKey()) {
            Assert.assertEquals(state, Byte.valueOf((byte) 0));
        }
    }

    @Test
    public void resetChip8() {
        chip8.reset();

        Assert.assertEquals(chip8.getOpcode(), Short.valueOf((short) 0));
        Assert.assertEquals(chip8.getI(), Short.valueOf((short) 0));
        Assert.assertEquals(chip8.getPc(), Short.valueOf((short) 0x200));
        Assert.assertEquals(chip8.getDelayTimer(), Byte.valueOf((byte) 0));
        Assert.assertEquals(chip8.getSoundTimer(), Byte.valueOf((byte) 0));
        Assert.assertEquals(chip8.getSp(), Short.valueOf((short) 0));

        for (var register : chip8.getV()) {
            Assert.assertEquals(register, Byte.valueOf((byte) 0));
        }

        for (var address : chip8.getMemory()) {
            Assert.assertEquals(address, Short.valueOf((short) 0));
        }

        for (var pixel : chip8.getGfx()) {
            Assert.assertEquals(pixel, Byte.valueOf((byte) 0));
        }

        for (var address : chip8.getStack()) {
            Assert.assertEquals(address, Short.valueOf((short) 0));
        }

        for (var state : chip8.getKey()) {
            Assert.assertEquals(state, Byte.valueOf((byte) 0));
        }
    }
}
