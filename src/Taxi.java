import java.util.ArrayList;
import java.util.List;

public class Taxi {

    private int taxiId;
    private char currentSpot;
    private int freeTime;
    private int earnings;
    private List<Booking> bookings;

    Taxi(int id){
        this.taxiId = id;
        this.currentSpot = 'A';
        this.freeTime = 0;
        this.earnings = 0;
        bookings = new ArrayList<>();
    }

    public boolean isFree(char pickUp, int pickUpTime ){
        int travelTime = Math.abs(pickUp - currentSpot);
        if(freeTime+travelTime<pickUpTime){
            return true;
        }
        return false;
    }

    public int getTaxiId(){
        return taxiId;
    }
    public char getCurrentSpot(){
        return currentSpot;
    }
    public int getFreeTime(){
        return freeTime;
    }
    public int getEarnings(){
        return earnings;
    }
    public List<Booking> getBookings(){
        return bookings;
    }
    public void setFreeTime(int freeTime){
        this.freeTime = freeTime;
    }
    public void setEarnings(int earnings){
        this.earnings = earnings;
    }
    public void setCurrentSpot(char s){
        this.currentSpot = s;
    }
    public void assignBookings(Booking b){ bookings.add(b); }
}
