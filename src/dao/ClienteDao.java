package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Cliente;

public class ClienteDao {
    public void agregar(Cliente cliente) throws SQLException {
        String baseDatos = "java";
        String usuario = "root";
        String contrasena = "";
        String host = "localhost";
        String puerto = "3306";
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://" + host + ":" + puerto + "/" + baseDatos + "?useSSL=false";
        
        try {
            Class.forName(driver);
            Connection conexion = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Conexión exitosa");

            String agregar = "INSERT INTO `clientes` (`id`, `nombre`, `apellido`, `telefono`, `email`) VALUES (NULL, '" 
                + cliente.getNombre() + "', '" 
                + cliente.getApellido() + "', '" 
                + cliente.getTelefono() + "', '" 
                + cliente.getEmail() + "');";
            Statement statement = conexion.createStatement();
            statement.execute(agregar);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver");
        }

    }        

    public List<Cliente> listar() throws SQLException {
        String baseDatos = "java";
        String usuario = "root";
        String contrasena = "";
        String host = "localhost";
        String puerto = "3306";
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://" + host + ":" + puerto + "/" + baseDatos + "?useSSL=false";

        List<Cliente> listado = new ArrayList<>();
        
        try {
            Class.forName(driver);
            Connection conexion = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Conexión exitosa");

            String consultar = "SELECT * FROM `clientes`;";
            
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(consultar);

            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultado.getString("id"));
                cliente.setNombre(resultado.getString("nombre"));
                cliente.setApellido(resultado.getString("apellido"));
                cliente.setTelefono(resultado.getString("telefono"));
                cliente.setEmail(resultado.getString("email"));
                listado.add(cliente);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver");
        }

        return listado;

    }
}
