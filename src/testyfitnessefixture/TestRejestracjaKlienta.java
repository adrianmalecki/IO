package testyfitnessefixture;

import fit.ColumnFixture;

public class TestRejestracjaKlienta extends ColumnFixture {

    public boolean registerClient(){
        String dane[] = new String[0];
        //String PESEL, firstName = "", lastName ="", phoneNumber ="", email ="", postCode ="", city ="", address ="", identityCardNumber ="", drivingLicenseNumber ="", login ="", password ="";
        try{
            SetUp.application.registerNewClient(dane[0],
                    dane[1],
                    dane[2],
                    dane[3],
                    dane[4],
                    dane[5],
                    dane[6],
                    dane[7],
                    dane[8],
                    dane[9],
                    dane[10],
                    dane[11]);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}


