package bioseq;

import java.awt.*;

abstract class Sequence {
    String sequence = "";
    int length = 0;

    public String getSeq() {return this.sequence;}

    public void setSeq(String seq) {sequence = seq; this.length = sequence.length();}

    public int getLength() {return this.length;}
    public abstract Color getColor(int color);
}

