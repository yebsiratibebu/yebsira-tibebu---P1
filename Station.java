import java.util.ArrayList;

public class Station { //a class that represents a metro station
    public String line;
    public String name;
    public boolean inService;
    public Station prev;
    public Station next;
   

    public Station (String line, String name) {
        this.line = line;
        this.name = name;
        this.inService = true;
        this.prev = null;
        this.next = null;
    }
    public String toString() {
        String prevname = (prev != null) ? prev.name : "none";
        String nextname = (next != null) ? next.name : "none";
        return "STATION" + " " + name + ":" + " " + line + " " + "line, in service:" + " " + isAvailable() + "," + " " + "previous station:" + " " + prevname + "," + " "+ "next station:" + " " + nextname;
    }
    public void addNext (Station next) {
        this.next = next;
        if (next.prev == null) {
        next.prev = this;
        }
    }
    public void addPrev (Station prev) {
        this.prev = prev;
        if (prev.next == null) {
        prev.next = this;
        }
    }
    public boolean isAvailable () {
        return this.inService;
    }
    public boolean switchAvailable () {
        return this.inService = !this.inService;
    }
    public void connect (Station a) {
        this.addNext(a);
        a.addPrev(this);
    }
    public String getline() {
        return line;
    }
   
    
   //base case: station and destionation
   //bases case is when is when you stop at your destination
   //create a helpre method
   //go to the beginning station and recursively call 
   //when youre at the transfer station you will have to recursively check all of the transfer paths

    public int tripLengthhelper (Station destination, int count, Station curr, ArrayList <Station> visitedStations) {
        if(curr.equals(destination)) {
            return count;
        }
        if(curr.next == null) {
            return -1;
        }
        if (visitedStations.contains(curr)) {
            return -1;
        }
        visitedStations.add(curr);
        if (curr instanceof TransferStation) {
            TransferStation transfer = (TransferStation) curr;
            for (int i=0; i < transfer.otherStations.size(); i++) {
                Station station = transfer.otherStations.get(i);
                if(station.getline().equals(destination.getline())) {
                    int result = tripLengthhelper (destination, count + 1, station, visitedStations);
                    if (result != -1) {
                        return result;
                    }
            }
            //String desline = destination.getline();
            
            }
            
        }
        System.out.println("curr station:" + curr + ", count:" + count);
        return tripLengthhelper(destination, count +1, curr.next, visitedStations); 
    }
    
    public int tripLength (Station destination) {
    int count = 0;
    Station curr = this;

    if (this.equals(destination)) {
        return count;
    }
    if (this.next == null) {
        return -1;
    }
    System.out.println("curr station:" + curr + ", count:" + count);
    ArrayList <Station> visitedStations = new ArrayList<>();
    return tripLengthhelper(destination,0, this, visitedStations);
}
public boolean equals (Station a) {
    if(this.line == a.line && this.name == a.name) {
        return true;
    }
    else {
        return false;
    }
}
}



