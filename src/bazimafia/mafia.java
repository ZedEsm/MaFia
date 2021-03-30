
package bazimafia;

import java.util.ArrayList;
import java.util.Scanner;

public class mafia extends Player {
        public mafia(String Name) {
        super(Name);
    }
        public String Vote_During_Night(int index_mafia,String name2){
            boolean found=false;
            Adminestrator adm = Adminestrator.getInstance();
            ArrayList listmaf = adm.Players;
            mafia m = (mafia)listmaf.get(index_mafia);
            if(m.LiveStatus==false){
               return " mafia(voter) is dead";  
            }
            for (int i = 0; i < listmaf.size(); i++) {
                Player p = (Player)listmaf.get(i);
                if(p.Name.equals(name2)){
                    if(p.LiveStatus==false){
                        return "votee already dead";
                    }
                    else{
                        p.VoteCounter++;
                        found=true;
                        break;
                    }
                }
              
            }
            if(found==false){
                    return "user not joined";
            }
            else{
                   int Max=((Player)listmaf.get(0)).VoteCounter;
                   int index = 0;
                   boolean flag1=false;//braye jologiri az tekrar khat 76
                    for (int i = 1; i <listmaf.size(); i++){
                        if(Max < ((Player)listmaf.get(i)).VoteCounter){
                            Max=((Player)listmaf.get(i)).VoteCounter;
                            index=i;//shomare max bara ki bode
                            
                        }              
                    }
                    int equalvote=0;
                    for (int i = 0; i <listmaf.size(); i++){
                        if(Max == ((Player)listmaf.get(i)).VoteCounter){
                          
                            equalvote++;
                        }
                    }
                    if(equalvote>1){
                         System.out.println("nobody died");//docotor byad
                         flag1=true;
                    }
                    else{
                        if(flag1==false){
                           ((Player)listmaf.get(index)).LiveStatus = false;
                           ((Player)listmaf.get(index)).time_of_being_killed=false;
                            if(((Player)listmaf.get(index)) instanceof mafia){
                              adm.mafia_counter--;
                          }
                          else if(((Player)listmaf.get(index)) instanceof godfather){
                              adm.godfather_counter--;
                          }
                          else if(((Player)listmaf.get(index)) instanceof silencer){
                              adm.silencer_counter--;
                          }
                          else if(((Player)listmaf.get(index)) instanceof villager){
                             adm.villager_counter--;
                          }
                          else if(((Player)listmaf.get(index)) instanceof detective){
                              adm.detective_counter--;
                          }
                          else if(((Player)listmaf.get(index)) instanceof doctor){
                              adm.doctor_counter--;
                          }
                          else if(((Player)listmaf.get(index)) instanceof bulletproof){
                              adm.bulletproof_counter--;
                          }
                          else if(((Player)listmaf.get(index)) instanceof Joker){
                              adm.Joker_counter--;
                          }
                          
                        }
                    }
                
            }


            return "";
        }
    
}
