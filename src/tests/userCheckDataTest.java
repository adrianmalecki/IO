package tests;

import data.Client;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
@RunWith(Parameterized.class)
public class userCheckDataTest {

    @Parameterized.Parameter(0)
    public String firstName;
    @Parameterized.Parameter(1)
    public String lastName;
    @Parameterized.Parameter(2)
    public String phoneNumber;
    @Parameterized.Parameter(3)
    public String idNumber;
    @Parameterized.Parameter(4)
    public String drivingLicenseNumber;
    @Parameterized.Parameter(5)
    public boolean expectedResult;


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {{ "Tomasz" , "Kot", "123456789", "ABC123", "BBB123", true},
                                          { "Robert" , "Lewandowski", "123456789", "ABC123", "BBB123", true},
                                          { "Al" , "Pacino", "asdffg", "ABC123", "BBB123", false},
                                          { "Angelina" , "Jolie", "", "ABC123", "BBB123", false},
                                          { "Robert" , "Kot", "123456789", "", "BBB123", false},
                                          { "Natalie" , "Portman", "", "ABC123", "", false},
                                          { "" , "Kot", "123456789", "", "BBB123", false}};
        return Arrays.asList(data);
    }

    @Test
    public void checkDataTest(){
        //when
        boolean result = Client.checkData(firstName, lastName, phoneNumber, idNumber, drivingLicenseNumber);
        //then
        Assert.assertEquals(result, expectedResult);
    }
}
