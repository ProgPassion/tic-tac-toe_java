public class Game {
   
    private int round = 1; 
    private char winner;
    public boolean over = false;
    public Square[] map = new Square[9];
    public Player player;

    public Game() {
        this.player = new Player();
        for(int i = 0; i < 9; i++) {
            this.map[i] = new Square(i + 1);
        }
    }

    private void setSquareSign(int playerInput) {
        for(int i = 0; i < this.map.length; i++) {
            if(this.map[i].getNumber() == playerInput && this.map[i].checkIfCellIsEmpty()) {
                this.map[i].setSign(this.player.getSign(round));
                this.round++;
            }
        }
    }
    
    public void printMap() {
        for(int i = 0; i < map.length; i++) {
            if(i % 3 == 0) {
                System.out.println();
                System.out.println("---------");
            }
            map[i].drawCell();
        }
        System.out.println();
        System.out.println("---------");
    }

    public void getPlayerInput() {
        int inputNum = this.player.getPlayerInput();
        this.setSquareSign(inputNum);
    }


    public char getWinner() {
        return this.winner;
    }

    private void checkHorizontalLines() {
        for(int i = 0; i < 7; i += 3) {
            if(map[i + 2].getSign() == map[i + 1].getSign() && 
            map[i + 2].getSign() == map[i].getSign() &&
            map[i + 2].getSign() != ' ') {
                this.winner = map[i].getSign();
                this.over = true;
            }
        }
    }

    private void checkVerticalLines() {
        for(int i = 0; i < 3; i++) {
            if(map[i].getSign() == map[i + 3].getSign() && 
            map[i].getSign() == map[i + 6].getSign() &&
            map[i].getSign() != ' ') {
                this.winner = map[i].getSign();
                this.over = true;
            }
        }
    }

    private void checkDiagonalLines() {
        if(map[0].getSign() == map[4].getSign() &&
        map[0].getSign() == map[8].getSign() &&
        map[0].getSign() != ' ') {
            this.winner = map[0].getSign();
            this.over = true;
        }
        if(map[2].getSign() == map[4].getSign() && 
        map[2].getSign() == map[6].getSign() &&
        map[2].getSign() != ' ') {
            this.winner = map[2].getSign();
            this.over = true;
        }
    }

    private void checkForDraw() {
        boolean mapIsFull = true;
        for(int i = 0; i < map.length; i++) {
            if(map[i].getSign() == ' ')
                mapIsFull = false;
        }

        if(mapIsFull && this.over == false) {
            this.winner = 'D';
            this.over = true;
        } 
    }

    public void checkGameStatus() {
        this.checkHorizontalLines();
        this.checkVerticalLines();
        this.checkDiagonalLines();
        this.checkForDraw();
    }
}
