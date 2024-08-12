import java.util.Random;

public class charmander {

        // other classes to interact with it
        bulbasaur b = new bulbasaur();
        squirtle s = new squirtle();
        Random ran = new Random();

        // pokemon stats
        int hp = 20;
        String type = "Fire";
        int damage;
        
        // moveset
        public int scratch() {
                int critChance = ran.nextInt(10);
                if (critChance >= 9) {
                        damage = 6;
                } else {
                        damage = 4;
                }
                return damage;
        }

        public int ember() {
                int critChance = ran.nextInt(10);
                if ("Grass".equals(b.type)) {
                        if (critChance >= 8) {
                                damage = 12;
                        } else {
                                damage = 9;
                        }
                } else if ("Water".equals(s.type)) {
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
        public String[] rivalMoveChoiceChar() {
                String[] charMoves = new String[2]; // add info about move somehow maybe
                int moveChance = ran.nextInt(10);
                if (moveChance <= 7) {
                        charMoves[0] = Integer.toString(scratch());
                        charMoves[1] = "Scratch";
                } else {
                        charMoves[0] = Integer.toString(ember());
                        charMoves[1] = "Ember";
                }
                return charMoves;
        }
}