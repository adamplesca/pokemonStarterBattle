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
}