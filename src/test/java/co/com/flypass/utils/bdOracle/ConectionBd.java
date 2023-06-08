package co.com.flypass.utils.bdOracle;

import java.sql.*;

public class ConectionBd {
    public static Connection conectionBdOracle() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String dbURL = "jdbc:oracle:thin:@172.50.2.118:1530:orcl";
        Connection connection = null;
        connection = DriverManager.getConnection(dbURL, "KEVINCAICEDO", "5H0*4zselGQl");
        return connection;
    }

    public static String consultTable (String query, String nombreColumna) throws SQLException, ClassNotFoundException {
        String respuesta = null;
        Connection connection = conectionBdOracle();
        Statement crearQuery = connection.createStatement();
        ResultSet resultado = crearQuery.executeQuery(query);
        if (resultado.next()) {
            respuesta = resultado.getString(nombreColumna);
        }
        resultado.close();
        crearQuery.close();
        connection.close();
        return respuesta;
    }

    public static void ejecutarQuery (String query) throws SQLException, ClassNotFoundException {
        Connection connection = conectionBdOracle();
        Statement crearQuery = connection.createStatement();
        crearQuery.executeQuery(query);
        crearQuery.close();
        connection.close();
    }


    // Método principal de la aplicación
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Se llama al método de consulta pasando el nombre de la tabla como parámetro
//        String respuesta =consultTable ("select * from tfps_dispositivos where cdusuario_ingresa = 36448 order by femodifica desc","cddispositivo");
//        eliminarRegistro("Delete from tfps_dispositivos where cddispositivo = "+respuesta);
        String respuesta =consultTable ("SELECT * FROM TFPS_VEHICULOS WHERE DSPLACA = 'ABC185'","CDUSUARIO");
        ejecutarQuery("UPDATE FLYPASS_PDN.tfps_usuarios SET vrsaldo_disponible=200000 where cdusuario="+respuesta);
    }

}
