import javax.swing.*;

public class CalculateArea {
    private final StringBuilder input;

    private String operator;

    private final JTextArea area;

    public CalculateArea(JTextArea area) {
        this.area = area;
        input = new StringBuilder();
        operator = "";
    }

    public StringBuilder getInput() {
        return input;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    //C clear按钮的方法
    public void clear() {
        area.setText("");
        input.setLength(0);//清空
        operator = "";
    }

    //等于按钮的方法
    public void equal() {
        input.append("=").append(" ").append(calculate(input.toString()));
        operator = "";
    }

    //直接对对象操作，取相反数
    public void inverse(StringBuilder input) {
        String[] token = input.toString().split(" ");//删除用来排版的数字
        for (int i = token.length - 1; i >= 0; i--) {
            boolean strResult = token[i].matches("-?[0-9]+.?[0-9]*");//匹配包含负数的数字
            if (strResult) {
                if (Double.parseDouble(token[i]) > 0) {
                    input.replace(input.lastIndexOf(token[i]), input.lastIndexOf(token[i]) + token[i].length(), "-" + token[i]);
                    break;
                } else if (Double.parseDouble(token[i]) < 0) {
                    input.replace(input.lastIndexOf(token[i]), input.lastIndexOf(token[i]) + token[i].length(), token[i].replace("-", ""));
                    break;
                } else {
                    input.append(token[i]);
                }
            }
        }
    }

    //对传入的String进行计算
    public String calculate(String input) {
        String[] tokens = input.split(" ");
        if (tokens.length != 4) {
            return "输入有误";
        }
        double num1 = Double.parseDouble(tokens[0]);
        double num2 = Double.parseDouble(tokens[2]);

        switch (operator) {
            case "+":
                return String.valueOf(num1 + num2);
            case "-":
                return String.valueOf(num1 - num2);
            case "*":
                return String.valueOf(num1 * num2);
            case "/":
                return String.valueOf(num1 / num2);
            case "%":
                return String.valueOf(num1 % num2);
            default:
                return "无效的操作符";
        }
    }
}
