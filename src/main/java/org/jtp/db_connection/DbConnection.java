package org.jtp.db_connection;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public static Connection getConnection(){
        Connection connection = null;

        Dotenv dotenv = Dotenv.load();

        String name_db = "students_db";
        String url = "jdbc:mysql://localhost:3306/" + name_db;
        String username = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        }catch(ClassNotFoundException  | SQLException e){
            System.out.println("Error to connect database: " + e.getMessage());
        }

        return connection;
    }

    public static void main(String[] args) {
        Connection connection = DbConnection.getConnection();
        if(connection != null){
            System.out.println("Conexion exitosa: " + connection);
        } else{
            System.out.println("No se logro conectar a la base de datos.");
        }
    }
}
