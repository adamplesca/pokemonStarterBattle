
public class enemyTrainer {

    private String pokemon, message;

    public void outcome(String chosenPokemon) {
        pokemon = chosenPokemon;
    }

    // rival chooses pokemon
    public String rivalPokemonChoice() {
        switch (pokemon) {
            case "Bulbasaur" -> {
                message = "Your rival chose 'Charmander'!";
                charmander chaPokemon = new charmander();
                // JOptionPane.showMessageDialog(null, "Your rival 'Blue' picked 'Charmander'!");
            }
            case "Charmander" -> {
                message = "Your rival chose 'Squirtle'!";
                squirtle squPokemon = new squirtle();
                // JOptionPane.showMessageDialog(null, "Your rival 'Blue' picked 'Squirtle'!");
            }
            case "Squirtle" -> {
                message = "Your rival chose 'Bulbasaur'!";
                bulbasaur bulPokemon = new bulbasaur();
                // JOptionPane.showMessageDialog(null, "Your rival 'Blue' picked 'Bulbasaur'!");
            }
            default -> {
                message = "Error, did not choose pokemon";
            }
        }
        return message;
    }

    // rival move selector for each pokemon
    public void rivalPokemonMoveForBulbasaur() {

    }

    public void rivalPokemonMoveForCharmander() {

    }

    public void rivalPokemonMoveForSquirtle() {

    }
}