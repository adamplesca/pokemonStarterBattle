import java.util.Random;

public class charmander {

        //pokemon stats
        String type = "Fire";
        int hp = 20;
        int attack = 11;
        int specAtt = 12;
        int defense = 10;
        int specDef = 13;
        int speed = 10;

        int damage;
        //int statLowering, accuracy;

        Random ran = new Random();

        //moveset
        public int scratch(){
                int critChance = ran.nextInt(10);
                if(critChance >= 9){
                        damage = 6;
                }else{
                        damage = 4;
                }
                return damage;
        }
        public int ember(){
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
        public String[] rivalMoveChoiceChar(){
                String[] charMoves = new String[2];    //add info about move somehow maybe
                int moveChance = ran.nextInt(10);
                if(moveChance <= 7){
                        charMoves[0] = Integer.toString(scratch());
                        charMoves[1] = "Scratch";
                }else{
                        charMoves[0] = Integer.toString(ember());
                        charMoves[1] = "Ember";
                }
                return charMoves; 
        }
}