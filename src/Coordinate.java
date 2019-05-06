public class Coordinate {
    private int columns;
    private int rows;
    //NELLA TABELLA ASCII IL CARATTERE A CORRISPONDE A 65,B A 66 ECC..
    private static final char characterFirst='A';

    //passo come parametro una stringa che contiene tutte le coordinate
    public Coordinate(String coordinates) {
        columns= coordinates.charAt(0)-characterFirst;
        String rows=coordinates.substring(1,2);
        this.rows=Integer.parseInt(rows);
    }

    public Coordinate(int rows,int columns) {
        this.columns=columns;
        this.rows=rows;
    }



    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public String toString() {
        String coordinates=new String();
        coordinates=coordinates+(char)(columns+characterFirst)+rows;
        return coordinates;
    }

    /*metodo equals che dato in parametro la coordinata mi restituisce true
    * se ha stessa riga e colonna*/
    public boolean equals(Coordinate o){
        return columns==o.columns && rows==o.rows;
    }
}
