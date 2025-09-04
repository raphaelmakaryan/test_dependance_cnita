package fr.raphaelmakaryan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

class WelcomeTest {
    @Test
    public void freeTest() {
        // Premiere paramètre (date) : lundi = 0 | mardi = 1 | mercredi = 2 | jeudi = 3 | vendredi = 4
        // Deuxième paramètre (heure) : 0 à 24
        FakeRealData fake = new FakeRealData(new int[]{2, 18});
        Welcome welcome = new Welcome(fake);
        // Bonjour ! / Bonne après-midi ! / Bonsoir ! / Bon week-end !
        Assertions.assertEquals("Bonne après-midi !", welcome.getMessage());
        System.out.println(welcome.getMessage());
    }

    @Test
    public void hello() {
        // Premiere paramètre (date) : lundi = 0 | mardi = 1 | mercredi = 2 | jeudi = 3 | vendredi = 4
        // Deuxième paramètre (heure) : 9 à 13
        int hours = 12;
        FakeRealData fake = new FakeRealData(new int[]{2, hours});
        Assumptions.assumeTrue(hours > 9 && hours <= 13, "L'heure que vous avez définis n'appartient pas a ce test → test ignoré.");
        Welcome welcome = new Welcome(fake);
        Assertions.assertEquals("Bonjour !", welcome.getMessage());
        System.out.println(welcome.getMessage());
    }

    @Test
    public void goodAfternoon() {
        // Premiere paramètre (date) : lundi = 0 | mardi = 1 | mercredi = 2 | jeudi = 3 | vendredi = 4
        // Deuxième paramètre (heure) : 13 à 18
        int hours = 15;
        FakeRealData fake = new FakeRealData(new int[]{2, hours});
        Assumptions.assumeTrue(hours >= 13 && hours <= 18, "L'heure que vous avez définis n'appartient pas a ce test → test ignoré.");
        Welcome welcome = new Welcome(fake);
        Assertions.assertEquals("Bonne après-midi !", welcome.getMessage());
        System.out.println(welcome.getMessage());
    }

    @Test
    public void goodNight() {
        // Premiere paramètre (date) : lundi = 0 | mardi = 1 | mercredi = 2 | jeudi = 3
        // Deuxième paramètre (heure) : 19 à 8
        int hours = 22;
        FakeRealData fake = new FakeRealData(new int[]{2, hours});
        Welcome welcome = new Welcome(fake);
        boolean response = welcome.hoursNight(hours);
        if (!response) {
            Assumptions.assumeTrue(false, "L'heure que vous avez définis n'appartient pas a ce test → test ignoré.");
        } else {
            Assertions.assertEquals("Bonsoir !", welcome.getMessage());
            System.out.println(welcome.getMessage());
        }
    }

    @Test
    public void goodWeekend() {
        // Premiere paramètre (date) : lundi = 0 | vendredi = 4
        // Deuxième paramètre (heure) : 9 | 18
        int hours = 9;
        int day = 0;
        if (hours == 9 && day == 0 || hours == 18 && day == 4) {
            FakeRealData fake = new FakeRealData(new int[]{2, hours});
            Welcome welcome = new Welcome(fake);
            Assertions.assertEquals("Bon week-end !", welcome.getMessage());
            System.out.println(welcome.getMessage());
        } else {
            Assumptions.assumeTrue(false, "Les valeurs que vous avez définis n'appartient pas a ce test → test ignoré.");
        }
    }
}