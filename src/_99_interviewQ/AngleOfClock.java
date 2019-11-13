/*
 * Objective: Find the Angle between hour hand and minute hand at a given time
 * Approach:
 * hour hand moves 360 in 12 hours => 30 degree/hour or 0.5 degree in min
 * minute hand moves 360 in 360 mins -> 6 degree/mins
 * So if given time is h hours and m mins, hour hand will move h*30+m*0.5
 * and minute hand will move 6*m
 */
package _99_interviewQ;

/**
 *
 * @author I300939
 */
public class AngleOfClock {
    public double angle(int hour, int minute) {
        if (hour < 0 || minute < 0 || minute > 59 || hour > 24) {
            return -1;
        }
        if (hour >= 12) {
            hour = hour - 12;
        }
        double hourAngle = hour * 30 + minute * 0.5;
        double minAngle = minute * 6;
        double diff = Math.abs(hourAngle - minAngle);
        return Math.min(360 - diff, diff);
    }
    
    public static void main(String[] args) {
        AngleOfClock me = new AngleOfClock();
        System.out.println(me.angle(12, 05));
        System.out.println(me.angle(3, 30));
        System.out.println(me.angle(2, 23));        
    }
}
