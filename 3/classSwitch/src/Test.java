/////////////////////////////////  文件头部的注释块  ////////////////////////////////////
//
//  题目:                类的定义和使用
//  课程:
//
//  作者:
//  邮件:
//  授课教师:
//
///////////////////////////////////  参考文献  //////////////////////////////////////
//
//
//
//
/////////////////////////////////  标准行宽度为80  ////////////////////////////////////

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * @author XXX
 * @author
 */
class Switch {//TODO  请完成划线部分的代码
    int status;//表示开关的状态，0表示关，1表示开，其他值表示开关异常
    String productID;//产品ID
    double maxVoltage;//开关最大承受电压
    PrintStream out;//为了实现在CG中输出中文，需要将标准的输出流进行转换，请大家使用这个out对象进行输出，具体使用同System.out

    {
        try {
            out = new PrintStream(System.out, false, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            //  TODO  Auto-generated  catch  block
            //e.printStackTrace();
        }
    }

    /**
     * 打开开关方法，如果开关的状态不为开，则将状态status设置为1
     */
    void open() {
        if (status != 1) {
            status = 1;
        }
    }

    /**
     * 关闭开关方法，如果开关的状态不为关，则将状态status设置为0
     */
    void close() {
        if (status != 0) {
            status = 0;
        }
    }

    /**
     * 显示开关状态方法
     * 注意在CG中输出中文需要使用out对象（而不是System.out），参见后面的方法
     */
    void displayStatus() {
        //请根据输出信息，及程序上下文，完成该方法的实现
        if (status == 0) {
            out.println("开关的状态为关");
        } else if (status == 1) {
            out.println("开关的状态为开");
        } else {
            out.println("开关的状态异常");
        }
    }

    /**
     * 显示产品ID
     */
    void displayProductID() {
        out.println("开关的产品ID为" + productID);
    }

    /**
     * 显示最大承受电压
     */
    void displayMaxVoltage() {
        out.println("开关能承受的最大电压为" + maxVoltage);
    }
}

public class Test {

    public static void main(String[] args) {
        //  TODO  Auto-generated  method  stub
        Switch bull = new Switch();
        bull.productID = "123456";
        bull.maxVoltage = 380;
        bull.status = 0;
        bull.displayProductID();
        bull.displayMaxVoltage();
        bull.displayStatus();
        bull.open();
        bull.displayStatus();
        bull.close();
        bull.displayStatus();
        bull.status = 3;
        bull.displayStatus();
    }

}