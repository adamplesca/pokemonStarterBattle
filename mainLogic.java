public class mainLogic {
    
    bulbasaur p1 = new bulbasaur();
    charmander p2 = new charmander();
    squirtle p3 = new squirtle();

    //bulbasaur attacks
    int bulTackle = p1.tackle();
    int bulVineWhip = p1.vineWhip();

    
    String name = "asdi " + "dsaoind";
    

    public int returnHP(){
        return p1.hp;
    }

    public String returnType(){
        return p1.type;
    }

    public int attackDamage(){
        return p2.hp - damage;
    }

}
