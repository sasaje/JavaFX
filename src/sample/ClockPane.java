package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ClockPane extends Pane {

    private int hour;
    private int minute;
    private int second;

    // Construct a default clock with the current time
    public ClockPane(){
        setCurrentTime();
    }

    // Construct a default clock with the specified hour, minute, second
    public ClockPane(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    // Return hour
    public int getHour(){
        return hour;
    }

    // Set a new hour
    public void setHour(int hour){
        this.hour = hour;
        paintClock();
    }

    // Return minute
    public int getMinute(){
        return minute;
    }

    // Set a new minute
    public void setMinute(int minute){
        this.minute = minute;
        paintClock();
    }

    // Return second
    public int getSecond(){
        return second;
    }

    // Set a new second
    public void setSecond(int second){
        this.second = second;
        paintClock();
    }

    //Set the current time for the clock
    public void setCurrentTime(){
        // construct a calendar for the current date and time
        Calendar calendar = new GregorianCalendar();

        //Set hour, minute and second
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);

        paintClock(); // Repaint the clock
    }

    //Paint the clock
    private void paintClock(){
        //Initialize clock parameters
        double clockRadius = Math.min(getWidth(), getHeight())*0.8*0.5;
        double centerX = getWidth()/2;
        double centerY = getHeight()/2;


        //draw the circle
        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        Text t1 = new Text(centerX-5, centerY-clockRadius+12, "12");
        Text t2 = new Text(centerX-clockRadius+3, centerY+5, "9");
        Text t3 = new Text(centerX+clockRadius-10, centerY+3+12, "6");
        Text t4 = new Text(centerX-3, centerY+clockRadius-3, "3");

        //draw second hand
        double sLength = clockRadius * 0.8;
        double secondX = centerX+sLength* Math.sin(second*(2*Math.PI/60));
        double secondY = centerY+sLength* Math.cos(second*(2*Math.PI/60));
        Line sLine = new Line(centerX,centerY,secondX,secondY);
        sLine.setStroke(Color.RED);

        //draw minute hand
        double mLength = clockRadius * 0.65;
        double minuteX = centerX+mLength* Math.sin(minute*(2*Math.PI/60));
        double minuteY = centerY+mLength* Math.cos(minute*(2*Math.PI/60));
        Line mLine = new Line(centerX,centerY,minuteX,minuteY);
        mLine.setStroke(Color.BLUE);
        mLine.setStrokeWidth(2);

        //draw hour hand
        double hLength = clockRadius * 0.5;
        double hourX = centerX+hLength* Math.sin(hour*(2*Math.PI/60));
        double hourY = centerY+hLength* Math.cos(hour*(2*Math.PI/60));
        Line hLine = new Line(centerX,centerY,hourX,hourY);
        hLine.setStroke(Color.GREEN);
        hLine.setStrokeWidth(2);

        getChildren().clear();
        getChildren().addAll(circle, t1,t2,t3,t4, sLine,mLine,hLine);
    }

    @Override
    public void setWidth(double width){
        super.setWidth(width);
        paintClock();
    }
    @Override
    public void setHeight(double height){
        super.setHeight(height);
        paintClock();
    }
}