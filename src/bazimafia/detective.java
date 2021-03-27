
package bazimafia;

import java.util.ArrayList;
import java.util.Scanner;


public class detective extends villager{
      String bazikon[];
      int counter_stelam=0;
      
    public detective(String Name) {
        super(Name);
       
    }
    
 
    public String  Take_Role(){
        Scanner scanner = new Scanner(System.in);
        String bazikonan=scanner.nextLine();
        bazikonan = bazikonan.trim();
        bazikon=bazikonan.split(" ");
        Adminestrator adm = Adminestrator.getInstance();
   
        
        if(counter_stelam==0){
            ArrayList list=adm.Players;
        boolean flag=false;
        for (int i = 0; i < list.size(); i++) {
            Player p = (Player)list.get(i);
            if(p.Name.equals(bazikon[0])){
                if(p instanceof detective){
                    flag=true;
                    break;
                }
                else{
                    counter_stelam++;
                    return "";
                }
            }
            
        }
        if(flag==false){
            counter_stelam++;
           return "user not found";
        }
        flag=false;
        for (int i = 0; i < list.size(); i++) {
            Player p = (Player)list.get(i);
            if(p.Name.equals(bazikon[1])){
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
            return "etective has already asked";
        }
    }
}

