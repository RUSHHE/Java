import java.sql.*;
public class SimpleDBdemoMethod {
    static String url = "jdbc:mysql://localhost:3306/stddb";
    static String dbName = "root";
    static String password = "zt3319861999";
    static Connection conn = null;
    static ResultSet rs = null;
    static Statement stm = null;

    public static void main(String[] args) {
        try {
            getconn();
            String strsql = "select * from information";
            stm = conn.createStatement();
            rs = stm.executeQuery(strsql);
            while (rs.next()) {
                String s1 = rs.getString(1);
                String s2 = rs.getString(2);
                double d3 = rs.getDouble(3);

                String res = s1 + "\t" + s2 + "\t" + d3;
                System.out.println(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public static void getconn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("数据库驱动加载成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(url, dbName, password);
            System.out.println("数据库连接成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close() {
        try {
            rs.close();
            stm.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
