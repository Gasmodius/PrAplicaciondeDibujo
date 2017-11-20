package praplicaciondibujo;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Oscureo
 */
public class Main {
    
    public static void main(String[] args) {
        PanelMain pp=new PanelMain();
        ActionListener ctrpp = new ControlPanelMain(pp);
        pp.controlador(ctrpp);
        
        JFrame ventana = new JFrame("Gestor de Dibujo");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
	ventana.setContentPane((JPanel) pp);
	ventana.pack();
	ventana.setVisible(true);
        ventana.setResizable(false);//prohibido cambiar tamaño de la ventana =D
        ventana.setLocationRelativeTo(null);//se centra en la pantalla =D
    }
    
}
