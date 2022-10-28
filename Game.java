public class Game {
   
    public boolean over = false;
    private int round = 1; 
    private char winner;
    private Map map;
    private Player player;

    public Game() {
        this.player = new Player();
        this.map = new Map(9);
    }
    
    public void getPlayerInput() {
        int inputNum = this.player.getPlayerInput();
        this.map.setSquareSign(inputNum, player, this);
    }

    public char getWinner() {
        return this.winner;
    }

    public void setWinner(char winner) {
        this.winner = winner;
    }

    public int getRound() {
        return this.round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void checkGameStatus() {
        this.map.checkHorizontalLines(this);
        this.map.checkVerticalLines(this);
        this.map.checkDiagonalLines(this);
        this.map.checkForDraw(this);
    }

    public void printMap() {
        this.map.printMap();
    }
}
