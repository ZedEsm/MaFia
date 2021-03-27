
package bazimafia;

import java.util.ArrayList;
import java.util.Scanner;


public class Player {
   // boolean Day_Or_
    boolean LiveStatus=true;
    boolean SilentStatus=false;
    public  String Name;
    int VoteCounter;
    public Player(String Name){
        this.Name=Name;
    }
   public String Vote(){
        String bazikon[];
       
        Scanner scanner = new Scanner(System.in);
        String bazikonan=scanner.nextLine();
        bazikonan = bazikonan.trim();
        bazikon=bazikonan.split(" ");
        Adminestrator adm = Adminestrator.getInstance();
   
        ArrayList list = adm.Players;
        boolean flag=false;
        for (int i = 0; i < list.size(); i++) {
            Player p = (Player)list.get(i);
            if(p.Name.equals(bazikon[0])){
                flag=true;
                if(p.LiveStatus==false){
                     return "voter already dead";
                }
                else{
                    if(p.SilentStatus==true){
                        return "voter is silenced";
                    }
                }
                break;
            }
            
        }
        if(flag==false){
           return "user not found";
        }
        flag=false;
        for (int i = 0; i < list.size(); i++) {
            Player p = (Player)list.get(i);
            if(p.Name.equals(bazikon[1])){
                flag=true;
                if(p.LiveStatus==false){
                    
                   return "votee already dead";
                }
                p.VoteCounter++;
                break;
            }
        }
        if(flag==false){
           
           return "user not found";
        }
      
        return "";
      

    }

       
   }
   
