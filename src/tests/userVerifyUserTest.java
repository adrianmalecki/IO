package tests;

import application.Facade;
import data.Client;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class userVerifyUserTest {
    DataForTests dataForTests;
    Facade facade;

    @Before
    public void setClientList(){
        dataForTests = new DataForTests();
        facade = new Facade();
        facade.setClientList(dataForTests.getPrepareClients());
    }
    @Parameterized.Parameter(0)
    public String login;
    @Parameterized.Parameter(1)
    public String password;
    @Parameterized.Parameter(2)
    public int expectedResult;


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {{ "blednyLogin" , "bledneHaslo", -1}, { "login2", "password2", 1}, { "login3", "password3", 2}};
        return Arrays.asList(data);
    }


    @Test
    public void verifyUserTest(){
        //when
        int result = Client.checkLoginData(login, password);
        //then
        Assert.assertEquals(result, expectedResult);
    }
}
