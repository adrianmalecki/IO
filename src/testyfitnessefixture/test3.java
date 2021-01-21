package testyfitnessefixture;

import java.util.IllegalFormatCodePointException;

public class test3 {
    private String dane1;// = {"99010112147","Jan","Nowak", "123456789", "asdf@o2.pl", "12-345", "Wrocław","ghtyhrtg","ABC123456","333","login1","password1"};

    public boolean verifyPasswordTest() throws IllegalFormatCodePointException {
        try{
            return SetUp.user.verifyPassword(getDane1().toCharArray());
        }catch (Exception e){
            return false;
        }
    }


    public String getDane1() {
        return dane1;
    }

    public void setDane1(String dane1) {
        this.dane1 = dane1;
    }
}
