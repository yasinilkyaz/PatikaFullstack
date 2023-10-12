import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "pgAdmin";

    private static Connection connection;

    public static Connection getConnection(){
        if(connection != null){
            return connection;
        }

        try {
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            System.out.println("Veri tabanına bağlantı kuruldu");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static void closeConnection(){
        if(connection !=null){
            try {
                connection.close();
                System.out.println("Veri tabanı bağlantısı kesildi");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }


    }

}
