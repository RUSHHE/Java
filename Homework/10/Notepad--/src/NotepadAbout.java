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

        BufferedImage image;
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

        /*
        谁懂啊，这托屎山我TM重构了才把bug修好，功能越加越多bug，看来以后代码还得加完功能以后再重构？
         */
        JTextArea introduction = new JTextArea("如果有Bug请前往GitHub页面提交pr\n\n我不会回答，也不会修bug(楽\n\n如果屎山能跑，就不要去动他(doge\n\n");
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
