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
public class userVerifyPESELTest {
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
    public String PESEL;
    @Parameterized.Parameter(1)
    public boolean expectedResult;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{"99010112147", true}, {"77122587963", true}, {"22122587963", false}};
        return Arrays.asList(data);
    }

    @Test
    public void verifyPESELTest() {
        //when
        boolean result = Client.checkPESEL(PESEL);
        //then
        Assert.assertEquals(result, expectedResult);
    }
}
