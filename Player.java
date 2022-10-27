import java.util.Scanner;

public class Player {

    public int getPlayerInput() {
        System.out.print("Write the number of cell 1-9: ");
        Scanner input = new Scanner(System.in);
        while(true) {
            int userInput;
            if(!input.hasNextInt()) {
                System.out.print("Write the number of cell 1-9: ");
                input = new Scanner(System.in);
                continue;
            }

            userInput = input.nextInt();
            if(userInput < 1 || userInput > 9) {
                System.out.print("Write the number of cell 1-9: ");
                input = new Scanner(System.in);
                continue;
            }
            return userInput;
        }
    }

    public char getSign(int round) {
        return (round % 2 == 0) ? 'O' : 'X';
    }
}
