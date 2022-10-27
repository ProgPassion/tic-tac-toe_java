public class Square {
    
    private char sign;
    private int number;

    public Square(int number) {
        this.number = number;
        this.sign = ' ';
    }

    public int getNumber() {
        return this.number;
    }

    public char getSign() {
        return this.sign;
    }
    public boolean checkIfCellIsEmpty() {
        return this.sign == ' '; 
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    public void drawCell() {
        System.out.print("|" + this.sign + "|");
    }
}
