package alinatinca;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
            /*
    Map : reprezentare de date in sistem cheie valoare
    nu este ordonat
    Exemplu: Ana are nota 10, John are nota 9
     */
        //declaration and initialisation an map
        Map<String, Integer> months = new HashMap<String, Integer>()
        {{
            put("Jan", 1);
            put("Feb", 2);
            put("Mar", 3);
        }};
        System.out.println(months.size());
        System.out.println(months);
        //declaration a map
        Map<String,Integer> grade_students = new HashMap<>();
        //add elements
        grade_students.put("Ana", 10);
        grade_students.put("John", 9);
        grade_students.put("Don", 10);
        System.out.println(grade_students);
        //get elements
        System.out.println("Ana has the grade: " + grade_students.get("Ana"));
        //update elements
        grade_students.replace("John", 10);
        System.out.println("John has the new grade: " + grade_students.get("John"));
        //size
        System.out.println(grade_students.size());
        //remove elements
        grade_students.remove("Ana");
        System.out.println(grade_students.size());
        System.out.println(grade_students);



    }
}