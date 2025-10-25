import java.util.ArrayList;
import java.util.List;

public class BookingSystem {

    private List<Taxi> taxis;
    int bookingId = 1;

    BookingSystem(int taxicount){
        taxis = new ArrayList<>();
        for(int i=0; i<taxicount; i++){
            taxis.add(new Taxi(i));
        }
    }

    private int calculateCharge(char pickUp, char drop){
        int distance = Math.abs(pickUp-drop);
        int charges = 100;
        distance -= 5;
        charges += distance*10;
        return charges;
    }

    Taxi findTaxi(char pickUp, int pickUpTime){
        List<Taxi> freeTaxis = new ArrayList<>();
        for(Taxi t: taxis){
            if(t.isFree(pickUp, pickUpTime)){
                freeTaxis.add(t);
            }
        }
        if(freeTaxis.isEmpty()){
            return null;
        }
        int minDistance  = Integer.MAX_VALUE;
        for(Taxi t: freeTaxis){
            int Distance  = Math.abs(pickUp-t.getCurrentSpot());
            if(Distance<minDistance){
                minDistance=Distance;
            }
        }

        List<Taxi> closest = new ArrayList<>();
        for(Taxi t: freeTaxis){
            int Distance  = Math.abs(pickUp - t.getCurrentSpot());
            if(Distance==minDistance){
                closest.add(t);
            }
        }

        Taxi selected  = closest.get(0);
        for(Taxi t: closest){
            if(t.getEarnings()<selected.getEarnings()){
                selected=t;
            }
        }
        return selected;
    }

    void bookTaxi(Customer c){
        Taxi selected = findTaxi(c.getPickUp(), c.getPickTime());

        if(selected == null){
            System.out.println("No Taxi is Available");
            return ;}

        int traveltime = Math.abs(c.getPickUp()-c.getDrop());
        int dropTime = c.getPickTime() + traveltime;
        int charges = calculateCharge(c.getPickUp(), c.getDrop());

        Booking booking = new Booking (bookingId, dropTime, charges, c);
        bookingId++;

        selected.assignBookings(booking);
        selected.setFreeTime(dropTime);
        selected.setEarnings(selected.getEarnings());
        selected.setCurrentSpot(c.getDrop());

        System.out.println("Taxi-"+selected.getTaxiId()+" is allocated");

}

    void displayTaxi(){
        System.out.println();
        System.out.println();
        for(Taxi t: taxis){
            System.out.println("Taxi-"+t.getTaxiId()+ " Earnings: "+t.getEarnings());
            System.out.println("Booking Id	Customer Id	From	To	Pickup Time	Drop Time	Charges");
            for(Booking b: t.getBookings()){
                System.out.println(b.getBookingId()+"		"+b.getCustomerId()
                        +"		"+b.getPickUpPoint()+"		"+b.getDropPoint()
                        +"		"+b.getPickUpTime()+"		"+b.getDropTime()+"		"
                        +b.getAmount());
            }
            System.out.println();
        }
    }
}
