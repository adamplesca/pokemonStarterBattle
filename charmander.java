public class charmander {

        //pokemon stats
        String type = "Fire";
        int hp = 20;
        int attack = 11;
        int specAtt = 12;
        int defense = 10;
        int specDef = 13;
        int speed = 10;

        //moves + vars for stats

        int phyDamage, specDamage, statLowering;
        int accuracy;

        public int scratch(){
                return phyDamage;
        }
        public int ember(){
                return specDamage;
        }
        public int growl(){
                return statLowering;
        }
}
