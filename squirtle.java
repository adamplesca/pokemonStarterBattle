import java.util.Random;

public class squirtle {

        //pokemon stats
        String type = "Water";
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
        public int waterGun(){
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
        public String[] rivalMoveChoiceSqur(){
                String[] squrMoves = new String[2];   //add info about move somehow maybe
                int moveChance = ran.nextInt(10);
                if(moveChance <= 7){
                        squrMoves[0] = Integer.toString(tackle());
                        squrMoves[1] = "Tackle";
                }else{
                        squrMoves[0] = Integer.toString(waterGun());
                        squrMoves[1] = "Water Gun";
                }
                return squrMoves; 
        }
}