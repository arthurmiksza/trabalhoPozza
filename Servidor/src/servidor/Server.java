package servidor;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import classes.Boi;
import infos.InfoArquivos;
import java.io.File;

public class Server implements Runnable {
    public DataInputStream input;
    public ServerSocket svSocket;
    public int porta = 9000;
    public Boi[] bois;
    public BufferedReader br;
    
    @Override
    public void run() {
        try {
            InfoArquivos info = new InfoArquivos();
            if (info.checkRequeriments()) {
                 File[] fs = new File[info.qtd()];
                bois = new Boi[info.qtd()];
                fs = new File(info.caminhoArquivos()).listFiles();
                for(File f : fs) {
                    br = new BufferedReader(new FileReader(f));
                    String texto = br.readLine();
                    if (texto != null) {
                        System.out.println(texto);
                    }
                }
                svSocket = new ServerSocket(porta);
                while(true) {
                    Socket cli = svSocket.accept();
                    input = new DataInputStream(cli.getInputStream());
                    String request = input.readUTF();
                }
            }
           
        } catch (IOException er) {
            System.out.println("Erro: " + er);
        }
    }
}
