import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Quantity quantity = new Quantity();

        String input = scan.nextLine();
        for (int i = 0; i < input.length(); i++) {
            quantity.addQuantity(input.charAt(i));
        }
        quantity.print();
    }
}

class Quantity {
    int letter = 0;
    int space = 0;
    int number = 0;
    int character = 0;

    public void addQuantity(char element) {
        if (Character.isLetter(element)) {
            letter++;
        } else if (Character.isWhitespace(element)) {
            space++;
        } else if (Character.isDigit(element)) {
            number++;
        } else {
            character++;
        }
    }

    public void print() {
        System.out.println("The number of letter is:" + letter);
        System.out.println("The number of space is:" + space);
        System.out.println("The number of number is:" + number);
        System.out.println("The number of other character is:" + character);
    }
}