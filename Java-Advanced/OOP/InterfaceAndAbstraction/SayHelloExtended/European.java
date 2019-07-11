package OOP.InterfaceAndAbstraction.SayHelloExtended;

public class European extends BasePerson {


    European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
