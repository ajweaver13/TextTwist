import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
In Text Twist, players try to score points by forming words using the letters from a 6-letter scrambled word.
They win the round if they can successfully unscramble the 6-letter word.

Create a function that takes in an array of already-guessed words, the unscrambled 6-letter word and returns the
total number of points the player scored in a particular round using the following rubric:

3-letter words are 1 pt
4-letter words are 2 pts
5-letter words are 3 pts
6-letter words are 4 pts + 50 pt bonus (for unscrambling the word)
Remember that invalid words (words that cannot be formed from the 6-letter unscrambled words) count as 0 pts.

Examples
totalPoints(["cat", "create", "sat"], "caster") ➞ 2
// Since "create" is an invalid word.

totalPoints(["trance", "recant"], "recant") ➞ 108
// Since "trance" and "recant" score 54 pts each.

totalPoints(["dote", "dotes", "toes", "set", "dot", "dots", "sted"], "tossed") ➞ 13
// Since 2 + 3 + 2 + 1 + 1 + 2 + 2 = 13

Notes:
If a 6-letter word has multiple anagrams, count each 6-letter unscramble as an additional 54 pts. For example,
if the word is arches, and the player guessed arches and chaser, add 108 pts for both words.
 */
public class TextTwist {
    public static void main(String[] args) throws IOException {
        Words wordClass = new Words();
        Scanner scan = new Scanner (System.in);
        String word = wordClass.generate();

        System.out.println("-------------------------------------");
        System.out.println("|       Welcome to Text Twist!      |");
        System.out.println("-------------------------------------");
        System.out.println("|  Guess as many valid words as you |");
        System.out.println("|   can from a random scrambled 6   |");
        System.out.println("|    letter word while trying to    |");
        System.out.println("| unscramble it. Enter * to submit  |");
        System.out.println("|     your entries to be scored.    |");
        System.out.println("-------------------------------------\n");


        System.out.println("Your word is:\t "+word+"\n");

        List<String> list = new ArrayList<>();
        System.out.print("Enter here: ");
        String temp = scan.nextLine().toLowerCase();
        while (!temp.equals("*")) {
            list.add(temp);
            System.out.print("Enter here: ");
            temp = scan.nextLine().toLowerCase();
        }
        System.out.println("");
        int total = wordClass.totalPoints(list, word);

        System.out.println("Your total points is:\t "+total);
    }
}
