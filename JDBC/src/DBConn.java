import java.sql.*;

public class DBConn {
    public static final String DB_URL = "jdbc:mysql://localhost/university";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "mysql";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            conn.setAutoCommit(false);


            PreparedStatement pr = conn.prepareStatement("INSERT INTO student (student_name, student_class) VALUES (?, ?) ");
            pr.setString(1, "John Dewey");
            pr.setInt(2, 1);
            pr.executeUpdate();

            if (true){
                throw new SQLException();
            }

            pr.setString(1, "Michael Douglas");
            pr.setInt(2, 5);
            pr.executeUpdate();

            conn.commit();
            pr.close();
            conn.close();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            System.out.println(e.getMessage());
        }
    }

}
