package testyfitnessefixture;

import fit.ColumnFixture;

import java.util.IllegalFormatCodePointException;

public class TestRejestracjaKlienta extends ColumnFixture {
    private String[] dane;

    public boolean registerClientTest() throws IllegalFormatCodePointException {
        try{
            SetUp.application.registerNewClient(getDane()[0], getDane()[1], getDane()[2], getDane()[3], getDane()[4], getDane()[5], getDane()[6], getDane()[7], getDane()[8], getDane()[9], getDane()[10], getDane()[11].toCharArray());
            return true;

        }catch (Exception e){
            return false;
        }
    }


    public String[] getDane() {
        return dane;
    }

    public void setDane(String[] dane) {
        this.dane = dane;
    }
}
