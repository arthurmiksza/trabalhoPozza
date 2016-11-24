package projects.Trabalho.models.mobilityModels;

import sinalgo.configuration.Configuration;
import sinalgo.io.mapIO.Map;
import sinalgo.nodes.Node;
import sinalgo.nodes.Position;
import sinalgo.runtime.Main;
import sinalgo.tools.Tools;

public class AlertOut {
    
    public AlertOut() {
        super();
    }
    
    public int isOut(Position n) {
        Map m = Tools.getBackgroundMap();
        if(Configuration.useMap)
            return (m.isBlack(n.xCoord, n.yCoord)) ? 1 : 0;
        return -1;
    }
}
