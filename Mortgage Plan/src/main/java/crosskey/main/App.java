package crosskey.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class App {
    public static void main(String[] args) {
        String fileName = "/prospects.txt";

        InputStream stream = App.class.getResourceAsStream(fileName);

        try(InputStreamReader r = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
            Reader reader = new Reader(r);
            MortgageCalc calculator = new MortgageCalc(reader.read());
            calculator.print();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
