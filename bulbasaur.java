import java.util.Random;

public class bulbasaur {

    // other classes to interact with it
    squirtle s = new squirtle();
    charmander c = new charmander();
    Random ran = new Random();

    // pokemon stats
    int hp = 20;
    String type = "Grass";
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

    public int vineWhip() {
        int critChance = ran.nextInt(10);
        if ("Water".equals(s.type)) {
            if (critChance >= 8) {
                damage = 12;
            } else {
                damage = 9;
            }
        } else if ("Fire".equals(c.type)) {
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
    public String[] rivalMoveChoiceBulb() { // add info about move somehow maybe
        String[] bulbMoves = new String[2];
        int moveChance = ran.nextInt(10);
        if (moveChance <= 7) {
            bulbMoves[0] = Integer.toString(tackle());
            bulbMoves[1] = "Tackle";
        } else {
            bulbMoves[0] = Integer.toString(vineWhip());
            bulbMoves[1] = "Vinewhip";
        }
        return bulbMoves;
    }
}