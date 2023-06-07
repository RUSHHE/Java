import javax.swing.*;
import java.awt.*;

public class Calculator {

    public Calculator() {
        JFrame frame = new JFrame("只因算器");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 3, 2, 2));

        CalculatorUI ui = new CalculatorUI();

        for (JButton buttons : ui.getButtons()) {
            panel.add(buttons);
        }

        frame.add(ui.getArea(), BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        frame.setSize(250, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculator::new);
    }
}
