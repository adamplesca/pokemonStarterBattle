import javax.swing.JOptionPane;

public class enemyTrainer {
    private Pokemon rivalPokemon;

    public enemyTrainer(Pokemon playerPokemon) {
        switch (playerPokemon.name) {
            case "Bulbasaur" -> rivalPokemon = new Pokemon(30, "Charmander", "fire", "water");
            case "Charmander" -> rivalPokemon = new Pokemon(30, "Squirtle", "water", "grass");
            case "Squirtle" -> rivalPokemon = new Pokemon(30, "Bulbasaur", "grass", "fire");
        }
        JOptionPane.showMessageDialog(null, "Your rival chose " + rivalPokemon.name + "!");
    }

    public Pokemon getRivalPokemon() {
        return rivalPokemon;
    }
}