package crosskey.main;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reader {
    private final InputStreamReader stream;

    public Reader(InputStreamReader s) {
        this.stream = s;
    }

    public List<Prospect> read() {
        List<Prospect> prospectList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(stream)) {
            String line;
            br.readLine(); // read first line and ignore contents
            while((line = br.readLine()) != null && !line.isEmpty()) {
                // Taken from stackoverflow https://stackoverflow.com/questions/1757065/java-splitting-a-comma-separated-string-but-ignoring-commas-in-quotes
                List<String> temp = Arrays.asList(line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1));
                double loan = Double.parseDouble(temp.get(1));
                double interest = Double.parseDouble(temp.get(2));
                double years = Double.parseDouble(temp.get(3));
                prospectList.add(new Prospect(temp.get(0), loan, interest, years));
            }
        } catch (IOException e) {
            System.out.println("File Not Found");
        }

        return prospectList;
    }

}
