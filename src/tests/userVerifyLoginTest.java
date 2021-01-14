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
public class userVerifyLoginTest {
    DataForTests dataForTests;
    Facade facade;

    @Before
    public void setClientList() {
        dataForTests = new DataForTests();
        facade = new Facade();
        facade.setClientList(dataForTests.getPrepareClients());
        System.out.println(dataForTests.getPrepareClients());
    }

    @Parameterized.Parameter(0)
    public String login;
    @Parameterized.Parameter(1)
    public boolean expectedResult;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{"login3", false}, {"login4", true}, {"login5", true}};
        return Arrays.asList(data);
    }

    @Test
    public void verifyLoginTest() {
        //when
        boolean result = Client.verifyUserName(login);
        //then
        Assert.assertEquals(result, expectedResult);
    }
}
