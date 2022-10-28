public class Map {
    
    private Square[] map;

    public Map(int numOfSquare) {
        this.map = new Square[numOfSquare];
        for(int i = 0; i < numOfSquare; i++) {
            this.map[i] = new Square(i + 1);
        }
    }

    public void setSquareSign(int playerInput, Player player, Game game) {
        for(int i = 0; i < this.map.length; i++) {
            if(this.map[i].getNumber() == playerInput && this.map[i].checkIfCellIsEmpty()) {
                this.map[i].setSign(player.getSign(game.getRound()));
                game.setRound(game.getRound() + 1);
            }
        }
    }

    public void printMap() {
        for(int i = 0; i < this.map.length; i++) {
            if(i % 3 == 0)
                System.out.println("\n---------");
            this.map[i].drawCell();
        }
        System.out.println("\n---------");
    }

    public void checkHorizontalLines(Game game) {
        for(int i = 0; i < 7; i += 3) {
            if(this.map[i + 2].getSign() == this.map[i + 1].getSign() && 
            this.map[i + 2].getSign() == this.map[i].getSign() &&
            this.map[i + 2].getSign() != ' ') {
                game.setWinner(map[i].getSign());
                game.over = true;
            }
        }
    }

    public void checkVerticalLines(Game game) {
        for(int i = 0; i < 3; i++) {
            if(this.map[i].getSign() == this.map[i + 3].getSign() && 
            this.map[i].getSign() == this.map[i + 6].getSign() &&
            this.map[i].getSign() != ' ') {
                game.setWinner(map[i].getSign());
                game.over = true;
            }
        }
    }

    public void checkDiagonalLines(Game game) {
        if(this.map[0].getSign() == this.map[4].getSign() &&
        this.map[0].getSign() == this.map[8].getSign() &&
        this.map[0].getSign() != ' ') {
            game.setWinner(map[0].getSign());
            game.over = true;
        }
        if(this.map[2].getSign() == this.map[4].getSign() && 
        this.map[2].getSign() == this.map[6].getSign() &&
        this.map[2].getSign() != ' ') {
            game.setWinner(map[2].getSign());
            game.over = true;
        }
    }

    public void checkForDraw(Game game) {
        boolean mapIsFull = true;
        for(int i = 0; i < this.map.length; i++) {
            if(this.map[i].getSign() == ' ')
                mapIsFull = false;
        }

        if(mapIsFull && game.over == false) {
            game.setWinner('D');
            game.over = true;
        } 
    }
}
