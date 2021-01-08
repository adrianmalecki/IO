package tests;

import application.Facade;
import data.Client;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.runners.Parameterized.Parameter;

@RunWith(Parameterized.class)
public class facadeTests {
    DataForTests dataForTests;
    Facade facade;

    @Before
    public void setClientList(){
        dataForTests = new DataForTests();
        facade = new Facade();
        facade.setClientList(dataForTests.getPrepareClients());
        System.out.println(dataForTests.getPrepareClients());
    }

    @Parameter(0)
    public String login;
    @Parameter(1)
    public String password;
    @Parameter(2)
    public int expectedResult;


    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {{ "blednyLogin" , "bledneHaslo", -1}, { "login2", "password2", 1}, { "login3", "password3", 2}};
        return Arrays.asList(data);
    }


    @Test
    public void verifyDataTest(){
        //given
        //when
        int result = Client.checkLoginData(login, password);
        //then
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void verifyPESELTest(){
        //given
        String PESEl = "99010112147";
        //when
        boolean result = Client.checkPESEL(PESEl);
        //then
        Assert.assertTrue(result);
    }
}