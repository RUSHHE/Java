/**
 * 我最喜欢阅读的书。
 * 【问题描述】Book类为抽象类，包含howToRead()、toString()两个抽象方法。派生类JavaBook、CBook继承于父类Book，并且重写了父类的howToRead()、toString()方法。主类运行结果是通过polyMethod(Book []a)方法输出信息。
 * 【输入形式】0或1
 * 【输出形式】字符串
 * 【样例输入】0
 * 【样例输出】Book:JavaBook--I like reading:JavaBook
 * 【说明】
 * polyMethod函数中控制台输入0或1，决定调用哪个对象
 */

import java.util.Scanner;

abstract class Book {
    private String name;

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String howToRead() {
        return "I like reading:" + getName();
    }
}

//子类JavaBook
class JavaBook extends Book {
    public JavaBook() {
        setName("JavaBook");
    }

    public String toString() {
        return "Book:" + getName();
    }
}

//子类CBook
class CBook extends Book {
    public CBook() {
        setName("CBook");
    }

    public String toString() {
        return "Book:" + getName();
    }
}

public class PolyAbstractBookTest {
    public static void main(String[] args) {
        Book[] book = new Book[2];
        //创建对象
        book[0] = new JavaBook();
        book[1] = new CBook();
        polyMethod(book);
    }

    //polyMethod方法定义
    static void polyMethod(Book[] book) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        System.out.println(book[n].toString() + "--" + book[n].howToRead());
    }
}


