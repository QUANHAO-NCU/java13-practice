package cn.edu.ncu.quanhao.Final;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        PetDog p = new PetDog("张三");
        System.out.println(p.name);
        PetDog[] petDogs = new PetDog[]{new PetDog("1")};

        Arrays.sort(petDogs);

    }
}
