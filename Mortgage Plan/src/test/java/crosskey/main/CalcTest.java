package crosskey.main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests for checking calculator logic
 */
public class CalcTest {
    private MortgageCalc calc1;

    private MortgageCalc calc2;


    @BeforeEach
    public void setUp() {
        InputStream testFile1 = getClass().getResourceAsStream("/prospects.txt");
        Reader reader = new Reader(new InputStreamReader(testFile1, StandardCharsets.UTF_8));
        calc1 = new MortgageCalc(reader.read());


        InputStream testFile2 = getClass().getResourceAsStream("/test.txt");
        reader = new Reader(new InputStreamReader(testFile2, StandardCharsets.UTF_8));
        calc2 = new MortgageCalc(reader.read());
    }

    @Test
    public void testFile1() {
        double[] expected = {43.87, 62.87, 59.22, 46.97};
        for(int i = 0; i < calc1.getProspectList().size(); i++) {
            assertEquals(expected[i], calc1.calculate(calc1.getProspectList().get(i).interest(),
                                    calc1.getProspectList().get(i).years(),
                                    calc1.getProspectList().get(i).totalLoan()),  0.01);
        }
    }

    @Test
    public void testFile2() {
        double[] expected = {75.49, 176.15};
        for(int i = 0; i < calc2.getProspectList().size(); i++) {
            assertEquals(expected[i], calc2.calculate(calc2.getProspectList().get(i).interest(),
                                    calc2.getProspectList().get(i).years(),
                                    calc2.getProspectList().get(i).totalLoan()),  0.01);
        }
    }
}
