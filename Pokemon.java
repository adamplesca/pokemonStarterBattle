import java.util.Random;

public class Pokemon {

    public int hp;
    public String name, type, strength, weakness;

    Random r = new Random();

    Pokemon(int hp, String name, String type, String weakness){
        this.hp = hp;
        this.name = name;
        this.type = type;
        this.weakness = weakness;
    }

    public int superEffectiveCalc(int damageMultiplyer, String type, Pokemon target){
        int critChance = r.nextInt(10);
        double extraDamage = 0;
        if(critChance >= 8){
            extraDamage = 0.5;
        }
        if(type.equals("normal")){
            int normalDamage = (int)(damageMultiplyer * (1 + extraDamage));
            target.hp -= normalDamage;
            return normalDamage; 
        }
        if(type.equals(target.weakness)){
            damageMultiplyer *= (2 + extraDamage);
        }else{
            damageMultiplyer *= (0.5 + extraDamage);
        } 
        target.hp -= damageMultiplyer;
        return damageMultiplyer;
    }

    //pokemon moves
    public int scratch(){
        return 4;
    }
    public int tackle(){
        return 5;
    }
    public int vinewhip(){
        return 7;
    }
    public int watergun(){
        return 7;
    }
    public int ember(){
        return 7;
    }
    
}   

//(Dom's Github link as he helped me alot with this project)
// https://github.com/domasbraz