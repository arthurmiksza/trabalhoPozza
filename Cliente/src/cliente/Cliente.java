package cliente;

import java.rmi.RemoteException;
import view.principal;

public class Cliente {
    public static void main(String[] args) throws RemoteException {
        new principal().setVisible(true);
    }
    
}
