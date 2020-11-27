package clases;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conectar {
    
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "";
    private static final String url = "jdbc:mysql://localhost:3306/dblicor";        

    public conectar() {
        conn = null;
        try{
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, user, pass);
            if(conn != null){
                System.out.println("La conexion se establecio bien con la DB");
            }  
        }catch(ClassNotFoundException | SQLException e){ 
            System.out.println("Error al conectar con la DB " + e);
        }
    }
    //Este metodo retorna la conexion.
    public Connection getConnection(){
        return conn;
    }
    
    //Metodo para desconectar.
    public void desconectar(){
        conn = null;
        if (conn == null) {
            System.out.println("Se desconecto de la DB");
        }
    }
}