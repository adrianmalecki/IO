package tests;

import application.Facade;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class facadeRegisterClientTest {
    DataForTests dataForTests;
    Facade facade;

    @Before
    public void setClientList(){
        dataForTests = new DataForTests();
        facade = new Facade();
        facade.setClientList(dataForTests.getPrepareClients());
    }

    @Test
    public void registerClientTest(){
        //facade.registerNewClient("99999999999","Johnny","Depp", "432134567", "tewfwe@o2.pl", "14-258", "Warszawa","64wu4wht","BSF147852","555","login4","password4".toCharArray());

        Assert.assertEquals(facade.getClientArrayList().get(3).getFirstName(), "Johnny");
        Assert.assertEquals(facade.getClientArrayList().get(3).getLastName(), "Depp");
        Assert.assertEquals(facade.getClientArrayList().get(3).getPESEL(), "99999999999");
        Assert.assertEquals(facade.getClientArrayList().get(3).getLogin(), "login4");
    }
}
