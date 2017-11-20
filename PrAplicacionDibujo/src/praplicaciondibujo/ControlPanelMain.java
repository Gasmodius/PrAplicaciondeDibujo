package praplicaciondibujo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Oscureo
 */
public class ControlPanelMain implements ActionListener{

    private PanelMain view;
    
    public ControlPanelMain(PanelMain pm){
        view=pm;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
