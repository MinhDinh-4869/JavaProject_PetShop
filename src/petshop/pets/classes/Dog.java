package petshop.pets.classes;
public class Dog extends PetsAb {
    public Dog(){
        this.location = "./dat/dog/";
        this.ID = generateDogId();
    }
    private String generateDogId()
    {
        return "D" + generate_ID();
    }
}
