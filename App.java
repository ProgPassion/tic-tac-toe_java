public class App {
    public static void main(String[] args) {
        Game game = new Game();
        char winner;
        while(!game.over) {
            game.printMap();
            game.getPlayerInput();
            game.checkGameStatus();
        }
        game.printMap();
        winner = game.getWinner();

        if(winner == 'D') 
            System.out.println("No winner, it's a draw!");
        else 
            System.out.println("Winner is: " + winner); 
    }
}
    

