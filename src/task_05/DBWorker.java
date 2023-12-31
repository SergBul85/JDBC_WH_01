package task_05;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBWorker {
    private static final String URL = "jdbc:mysql://localhost:3306/MyJoinsDB";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    public DBWorker() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Драйвер загружен.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<EmpContact> getAllEmpContacts() {
        Connection connection = null;
        Statement statement = null;

        List<EmpContact> empContacts = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Соединение установлено");
                statement = connection.createStatement();
                statement.execute("SELECT * FROM empcontact");
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String telNumber = resultSet.getString("telNumber");
                    EmpContact empContact = new EmpContact(id, name, telNumber);
                    empContacts.add(empContact);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return empContacts;
    }
    public List<EmpFamily> getAllEmpFamilys() {
        Connection connection = null;
        Statement statement = null;

        List<EmpFamily> empFamilys = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Соединение установлено");
                statement = connection.createStatement();
                statement.execute("SELECT * FROM empfamily");
                ResultSet resultSet = statement.getResultSet();

                while (resultSet.next()) {
                    int id_empFam = resultSet.getInt(1);
                    boolean maried = resultSet.getBoolean(2);
                    String dob = resultSet.getString("dob");
                    String address = resultSet.getString("address");
                    EmpFamily empFamily = new EmpFamily(id_empFam, maried, dob, address);
                    empFamilys.add(empFamily);
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return empFamilys;
    }
    public List<EmpSalary> getAllEmpSalarys() {
        Connection connection = null;
        Statement statement = null;

        List<EmpSalary> empSalarys = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Соединение установлено");
                statement = connection.createStatement();
                statement.execute("SELECT * FROM empsalary");
                ResultSet resultSet = statement.getResultSet();

                while (resultSet.next()) {
                    int id_empSal = resultSet.getInt(1);
                    String position = resultSet.getString(2);
                    double salary = resultSet.getDouble("salary");

                    EmpSalary empSalary = new EmpSalary(id_empSal, position, salary);
                    empSalarys.add(empSalary);
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return empSalarys;
    }
}
