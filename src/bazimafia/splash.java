
package bazimafia;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author My Laptop
 */
public class splash extends JFrame implements Runnable{
   boolean flag=false,flag1=true;
   int counter=0;
   Thread t = new Thread(this);
    ImageIcon x= new ImageIcon("C:\\Users\\My Laptop\\Desktop\\41NrywwjCEL._AC_.JPG");
    JButton b1 = new JButton(x);
    
   public  splash(){
       getContentPane().add(b1);
      b1.setBackground(Color.BLACK);
      t.start();
      
   } 
   public void paint(Graphics g){
       
 
           if(flag==true){
           g.setColor(Color.WHITE);
           Font f = b1.getFont();
           g.setFont(new Font(f.getName(),Font.BOLD,60));
           g.drawString("ZAHRA SADAT ESMATI BAYEGI", 50, 150);
           }
        
   }

    @Override
    public void run() {
        while(flag1==true)
        {        
            try{
                    t.sleep(5000);
                    counter++;
                    if (counter==3)
                    {
                     flag1=false;
                    }                    
                    flag=true;
                    repaint();
              }
             catch (Exception e) {
                  System.out.println(e);
             }
        }
        this.setVisible(false);
                        System.out.println("welcome to this game:");
                      Adminestrator x = Adminestrator.getInstance();
                      x.get_command();

    }
}
