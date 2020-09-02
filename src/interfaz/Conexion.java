package interfaz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


    
    public class Conexion {
  //  Connection conectar;
    private final String base = "poii_restaurante";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://127.0.0.1/" + base;
    private Connection con = null;
    
    public Connection getConexion()
    {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("Se conectó con éxito a la base de datos");
        } catch(SQLException e)
        {
            System.out.println("Error1");
            JOptionPane.showMessageDialog(null, "Se produjo un error al conectar en la base de datos", "Error01", JOptionPane.WARNING_MESSAGE);
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error2");
        }
      return con;  
    }


     
/* prueba1
    public Conectar_Base_de_RH(){
         Statement statement1; //objeto utilizado para ejecutar una declaración SQL estática y devolver los resultados que produce.
         ResultSet resultado1;// Un objeto ResultSet mantiene un cursor apuntando a su fila actual de datos. Inicialmente, el cursor se coloca antes de la primera fila. El siguiente método mueve el cursor a la siguiente fila, y debido a que devuelve falso cuando no hay más filas en el objeto ResultSet, se puede usar en un ciclo while para iterar a través del conjunto de resultados.
       
       try {
           Class.forName("com.mysql.jdbc.Driver");
           conectar = DriverManager.getConnection("jdbc:mysql://127.0.0.1/poii_restaurante", "root", ""); //Intenta conectar a BD
           System.out.println("Se conectó con éxito a la base de datos");
           
       }catch (Exception error_1){ //Manejo de excepciones y errores
           JOptionPane.showMessageDialog(null, "Se produjo un error al conectar a la base de datos");
       }
        try {
            statement1=conectar.createStatement();
            resultado1 = statement1.executeQuery("select * from personal"); //petición SQL
            while(resultado1.next()){
            System.out.println(resultado1.getInt("Numero_de_Empleado")+ resultado1.getString("Nombre")+ resultado1.getString("Apellidos") + resultado1.getString("CURP"));
            }
        }catch (Exception e)
                 {
                 System.out.println("No se recuperó la información");
                 }
        
        }
    */
    
    
    
    
    
    
       
       
    }

