public class EndStation extends Station { //inherits end station
    public EndStation (String line, String name) {
        super(line, name);
    }
   
    public void makeEnd() {
        if (this.next != null) {
            this.prev = this.next;
        }
        if (this.prev != null) {
            this.next = this.prev;
        }
    }
    public String toString() {
        String prevname = (prev != null) ? prev.name : "none";
        String nextname = (next != null) ? next.name : "none";
        return "ENDSTATION" + " " + name + ":" + " " + line + " " + "line, in service:" + " " + isAvailable() + "," + " " + "previous station:" + " " + prevname + "," + " "+ "next station:" + " " + nextname;
    
    }
}
