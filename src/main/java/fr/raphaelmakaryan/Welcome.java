package fr.raphaelmakaryan;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Welcome {
    public String dateNow;
    public int hoursNow;
    public String[] helloGoodAfternoon = {"lundi", "mardi", "mercredi", "jeudi", "vendredi"};
    public String[] goodEvening = {"lundi", "mardi", "mercredi", "jeudi"};
    public String[] niceWeekend = {"lundi", "vendredi"};
    public int[] hoursArrayNight = {19, 20, 21, 22, 23, 0, 1, 2, 3, 4, 5, 6, 7, 8};

    public void getDateData() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter day = DateTimeFormatter.ofPattern("EEEE");
        DateTimeFormatter hours = DateTimeFormatter.ofPattern("HH");
        this.dateNow = myDateObj.format(day);
        this.hoursNow = Integer.parseInt(myDateObj.format(hours));
    }

    public boolean getDateArray(String[] date, String dateNow) {
        boolean response = false;
        for (int i = 0; i < date.length; i++) {
            if (date[i].equals(dateNow)) {
                response = true;
                return response;
            }
        }
        return response;
    }

    public boolean hoursNight(boolean test, int hoursTest) {
        boolean response = false;
        if (!test && hoursTest == 0) {
            for (int i = 0; i < hoursArrayNight.length; i++) {
                if (hoursArrayNight[i] == this.hoursNow) {
                    response = true;
                    return response;
                }
            }
        } else {
            for (int i = 0; i < hoursArrayNight.length; i++) {
                if (hoursArrayNight[i] == hoursTest) {
                    response = true;
                    return response;
                }
            }
        }
        return response;
    }

    public void getMessage(boolean test, int hoursTest, String dateTest) {
        if (!test && hoursTest == 0 && dateTest == null) {
            getDateData();
        } else {
            this.dateNow = dateTest;
            this.hoursNow = hoursTest;
        }
        if (this.hoursNow > 9 && this.hoursNow < 13 && getDateArray(this.helloGoodAfternoon, this.dateNow)) {
            System.out.println("Bonjour ! ");
        } else if (this.hoursNow > 13 && this.hoursNow < 18 && getDateArray(this.helloGoodAfternoon, this.dateNow)) {
            System.out.println("Bonne après-midi !");
        } else if (hoursNight(false, 0) && getDateArray(this.goodEvening, this.dateNow)) {
            System.out.println("Bonsoir !");
        } else if (getDateArray(this.niceWeekend, "vendredi") && this.hoursNow == 18 || this.hoursNow == 9 && getDateArray(this.niceWeekend, "lundi")) {
            System.out.println("Bon week-end !");
        } else {
            System.out.println("Une erreur est survenue.");
        }
    }
}
