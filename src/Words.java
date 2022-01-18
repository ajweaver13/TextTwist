import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Words {
    private List<String> list_six;
    private List<String> list_five;
    private List<String> list_four;
    private List<String> list_three;

    public Words() throws IOException {
        list_six = new ArrayList<>();
        list_five = new ArrayList<>();
        list_four = new ArrayList<>();
        list_three = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get("valid6.txt"))) {
            stream.forEach(s -> {
                if (s.length() == 6) list_six.add(s.toLowerCase());
            });
        }

        try (Stream<String> stream = Files.lines(Paths.get("valid5.txt"))) {
            stream.forEach(s -> {
                if (s.length() == 5) list_five.add(s.toLowerCase());
            });
        }

        try (Stream<String> stream = Files.lines(Paths.get("valid4.txt"))) {
            stream.forEach(s -> {
                if (s.length() == 4) list_four.add(s.toLowerCase());
            });
        }

        try (Stream<String> stream = Files.lines(Paths.get("valid3.txt"))) {
            stream.forEach(s -> {
                if (s.length() == 3) list_three.add(s.toLowerCase());
            });
        }
    }

    public String generate() {
        int max = list_six.size();
        int min = 1;
        int range = max - min + 1;
        int random = (int)Math.floor(Math.random()*(range)+min);
        return list_six.get(random);
    }

    public boolean check(String word) {
        if (word.length() == 6) {
            return list_six.contains(word);
        } else if (word.length() == 5) {
            return list_five.contains(word);
        } else if (word.length() == 4) {
            return list_four.contains(word);
        } else if (word.length() == 3) {
            return list_three.contains(word);
        } else {
            return false;
        }
    }
}
