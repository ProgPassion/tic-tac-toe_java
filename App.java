public class App {
    public static void main(String[] args) {
        Game game = new Game();
        while(!game.over) {
            game.printMap();
            game.getPlayerInput();
            game.checkGameStatus();
        }
        game.printMap();
        System.out.println();
        System.out.println("Winner is: " + game.getWinner());
        
    }
    
}
    

