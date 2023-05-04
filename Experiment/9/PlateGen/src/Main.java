import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Plate plate = new Plate();
        plate.GeneratePlate();
        System.out.println(plate.getPlate());
    }
}

class Plate {
    String plate;

    //此方法会要求你输入一组字符串
    public void GeneratePlate() {
        Scanner scan = new Scanner(System.in);

        String plate = scan.nextLine();
        setPlate(plate);
    }

    public String getPlate() {
        return plate;
    }

    private void setPlate(String temp) {
        StringBuilder plate = new StringBuilder(temp);
        NumberCounter number = new NumberCounter();

        number.CountLetterNDigit(temp);
        //判断是不是三位数字两位字母
        if (number.getDigit() == 3 || number.getLetter() == 2) {
            for (int i = 0; i < plate.length(); i++) {
                //判断是否不是数字和字母
                if (!Character.isLetterOrDigit(plate.charAt(i))) {
                    System.out.println("license plate error.");
                    System.exit(1);
                }
            }
            this.plate = plate.toString().toUpperCase();
        } else {
            System.out.println("license plate error.");
            System.exit(1);
        }
    }

    //统计数字和字母的数量的内部类
    private static class NumberCounter {
        int digit = 0;
        int letter = 0;

        public int getDigit() {
            return digit;
        }

        public int getLetter() {
            return letter;
        }

        //统计数字和字母的数量的方法
        public void CountLetterNDigit(String temp) {
            StringBuilder plate = new StringBuilder(temp);
            for (int i = 0; i < plate.length(); i++) {
                if (Character.isDigit(plate.charAt(i))) {
                    digit++;
                } else if (Character.isLetter(plate.charAt(i))) {
                    letter++;
                }
            }
        }
    }
}