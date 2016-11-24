/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projects.Trabalho.nodes.nodeImplementations;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.reflect.Method;
import java.util.TreeSet;
import sinalgo.nodes.Node;
import sinalgo.configuration.WrongConfigurationException;
import sinalgo.gui.dialogs.GenerateNodesDialog;
import sinalgo.gui.transformation.PositionTransformation;
import sinalgo.io.eps.EPSOutputPrintStream;
import sinalgo.nodes.Node;
import sinalgo.nodes.edges.Edge;
import sinalgo.nodes.messages.Inbox;
import sinalgo.runtime.Runtime;
import sinalgo.tools.Tools;
/**
 *
 * @author Arthur
 */
public class Sink extends Node {
    private boolean isMaxNode = false; 
	private boolean drawAsNeighbor = false; 
	private TreeSet<S2Node> neighbors = new TreeSet<S2Node>();
    @Override
	public void checkRequirements() throws WrongConfigurationException {
	}

	@Override
	public void handleMessages(Inbox inbox) {
	}

	@Override
	public void init() {
            this.setColor(Color.PINK);
           
	}

	@Override
	public void neighborhoodChange() {
	}

	@Override
	public void preStep() {
            
	}

	@Override
	public void postStep() {
	}
        public void draw(Graphics g, PositionTransformation pt, boolean highlight) {
		double fraction = Math.max(0.1, ((double) neighbors.size()) / Tools.getNodeList().size());
		this.drawingSizeInPixels = (int) (fraction * pt.getZoomFactor() * this.defaultDrawingSizeInPixels);
		drawAsDisk(g, pt, highlight, this.drawingSizeInPixels);
	}
	public void drawToPostScript(EPSOutputPrintStream pw, PositionTransformation pt) {
		drawToPostScriptAsDisk(pw, pt, drawingSizeInPixels/2, getColor());
	}
}
