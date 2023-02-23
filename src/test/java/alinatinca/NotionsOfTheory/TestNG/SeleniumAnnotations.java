package alinatinca.NotionsOfTheory.TestNG;

import org.testng.annotations.*;

public class SeleniumAnnotations {
//Order

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }
    //1.ruleaza primul inainte de intreaga suita de teste
    //se ruleazaz in principiu din suita creata

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }
    //2.se ruleaza o singura data inainte de un test

    @BeforeGroups(groups = {"Grupul 1"})
    public void beforeGroups(){
        System.out.println("Before Groups");
    }
    //se ruleaza inaintea grupului 1, adica inainte de before method, deci inainte de test 1
    //se ruleazaz in principiu din grupul creat

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }
    //3.se ruleaza inainte de (intreaga clasa de) teste;
    //daca sunt rulate in acelasi timp 2 clase, atunci before class ruleaza o data pt prima clasa si inca o data pt a doua

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }
    //4.7. se ruleaza inainte de fiecare metoda de test

    @Test(groups = {"Grupul 1"})
    public void test1(){
        System.out.println("test1");
    }
    //5.se ruleaza prima data

    @Test
    public void test2(){
        System.out.println("test2");
    }
    //8.se ruleaza a doua oara

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }
    //5.9. se ruleaza de fiecare data dupa fiecare metoda de test

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
    //10. se ruleaza dupa (intreaga clasa de) teste

    @AfterGroups(groups = {"Grupul 1"})
    public void afterGroups(){
        System.out.println("After Groups");
    }
    //ruleaza dupa Grupul 1, adica dupa after method, deci dupa test 1

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
    //11.se ruleazaz o dingura data dupa un test

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }
    //12.se ruleazaz ultimul dupa intreaga suita de teste

}
