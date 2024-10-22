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
        return "STATION" + " " + name + ":" + " " + line + "line, in service:" + " " + inService + "," + " " + "previous station:" + " " + prev + "," + "next station:" + " " + next;
    }
    public void addNext (Station next) {
        this.next = next;
        next.prev = this;
    }
    public void addPrev (Station prev) {
        this.prev = prev;
        prev.prev = this;
    }
    public boolean isAvailable () {
        return this.inService;
    }
    public boolean switchAvailable () {
        return !this.inService;
    }
    public void connect (Station a) {
        this.addNext(a);
    }
    public Station getNext() {
        return this.next;
    }
  
    public int tripLength (Station a) {
       if (a == null || !this.isAvailable() || !a.isAvailable()) {
       return -1;
    }
    if (this == a) {
        return 0;
    }
    if (this.next != null) {
        int len = this.next.tripLength(a);
    
    if (len != -1) {
        return 1 + len;
    }
    }
    return -1;
}
}


