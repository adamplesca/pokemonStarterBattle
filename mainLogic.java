public class mainLogic {
    
    //pokemon objects created
    bulbasaur b = new bulbasaur();
    charmander c = new charmander();
    squirtle s = new squirtle();

    //bulbasaur attacks
    int bulbTackle = b.tackle();
    int bulbVineWhip = b.vineWhip();

    //charmander attacks
    int charScratch = c.scratch();
    int charEmber = c.ember();

    //squirtle attacks
    int squrTackle = s.tackle();
    int squrWaterGun = s.waterGun();


    public void pokemonBattleTurn(){


    }

   /*  public int returnHP(){
        return b.hp;
    }

    public String returnType(){
        return b.type;
    }

    public int attackDamage(){
        return c.hp - damage;
    } */

}