import javax.swing.JOptionPane;

public class pokemonBattleApp{
    public static void main(String [] args){
        

        mainLogic ML = new mainLogic();

      /*   System.out.println(ML.returnHP());
        System.out.println(ML.returnType()); */

        String[] starterPokemon = {"Bulbasaur", "Charmander", "Squirtle"};
        
        int choice = JOptionPane.showOptionDialog(
            null,                        
            "Pick your starter",           
            "Choose your starter Pokémon",           
            JOptionPane.DEFAULT_OPTION,      
            JOptionPane.INFORMATION_MESSAGE, 
            null,                         
            starterPokemon,                         
            starterPokemon[0]                   
        );

        enemyTrainer rival = new enemyTrainer();
        rival.outcome(starterPokemon[choice]);

        
        /* bulbasaur b = new bulbasaur();

        for(String move : b.moveChoice()){
            System.out.println(move);
        } */


    }
}

