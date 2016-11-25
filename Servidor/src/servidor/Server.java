package servidor;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import classes.*;
import infos.InfoArquivos;
import java.io.File;
import java.util.ArrayList;

public class Server implements Runnable {
    public DataInputStream input;
    public ServerSocket svSocket;
    public int porta = 9000;
    public ArrayList<Boi> bois;
    public BufferedReader br;
    public Boi boiAux;
    
    @Override
    public void run() {
        try {
            InfoArquivos info = new InfoArquivos();
            if (info.checkRequeriments()) {
                boiAux = new Boi();
                File[] fs = new File[info.qtd()];
                bois = BoiAux.bois;
                fs = new File(info.caminhoArquivos()).listFiles();
                for(File f : fs) {
                    br = new BufferedReader(new FileReader(f));
                    String texto = br.readLine();
                    if (texto != null) {
                        String[] resposta = info.trataResposta(texto);
                        bois.add(new Boi(Integer.parseInt(resposta[0]), resposta[1].equals("TRUE"), new Posicao(Float.parseFloat(resposta[2]), Float.parseFloat(resposta[3]))));
                    }
                    Boi teste = boiAux.acharPeloId(bois, 21);
                }
                svSocket = new ServerSocket(porta);
                while(true) {
                    Socket cli = svSocket.accept();
                    input = new DataInputStream(cli.getInputStream());
                    String request = input.readUTF();
                }
            }
            else {
                System.out.println("Erro nos requisitos para ligar o servidor!");
            }
           
        } catch (IOException er) {
            System.out.println("Erro: " + er);
        }
    }
}
