package praplicaciondibujo;

import java.awt.BorderLayout;
import java.awt.Window;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Oscureo
 */
public class PanelMain extends JPanel {
    
    private JButton bb,ala;
    private JMenuBar topMenu;
    
    public PanelMain(JMenuBar jm){
        
        topMenu=jm;
        JMenu file=new JMenu("Archivo");
        JMenu view=new JMenu("Vista");
        JMenu alarm=new JMenu("Alarma");
        topMenu.add(file);
        topMenu.add(view);
        topMenu.add(alarm);
                //REllename de JMenuItem-----------------------------------
        bb= new JButton("Hola");
        ala= new JButton("Crear alarma");
        
        // distribuición de los componentes en el panel
        setLayout(new BorderLayout());
        
        //Panel Principal donde se muestra la informacion
        JPanel panelCenter=new JPanel();
        panelCenter.add(bb);
        add(panelCenter,BorderLayout.CENTER);
        
        //Panel Segundario donde se muestran las alarmas
        JPanel panelAlarm=new JPanel();
        panelAlarm.add(ala);
        add(panelAlarm,BorderLayout.EAST);
    }

    public void controlador(ActionListener ctr){
            
    }
}