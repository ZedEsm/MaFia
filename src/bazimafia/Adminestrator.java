
package bazimafia;

import java.util.ArrayList;
import java.util.Scanner;

public class Adminestrator {
    boolean Day_Or_Night;
    int Day_Counter;
    int Night_Counter;
    ArrayList Players = new ArrayList();
    Joker joker = null;
    int mafia_counter=0;
    int detective_counter=0;
    int bulletproof_counter=0;
    int doctor_counter=0;
    int godfather_counter=0;
    int silencer_counter=0;
    int villager_counter=0;
    boolean create_game_command=false;
    String player_names[];
    String roles_list[]={"Joker","detective","bulletproof","doctor","godfather","mafia","silencer","villager"};
    boolean errorflag=false;
    int num_of_assign_role=0;
    boolean game_started=false;
    public Adminestrator() {
        
        
    }
    
    public void get_command(){
         Scanner scanner = new Scanner(System.in);
         while(true){
            String command ;

            command=scanner.nextLine();
            command = command.trim();
            //command=command.toLowerCase();

            if(command.startsWith("create_game")){
                create_game_command = true;
                int index= command.indexOf(" ");
                command = command.substring(index+1);
                player_names  = command.split(" ");
                create_game (player_names);
            }
            else if(command.startsWith("assign_role")){
                int index= command.indexOf(" ");
                command = command.substring(index+1);
                String namerole[]  = command.split(" ");
                assign_role(namerole[0], namerole[1]);
            }
            else if(command.startsWith("start_game")){
              
                 start_game();
                   
                
            } 
         }
    }
    public void start_game(){
          if(errorflag==false){
              if(game_started==false){
                  if(create_game_command==false){
                       System.out.println("no game created" ); 
                  }
                  else{
                  if(num_of_assign_role<player_names.length){
                      System.out.println("one or more player do not have a role");
                  }
                  else{
                for (int i = 0; i < Players.size(); i++) {
                        if(Players.get(i).getClass().toString().endsWith("mafia")){
                            mafia obj=(mafia)Players.get(i);
                            System.out.println(obj.Name+": mafia");
                        }
                        else if(Players.get(i).getClass().toString().endsWith("silencer")){
                            silencer obj =(silencer)Players.get(i);
                            System.out.println(obj.Name+": silencer");
                        }
                        else if(Players.get(i).getClass().toString().endsWith("godfather")){
                            godfather obj =(godfather)Players.get(i);
                            System.out.println(obj.Name+": godfather");
                        }
                        else if(Players.get(i).getClass().toString().endsWith("villager")){
                            villager obj =(villager)Players.get(i);
                            System.out.println(obj.Name+": villager");
                        }
                        else if(Players.get(i).getClass().toString().endsWith("doctor")){
                            doctor obj =(doctor)Players.get(i);
                            System.out.println(obj.Name+": doctor");
                        }
                        else if(Players.get(i).getClass().toString().endsWith("bulletproof")){
                            bulletproof obj =(bulletproof)Players.get(i);
                            System.out.println(obj.Name+": bulletproof");
                        }
                        else if(Players.get(i).getClass().toString().endsWith("detective")){
                            detective obj =(detective)Players.get(i);
                            System.out.println(obj.Name+": detective");
                        }
                       
                      
                        
                    }
          
                    if(joker!=null){
                       System.out.println(joker.Name+": Joker");
                    }
                    System.out.println("\nReady? Set! Go.");
                     game_started=true;
               }
                  }
              }
              else{
                  System.out.println("game has already started");
              }
          }
          else{
              System.out.println("no game created");
          }
    }
    public void create_game (String player_names[]){
        if(create_game_command==false){
            System.out.println("no game created" );
            errorflag=true;
        }
        else{
             errorflag=false;
        }

   
    }
   public void assign_role(String player_name,String role_name){
           errorflag=false;
        if(create_game_command==false){
            
           System.out.println("no game created" ); 
            errorflag=true;
        }
        else {
            boolean flag = false;
            for (int i = 0; i < player_names.length; i++) {
                if( player_name.equalsIgnoreCase(player_names[i])){
                    flag=true;  
                    break;
                }
                
            }
            if(flag==false){
                System.out.println("user not found");
                 errorflag=true;
            }
            else{
                boolean flag1=false; 
                for (int i = 0; i <roles_list.length; i++) {
                    if(role_name.equalsIgnoreCase(roles_list[i])){
                        flag1=true;
                        break;
                    }
                }
                if(flag1==false){
                    System.out.println("role not found");
                     errorflag=true;
                }
                else{
                    if(role_name.equalsIgnoreCase("mafia")){
                        Players.add(new mafia( player_name));
                        mafia_counter++;
                    }
                    else if(role_name.equalsIgnoreCase("godfather")){
                        Players.add(new godfather( player_name));
                        godfather_counter++;
                    }
                    else if(role_name.equalsIgnoreCase("silencer")){
                        Players.add(new silencer( player_name));
                        silencer_counter++;
                    }
                    else if(role_name.equalsIgnoreCase("villager")){
                        Players.add(new villager( player_name));
                        villager_counter++;
                    }
                    else if(role_name.equalsIgnoreCase("detective")){
                        Players.add(new detective( player_name));
                        detective_counter++;
                    }
                    else if(role_name.equalsIgnoreCase("doctor")){
                        Players.add(new doctor( player_name));
                        doctor_counter++;
                    } 
                    else if(role_name.equalsIgnoreCase("bulletproof")){
                        Players.add(new bulletproof( player_name));
                        bulletproof_counter++;
                    }
                    else if(role_name.equalsIgnoreCase("Joker")){
                        joker=new Joker( player_name);
                    }
                    num_of_assign_role++;
                }
            }
        }
        
           

    }
    public String End_Vote(){
        return null;
    }
    public String End_Night(){
        return null;
    }
    public String Wakeup_List(){
        return null;
    }
    public int Get_Games_State(){
        return 0;
    }
}
