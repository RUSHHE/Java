//说明： 根据mysql版本，调整相应的驱动名称以及数据库的连接配置参数

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SimpleDBDemo {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stddb", "root", "zt3319861999");

            Statement stm = conn.createStatement();

            ResultSet rs = stm.executeQuery("select * from person");

            while (rs.next()) {
                String s1 = rs.getString(1);
                String s2 = rs.getString(2);
                double d3 = rs.getDouble(3);
                String res = s1 + "\t" + s2 + "\t\t" + d3;
                System.out.println(res);
            }
            rs.close();
            stm.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}