package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5P1 {

    public static void main(String[] args) {
        Connection conn;
        conn = connect();
        selectAll(conn);
        close(conn);
        // TODO code application logic here
    }

    private static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:KATA5.db";
            conn = DriverManager.getConnection(url);
            
        
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } 
        return conn;
    }

    private static void close(Connection conn) {
        try { 
                if (conn != null){
                    conn.close();
                }
            } catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
    }

    private static void selectAll(Connection conn) {
        String sql = "SELECT * FROM PEOPLE";
        
        try (Connection conn2 = Kata5P1.connect();
             Statement stmt = conn2.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){
            while(rs.next()){
                System.out.println(rs.getInt("Id") + "\t" + 
                                   rs.getString("Name") + "\t" +
                                   rs.getString("Apellidos") + "\t" + 
                                   rs.getString("Departamento") + "\t");
            }
            
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    
}
