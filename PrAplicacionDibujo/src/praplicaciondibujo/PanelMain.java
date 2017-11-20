package praplicaciondibujo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


/**
 *
 * @author Oscureo
 */
public class PanelMain extends JPanel {
    
    private JButton bAddcomic,bDeletecomic,bAddAlarm,bnextAlarm,bVentanaAtras;
    private JMenuBar topMenu;
    
    public PanelMain(JMenuBar jm){
        
        topMenu=jm;
        JMenu file=new JMenu("Archivo");
        JMenu view=new JMenu("Vista");
        JMenu alarm=new JMenu("Alarma");
        topMenu.add(file);
        topMenu.add(view);
        topMenu.add(alarm);
        
        JMenuItem item1=new JMenuItem("Crear uno comic");
        JMenuItem item2=new JMenuItem("Borrar Comic");
        JMenuItem item3=new JMenuItem("Accion 3");
        JMenuItem item4=new JMenuItem("Accion 4");
        JMenuItem item5=new JMenuItem("Accion 5");
        JMenuItem item6=new JMenuItem("Accion 6");
        JMenuItem item7=new JMenuItem("Crear nueva Alarma");
        file.add(item1);
        file.add(item2);
        view.add(item3);
        view.add(item4);
        view.add(item5);
        view.add(item6);
        alarm.add(item7);
                //CAmbiar los nombres de los JMenuItem-------------------------------------------------------------------
        bAddcomic= new JButton("Añadir nuevo comic");
        bDeletecomic=new JButton("Borrar comic");
        bAddAlarm= new JButton("Crear nueva Alarma");
        bVentanaAtras=new JButton(new ImageIcon("flechaR.PNG"));
        bnextAlarm=new JButton("Alarma Proxima");
        // distribuición de los componentes en el panel
        setLayout(new BorderLayout());
        
        //Panel Principal donde se muestra la informacion
        JPanel panelCenter=new JPanel();
        panelCenter.setLayout(new BorderLayout());
        add(panelCenter,BorderLayout.CENTER);
        
        //Ventana centrada Parte superior con un menu
        JPanel pCenterMenu=new JPanel();
        pCenterMenu.add(bAddcomic);
        pCenterMenu.add(bDeletecomic);
        pCenterMenu.add(bVentanaAtras);
        
        //Ventana centrada donde se visualiza el contenido
        PanelImage pCenterDibu=new PanelImage("vineta.PNG");
        panelCenter.setPreferredSize(new Dimension(600, 500));//Esto no deberia ser asi
        
        panelCenter.add(pCenterMenu,BorderLayout.NORTH);
        panelCenter.add(pCenterDibu,BorderLayout.CENTER);
        
        //Panel Segundario donde se muestran las alarmas
        JPanel panelAlarm=new JPanel();
        JPanel menualarm=new JPanel();
        menualarm.add(bAddAlarm);
        menualarm.add(bnextAlarm);
        
        panelAlarm.setLayout(new GridLayout(6,0));
        panelAlarm.add(menualarm);
        panelAlarm.add(new JLabel("No olvides ponerlo bonito"));
        panelAlarm.add(new JLabel("No olvides aprobarme"));
        panelAlarm.add(new JLabel("A las 18:00 sale el proximo cap"));
        panelAlarm.add(new JLabel("Todos estos mensajes son predefinidos y hay que borrarlos"));
        add(panelAlarm,BorderLayout.EAST);
    }

    public void controlador(ActionListener ctr){
        //Cuando haya que conectarse con el controlador
    }
}