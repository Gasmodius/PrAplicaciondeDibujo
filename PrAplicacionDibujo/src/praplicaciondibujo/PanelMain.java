package praplicaciondibujo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;


/**
 *
 * @author Oscureo
 */
public class PanelMain extends JPanel {
    
    private JButton bb,bAddAlarm;
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
        bAddAlarm= new JButton("Crear nueva Alarma");
        
        // distribuición de los componentes en el panel
        setLayout(new BorderLayout());
        
        //Panel Principal donde se muestra la informacion
        JPanel panelCenter=new PanelImage("vineta.PNG");
        panelCenter.setLayout(new BorderLayout());
        add(panelCenter,BorderLayout.CENTER);
        
        //Ventana centrada Parte superior con un menu
        JPanel pCenterMenu=new JPanel();
        pCenterMenu.add(bb);
        pCenterMenu.add(new JButton("muajajaja"));
        
        //Ventana centrada donde se visualiza el contenido
        JPanel pCenterDibu=new JPanel();
        
        panelCenter.add(pCenterMenu,BorderLayout.NORTH);
        panelCenter.add(pCenterDibu,BorderLayout.CENTER);
        
        //Panel Segundario donde se muestran las alarmas
        JPanel panelAlarm=new JPanel();
        panelAlarm.add(bAddAlarm);
        add(panelAlarm,BorderLayout.EAST);
    }

    public void controlador(ActionListener ctr){
            
    }
}