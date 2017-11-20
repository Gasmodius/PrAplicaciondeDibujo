package praplicaciondibujo;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Oscureo
 */
public class PanelMain extends JPanel {
    
    private JButton bb;
    
    public PanelMain(){
    
        bb= new JButton("Hola");
        
        // distribuición de los componentes en el panel
        setLayout(new BorderLayout());
        add(bb);
    }

    public void controlador(ActionListener ctr){
            
    }
}