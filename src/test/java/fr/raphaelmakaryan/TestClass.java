package fr.raphaelmakaryan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

class TestClass {

    @Test
    void hello() {
        // 9 - 13
        int hours = 11;
        // lundi, mardi, mercredi, jeudi, vendredi
        String date = "mercredi";
        Assumptions.assumeTrue(hours > 9 && hours < 13, "L'heure que vous avez définis n'appartient pas a ce test → test ignoré.");
        Assumptions.assumeTrue(date.matches("[a-zA-Z]+"), "Chaîne contient des caractères non autorisés → test ignoré.");
        Assumptions.assumeTrue(true);
        new Welcome().getMessage(true, hours, date);
    }

    @Test
    void goodAfternoon() {
        // 13 - 18
        int hours = 14;
        // lundi, mardi, mercredi, jeudi, vendredi
        String date = "jeudi";
        Assumptions.assumeTrue(hours > 13 && hours < 18, "L'heure que vous avez définis n'appartient pas a ce test → test ignoré.");
        Assumptions.assumeTrue(date.matches("[a-zA-Z]+"), "Chaîne contient des caractères non autorisés → test ignoré.");
        Assumptions.assumeTrue(true);
        new Welcome().getMessage(true, hours, date);
    }

    @Test
    void goodNight() {
        Welcome welcome = new Welcome();
        // 18 - 9
        int hours = 20;
        // lundi, mardi, mercredi, jeudi
        String date = "jeudi";
        boolean response = welcome.hoursNight(true, hours);
        if (!response) {
            Assumptions.assumeTrue(false, "L'heure que vous avez définis n'appartient pas a ce test → test ignoré.");
        } else {
            Assumptions.assumeTrue(date.matches("[a-zA-Z]+"), "Chaîne contient des caractères non autorisés → test ignoré.");
            Assumptions.assumeTrue(true);
            welcome.getMessage(true, hours, date);
        }
    }

    @Test
    void goodWeekend() {
        // 9 et 18
        int hours = 9;
        // lundi et vendredi
        String date = "lundi";
        if (hours == 9 && date.equals("lundi") || hours == 18 && date.equals("vendredi")) {
            Assumptions.assumeTrue(date.matches("[a-zA-Z]+"), "Chaîne contient des caractères non autorisés → test ignoré.");
            new Welcome().getMessage(true, hours, date);
        } else {
            Assumptions.assumeTrue(false, "Les valeurs que vous avez définis n'appartient pas a ce test → test ignoré.");
        }
    }
}