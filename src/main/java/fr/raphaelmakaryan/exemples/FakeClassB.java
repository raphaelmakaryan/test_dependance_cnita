package fr.raphaelmakaryan.exemples;

public class FakeClassB implements IClassB {
    private String dataToReturn;

    public FakeClassB(String dataToReturn) {
        this.dataToReturn = dataToReturn;
    }

    @Override
    public String getData() {
        return dataToReturn;
    }
}