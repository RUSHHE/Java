// NotepadAbout.java
// 导入需要的包和类
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

// 定义NotepadAbout类，用来显示关于页面
class NotepadAbout {

    // 定义一个方法，用来显示关于页面
    public void show() {
        JDialog aboutNotepad = new JDialog(new JFrame(), "关于");
        aboutNotepad.setSize(600, 350);
        aboutNotepad.setLocation(350, 250);
        aboutNotepad.setLayout(new FlowLayout());

        BufferedImage image = null;
        try {
            image = ImageIO.read(Objects.requireNonNull(Notepad.class.getResourceAsStream("/resource/icon.jpg")));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_DEFAULT);

        ImageIcon icon = new ImageIcon(scaledImage);

        JLabel label = new JLabel(icon);

        aboutNotepad.add(label);

        JButton jump = new JButton("跳转");
        aboutNotepad.add(jump);

        JTextArea introduction = new JTextArea("Bullshit Opensource Project.\n\nAll right reserved.(doge\n\n如果屎山能跑，就不要去动他\n\n来看看我的github吧");
        introduction.setEditable(false);
        introduction.setLineWrap(false);
        introduction.setOpaque(false);

        aboutNotepad.add(introduction);

        aboutNotepad.setVisible(true);


        jump.addActionListener(e1 -> {
            if (java.awt.Desktop.isDesktopSupported()) {
                try {

                    java.net.URI uri = java.net.URI.create("https://github.com/RUSHHE/");

                    java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

                    if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {

                        desktop.browse(uri);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }
}
