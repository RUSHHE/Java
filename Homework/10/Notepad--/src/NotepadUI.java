import javax.swing.*;

// 定义NotepadUI类，用来创建界面元素
class NotepadUI {

    // 定义一个文本区域对象，用来显示文本内容
    private final JTextArea area;

    // 定义一个菜单栏对象，用来显示菜单选项
    private final JMenuBar menuBar;

    // 定义一个新建菜单项对象，用来实现新建功能
    private final JMenuItem create;

    // 定义一个打开菜单项对象，用来实现打开功能
    private final JMenuItem open;

    private final JMenuItem save;

    private final JMenuItem saveAs;

    // 定义一个退出菜单项对象，用来实现退出功能
    private final JMenuItem exit;

    // 定义一个关于菜单项对象，用来显示关于页面
    private final JMenuItem about;

    // 定义一个构造方法，用来初始化界面元素并添加到菜单栏中
    public NotepadUI() {
        area = new JTextArea();

        menuBar = new JMenuBar();

        // 定义一个文件菜单对象，用来显示文件相关的选项
        JMenu file = new JMenu("文件");
        // 定义一个帮助菜单对象，用来显示帮助相关的选项
        JMenu help = new JMenu("帮助");

        menuBar.add(file);
        menuBar.add(help);

        create = new JMenuItem("新建");
        open = new JMenuItem("打开");
        save = new JMenuItem("保存");
        saveAs = new JMenuItem("另存为");
        exit = new JMenuItem("退出");

        file.add(create);
        file.addSeparator();
        file.add(open);
        file.addSeparator();
        file.add(save);
        file.addSeparator();
        file.add(saveAs);
        file.addSeparator();
        file.add(exit);

        about = new JMenuItem("关于");
        help.add(about);
    }

    // 定义一些get方法，用来返回界面元素的对象

    public JTextArea getArea() {
        return area;
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public JMenuItem getCreate() {
        return create;
    }

    public JMenuItem getOpen() {
        return open;
    }

    public JMenuItem getSave() {
        return save;
    }

    public JMenuItem getSaveAs() {
        return saveAs;
    }

    public JMenuItem getExit() {
        return exit;
    }

    public JMenuItem getAbout() {
        return about;
    }
}