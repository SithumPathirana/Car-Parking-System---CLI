package lk.sithum.CarPark;

/**
 * Created by DELL on 8/20/2017.
 */
public class DateTime {

    // Two main attributes in DateTime class
    private double time;
    private String date;

    public DateTime(double time, String date) {
        this.setDate(date);
        this.setTime(time);
    }

    public double getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    // In 24h clock time cannot exceed 23.59 and it is greater than or equals to 0
    public void setTime(double time) {
        if(time>=0 && time<=23.59) {
            this.time = time;
        }else{
            throw new IllegalArgumentException("Invalid time input");
        }
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static  void convertTime(){

    }
}
