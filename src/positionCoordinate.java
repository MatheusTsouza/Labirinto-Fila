public class positionCoordinate {
    int line;
    int col;

    public positionCoordinate(int line, int col){
        this.line = line;
        this.col = col;
    }

    public String retriveCordinate(){
        return (this.line +","+ this.col);
    }

}
