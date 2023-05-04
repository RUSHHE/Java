import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringCount string = new StringCount(scan.nextLine());

        string.display();
    }
}

class StringCount {
    int characters;
    int words;

    public StringCount(String string) {
        characters = string.length();
        words = splitString(string);
    }

    public int splitString(String string) {
        String[] words = string.split("[\\s?!\t]+");//分割空格?!\t
        return words.length;
    }

    public void display() {
        System.out.println(characters + " characters");
        System.out.println(words + " words");
    }
}