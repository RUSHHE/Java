// 导入需要的包和类
import javax.swing.*;

// 定义Notepad类，用来创建Notepad--窗口
public class Notepad {

    // 定义一个NotepadUI对象，用来创建界面元素
    private NotepadUI ui;

    // 定义一个NotepadAction对象，用来实现操作功能
    private NotepadAction action;

    // 定义一个NotepadAbout对象，用来显示关于页面
    private NotepadAbout about;

    // 定义一个构造方法，用来初始化对象和添加监听器
    public Notepad() {
        ui = new NotepadUI();
        action = new NotepadAction(ui.getArea());
        about = new NotepadAbout();

        ui.getCreate().addActionListener(e -> action.create());
        ui.getOpen().addActionListener(e -> action.open());
        ui.getSave().addActionListener(e -> action.save());
        ui.getSaveAs().addActionListener(e -> action.saveAs());
        ui.getExit().addActionListener(e -> action.exit());
        ui.getAbout().addActionListener(e -> about.show());
    }

    // 定义一个方法，用来创建并显示Notepad--窗口
    public void createAndShowGUI() {
        JFrame notepad = new JFrame("Notepad--");
        notepad.setSize(640, 480);
        notepad.setLocation(300, 200);
        notepad.setVisible(true);
        notepad.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        notepad.setJMenuBar(ui.getMenuBar());
        notepad.add(ui.getArea());
    }

    // 主方法，用来启动程序
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Notepad notepad = new Notepad();
            notepad.createAndShowGUI();
        });
    }
}
