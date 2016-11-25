package servidor;
import classes.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServerRMI implements Remoto {
    public ArrayList<Boi> bois = BoiAux.bois;
    
    public void ligarRMI() {
        /*try {
            Remoto remote = (Remoto) UnicastRemoteObject.exportObject(new ServerRMI(), 0);

            Registry reg = LocateRegistry.createRegistry(porta);
            reg.bind("controle", controle);
            System.out.println("Servidor RMI... OK");
        } catch (Exception e) {
            System.err.println("Erro ao iniciar servidor RMI: " + e);
        }*/
    }
    
    @Override
    public ArrayList<Boi> getBois() throws RemoteException {
        return this.bois;
    }
    
}
