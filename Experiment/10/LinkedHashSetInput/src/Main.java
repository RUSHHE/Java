import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
    Calculate calculate = new Calculate();

    calculate.input();
    calculate.display();
    }
}

class Calculate {
    Set<String> string = new LinkedHashSet<>();

    public void input() {
        Scanner scan = new Scanner(System.in);

        string.addAll(Arrays.asList(spilt(scan.nextLine())));//分割所输入的字符串，储存金LinkedHashSet
    }

    public String[] spilt(String string) {
        return string.split("\\s");//以空格分割
    }

    public void display() {
        System.out.println(string.toString());
    }
}