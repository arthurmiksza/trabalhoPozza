package cliente;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientRMI {
    public static int porta = 3030;
    public static Remoto remoto = null;
    
      public static Remoto getServer(){
        if(remoto != null){
            return remoto;
        } else {
           
            System.setProperty("java.rmi.server.hostname","127.0.0.1");
            try {                
                Registry reg = LocateRegistry.getRegistry("Localhost", porta);
                remoto = (Remoto) reg.lookup("remoto");

            } catch (Exception e) {
                System.err.println("Erro no servidor RMI: " + e);
            }
        }
        return remoto;
    }
}
