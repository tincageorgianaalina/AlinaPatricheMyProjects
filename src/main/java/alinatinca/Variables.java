package alinatinca;

public class Variables {
    public static void main(String[] args) {
        //declaration and initialization:
        String brandCar = "Volvo";
        String modelCar = "XC 60";

        //! strongly type (explicitly mode)- they are not recognized at runtime
        System.out.println("I bought a car, brand: " + brandCar);
        System.out.println("It is model: " + modelCar);

        //overwrite:
        System.out.println("After overwrite it will be: ");
        brandCar = "XC 60 facelift";
        System.out.println("It is model: " + brandCar);
        System.out.println("It is model: " + modelCar);

        //declaration:
        String name;
        String firstname;
        int age;
        //initialization:
        name = "Patriche";
        firstname = "Alina";
        age = 29;
        //concatenation:
        System.out.println("My name is: " + name + " " + firstname + " and I am: " + age + " years old");
        //automatically transform variables at runtime
    }
}