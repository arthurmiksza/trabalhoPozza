/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projects.Trabalho.models.connectivityModels;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import projects.Trabalho.nodes.nodeImplementations.S2Node;
import projects.Trabalho.nodes.nodeImplementations.Sink;
import sinalgo.configuration.Configuration;
import sinalgo.configuration.CorruptConfigurationEntryException;
import sinalgo.models.ConnectivityModelHelper;
import sinalgo.nodes.Node;
import sinalgo.nodes.Position;
/**
 *
 * @author Arthur
 */
public class Conectador extends ConnectivityModelHelper {
    public double raio;
    public final String filePath = "src/data/";

    
    protected boolean isConnected(Node from, Node to){
        if (from instanceof S2Node && to instanceof S2Node)
            return false;
        if (from instanceof Sink)
            return false;
        Position p1 = from.getPosition();
        Position p2 = to.getPosition();	
        double distance = p1.squareDistanceTo(p2);
        try {
            File f = new File(this.filePath + "dados" + from.ID + ".txt");
            if (f.exists()) {
                PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f, false)));
                pw.println("ID&" + from.ID + ";OUT&" + ((distance < raio)? "FALSE": "TRUE") + ";POS&X-" + from.getPosition().xCoord + "separaY-" + from.getPosition().yCoord);
                pw.close();
            }
        } catch (IOException err) {
            System.out.println("Erro ao salvar no arquivo: " + err);
        }
        return (distance < raio);
    }
    
    public Conectador(double r) {
        this.raio = r * r;
    }
    private static boolean inicializado = false;
    private static double maxRaio;  
	
    
    public Conectador() throws CorruptConfigurationEntryException {
        if(!inicializado) {
                double nodeMaxRaio = Configuration.getDoubleParameter("GeometricNodeCollection/rMax");
                try {
                        maxRaio = Configuration.getDoubleParameter("Conectador/rMax");
                } catch(CorruptConfigurationEntryException e) {
                        maxRaio = nodeMaxRaio;
                }			
                maxRaio = maxRaio * maxRaio;
                inicializado = true;
        }
        raio = maxRaio;
    }
}
