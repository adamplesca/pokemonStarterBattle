import java.util.Random;
import javax.swing.JOptionPane;

public class Pokemon {

    public int hp;
    public String name, type, strength, weakness;

    Random r = new Random();

    Pokemon(int hp, String name, String type, String weakness) {
        this.hp = hp;
        this.name = name;
        this.type = type;
        this.weakness = weakness;
    }

    //calculates correct damage of each move
    public int superEffectiveCalc(int damage, String moveType, Pokemon target) {
        double finalDamage = damage;

        // 20% chance of critical hit
        if (r.nextInt(10) < 2) {  
            finalDamage *= 1.5;
            JOptionPane.showMessageDialog(null, "Critical hit!");
        }

        // normal type moves deal neutral damage
        if (moveType.equals("normal")) {
            target.hp -= finalDamage;
            return (int) finalDamage;
        }

        // apply type effectiveness based on the move type
        if (moveType.equals(target.weakness)) {
            finalDamage *= 2;  // super effective
            JOptionPane.showMessageDialog(null, "It's super effective!");
        } else if (moveType.equals(target.strength)) {
            finalDamage *= 0.5;  // not very effective
            JOptionPane.showMessageDialog(null, "It's not very effective...");
        }

        target.hp -= finalDamage;
        return (int) finalDamage;
    }

    // pokemon moves
    public int scratch() {
        return 4;
    }

    public int tackle() {
        return 5;
    }

    public int vinewhip() {
        return 7;
    }

    public int watergun() {
        return 7;
    }

    public int ember() {
        return 7;
    }

    // get pokemon moveset
    public String[] getMoveSet() {
        return switch (this.name) {
            case "Bulbasaur" -> new String[]{"Tackle", "Vine Whip"};
            case "Charmander" -> new String[]{"Scratch", "Ember"};
            case "Squirtle" -> new String[]{"Tackle", "Water Gun"};
            default -> new String[]{"Tackle"};
        };
    }

    // assigns move type
    public String getMoveType(String move) {
        return switch (move) {
            case "Tackle", "Scratch" -> "normal";
            case "Vine Whip" -> "grass";
            case "Water Gun" -> "water";
            case "Ember" -> "fire";
            default -> "normal"; 
        };
    }
}
