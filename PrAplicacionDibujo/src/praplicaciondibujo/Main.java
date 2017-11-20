package praplicaciondibujo;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

/**
 *
 * @author Oscureo
 */
public class Main {
    
    public static void main(String[] args) {
        //Inicializamos las partes de la ventana
        JMenuBar jmb=new JMenuBar();
        PanelMain pm=new PanelMain(jmb);
        ActionListener ctrpp = new ControlPanelMain(pm);
        pm.controlador(ctrpp);
        
        //Creamos la ventana
        JFrame windowFrame = new JFrame("Gestor de Dibujo");
        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	windowFrame.setContentPane((JPanel) pm);
        windowFrame.setJMenuBar(jmb);
	windowFrame.pack();
	windowFrame.setVisible(true);
        windowFrame.setResizable(false);//prohibido cambiar tamaño de la ventana =D
        windowFrame.setLocationRelativeTo(null);//se centra en la pantalla =D
    }
    
}
