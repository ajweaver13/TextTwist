import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Words {
    private List<String> list;

    public Words() throws IOException {
        list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get("database.txt"))) {
            stream.forEach(s -> {
                if (s.length() == 6) list.add(s);
            });
        }
        System.out.println(list.size());
    }

    private String generate() {
        return null;
    }
}
