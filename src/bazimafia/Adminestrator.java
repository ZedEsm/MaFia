
package bazimafia;

import java.util.ArrayList;
import java.util.Scanner;

public class Adminestrator {
    boolean Day_Or_Night;//agar day=true agar night=false
    int Day_Counter=0;
    int Night_Counter=0;
    ArrayList Players = new ArrayList();
    String command ;
    boolean flag_end_of_game=false;
    int Joker_counter=0;
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
    boolean errorflag=false;//role nadaran
    int num_of_assign_role=0;
    boolean game_started=false;
    private static Adminestrator Instance = null;
    public static Adminestrator getInstance(){
        if(Instance==null){
            Instance=new Adminestrator();
        }
        return Instance;
    }
    private Adminestrator() {
 
    }
    
    public void get_command(){
         Scanner scanner = new Scanner(System.in);
    
         while(flag_end_of_game==false){
           

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
            else if(command.startsWith("end_vote")){

                 
            }
            else if(command.startsWith("end_night")){
                    Day_Counter++;
                    System.out.println("Day "+Day_Counter);
                    //kamel nist be safhe 7 highlight morajee shavad
                    boolean flg = false;
                              String bazikon[];
                             // Scanner scanner = new Scanner(System.in);
                            while(flg==false){
                                String bazikonan=scanner.nextLine();
                                if(bazikonan.equals("end_vote")){
                                    flg=true;
                                    End_Vote();
                                }
                                else{
                                    bazikonan = bazikonan.trim();
                                    bazikon=bazikonan.split(" ");

                                    System.out.println(new Player().Vote(bazikon[0],bazikon[1]));
                                }
                            }
                   
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
                        if(Players.get(i) instanceof mafia){
                            mafia obj=(mafia)Players.get(i);
                            System.out.println(obj.Name+": mafia");
                        }
                        else if(Players.get(i) instanceof silencer){
                            silencer obj =(silencer)Players.get(i);
                            System.out.println(obj.Name+": silencer");
                        }
                        else if(Players.get(i) instanceof godfather){
                            godfather obj =(godfather)Players.get(i);
                            System.out.println(obj.Name+": godfather");
                        }
                        else if(Players.get(i) instanceof villager){
                            villager obj =(villager)Players.get(i);
                            System.out.println(obj.Name+": villager");
                        }
                        else if(Players.get(i) instanceof doctor){
                            doctor obj =(doctor)Players.get(i);
                            System.out.println(obj.Name+": doctor");
                        }
                        else if(Players.get(i) instanceof bulletproof){
                            bulletproof obj =(bulletproof)Players.get(i);
                            System.out.println(obj.Name+": bulletproof");
                        }

                         else if(Players.get(i) instanceof Joker){
                            Joker obj =(Joker)Players.get(i);
                            System.out.println(obj.Name+": Joker");
                        }
                        else if(Players.get(i) instanceof detective){
                            detective obj=(detective)Players.get(i);
                            System.out.println(obj.Name+": detective");
                        }
                       
                        }
                            System.out.println("\nReady? Set! Go.");
                            game_started=true;
                            Day_Counter++;
                            Day_Or_Night=true;
                            System.out.println("Day "+Day_Counter);
                            boolean flg = false;
                              String bazikon[];
                              Scanner scanner = new Scanner(System.in);
                            while(flg==false){
                                String bazikonan=scanner.nextLine();
                                if(bazikonan.equals("end_vote")){
                                    flg=true;
                                    End_Vote();
                                }
                                else{
                                    bazikonan = bazikonan.trim();
                                    bazikon=bazikonan.split(" ");

                                    System.out.println(new Player().Vote(bazikon[0],bazikon[1]));
                                }
                            }
                    }
                }
            }
            else{
                System.out.println("game has already started");
            }
            
        }
    }
    public void create_game (String player_names[]){
        if(create_game_command==false){
            System.out.println("no game created" );
            errorflag=true;
        }
        else{
             errorflag=false;//agar error bod in true beshe
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
                    flag=true;  //agar nabod az haghe byron myomad
                    break;
                }
                
            }
            if(flag==false){//agar adame peyda nashod
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
              
                    else if(role_name.equalsIgnoreCase("doctor")){
                        Players.add(new doctor( player_name));
                        doctor_counter++;
                    } 
                    else if(role_name.equalsIgnoreCase("detective")){
                        Players.add(new detective( player_name));
                        detective_counter++;
                    }
                    else if(role_name.equalsIgnoreCase("bulletproof")){
                        Players.add(new bulletproof( player_name));
                        bulletproof_counter++;
                    }
                    else if(role_name.equalsIgnoreCase("Joker")){
                        boolean flagj= false;
                        for (int i = 0; i <Players.size(); i++) {
                            if(Players.get(i) instanceof Joker){
                              flagj=true;
                              break;
                            }
                        }
                        if(flagj==false){
                        Joker joker=new Joker( player_name);
                        Players.add(joker);
                        Joker_counter=1;
                        }
                    } 
                        
                    num_of_assign_role++;
                }
            }
        }
        
           

    }
    public void End_Vote(){
        
        if(Day_Or_Night==true){
                   int Max=((Player)Players.get(0)).VoteCounter;
                   int index = 0;
                   boolean flag1=false;//braye jologiri az tekrar khat 76
                    for (int i = 1; i <Players.size(); i++){
                        if(Max < ((Player)Players.get(i)).VoteCounter){
                            Max=((Player)Players.get(i)).VoteCounter;
                            index=i;//shomare max bara ki bode
                            
                        }              
                    }
                    int equalvote=0;
                    for (int i = 0; i <Players.size(); i++){
                        if(Max == ((Player)Players.get(i)).VoteCounter){
                          
                            equalvote++;
                        }
                    }
                    if(equalvote>1){
                         System.out.println("nobody died");
                         flag1=true;
                    }
                    if(flag1==false){
                        ((Player)Players.get(index)).LiveStatus = false;
                         ((Player)Players.get(index)).time_of_being_killed=true;
                          if(((Player)Players.get(index)) instanceof mafia){
                              mafia_counter--;
                          }
                          else if(((Player)Players.get(index)) instanceof godfather){
                              godfather_counter--;
                          }
                          else if(((Player)Players.get(index)) instanceof silencer){
                              silencer_counter--;
                          }
                          else if(((Player)Players.get(index)) instanceof villager){
                              villager_counter--;
                          }
                          else if(((Player)Players.get(index)) instanceof detective){
                              detective_counter--;
                          }
                          else if(((Player)Players.get(index)) instanceof doctor){
                              doctor_counter--;
                          }
                          else if(((Player)Players.get(index)) instanceof bulletproof){
                              bulletproof_counter--;
                          }
                          else if(((Player)Players.get(index)) instanceof Joker){
                              Joker_counter--;
                          }
                          
                          
                            if(((Player)Players.get(index)) instanceof Joker){
                                Joker j =(Joker)Players.get(index);
                                    if(j.time_of_being_killed==true){
                                        System.out.println("Joker won!");
                                        flag_end_of_game=true;
                                    }
                            }
                        else{
                             System.out.println(((Player)Players.get(index)).Name+" died");
                            
                        }
                    }
                    
                }
                Night_Counter++;
      
                System.out.println("Night "+Night_Counter);//shoro
                Day_Or_Night=false;
               for (int i = 0; i < Players.size(); i++) {
                    Player p = (Player)Players.get(i);
                        if(p instanceof mafia){
                            if(((mafia) p).LiveStatus==true){
               
                              System.out.println(p.Name+": mafia");
                            }
                        }
                        else if(p instanceof silencer){
                            if(((silencer) p).LiveStatus==true){
                              System.out.println(p.Name+": silencer");
                            }
                        }
                        else if(p instanceof godfather){
                            if(((godfather) p).LiveStatus==true){
                              System.out.println(p.Name+": godfather");
                            }
                        }
//                       else if(Players.get(i).getClass().toString().endsWith("villager")){
//
//                            System.out.println(p.Name+": villager");
//                       }
                       else if(p instanceof doctor){
                           if(((doctor) p).LiveStatus==true){
                             System.out.println(p.Name+": doctor");
                           }
                       }
////                        else if(Players.get(i).getClass().toString().endsWith("bulletproof")){
////                            bulletproof obj =(bulletproof)Players.get(i);
////                            System.out.println(obj.Name+": bulletproof");
////                        }
                        else if(p instanceof detective){
                            if(((detective) p).LiveStatus==true){
                            System.out.println(p.Name+": detective");
                            }
                        }
////                       
////                      
////                        
                    }
                
                    Scanner scanner1 = new Scanner(System.in);
                    String vorodi = scanner1.nextLine();
                    vorodi=vorodi.trim();
                    String bazikon[]=vorodi.split(" ");
                    ArrayList list=Players;
                    for (int i = 0; i < list.size(); i++) {
                        Player p = (Player)list.get(i);
                        if(p.Name.equals(bazikon[0])){
                            if(p instanceof silencer){
                                silencer s1 = new silencer(bazikon[0]);
                                System.out.println(s1.Silent(i,bazikon[1]));
                                break;
                            }
                            else if(p instanceof detective){
                                detective d1 = new detective(bazikon[0]);
                                System.out.println(d1.Take_Role(i,bazikon[1]));
                                break;

                            }
                            else if(p instanceof doctor){

                            }
                            else if(p instanceof mafia){
                                mafia m1 = new mafia(bazikon[0]);
                                System.out.println(m1.Vote_During_Night(i,bazikon[1]));
                                break;

                            }
                            else{
                                System.out.println("user can not wake up during night"); 
                                        
                            }
                        }
                    }
                    

//               
    }
    public String End_Night(){
        return null;
    }
//    public void wakeup(Player cc){
//    }
//    public String Wakeup_List(){
//        return null;
//    }
    public int Get_Games_State(){
        return 0;
    }
}
