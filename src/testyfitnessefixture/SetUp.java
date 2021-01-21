package testyfitnessefixture;

import application.Facade;
import application.SignInPanel;
import data.Client;
import data.User;
import fit.Fixture;

public class SetUp extends Fixture {
    static Facade application;
    static User user;
    static Client client;
    static SignInPanel signInPanel;

    public SetUp() {
        application = new Facade();
        user = new User();
        client = new Client();
        signInPanel = new SignInPanel();
    }
}
