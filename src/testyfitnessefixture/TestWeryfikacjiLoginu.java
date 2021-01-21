package testyfitnessefixture;

import fit.ColumnFixture;

import java.util.IllegalFormatCodePointException;

public class TestWeryfikacjiLoginu extends ColumnFixture {
    private String dane;

    public boolean verifyLoginTest() throws IllegalFormatCodePointException {
        try{
            return SetUp.user.verifyUserName(getDane());
        }catch (Exception e){
            return false;
        }
    }


    public String getDane() {
        return dane;
    }

    public void setDane(String dane) {
        this.dane = dane;
    }
}
