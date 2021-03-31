
package bazimafia;

import java.util.ArrayList;
import java.util.Scanner;


public class silencer extends Player {
  
    int counter_silent_kardan=0;
    public silencer(String Name) {
        super(Name);
    }

    public String Silent(int silencer_index,String name2){
        
    
        
            Adminestrator adm1 = Adminestrator.getInstance();
            ArrayList list=adm1.Players;

            silencer s = (silencer)list.get(silencer_index);
            if(s.LiveStatus==false){
                return "user is dead";  
            }
            else{
                if(counter_silent_kardan==0){
                    for (int i = 0; i < list.size(); i++) {
                        Player p = (Player)list.get(i);
                        if(p.Name.equals(name2)){

                            if(p.LiveStatus==false){
                                return "user is dead";
                            }
                            else{
                                p.SilentStatus=true;
                                p.Silent_Day=adm1.Day_Counter;
                                counter_silent_kardan++;
                                return "";
                            }

                        }
                    }
                }
                else{
                    mafia m =new mafia(s.Name);
                    System.out.println(m.Vote_During_Night(silencer_index, name2));
                  
                }
            }
        return "";
    }
}
