import java.util.Random;

public class bulbasaur {
    
    //pokemon stats
    String type = "Grass/Poisin";
    int hp = 20;
    int attack = 11;
    int specAtt = 12;
    int defense = 10;
    int specDef = 13;
    int speed = 10;

    //moves + vars for stats
    Random ran = new Random();
    int damage, statLowering;
    
    //int accuracy;

    public int tackle(){
        int critChance = ran.nextInt(10);
        if(critChance == 10){
            damage = 8;
        }else{
            damage = 4;
        }
        return damage;
    }
    
    public int vineWhip(){
        int critChance = ran.nextInt(10);
        if(critChance == 10){
            damage = 12;
        }else{
            damage = 6;
        }
        return damage;
    }
    /* public int growl(){
        return statLowering;
    } */

    /* public int moveChoice(){
        //String[] bulbMoves = new String[2];
        int moveChance = ran.nextInt(10);
        if(moveChance <= 7){
            damage = tackle();
        }else{
            damage = vineWhip();
        }
        return damage;
    } */

    public String[] moveChoice(){
        String[] bulbMoves = new String[2];
        int moveChance = ran.nextInt(10);
        if(moveChance <= 7){
            bulbMoves[0] = Integer.toString(tackle());
            bulbMoves[1] = "Tackle";
        }else{
            bulbMoves[0] = Integer.toString(vineWhip());
            bulbMoves[1] = "Vinewhip";
        }
        return bulbMoves; 
    } 
}