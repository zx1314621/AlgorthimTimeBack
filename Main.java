import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = 3;
        String time = "2:10";
        int minute = 2333 ;

        System.out.println(calcute(n, time, minute));
    }

    private static String calcute(int day, String time, int minus) {
        String[] tim = time.split(":");
        int hour = Integer.valueOf(tim[0]);
        int minute = Integer.valueOf(tim[1]);

        int minus_day = minus / (24 * 60);
        minus_day &= 7;
        minus = minus % (24 * 60);
        int minus_hour = minus / (60);
        minus = minus % 60;
        int minus_minute = minus;

        if (day < minus_day) {
            day += (7 - minus_day);
        } else {
            day -= minus_day;
        }


        if (hour < minus_hour) {

            if (day == 1) day = 7;
            else day--;

            hour += (24 - minus_hour);
        } else hour -= minus_hour;


        if (minute < minus_minute) {
            if (hour == 0) {
                if (day == 1) day = 7;
                else day--;
                hour = 23;
            } else hour --;
            minute += (60 - minus_minute);
        } else {
            minute -= minus_minute;
        }


        return day + " " +hour + ":" + minute;
    }
}
