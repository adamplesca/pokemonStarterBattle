
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
            }
            case "Charmander" -> {
                message = "Your rival chose 'Squirtle'!";
            }
            case "Squirtle" -> {
                message = "Your rival chose 'Bulbasaur'!";
            }
            default -> {
                message = "Error, did not choose pokemon";
            }
        }
        return message;
    }
}