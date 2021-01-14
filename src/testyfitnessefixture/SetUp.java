package testyfitnessefixture;

import fit.Fixture;
import application.Facade;

public class SetUp extends Fixture {
    static Facade application;

    public SetUp() {
        application = new Facade();
    }
}
