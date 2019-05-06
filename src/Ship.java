public class Ship {
    private Coordinate start;
    private Coordinate end;
    private Coordinate[] partsTouched; //coordinate di dove colpisci
    private int numTouch; //numero di volte che hai colpito

    public Ship(Coordinate start,int footage,boolean isVertical) {
        this.start=start;

        if(isVertical) {
            end=new Coordinate(this.start.getRows()+footage-1,this.start.getColumns());
        }else{
            end=new Coordinate(this.start.getRows(),this.start.getColumns()+footage-1);
        }

        partsTouched=new Coordinate[footage];
        numTouch=0;
    }

    public Coordinate getStart() {
        return start;
    }

    public Coordinate getEnd() {
        return end;
    }

    /*metodo contiene che ritorna vero se la coordinata passata
    * in parametro contiene la nave*/
    public boolean contain(Coordinate c){
        return c.getColumns() >= start.getColumns()
                && c.getColumns() <= end.getColumns()
                && c.getRows() >= start.getRows()
                && c.getRows() <= end.getRows();
    }

    /*metodo per controllare se una nave è sovrapposta
    ,anche solo in parte,da un'altra nave*/
    public boolean isOverlap(Ship n) {
        if(this.start.getRows()==this.end.getRows()){
            return n.start.getColumns() >= this.start.getColumns()
                    && n.start.getColumns() <= this.end.getColumns()
                    && this.start.getRows() >= n.start.getColumns();
        }else{
            return n.start.getRows() >= this.start.getRows()
                    && n.start.getRows() <= this.end.getRows()
                    && this.start.getColumns() >= n.start.getColumns()
                    && this.start.getColumns() <= n.end.getColumns();
        }
    }

    public boolean isTouched(Coordinate c) {
        for(int i=0;i<partsTouched.length;i++) {
            if(partsTouched[i].equals(c)){
                return true;
            }
        }
        return false;
    }

    public boolean receiveHit(Coordinate c) {

        if(this.contain(c)) {
            partsTouched[numTouch]=c;
            numTouch++;
            return true;
        }
        return false;

    }

    public boolean isTouched() {
        return numTouch>0;
    }

    //affondata?
    public boolean isSinked() {
        return partsTouched.length==numTouch;
    }



}
