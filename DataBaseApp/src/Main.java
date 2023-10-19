import java.sql.*;

public class Main {
    //Veri tabanına bağlanmak için url adresi ve kullanıcı bilgileri değişkenleri oluşturuldu.
    public static final String DB_URL = "jdbc:mysql://localhost/employees";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "mysql";

    public static void main(String[] args) {
        Connection socket = null; // socket adıyla bir bağlantı nesne oluşturuldu
        String sql = "SELECT * FROM employees"; //sorgu metni, okuma kolaylığı olması için burada değişken olarak oluşturuldu

        //bağlantıyı oluşturan ve sorgulama yapan kodlar hata vermesi ihtimaline karşı try-catch yapısı içine alındı.
        try {
            socket = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            socket.setAutoCommit(false);
            Statement st = socket.createStatement();
            ResultSet data = st.executeQuery(sql);

            //data.next sorgusu 1. elemandan başlayarak satında veri olduğu sürece while döngüsü içinde sorgulama yapar ve sonuçlar yazdırılır.
            while (data.next()) {
                System.out.println("Id :" + data.getInt("employee_id"));
                System.out.println("Name :" + data.getString("employee_name"));
                System.out.println("Position :" + data.getString("employee_position"));
                System.out.println("Salary :" + data.getInt("employee_salary"));
                System.out.println("====================");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
