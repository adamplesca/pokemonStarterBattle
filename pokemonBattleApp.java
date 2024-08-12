import javax.swing.JOptionPane;

public class pokemonBattleApp {
    public static void main(String[] args) {

        mainLogic ML = new mainLogic();

        String[] playerOptions = { "Play", "Rules", "Exit" };

        int nav = JOptionPane.showOptionDialog(
                null,
                "Welcome to Pokémon starter Battle",
                "Pokémon Starter Battle",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                playerOptions,
                playerOptions[0]);

        switch (playerOptions[nav]) {
            case "Play" -> {
                startGame();
            }
            case "Rules" -> {
                gameRules();
                // add choice after if they want to play the game rather than closing then reopening to do so
            }
            default -> {
                exitGame();
            }
        }

    }

    // start game function
    private static void startGame() {

        String[] starterPokemon = { "Bulbasaur", "Charmander", "Squirtle" };
        int choice = JOptionPane.showOptionDialog(
                null,
                "Pick your starter",
                "Choose your starter Pokémon",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                starterPokemon,
                starterPokemon[0]);

        enemyTrainer rival = new enemyTrainer(); // creates rival
        rival.outcome(starterPokemon[choice]); // gives info to rival
        rival.rivalPokemonChoice(); // rival pokemon chosen
        // battle starts
        // player chooses attack
        // bot chooses attack
        // repeat + track hp values
        // W/L screens + tracking W/L
        // choice of playing again
    }

    // tutorial function
    private static void gameRules() {
        JOptionPane.showMessageDialog(null, "Here are the rules;"
                + "\n1) You pick your starter pokemon, they all have unique strengths & weaknesses."
                + "\n2) Your rival also picks a pokemon."
                + "\n3) You battle your rival, using the pokemon of your choice."
                + "\n4) With your pokemon's unique moveset you must make your rivals pokemon 'faint' in order to win the battle."
                + "\n5) Whoever makes their oppenents pokemon faint first wins the battle."
        // add optional info about W/L tracking + playing with any starter and however much you like
        );
    }

    // exit game function
    private static void exitGame() {
        JOptionPane.showMessageDialog(null, "Come Back Anytime!");
        System.exit(0);
    }

}

// make option for player to pick a move to attack with within pokemonRound
// function
// make function so ai uses random pokemon move
// track hp of both pokemon and when they reach zero notify user and make W/L
// screen + counter + replay
// make function that simmulates pokemon round