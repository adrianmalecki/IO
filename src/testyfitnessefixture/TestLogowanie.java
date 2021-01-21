package testyfitnessefixture;

import java.util.IllegalFormatCodePointException;

public class TestLogowanie {
    private String[] dane;

    public int checkDataTest() throws IllegalFormatCodePointException {
        try{
            return SetUp.user.checkLoginData(getDane()[0], getDane()[1]);
        }catch (Exception e){
            return -2;
        }
    }


    public String[] getDane() {
        return dane;
    }

    public void setDane(String[] dane) {
        this.dane = dane;
    }
}
