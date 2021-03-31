
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
                       return index_mafia+"->"+i+"]"; 
                     // p.VoteCounter++;
                    }
                }
              
            }
            if(found==false){
                    return "user not joined";
            }



            return "";
        }
        public void kill(){
                    Adminestrator adm = Adminestrator.getInstance();
                    ArrayList listmaf = adm.Players;
                    int Max=((Player)listmaf.get(0)).nigth_VoteCounter;
                    int index = 0;
                    boolean flag1=false;//braye jologiri az tekrar khat 76
                    for (int i = 1; i <listmaf.size(); i++){
                        if(Max < ((Player)listmaf.get(i)).nigth_VoteCounter){
                            Max=((Player)listmaf.get(i)).nigth_VoteCounter;
                            index=i;//shomare max bara ki bode
                            
                        }              
                    }
                    int equalvote=0;
                    for (int i = 0; i <listmaf.size(); i++){//ki bod ke max shod
                        if(Max == ((Player)listmaf.get(i)).nigth_VoteCounter){
                          
                            equalvote++;
                        }
                    }
                    if(equalvote>2){
                         System.out.println("nobody died");//chand nafaar ray yeksan dashtan
                         flag1=true;
                    }
                    else if(equalvote==2){
                        
                      int idx1=-1,idx2=-1;
                      for (int i = 0; i <listmaf.size(); i++){//ki bod ke max shod
                           if(Max == ((Player)listmaf.get(i)).nigth_VoteCounter){
                              idx1=i;
                              equalvote++;
                            }
                        }
                       for (int i = idx1+1; i <listmaf.size(); i++){//ki bod ke max shod
                           if(Max == ((Player)listmaf.get(i)).nigth_VoteCounter){
                              idx2=i;
                              equalvote++;
                            }
                        }
                        int max=2;
                        int min=0;
                        int select= (int)Math.floor((max+1-min)*Math.random()+min);
                        if(select==0){
                          ((Player)listmaf.get(idx1)).LiveStatus=true;
                         
                          if(!(((Player)listmaf.get(idx1)) instanceof bulletproof)){
                               ((Player)listmaf.get(idx1)).tried_to_kill=true;
                          }
                          else{
                               ((Player)listmaf.get(idx1)).tried_to_kill=false;    
                          }
                          if((((Player)listmaf.get(idx2)) instanceof bulletproof)){
                              if(((bulletproof)listmaf.get(idx2)).Num_Of_Life>0){
                                   ((bulletproof)listmaf.get(idx2)).Num_Of_Life--; 
                              }
                              else{
                                    ((Player)listmaf.get(idx2)).LiveStatus=false;
                                    ((Player)listmaf.get(idx2)).time_of_being_killed=false;
                                     adm.bulletproof_counter--;
                              }
                            
                          }
                          else{
                            ((Player)listmaf.get(idx2)).LiveStatus=false;
                            ((Player)listmaf.get(idx2)).time_of_being_killed=false;

                            if(((Player)listmaf.get(idx2)) instanceof mafia){
                                adm.mafia_counter--;
                            }
                            else if(((Player)listmaf.get(idx2)) instanceof godfather){
                                adm.godfather_counter--;
                            }
                            else if(((Player)listmaf.get(idx2)) instanceof silencer){
                                adm.silencer_counter--;
                            }
                            else if(((Player)listmaf.get(idx2)) instanceof villager){
                               adm.villager_counter--;
                            }
                            else if(((Player)listmaf.get(idx2)) instanceof detective){
                                adm.detective_counter--;
                            }
                            else if(((Player)listmaf.get(idx2)) instanceof doctor){
                                adm.doctor_counter--;
                            }
                            else if(((Player)listmaf.get(idx2)) instanceof bulletproof){
                                adm.bulletproof_counter--;
                            }
                            else if(((Player)listmaf.get(idx2)) instanceof Joker){
                                adm.Joker_counter--;
                            }

                          }
                          
                        }
                        else if(select==1){
                          ((Player)listmaf.get(idx2)).LiveStatus=true;
                            if(!(((Player)listmaf.get(idx2)) instanceof bulletproof)){
                               ((Player)listmaf.get(idx2)).tried_to_kill=true;
                            }
                            else{
                               ((Player)listmaf.get(idx2)).tried_to_kill=false;
                            }
                            if((((Player)listmaf.get(idx1)) instanceof bulletproof)){
                                if(((bulletproof)listmaf.get(idx1)).Num_Of_Life>0){
                                   ((bulletproof)listmaf.get(idx1)).Num_Of_Life--; 
                                }
                                else{
                                    ((Player)listmaf.get(idx1)).LiveStatus=false;
                                    ((Player)listmaf.get(idx1)).time_of_being_killed=false;
                                     adm.bulletproof_counter--;
                                }
                            }
                            else{
                                ((Player)listmaf.get(idx1)).LiveStatus=false;
                                ((Player)listmaf.get(idx1)).time_of_being_killed=false;

                                if(((Player)listmaf.get(idx1)) instanceof mafia){
                                    adm.mafia_counter--;
                                }
                                else if(((Player)listmaf.get(idx1)) instanceof godfather){
                                    adm.godfather_counter--;
                                }
                                else if(((Player)listmaf.get(idx1)) instanceof silencer){
                                    adm.silencer_counter--;
                                }
                                else if(((Player)listmaf.get(idx1)) instanceof villager){
                                   adm.villager_counter--;
                                }
                                else if(((Player)listmaf.get(idx1)) instanceof detective){
                                    adm.detective_counter--;
                                }
                                else if(((Player)listmaf.get(idx1)) instanceof doctor){
                                    adm.doctor_counter--;
                                }
                                else if(((Player)listmaf.get(idx1)) instanceof bulletproof){
                                    adm.bulletproof_counter--;
                                }
                                else if(((Player)listmaf.get(idx1)) instanceof Joker){
                                    adm.Joker_counter--;
                                }
                            } 
                        }
                        else{//hich kodam ra nejat nemidahad
                     
                           ((Player)listmaf.get(idx1)).LiveStatus=true;
                            if(!(((Player)listmaf.get(idx1)) instanceof bulletproof)){
                               ((Player)listmaf.get(idx1)).tried_to_kill=true;
                            }
                            else{
                             ((Player)listmaf.get(idx1)).tried_to_kill=false;
                            }
                           
                            ((Player)listmaf.get(idx2)).LiveStatus=true;
                            if(!(((Player)listmaf.get(idx2)) instanceof bulletproof)){
                               ((Player)listmaf.get(idx2)).tried_to_kill=true;
                            }
                            else{
                             ((Player)listmaf.get(idx2)).tried_to_kill=false;
                            }
                      
                            System.out.println("nobody died");
                        }
                    }
                    
                    else{//max koshte shod ye nafar bayad koshte beshe
                        
                           ((Player)listmaf.get(index)).LiveStatus = true;
                          
                            if(!(((Player)listmaf.get(index)) instanceof bulletproof)){
                               ((Player)listmaf.get(index)).tried_to_kill=true;
                            }
                            else{
                             ((Player)listmaf.get(index)).tried_to_kill=false;
                            }
                         
                          
                        
                    }
        }
    
}
