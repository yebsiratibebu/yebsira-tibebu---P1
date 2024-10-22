import java.util.ArrayList;
public class TransferStation extends Station {

    private ArrayList <Station> TransferStationPrev;
    private ArrayList <Station> TransferStationNext;
    public ArrayList <Station> otherStations;
    public TransferStation (String line, String name) {
        super(line,name);
        this.TransferStationPrev = new ArrayList<>();
        this.TransferStationNext = new ArrayList<>();
    }
    public String toString() {
        String prevname = (prev != null) ? prev.name : "none";
        String nextname = (next != null) ? next.name : "none";
        return "ENDSTATION" + " " + name + ":" + " " + line + "line, in service:" + " " + isAvailable() + "," + " " + "previous station:" + " " + prev + "," + "next station:" + " " + next;
    
    }
    public void addTransferStationPrev (Station a) {
        TransferStationPrev.add(a);
    }
    public void addTransferStationNext (Station a) {
        TransferStationNext.add(a);
    }
    public void addotherStations (Station a) {
        otherStations.add(a);
    }

}
