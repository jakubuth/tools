package pl.example.tools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToolTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testHammerUseAndMaterial() {
        Hammer hammer = new Hammer("Claw Hammer");
        hammer.use();
        assertEquals("Hammer is hitting", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();
        assertEquals("Steel", hammer.material());
    }

    @Test
    public void testScrewdriverUseAndMaterial() {
        Screwdriver screwdriver = new Screwdriver("Flathead Screwdriver");
        screwdriver.use();
        assertEquals("Screwdriver is turning screws", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();
        assertEquals("Plastic and Metal", screwdriver.material());
    }

    @Test
    public void testSawUseAndMaterial() {
        Saw saw = new Saw("Hand Saw");
        saw.use();
        assertEquals("Saw is cutting", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();
        assertEquals("Carbon Steel", saw.material());
    }
}
