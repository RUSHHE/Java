import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorUI implements ActionListener {

    private final CalculateArea CArea;

    private final JTextArea area;

    private final JButton[] buttons;

    public CalculatorUI() {
        area = new JTextArea();
        area.setEditable(false);

        CArea = new CalculateArea(area);

        String[] names = {"%", "C", "←", "=", "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "+/-", "0", ".", "+"};//按键名称
        buttons = new JButton[names.length];
        for (int i = 0; i < names.length; i++) {
            buttons[i] = new JButton(names[i]);
            buttons[i].addActionListener(this);//添加监听器
        }

//        JMenu mode = new JMenu("模式");//暂时无用

    }

    public JTextArea getArea() {
        return area;
    }

    public JButton[] getButtons() {
        return buttons;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String actionCommand = button.getText();

        //处理按键监听
        switch (actionCommand) {
            case "C":
                CArea.clear();
                break;
            case "=":
                CArea.equal();
                break;
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                CArea.getInput().append(actionCommand).append(" ");
                CArea.setOperator(actionCommand);
                break;
            case ".":
                if (CArea.getInput().length() != 0) {
                    CArea.getInput().setLength(CArea.getInput().length() - 1);//删去空格和重复的
                    CArea.getInput().append(".");
                } else {
                    CArea.getInput().append(".");
                }
                break;
            case "←":
                if (CArea.getInput().length() != 0) {
                    CArea.getInput().setLength(CArea.getInput().length() - 1);//缩小长度可等效于StringBuilder删除最后一位
                }
                break;
            case "+/-":
                CArea.inverse(CArea.getInput());
                break;
            default:
                CArea.getInput().append(actionCommand).append(" ");
                //正则表达式删除两个数字间的空格
                CArea.getInput().replace(0, CArea.getInput().length(), CArea.getInput().toString().replaceAll("(\\d)\\s+(\\d)", "$1$2"));
        }
        area.setText(CArea.getInput().toString());
    }
}
