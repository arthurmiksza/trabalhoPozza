package servidor;

import classes.Boi;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerRMI {
    public static int porta = 3000;
    public static Remoto remoto = null;
    
      public static Remoto getServer(){
        if(remoto == null){
            try {                
                //conecta no servidor
                Registry reg = LocateRegistry.getRegistry("Localhost", porta);
                //procura no registro o nome "remoto" cadastrado pelo servidor
                remoto = (Remoto) reg.lookup("remoto");
            } catch (Exception e) {
                System.err.println("Erro no servidor RMI: " + e);
            }
        }
        return remoto;
    }
}
