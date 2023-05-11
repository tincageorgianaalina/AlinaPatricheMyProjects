package alinatinca;

public class Array {
    public static void main(String[] args) {
        /* Array:
        - contine mai multe elemente de acelasi tip
        - accesam elementele prin index, care incepe mereu de la 0
        - are o dimensiune fixa
        - are proprietatea length care ne da proprietatea array-ului
         */
         //declaration and alocate memory
        int[] grade = new int[5]; // 0, 0, 0, 0, 0
        System.out.println(grade[1]);
        grade[0] = 10; //declaration values
        grade[1] = 9;
        // declaration and initialisation
        String[] students = {"Ana", "John", "Maria", "Ella", "Ada"};
        int[] numbers ={1, 33, 81, 99, 201};
        System.out.println(students[0]); //Ana
        students[0] = "Sebi"; //suprascriere
        System.out.println(students[0]); //aflam primul element din array
        System.out.println(students.length); //aflam lungimea array
        System.out.println(students[0]+ " " +students[1]);
        System.out.println(students.length + 5);
        System.out.println(students.length-1); //aflam indexul ultimului element
        System.out.println("Last place: " + students[students.length-1]); //aflam ultimul element din array
    }
}