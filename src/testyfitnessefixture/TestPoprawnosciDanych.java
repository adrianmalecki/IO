package testyfitnessefixture;

import fit.ColumnFixture;

import java.util.IllegalFormatCodePointException;

public class TestPoprawnosciDanych extends ColumnFixture {
    private String[] dane;

    public boolean checkDataTest() throws IllegalFormatCodePointException {
        try{
            return SetUp.client.checkData(getDane()[0], getDane()[1],getDane()[2],getDane()[3],getDane()[4]);
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
