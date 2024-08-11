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

    int damage = 0;
    //int statLowering, accuracy;

    Random ran = new Random();

    //moveset
    public int tackle(){
        int critChance = ran.nextInt(10);
        if(critChance >= 9){
            damage = 6;
        }else{
            damage = 4;
        }
        return damage;
    }
    public int vineWhip(){
        int critChance = ran.nextInt(10);
        if(critChance >= 9){
            damage = 9;
        }else{
            damage = 6;
        }
        return damage;
    }

    /* public int growl(){
        return statLowering;
    } */

    //rival randomising moveset
    public String[] rivalMoveChoiceBulb(){  //add info about move somehow maybe
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