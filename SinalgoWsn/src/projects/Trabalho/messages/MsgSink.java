/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projects.Trabalho.messages;

import sinalgo.nodes.Node;
import sinalgo.nodes.messages.Message;

/**
 *
 * @author Arthur
 */
public class MsgSink extends Message {
    
    private Node origem;

    public MsgSink(Node o) {
        this.origem = o;
    }
    
    @Override
    public Message clone() {
        return new MsgSink(this.origem);
    }

    public Node getOrigem() {
        return this.origem;
    }
}
