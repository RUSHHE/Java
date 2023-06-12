import java.sql.*;

//mysqld --console　　


class Conn {

    Connection con;

    public Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("数据库驱动加载成功");

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_demo", "root", "zt3319861999");
            System.out.println("数据库连接成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}

public class JdbcTest {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Conn c = new Conn();
            conn = c.getConnection();
            //添加 增删改查操作
            String sql = "INSERT INTO websites(id, name, url, alexa, country) VALUES (6, 'Bing', 'https://www.bing.com/', 40, 'USA')";
            stmt = conn.prepareStatement(sql);

            stmt.executeUpdate(sql);

            int rows = stmt.getUpdateCount();
            System.out.println("插入了" + rows + "条数据");

            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from websites");

            while (rs.next()) {
                int i1 = rs.getInt(1);
                String s2 = rs.getString(2);
                String s3 = rs.getString(3);
                int i4 = rs.getInt(4);
                String s5 = rs.getString(5);
                String res = i1 + "\t" + s2 + "\t\t\t" + s3 + "\t\t" + i4 + "\t" + s5;
                System.out.println(res);
            }

            rs.close();
            stm.close();
            conn.close();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException ignored) {
            }// 什么都不做
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}