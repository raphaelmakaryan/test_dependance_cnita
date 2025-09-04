package fr.raphaelmakaryan.exemples;

public class ClassA {

    private IClassB classB;

    public ClassA() {
        this(new ClassB());
    }

    public ClassA(IClassB classB) {
        this.classB = classB;
    }

    public String doSomething() {
        return this.classB.getData();
    }
}