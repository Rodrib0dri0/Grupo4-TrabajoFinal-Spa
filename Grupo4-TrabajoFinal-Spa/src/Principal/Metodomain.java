
package Principal;

import Modelo.Cliente;
import Modelo.Conexion;
import Modelo.Masajista;
import Persistencia.ClienteData;
import Persistencia.InstalacionData;
import Persistencia.MasajistaData;
import java.sql.Connection;


public class Metodomain {
    
    public static void main (String[]args) {
        
         Conexion miConexion = new Conexion(
            "jdbc:mariadb://localhost:3306/grupo4-trabajofinal-spa",
            "root",
            ""
        );
        
        Connection con= miConexion.buscarconexion();
        
        if (con != null) {
        
        
            System.out.println("Conexion activada");
            
        
        
        } else {
        
            System.out.println("No se pudo establecer la conexion ");
        
        }
       // creamos un objeto ClienteData y un Cliente
        ClienteData clidat= new ClienteData();
        Cliente cliente1 = new Cliente(39395371,"franco","ledesma",2887,29,"masaje",true);
        
        //se agrega un cliente
        
        //nota: me permite agregar clientes con los mismos datos, solo teniendo dif id, corregir eso.
        
        //clidat.agregarCliente(cliente1);
       
        //busca el cliente cuando esta en la base de datos, pero si busco un id inexistente no me muestra el cartel de error al buscar
       /* clidat.buscarCliente(2);*/
       
        //Intengo agregar el cliente creado y el metodo me indica que ya fue dado de alta ese cliente 
        
        /*clidat.darDeAlta(cliente1);
        System.out.println("ya esta dado de alta");*/
       
        //Eliminamos el cliente que creamos que tenia id 1
        //clidat.eliminarCliente(1); 
        
        //se agrego un masajista 
        
        MasajistaData MD= new MasajistaData();
        Masajista masj= new Masajista(10,"Carlos","Gomez",2668,"manos",true);
        
       MD.GuardarMasajista(masj);
    }

   







}
