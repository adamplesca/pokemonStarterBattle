import java.util.Random;
import javax.swing.JOptionPane;

public class pokemonBattleApp {

    // Global variables to track wins, losses, and total games
    static int win = 0;
    static int loss = 0;
    static int totalGames = 0;

    public static void main(String[] args) {

        Pokemon bulbasaur = new Pokemon(30, "Bulbasaur", "grass", "fire");
        Pokemon squirtle = new Pokemon(30, "Squirtle", "water", "grass");
        Pokemon charmander = new Pokemon(30, "Charmander", "fire", "water");

        String[] playerOptions = {"Play", "Rules", "Stats", "Exit"};

        // Main loop to keep the game running until the player exits
        while (true) {
            int nav = JOptionPane.showOptionDialog(
                    null,
                    "Welcome to Pokémon Starter Battle",
                    "Pokémon Starter Battle",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    playerOptions,
                    playerOptions[0]);

            switch (playerOptions[nav]) {
                case "Play" -> startGame(bulbasaur, squirtle, charmander);
                case "Rules" -> {
                    gameRules();
                    int choice = JOptionPane.showConfirmDialog(null, "Would you like to play now?");
                    if (choice == JOptionPane.YES_OPTION) {
                        startGame(bulbasaur, squirtle, charmander);
                    } else {
                        exitGame();
                    }
                }
                case "Stats" -> {
                    showStats();
                    int choice = JOptionPane.showConfirmDialog(null, "Would you like to play now?");
                    if (choice == JOptionPane.YES_OPTION) {
                        startGame(bulbasaur, squirtle, charmander);
                    } else {
                        exitGame();
                    }
                }
                default -> exitGame();
            }
        }
    }

    private static void startGame(Pokemon bulbasaur, Pokemon squirtle, Pokemon charmander) {
        // Choose starter Pokémon
        String[] starterPokemon = {"Bulbasaur", "Charmander", "Squirtle"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Pick your starter",
                "Choose your starter Pokémon",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                starterPokemon,
                starterPokemon[0]);

        Pokemon playerPokemon;
        Pokemon aiPokemon;

        switch (starterPokemon[choice]) {
            case "Bulbasaur" -> playerPokemon = bulbasaur;
            case "Charmander" -> playerPokemon = charmander;
            case "Squirtle" -> playerPokemon = squirtle;
            default -> throw new IllegalStateException("Unexpected value: " + starterPokemon[choice]);
        }

        // Reset Pokémon health before starting a new game
        playerPokemon.hp = 30;
        aiPokemon = new enemyTrainer(playerPokemon).getRivalPokemon();
        aiPokemon.hp = 30;

        // Start battle loop
        while (playerPokemon.hp > 0 && aiPokemon.hp > 0) {

            // Player's turn to choose a move
            String playerMove = playerChooseMove(playerPokemon);
            int playerDamage = executeMove(playerPokemon, aiPokemon, playerMove);
            JOptionPane.showMessageDialog(null, playerPokemon.name + " used " + playerMove + " and dealt " + playerDamage + " damage!");

            if (aiPokemon.hp <= 0) {
                win++;
                totalGames++;
                break;
            }

            JOptionPane.showMessageDialog(null, "It's now your rival's turn!");

            // AI's turn to choose a move
            String aiMove = aiChooseMove(aiPokemon);
            int aiDamage = executeMove(aiPokemon, playerPokemon, aiMove);
            JOptionPane.showMessageDialog(null, aiPokemon.name + " used " + aiMove + " and dealt " + aiDamage + " damage!");

            if (playerPokemon.hp <= 0) {
                loss++;
                totalGames++;
                break;
            }
        }

        // Determine winner + ask if user wants to play again
        String winner = playerPokemon.hp > 0 ? playerPokemon.name : aiPokemon.name;
        JOptionPane.showMessageDialog(null, winner + " wins!");

        // Provide options after the game ends
        String[] replayOptions = {"Play again", "Rules", "Stats", "Exit"}; 
        int replayQuestion = JOptionPane.showOptionDialog(
                null,
                "What would you like to do?",
                "Pokémon Starter Battle",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                replayOptions,
                replayOptions[0]);

        // Handle player's choice after the game
        switch (replayOptions[replayQuestion]) {
            case "Play again" -> startGame(bulbasaur, squirtle, charmander);
            case "Rules" -> gameRules();
            case "Stats" -> showStats();
            default -> exitGame();
        }
    }

    // Player chooses a move from available options
    private static String playerChooseMove(Pokemon playerPokemon) {
        String[] moves = playerPokemon.getMoveSet();
        int moveChoice = JOptionPane.showOptionDialog(
                null,
                "Choose your move",
                "Choose a Move",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                moves,
                moves[0]);

        return moves[moveChoice];
    }

    // AI chooses a move with a higher probability of selecting the weaker move
    private static String aiChooseMove(Pokemon aiPokemon) {
        String[] moves = aiPokemon.getMoveSet();
        Random r = new Random();
        // 70% chance to use the weaker move (index 0), 30% chance to use the stronger move (index 1)
        int moveChoice = r.nextInt(10) <= 7 ? 0 : 1;
        return moves[moveChoice];
    }

    // Executes the move and calculates damage
    private static int executeMove(Pokemon attacker, Pokemon defender, String move) {
        int damage = 0;

        // Get the move's type
        String moveType = attacker.getMoveType(move);

        // Set damage based on the move
        switch (move) {
            case "Tackle" -> damage = attacker.tackle();
            case "Scratch" -> damage = attacker.scratch();
            case "Vine Whip" -> damage = attacker.vinewhip();
            case "Water Gun" -> damage = attacker.watergun();
            case "Ember" -> damage = attacker.ember();
        }

        // Calculate and apply damage based on move type
        return attacker.superEffectiveCalc(damage, moveType, defender);
    }

    // Display the game rules
    private static void gameRules() {
        JOptionPane.showMessageDialog(null, "Here are the rules..."
                + "\n1) You pick your starter Pokémon, they all have unique strengths & weaknesses."
                + "\n2) Your rival also picks a Pokémon."
                + "\n3) You battle your rival, using the Pokémon of your choice."
                + "\n4) With your Pokémon's unique moveset you must make your rival's Pokémon 'faint' to win the battle."
                + "\n5) Whoever makes their opponent's Pokémon faint first wins the battle.");
    }

    // Display the win/loss stats and win percentage
    private static void showStats() {
        if (totalGames == 0) {
            JOptionPane.showMessageDialog(null, "No games played yet!");
        } else {
            double winPercentage = ((double) win / totalGames) * 100;
            JOptionPane.showMessageDialog(null, "Stats:\n"
                    + "Wins: " + win + "\n"
                    + "Losses: " + loss + "\n"
                    + "Win Percentage: " + String.format("%.2f", winPercentage) + "%");
        }
    }

    // Exit the game
    private static void exitGame() {
        JOptionPane.showMessageDialog(null, "Come Back Anytime!");
        System.exit(0);
    }
}