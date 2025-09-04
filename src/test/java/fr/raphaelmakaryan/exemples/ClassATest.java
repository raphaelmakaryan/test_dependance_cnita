package fr.raphaelmakaryan.exemples;

import fr.raphaelmakaryan.exemples.ClassA;
import fr.raphaelmakaryan.exemples.FakeClassB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClassATest {
    @Test
    public void doSomethingTest() {
        // Appel la class b ave des données factices
        FakeClassB fake = new FakeClassB("Mes data");
        // Injecte la fausse class b dans la class a
        ClassA target = new ClassA(fake);
        // Vérifie que la méthode doSomething retourne les données factices
        Assertions.assertEquals("Mes data", target.doSomething());
    }
}