import java.util.*;

public class GuessGameLauncher {
    public static void main(String[] args){
        System.out.print("Enter the max number of games: ");
        Scanner sc = new Scanner(System.in);
        GuessGame game = new GuessGame(sc.nextInt());
        sc.close();
        game.makeUserSetPlayerName();
        game.startGame();
    }
}
