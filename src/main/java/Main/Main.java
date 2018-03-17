package Main;

import java.sql.*;

public class Main {
    public static final String JDBC_DRIVER = "" + "com.mysql.cj.jdbc.Driver";

    public static final String DB_URL = "" + "jdbc:mysql://localhost/rental_db?useSSL=false&serverTimezone=UTC";

    public static final String USER = "root";
    public static final String PASSWORD = "password";


    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = connection.createStatement();

            String sql = "select * from car";
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println(resultSet);

            while (resultSet.next()){
                System.out.println("Imie: " +
                 resultSet.getString("mark"));
            }
/*
            String insert = "insert into customer (firstname, lastname, address, postal_code) values (?, ?, ?, ?)";
            PreparedStatement preparedStatement1 = connection.prepareStatement(insert);
            preparedStatement1.setString(1, "Malgorzata");
            preparedStatement1.setString(2, "Janusz");
            preparedStatement1.setString(3, "POLSKA");
            preparedStatement1.setString(4, "00-666");
            preparedStatement1.executeUpdate();
*//*
            String insert2car = "insert into car (reg_number, mark, model, rate) values (?, ?, ?, ?)";
            PreparedStatement preparedStatement2 = connection.prepareStatement(insert2car);
            preparedStatement2.setString(2, "OPEL");
            preparedStatement2.setString(3, "Kadet");
            preparedStatement2.setString(4, "9");
            preparedStatement2.setString(1, "CBY666");
            preparedStatement2.executeUpdate();

*/
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
