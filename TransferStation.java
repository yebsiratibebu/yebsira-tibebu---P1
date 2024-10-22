import java.util.ArrayList;
public class TransferStation extends Station {

    private ArrayList <Station> TransferStationPrev;
    private ArrayList <Station> TransferStationNext;
    public ArrayList <Station> otherStations;
    public TransferStation (String line, String name) {
        super(line,name);
        this.TransferStationPrev = new ArrayList<>();
        this.TransferStationNext = new ArrayList<>();
        this.otherStations = new ArrayList<>();
    }
    public String toString() {
        String prevname = (prev != null) ? prev.name : "none";
        String nextname = (next != null) ? next.name : "none";
        return "TRANSFERSTATION" + " " + name + ":" + " " + line + " " + "line, in service:" + " " + isAvailable() + "," + " " + "previous station:" + " " + prevname + "," + " " + "next station:" + " " + nextname + "\n\tTransfers: \n";
    
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
