import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
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
        return shuffle(list_six.get(random));
    }

    public int check(String word) {
        int length = word.length();
        switch (length) {
            case 6: if(list_six.contains(word)) {
                System.out.println("Congratulations, you are a winner! You unscrambled the word!");
                return 54;
            }
            case 5: if(list_five.contains(word)) return 3;
            case 4: if(list_four.contains(word)) return 2;
            case 3: if(list_three.contains(word)) return 1;
            default: return 0;
        }
    }

    public String shuffle(String word) {
        List<Character> list = new ArrayList<>();
        for(char c : word.toCharArray()) {
            list.add(c);
        }
        Collections.shuffle(list);
        StringBuilder builder = new StringBuilder(list.size());
        for(char c: list)
        {
            builder.append(c);
        }
        return builder.toString().toLowerCase();
    }

    public int totalPoints(List<String> list, String word) {
        int result = 0;

        for (String s : list) {
            boolean check = true;

            List<Character> charList = new ArrayList<>();
            String temp = word;
            for(char c : temp.toCharArray()) {
                charList.add(c);
            }

            for (int i = 0; i < s.length(); i++) {
                int pos = charList.indexOf(s.charAt(i));
                if (pos == -1) {
                    check = false;
                    break;
                } else {
                    charList.remove(pos);
                }
            }

            if(check) result = result + check(s);
        }
        return result;
    }
}
