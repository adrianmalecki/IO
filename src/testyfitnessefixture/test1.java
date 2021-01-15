package testyfitnessefixture;

import fit.ColumnFixture;

import java.util.IllegalFormatCodePointException;

public class test1 extends ColumnFixture {
    private String[] dane1;// = {"99010112147","Jan","Nowak", "123456789", "asdf@o2.pl", "12-345", "Wrocław","ghtyhrtg","ABC123456","333","login1","password1"};

    public boolean registerClientTest() throws IllegalFormatCodePointException {
        try{
            SetUp.application.registerNewClient(getDane1()[0], getDane1()[1], getDane1()[2], getDane1()[3], getDane1()[4], getDane1()[5], getDane1()[6], getDane1()[7], getDane1()[8], getDane1()[9], getDane1()[10], getDane1()[11].toCharArray());

            return true;

        }catch (Exception e){
            return false;
        }
    }


    public String[] getDane1() {
        return dane1;
    }

    public void setDane1(String[] dane1) {
        this.dane1 = dane1;
    }
}
