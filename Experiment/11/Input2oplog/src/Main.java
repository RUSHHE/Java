import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        try {
            input.input();
        } catch (Exception ignored) {}//题目没指定要输出的错误
    }
}

class Input {
    public void input() throws IOException {
        Scanner scan = new Scanner(System.in);
        String tempText;
        do {
            tempText = scan.nextLine();
            writeToFile(removeTrailingText(tempText), "oplog.txt");
        } while (!tempText.contains("#"));
    }

    private void writeToFile(String text, String fileName) throws IOException {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(text);
            writer.write("\r\n");
        }
    }

    private String removeTrailingText(String string) {
        if (string.contains("#")) {
            return string.replaceAll("#.*", "");
        }
        return string;
    }
}