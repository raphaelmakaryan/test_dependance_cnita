package fr.raphaelmakaryan;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RealData implements IRealData {
    public String[] days = {"lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi", "dimanche"};

    public int valueDay(String jour) {
        int index = 0;
        for (int i = index; i < days.length; i++) {
            if (days[i].equals(jour)) {
                return index;
            }
            index = index + 1;
        }
        return index;
    }

    @Override
    public int[] getData() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter day = DateTimeFormatter.ofPattern("EEEE");
        DateTimeFormatter hours = DateTimeFormatter.ofPattern("HH");
        int dateNow = valueDay(myDateObj.format(day));
        int hoursNow = Integer.parseInt(myDateObj.format(hours));
        return new int[]{dateNow, hoursNow};
    }
}