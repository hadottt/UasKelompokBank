package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class koneksi {
    private Connection con;

    public koneksi() {
        try {

            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root", "");

        } catch (Exception e) {

            System.exit(0);
        }
    }

    public Connection getCon() {
        return con;
    }

}