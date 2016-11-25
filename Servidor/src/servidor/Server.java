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
    DataInputStream input;
    public ServerSocket svSocket;
    public int porta = 9000;
    public Boi[] bois;
    
    @Override
    public void run() {
        try {
            InfoArquivos info = new InfoArquivos();
            File[] fs = new File[info.qtd()];
            fs = new File(info.caminhoArquivos()).listFiles();
            System.out.println("Listando arquivos...");
            for(File f : fs) {
                System.out.println(f.getName());
            }
            svSocket = new ServerSocket(porta);
            while(true) {
                Socket cli = svSocket.accept();
                input = new DataInputStream(cli.getInputStream());
                String request = input.readUTF();
                
            }
        } catch (IOException er) {
            System.out.println("Erro: " + er);
        }
    }
}
