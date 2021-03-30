
package bazimafia;

import java.util.ArrayList;
import java.util.Scanner;


public class detective extends Player{
      String bazikon[];
      int counter_stelam=0;
      
    public detective(String Name) {
        super(Name);
       
    }
    
 
    public String  Take_Role(int detective_index,String name2){
         Adminestrator adm1 = Adminestrator.getInstance();
         ArrayList list=adm1.Players;
   
         detective d = (detective)list.get(detective_index);
        if(d.LiveStatus==false){
            return "user is dead";  
        }
        if(counter_stelam==0){
            boolean flag=false;
            for (int i = 0; i < list.size(); i++) {
                Player p = (Player)list.get(i);
                if(p.Name.equals(name2)){
                    flag=true;
                    if(p.LiveStatus==false){
                        counter_stelam++;
                        return "suspect is dead";
                    }
                    else{
                        if(p instanceof godfather){
                            counter_stelam++;
                             return "No";
                        }
                        else if(p instanceof mafia){
                            counter_stelam++;
                            return "Yes";
                        }
                        else {
                            counter_stelam++;
                            return "No";
                        }
                    }
                }
            }
            if(flag==false){
                counter_stelam++;
               return "user not found";
            }
            counter_stelam++;
            return "";
       }
       else{
         counter_stelam++;  
         return "etective has already asked";
       }
    }
}

