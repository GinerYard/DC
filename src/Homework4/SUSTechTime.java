package Homework4;

public class SUSTechTime {

    private Weekday.weekday weekday;
    private String startTime;
    private String endTime;
    private WeekType.weekType weekType;


    SUSTechTime(String startTime, String endTime, Weekday.weekday weekday, WeekType.weekType weekType){
        this.startTime = startTime;
        this.endTime = endTime;
        this.weekday = weekday;
        this.weekType = weekType;
    }
    public String getStartTime(){return startTime;}
    public String getEndTime(){return endTime;}
    public Weekday.weekday getWeekday(){return weekday;}
    public WeekType.weekType getWeekType(){return weekType;}


    public String toString(){
        return "SUSTechTime{"+this.getStartTime()+" ~ "+this.getEndTime()+" | "+this.getWeekday()+" | "+this.getWeekType()+" week}";
    }

}
