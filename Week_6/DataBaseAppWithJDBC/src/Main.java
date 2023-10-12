import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection connection = DBConnect.getConnection();
        addEmployees(connection);
        getListEmployees(connection);
        DBConnect.closeConnection();
    }

    private static void getListEmployees(Connection connection) {

        String query = "SELECT * FROM employees";
        try {

            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + resultSet.getString("name") + resultSet.getString("position") + resultSet.getDouble("salary"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void addEmployees(Connection connection) {

        String sql = "INSERT INTO employees (name, position, salary) VALUES \n" +
                "('Emma Johnson', 'Sales Representative', 48000.00),\n" +
                "('Matthew Davis', 'Software Engineer', 65000.00),\n" +
                "('Olivia Williams', 'Project Manager', 72000.00),\n" +
                "('Daniel Brown', 'Marketing Specialist', 53000.00),\n" +
                "('Sophia Miller', 'Data Analyst', 58000.00);\n";
        
        try {
            connection.setAutoCommit(false);
            Statement st = connection.createStatement();
            st.executeUpdate(sql);
            connection.commit();
            System.out.println("Çalışanlar eklendi.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}