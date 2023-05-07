/**
 * 程序形参aa bb cc dd
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArraylistTest {
    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        for (String str : args) {
            list.add(str);
        };

        for (String str : list){
            System.out.println(str);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //

        Iterator<String> ite = list.iterator();
        while (ite.hasNext())//判断下一个元素之后有值
        {
            System.out.println(ite.next());
        }
    }
}