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
    public ArrayList<Boi> bois = new ArrayList<>();
    public int porta = 3000;
   
    @Override
    public ArrayList<Boi> getBois() throws RemoteException {
        bois.clear();
         InfoArquivos info = new InfoArquivos();
            //checkRequeriments verifica se existe arquivos na pasta
            if (info.checkRequeriments()) {
                File[] fs;
                //lista todos os arquivos da pasta
                fs = new File(info.caminhoArquivos()).listFiles();
                for(File f : fs) {
                    //Para cada arquivo na pasta...
                    try {
                        //Lê o conteudo do arquivo
                        BufferedReader br = new BufferedReader(new FileReader(f));
                        String texto = br.readLine();
                        if (texto != null) {
                            //Se tem conteudo, trata o conteudo estranho dentro dele
                            String[] resposta = info.trataResposta(texto);
                            //E adiciona um boi eeeee
                            bois.add(new Boi(Integer.parseInt(resposta[0]), resposta[1].equals("TRUE"), new Posicao(Float.parseFloat(resposta[2]), Float.parseFloat(resposta[3]))));
                        }
                    } catch(Exception errou) {
                        System.out.println("Erro: " + errou);
                    }
                }
                return bois;
            }
            else {
                System.out.println("Erro nos requisitos para ligar o servidor!");
            }
        return this.bois;
    }
    
    public void ligarRMI() {
        ServerRMI s = new ServerRMI();
        try {
            Remoto remote = (Remoto) UnicastRemoteObject.exportObject(s, 0);
            Registry reg = LocateRegistry.createRegistry(porta);
            reg.bind("remoto", remote);
            System.out.println("Server Ligado.");
        } catch (Exception e) {
            System.err.println("Erro no RMI: " + e.getMessage());
        }
    }
   
    
}
