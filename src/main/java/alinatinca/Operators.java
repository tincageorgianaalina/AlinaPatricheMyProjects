package alinatinca;

public class Operators {
    /*
    aritmetici: +, -, /, *, %
    de comparare: >, <, ==, !=, >=, <=
    logici: && and, || or

    Flow Control -if else = evalueaza conditii si bifurca codul in functie de rezultat
     */
    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        a = b; //suprascriere (a ia valoarea lui b, adica 5)
        System.out.println(a != b); // 5 diferit de 5?
        System.out.println(a == b);
        System.out.println(7>b && 8>b); //7>5 si 8>5 true and true->true
        System.out.println(10>b && 10<b); // true and false->false
        System.out.println(10>b || 5<b); //true or false-> true
        System.out.println(!(7>b));
    }
}