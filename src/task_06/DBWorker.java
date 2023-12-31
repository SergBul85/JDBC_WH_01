package task_06;

import task_05.EmpContact;

import java.sql.*;
import java.util.ArrayList;

public class DBWorker {
    private static final String URL = "jdbc:mysql://localhost:3306/MyTestDB";
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

    public void updateCarInfoByCarID(int id, String model, double price, String color) {
        String updateDataQuery = "UPDATE car SET model = ?, price = ?, color = ? WHERE ID = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            preparedStatement = connection.prepareStatement(updateDataQuery);
            preparedStatement.setString(1, model);
            preparedStatement.setDouble(2, price);
            preparedStatement.setString(3, color);
            preparedStatement.setInt(4, id);
            preparedStatement.execute();

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Авто по id=" + id + "обновлено");
            } else {
                System.out.println("Авто с таким ID нет в базе данных");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<Car> getAllAutoFromDB() {
        Connection connection = null;
        Statement statement = null;
        ArrayList<Car> cars = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();
            statement.execute("SELECT * FROM car");
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String model = resultSet.getString("model");
                double price = resultSet.getDouble("price");
                String color = resultSet.getString("color");
                Car car = new Car(id, model, price, color);
                cars.add(car);
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
        return cars;
    }

    public void deleteCarFromDBbyModel(String model) {
        String insertDataQuery = "DELETE FROM car WHERE model = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            preparedStatement = connection.prepareStatement(insertDataQuery);
            preparedStatement.setString(1, model);
            preparedStatement.execute();

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Авто " + model + " удалено из базы данных.");
            } else {
                System.out.println("Такой модели нет в базе данных");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void addCarToDB(Car car) {
        String insertDataQuery = "INSERT INTO car ( model, price, color) VALUES (?, ?, ?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            preparedStatement = connection.prepareStatement(insertDataQuery);
            preparedStatement.setString(1, car.getModel());
            preparedStatement.setDouble(2, car.getPrice());
            preparedStatement.setString(3, car.getColor());
            preparedStatement.execute();
            System.out.println("Авто добавлено в базу.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void createTableCar() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();
            statement.execute("CREATE TABLE car (\n" +
                    "  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                    "  model VARCHAR(255),\n" +
                    "  price DOUBLE,\n" +
                    "  color VARCHAR(255)\n" +
                    ");");
            System.out.println("Таблица Car создана");
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
    }
}
