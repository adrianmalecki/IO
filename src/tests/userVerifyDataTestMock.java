package tests;

import application.Facade;
import data.Client;
import data.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.runners.Parameterized.Parameter;
import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class userVerifyDataTestMock {
    DataForTests dataForTests;
    ArrayList<Client> clientList;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        dataForTests = new DataForTests();
        clientList = dataForTests.getPrepareClients();
    }

    @Parameter(0)
    public String login;
    @Parameter(1)
    public String password;
    @Parameter(2)
    public int expectedResult;

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {{ "blednyLogin" , "bledneHaslo", -1}, { "login2", "password2", -1}, { "login3", "password3", -1}};
        return Arrays.asList(data);
    }

    @Test
    public void verifyDataTest(){
        Facade facade = mock(Facade.class);
        Mockito.when(facade.getClientArrayList()).thenReturn(clientList);
        //when
        int result = User.checkLoginData(login, password);
        //then
        Assert.assertEquals(result, expectedResult);
    }
}
