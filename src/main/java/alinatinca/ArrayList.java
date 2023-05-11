package alinatinca;

import java.util.Arrays;
import java.util.List;

public class ArrayList {
    public static void main(String[] args) {
        /*
        Arraylist:
        = structuri de date ordonate
        - au o dimensiune dinamica
        - putem sa aflam indexul unui element din lista
         */
        //declaration an empty list
        List<String> fruits = new java.util.ArrayList<>();
        //how to add elements
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("orange");
        //how to get elements
        System.out.println(fruits.get(1)); //banana
        //how to know an index of element
        System.out.println(fruits.indexOf("banana"));
        //how to know if the list is empty
        System.out.println(fruits.isEmpty()); //false
        //Exercise
        if (!fruits.isEmpty()){  //if the list is not empty
            System.out.println("Go shopping!");
        }else {
            System.out.println("Eat!");
        }
        //how to delete list
//        fruits.clear();
        //how to remove an element
        System.out.println(fruits.remove("apple"));
        //hot to list all the element from Arraylist
        System.out.println(Arrays.toString(fruits.toArray()));
        System.out.println(fruits.size());
        //declaration and initialisation
        List<String> listString =Arrays.asList(new String[]{"watermelon", "pums"});
        System.out.println(listString);
        List<Integer> listInt = Arrays.asList(new Integer[]{1,2,3});
        System.out.println(Arrays.toString(listInt.toArray())); // or sout (listInt)
        //dinamic list
        String[] flowers = {"Ageratum", "Allium", "Poppy"}; //plecam de la un array
        List<String> flowerList = new java.util.ArrayList<>(Arrays.asList(flowers)); //il folosim pt a putea adauga ulterior in lista noastra valori
        flowerList.add("Rose");
        System.out.println(Arrays.toString(flowerList.toArray()));
        System.out.println(flowers); //array nu se pot printa la consola
        System.out.println(flowerList); //arraylist se pot printa la consola

    }
}