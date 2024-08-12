public class mainLogic {
    
    //rival object
    enemyTrainer rival = new enemyTrainer();

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

    //pokemon hp value
    int bulbHP = b.hp;
    int charHP = c.hp;
    int squrHP = s.hp;  


    public void pokemonBattleTurn(){}


    
    /* public int returnhp(){
        return bulbHP - charEmber;
    } */

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