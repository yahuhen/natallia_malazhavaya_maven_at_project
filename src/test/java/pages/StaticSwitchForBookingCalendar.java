package pages;

public class StaticSwitchForBookingCalendar {
    public static String switchForBookingCalendar(String mounth) {
        if (mounth.equals("Январь")) {
            mounth = "Февраль";
            return mounth;
        }
        if (mounth.equals("Февраль")) {
            mounth = "Март";
            return mounth;
        }
        if (mounth.equals("Март")) {
            mounth = "Апрель";
            return mounth;
        }
        if (mounth.equals("Апрель")) {
            mounth = "Май";
            return mounth;
        }
        if (mounth.equals("Май")) {
            mounth = "Июнь";
            return mounth;
        }
        if (mounth.equals("Июнь")) {
            mounth = "Июль";
            return mounth;
        }
        if (mounth.equals("Июль")) {
            mounth = "Август";
            return mounth;
        }
        if (mounth.equals("Август")) {
            mounth = "Сентябрь";
            return mounth;
        }
        if (mounth.equals("Сентябрь")) {
            mounth = "Октябрь";
            return mounth;
        }
        if (mounth.equals("Октябрь")) {
            mounth = "Ноябрь";
            return mounth;
        }
        if (mounth.equals("Ноябрь")) {
            mounth = "Декабрь";
            return mounth;
        }
        if (mounth.equals("Декабрь")) {
            mounth = "Январь";
            return mounth;
        }

            else return null;
    }
}
