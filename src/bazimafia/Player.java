
package bazimafia;

import java.util.ArrayList;
import java.util.Scanner;


public class Player {
    boolean time_of_being_killed=false;//false bashe yani shab morde true bashe roz morde
    boolean tried_to_kill=false;
    boolean LiveStatus=true;
    boolean SilentStatus=false;
    public  String Name;
    int VoteCounter=0;
    public Player(String Name){
        this.Name=Name;
    }
    public Player(){}
    public String Vote(String voter,String votee){
        Adminestrator adm = Adminestrator.getInstance();
        ArrayList list = adm.Players;
        boolean flag=false;
        for (int i = 0; i < list.size(); i++) {
            Player p = (Player)list.get(i);
            if(p.Name.equals(voter)){
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
            if(p.Name.equals(votee)){
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
   
