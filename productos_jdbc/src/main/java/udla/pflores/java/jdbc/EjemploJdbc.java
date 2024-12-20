package udla.pflores.java.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class EjemploJdbc {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/productos_jdbc"; //el 3306 era el puerto y le sigue el nombre de la base de datos en el sql
        String us = "root"; //user del sql
        String pw = "sasa"; //password del sql

        //hacer la conexion
        //connection es una clase propia de java
        //Se hace dentro de un try porque la conexión puede fallar
        try {
            Connection conn = DriverManager.getConnection(url, us, pw);
            //generar la sentencia
            Statement st = conn.createStatement();
            ResultSet resultado = st.executeQuery("select * from productos"); //se usa el select de sql que muestra el listado de productos
            System.out.println("Id  |  Marca  |  Modelo  |  Precio");
            while(resultado.next()){
                //Pone el resultado en una lista
                StringBuilder sb = new StringBuilder();
                sb.append(resultado.getInt("id")).append("  |  ")
                //es getString porque es el tipo de columna en el SQL
                .append(resultado.getString("marca"))
                .append("  |  ")
                .append(resultado.getString("modelo"))
                .append("  |  ")
                .append(resultado.getString("precio"));
                System.out.println(sb.toString());


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
