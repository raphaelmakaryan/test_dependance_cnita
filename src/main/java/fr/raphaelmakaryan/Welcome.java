package fr.raphaelmakaryan;

public class Welcome {
    private IRealData realData;
    public int[] helloGoodAfternoon = {0, 1, 2, 3, 4};
    public int[] goodEvening = {0, 1, 2, 3};
    public int[] niceWeekend = {0, 4};
    public int[] hoursArrayNight = {19, 20, 21, 22, 23, 0, 1, 2, 3, 4, 5, 6, 7, 8};

    public Welcome() {
        this(new RealData());
    }

    public Welcome(IRealData realData) {
        this.realData = realData;
    }

    public boolean getDateArray(int[] date, int dateNow) {
        boolean response = false;
        for (int i = 0; i < date.length; i++) {
            if (date[i] == dateNow) {
                response = true;
                return response;
            }
        }
        return response;
    }

    public boolean hoursNight(int hours) {
        boolean response = false;
        for (int i = 0; i < hoursArrayNight.length; i++) {
            if (hoursArrayNight[i] == hours) {
                response = true;
                return response;
            }
        }
        return response;
    }

    public String getMessage() {
        int[] data = this.realData.getData();
        String value = "Les valeurs définis ne correspondent a aucun moment.";
        if (data[1] > 9 && data[1] <= 13 && getDateArray(this.helloGoodAfternoon, data[0])) {
            value = "Bonjour !";
        } else if (data[1] >= 13 && data[1] <= 18 && getDateArray(this.helloGoodAfternoon, data[0])) {
            value = "Bonne après-midi !";
        } else if (hoursNight(data[1]) && getDateArray(this.goodEvening, data[0])) {
            value = "Bonsoir !";
        } else if (getDateArray(this.niceWeekend, 4) && data[1] == 18 || data[1] == 9 && getDateArray(this.niceWeekend, 0)) {
            value = "Bon week-end !";
        }
        return value;
    }
}
