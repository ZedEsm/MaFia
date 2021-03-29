
package bazimafia;

import java.util.ArrayList;
import java.util.Scanner;


public class silencer extends mafia {
  
    
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
            for (int i = 0; i < list.size(); i++) {
                Player p = (Player)list.get(i);
                if(p.Name.equals(name2)){

                    if(p.LiveStatus==false){
                        return "user is dead";
                    }
                    else{
                        p.SilentStatus=true;
                    }
                    break;
                }
            }
        }
        return null;
    }
       public String Select(){
        return null;
    }
}
