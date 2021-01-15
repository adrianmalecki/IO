package tests;

import data.Client;

import java.util.ArrayList;

public class DataForTests {
    public ArrayList<Client> prepareClients = new ArrayList<Client>();
    Client client1 = new Client("99010112147","Jan","Nowak", "123456789", "asdf@o2.pl", "12-345", "Wrocław","ghtyhrtg","ABC123456","333","login1","password1");
    Client client2 = new Client("77122587963","John","Nowak", "123456789", "asdf@o2.pl", "98-765", "Łódź","w54hw54h","CBA456789","444","login2","password2");
    Client client3 = new Client("88071945789","Tomasz","Kot", "432134567", "tdh@o2.pl", "14-258", "Warszawa","64wu4wht","BSF147852","555","login3","password3");

    public ArrayList<Client> getPrepareClients() {
        prepareClients.add(client1);
        prepareClients.add(client2);
        prepareClients.add(client3);
        return prepareClients;
    }
}


