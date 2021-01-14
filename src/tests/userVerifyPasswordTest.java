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
public class userVerifyPasswordTest {
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
    public char[] password;
    @Parameter(1)
    public boolean expectedResult;


    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {{ "password!1".toCharArray() , true}, { "JakiesHasło23".toCharArray(), true}, { "Krotkie".toCharArray(), false}};
        return Arrays.asList(data);
    }


    @Test
    public void verifyPasswordTest(){
        //when
        boolean result = Client.verifyPassword(password);
        //then
        Assert.assertEquals(result, expectedResult);
    }
}