import java.util.Random;

public class squirtle {

        // other classes to interact with it
        bulbasaur b = new bulbasaur();
        charmander c = new charmander();
        Random ran = new Random();

        // pokemon stats
        int hp = 20;
        String type = "Water";
        int damage;


        // moveset
        public int tackle() {
                int critChance = ran.nextInt(10);
                if (critChance >= 9) {
                        damage = 6;
                } else {
                        damage = 4;
                }
                return damage;
        }

        public int waterGun() {
                int critChance = ran.nextInt(10);
                if ("Fire".equals(c.type)) {
                        if (critChance >= 8) {
                                damage = 12;
                        } else {
                                damage = 9;
                        }
                } else if ("Grass".equals(b.type)) {
                        if (critChance >= 8) {
                                damage = 5;
                        } else {
                                damage = 3;
                        }
                } else {
                        damage = 6;
                }
                return damage;
        }

        // rival randomising moveset
        public String[] rivalMoveChoiceSqur() {
                String[] squrMoves = new String[2]; // add info about move somehow maybe
                int moveChance = ran.nextInt(10);
                if (moveChance <= 7) {
                        squrMoves[0] = Integer.toString(tackle());
                        squrMoves[1] = "Tackle";
                } else {
                        squrMoves[0] = Integer.toString(waterGun());
                        squrMoves[1] = "Water Gun";
                }
                return squrMoves;
        }
}