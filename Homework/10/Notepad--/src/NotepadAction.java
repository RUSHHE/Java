import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

// 定义NotepadAction类，用来实现操作功能
class NotepadAction {
    // 定义一个窗口对象，用来操作窗口
    private final JFrame frame;
    // 定义一个文本区域对象，用来显示文本内容
    private final JTextArea area;
    //定义一个String类，用来储存文件地址
    private String filePaths;

    // 定义一个构造方法，传入窗口和文本区域
    public NotepadAction(JFrame frame, JTextArea area) {
        this.frame = frame;
        this.area = area;
    }

    // 定义一个方法，用来实现新建功能
    public void create() {
        Notepad notepad = new Notepad();
        notepad.createAndShowGUI();
    }

    // 定义一个方法，用来实现打开功能
    public void open() {
        JFileChooser chooser = new JFileChooser();

        // 设置文件过滤器，只显示txt文件
        chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".txt") || f.isDirectory();
            }

            @Override
            public String getDescription() {
                return "Text Files (*.txt)";
            }
        });

        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                // 创建一个BufferedReader对象，用来读取选中的文件
                BufferedReader reader = new BufferedReader(new FileReader(chooser.getSelectedFile()));
                String str;
                // 清空文本区域的内容
                filePaths = chooser.getSelectedFile().getPath();
                setTitle(chooser.getSelectedFile().getName());
                area.setText("");
                // 逐行读取文件内容，并追加到文本区域中
                while ((str = reader.readLine()) != null) {
                    area.append(str + "\n");
                }
                // 关闭BufferedReader对象
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void save() {
        if (filePaths == null) {
            saveAs();
        } else {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePaths));
                bufferedWriter.write(String.valueOf(area.getText()));
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 定义一个方法，用来实现另存为功能
    public void saveAs() {
        // 创建一个文件选择器
        JFileChooser chooser = new JFileChooser();
        // 设置文件过滤器，只显示txt文件
        chooser.setFileFilter(new FileNameExtensionFilter("文本文件", "txt"));
        // 弹出一个保存文件的对话框
        int result = chooser.showSaveDialog(null);
        // 如果用户点击了保存按钮
        if (result == JFileChooser.APPROVE_OPTION) {
            // 获取用户选择的文件
            File file = chooser.getSelectedFile();
            // 打印文件名
            System.out.println("用户选择了路径：" + file.getPath());
            filePaths = chooser.getSelectedFile().getPath();

            save();
        }
    }

    // 定义一个方法，用来实现退出功能
    public void exit() {
        System.exit(0);
    }

    //定义一个私有方法，用来实现设置标题的功能
    private void setTitle(String name) {
        frame.setTitle("Notepad-- \"" + name +"\"");
    }
}

