package servidor;
import classes.*;
import infos.InfoArquivos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServerRMI implements Remoto {
    public ArrayList<Boi> bois;
    public int porta = 3000;
    
    public void ligarRMI() {
        try {
            Remoto remote = (Remoto) UnicastRemoteObject.exportObject(new ServerRMI(), 0);
            Registry reg = LocateRegistry.createRegistry(porta);
            reg.bind("remoto", remote);
        } catch (Exception e) {
            System.err.println("Erro no RMI: " + e.getMessage());
        }
    }
    
    @Override
    public ArrayList<Boi> getBois() throws RemoteException {
         InfoArquivos info = new InfoArquivos();
            if (info.checkRequeriments()) {
                File[] fs;
                fs = new File(info.caminhoArquivos()).listFiles();
                for(File f : fs) {
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(f));
                        String texto = br.readLine();
                        if (texto != null) {
                            String[] resposta = info.trataResposta(texto);
                            bois.add(new Boi(Integer.parseInt(resposta[0]), resposta[1].equals("TRUE"), new Posicao(Float.parseFloat(resposta[2]), Float.parseFloat(resposta[3]))));
                        }
                    } catch(Exception errou) {
                        System.out.println("Erro: " + errou.getMessage());
                    }
                }
                return bois;
            }
            else {
                System.out.println("Erro nos requisitos para ligar o servidor!");
            }
        return this.bois;
    }
    
}
