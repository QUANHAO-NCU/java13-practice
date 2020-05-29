package cn.edu.ncu.quanhao.Final;

class PetDog implements Movable{
    public     String name;
    public void move(){

        System.out.println("PetDog is moving");

    }
    PetDog(){
        System.out.println("PetDog");
    };
    PetDog(String name){
        this();
        this.name = name;
    }

}
