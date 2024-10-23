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
        //loop through other methods
        String transfer = "TRANSFERSTATION" + " " + name + ":" + " " + line + " " + "line, in service:" + " " + this.inService + "," + " " + "previous station:" + " " + prevname + "," + " " + "next station:" + " " + nextname + "\n\tTransfers: \n";

        for (int i =0; i < otherStations.size(); i++) {
            transfer += "\t" + otherStations.get(i).toString() + "\n";
        }
        return transfer;
    }
    public void addTransferStationPrev (Station a) {
        TransferStationPrev.add(a);
        this.otherStations.add(a);
    }
    public void addTransferStationNext (Station a) {
        TransferStationNext.add(a);
        this.otherStations.add(a);
    }
    public void addotherStations (Station a) {
        otherStations.add(a);
    }

}
