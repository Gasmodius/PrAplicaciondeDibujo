package praplicaciondibujo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.EventListener;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/**
 *
 * @author Oscureo
 */
public class PanelImage extends JPanel implements MouseListener,MouseMotionListener,MouseWheelListener{
    
    private final ImageIcon image;
    private int oldClickX,oldClickY;
    private int posImgX,posImgY,oldposX,oldposY;
    private float zoomH,zoomW;
    private float proportion;
    
    
    public PanelImage(String file){
        oldClickX=0;
        oldClickY=0;
        posImgX=0;
        posImgY=0;
        oldposX=0;
        oldposY=0;
        zoomH=0;
        zoomW=0;
        image=new ImageIcon(file); 
        proportion=(float)image.getImage().getHeight(this)/(float)image.getImage().getWidth(this);
    }
    
    public void controlador(EventListener ctrpp) {
        addMouseListener((MouseListener) ctrpp);
        addMouseMotionListener((MouseMotionListener) ctrpp);
        addMouseWheelListener((MouseWheelListener)ctrpp);
    }
    
    private int DoZoomW(int ancho){
    return (int)Math.max(0,ancho+(2*zoomW));
    }
    
    private int DoZoomH(int alto){
    return (int)Math.max(0,alto+(2*zoomH));
    }
    
    public void center(){
        oldposX=0;
        oldposY=0;
        zoomH=0;
        zoomW=0;
        this.repaint();
    }
    
    public void setImage(String file){
        oldposX=0;
        oldposY=0;
        zoomH=0;
        zoomW=0;
        ImageIcon im=new ImageIcon(file);
        Image ima=im.getImage();
        image.setImage(ima);
        proportion=(float)image.getImage().getHeight(this)/(float)image.getImage().getWidth(this);
        this.repaint();
    }

    //Devuelve un JPopmenu con las acciones posibles que puede hacer el robot
    public JPopupMenu acciones(ControlPanelMain crt){
       JMenuItem item;
       JPopupMenu m=new JPopupMenu("Acciones");
        
        m.addSeparator();
        m.add(item = new JMenuItem("CENTRAR"));
        item.addActionListener(crt);
        item.setActionCommand("CENTRAR");
        
        m.addSeparator();
        m.add(item = new JMenuItem("CAMBIAR"));
        item.addActionListener(crt);
        item.setActionCommand("CAMBIARIMG");
        
        m.addSeparator();
        m.add(item = new JMenuItem("CERRAR"));
        item.addActionListener(crt);
        item.setActionCommand("CERRAR");
        
        return m;
    }
    
    @Override
    public void paint(Graphics g) {
        if((image.getImage().getWidth(this)<this.getWidth())&&
        (image.getImage().getHeight(this)<this.getHeight())){//Ambos lados de la imagen son más pequeños.
            if(image.getImage().getWidth(this)>image.getImage().getHeight(this)){
                float scalew=(float)this.getWidth()/(float)image.getImage().getWidth(this);
                if(image.getImage().getHeight(this)*scalew<this.getHeight()){//Se agranda el lado correcto h
                    
                int heightimag=(int)( image.getImage().getHeight(this)*scalew);
                g.drawImage(image.getImage(),posImgX+oldposX,Math.abs((this.getHeight()/2)-(heightimag/2))+posImgY+oldposY,
                        DoZoomW(this.getWidth()) ,DoZoomH(heightimag), this);
                
                }else{
                    
                float scaleh=(float)this.getHeight()/(float)image.getImage().getHeight(this);
                int wightimag=(int)( image.getImage().getWidth(this)*scaleh);
                g.drawImage(image.getImage(),Math.abs((this.getWidth()/2)-(wightimag/2))+posImgX+oldposX,posImgY+oldposY,
                        DoZoomW(wightimag) ,DoZoomH(this.getHeight()), this);
                
                }
            }else{
               float scaleh=(float)this.getHeight()/(float)image.getImage().getHeight(this);
                if(image.getImage().getWidth(this)*scaleh<this.getWidth()){//Se agranda el lado correcto w
                    
                int wightimag=(int)( image.getImage().getWidth(this)*scaleh);
                g.drawImage(image.getImage(),Math.abs((this.getWidth()/2)-(wightimag/2))+posImgX+oldposX,posImgY+oldposY,
                        DoZoomW(wightimag) ,DoZoomH(this.getHeight()), this);
                
                }else{
                    
                float scalew=(float)this.getWidth()/(float)image.getImage().getWidth(this);
                int heightimag=(int)( image.getImage().getHeight(this)*scalew);
                g.drawImage(image.getImage(),posImgX+oldposX,Math.abs((this.getHeight()/2)-(heightimag/2))+posImgY+oldposY,
                        DoZoomW(this.getWidth()) ,DoZoomH(heightimag), this);
                
                }
            } 
        }else if((image.getImage().getWidth(this)>this.getWidth())&&
        (image.getImage().getHeight(this)>this.getHeight())){//Ambos lados de la imagen son más grandes.
            float scaleh=(float)this.getHeight()/(float)image.getImage().getHeight(this);
            float scalew=(float)this.getWidth()/(float)image.getImage().getWidth(this);
            if(scaleh>scalew){
                
            int wightimag=(int)( image.getImage().getWidth(this)*scalew);
            int heightimag=(int)( image.getImage().getHeight(this)*scalew);
            g.drawImage(image.getImage(),Math.abs((this.getWidth()/2)-(wightimag/2))+posImgX+oldposX,Math.abs((this.getHeight()/2)-(heightimag/2))+posImgY+oldposY,
                    DoZoomW(wightimag) ,DoZoomH(heightimag), this);
            
            }else{
                
            int wightimag=(int)( image.getImage().getWidth(this)*scaleh);
            int heightimag=(int)( image.getImage().getHeight(this)*scaleh);
            g.drawImage(image.getImage(),Math.abs((this.getWidth()/2)-(wightimag/2))+posImgX+oldposX,Math.abs((this.getHeight()/2)-(heightimag/2))+posImgY+oldposY,
                   DoZoomW(wightimag) ,DoZoomH(heightimag), this);
            
            }
        }else{//Uno de los lados es más grande.
            if(image.getImage().getHeight(this)>this.getHeight()){
                
            float scale=(float)this.getHeight()/(float)image.getImage().getHeight(this);
            int wightimag=(int)( image.getImage().getWidth(this)*scale);
            g.drawImage(image.getImage(),Math.abs((this.getWidth()/2)-(wightimag/2))+posImgX+oldposX,posImgY+oldposY,
                    DoZoomW(wightimag) ,DoZoomH(this.getHeight()), this);
                
            }else if(image.getImage().getWidth(this)>this.getWidth()){
                
            float scale=(float)this.getWidth()/(float)image.getImage().getWidth(this);
            int heightimag=(int)( image.getImage().getHeight(this)*scale);
            g.drawImage(image.getImage(),posImgX+oldposX,Math.abs((this.getHeight()/2)-(heightimag/2))+posImgY+oldposY,
                    DoZoomW(this.getWidth()) ,DoZoomH(heightimag), this);
                
            }else{//La imagen es igual a al ventana
                g.drawImage(image.getImage(),posImgX+oldposX,posImgY+oldposY,
                        DoZoomW(this.getWidth()),DoZoomH(this.getHeight()), this);
            }
        }
        
        setOpaque(false);
        super.paint(g);
    }
    
    //Estos metodos del mouse son solo para una imagen en especifico
    @Override
    public void mouseDragged(MouseEvent me) {
        
        if(oldClickX!=0 && oldClickY!=0){
            posImgX=me.getXOnScreen()-oldClickX;
            posImgY=me.getYOnScreen()-oldClickY;
            this.repaint();
        }else{
            oldClickX=me.getXOnScreen();
            oldClickY=me.getYOnScreen();
        }
        
    }
    
    @Override
    public void mouseMoved(MouseEvent me) {
        if(oldClickX!=0 && oldClickY!=0){
        oldposX+=posImgX;
        oldposY+=posImgY;
        posImgX=0;
        posImgY=0;
        oldClickX=0;
        oldClickY=0;
        this.repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet.");}
    
    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet.");}
    
    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet.");}
    
    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet.");}
    
    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet.");}

    @Override
    public void mouseWheelMoved(MouseWheelEvent mwe) {
        int speedZoom=10;
        
        zoomW=zoomW-speedZoom*mwe.getWheelRotation();
        zoomH=zoomW*proportion;
        oldposX+=speedZoom*mwe.getWheelRotation();
        oldposY+=speedZoom*mwe.getWheelRotation();
        
        this.repaint();
    }
}
