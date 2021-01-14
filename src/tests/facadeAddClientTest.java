package tests;

import application.Facade;
import data.Client;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

public class facadeAddClientTest{

    DataForTests dataForTests;
    Client newClient;
    ArrayList<Client> clientList;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        dataForTests = new DataForTests();
        newClient = new Client("99999999999","Johnny","Depp", "432134567", "tewfwe@o2.pl", "14-258", "Warszawa","64wu4wht","BSF147852","555","login4","password4");
        clientList = dataForTests.getPrepareClients();

    }

    @Test
    public void addClientTest(){
        Facade facade = mock(Facade.class);

        Mockito.when(facade.getClientArrayList()).thenReturn(clientList);
        clientList.add(newClient);

        Assert.assertEquals(facade.getClientArrayList().get(3), newClient);
    }
}
