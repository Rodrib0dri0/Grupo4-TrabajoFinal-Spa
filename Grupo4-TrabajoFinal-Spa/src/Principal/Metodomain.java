package Principal;

import Modelo.Cliente;
import Modelo.Conexion;
import Modelo.Masajista;
import Persistencia.ClienteData;
import Persistencia.InstalacionData;
import Persistencia.MasajistaData;
import java.sql.Connection;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Metodomain {

    public static void main(String[] args) {
        
        String hora = "20:43:00";
            Time sepa = Time.valueOf(hora);
            System.out.println("The current time is: " +sepa);
        
   
        
        

        // creamos un objeto ClienteData y un Cliente
        ClienteData clidat = new ClienteData();
        Cliente cliente1 = new Cliente(39395371, "franco", "ledesma", 2887, 29, null, true);
        
        Cliente cliente2 = new Cliente(765433,"Fernando","Velazquez",4745,22,null,true);

        //se agrega un cliente
        //clidat.agregarCliente(cliente1);
        
        //clidat.agregarCliente(cliente2);
        
        //busca el cliente cuando esta en la base de datos
         //System.out.println(clidat.buscarCliente(2));
        
        //Intengo dar de alta al cliente creado y el metodo me indica que ya fue dado de alta
        //clidat.darDeAlta(cliente1);

        //Eliminamos el cliente que creamos que tenia id 1
        //clidat.eliminarCliente(1);

        //se agrego un masajista 
        MasajistaData MD = new MasajistaData();
        Masajista masj = new Masajista(10, "Carlos", "Gomez", 2668, "manos", true);

        //MD.GuardarMasajista(masj);
        System.out.println(MD.buscarMasajista(10));
        
       //MD.darDeAlta(masj);
       
       GestionarTratamientos ts = new GestionarTratamientos();
        System.out.println();
    }

}
