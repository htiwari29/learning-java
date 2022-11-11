import java.util.*;  


public class GameLauncher {
    public static void main(String[] args){
        System.out.print("Enter the max number of games: ");
        Scanner sc = new Scanner(System.in);
        GuessGame game = new GuessGame(sc.nextInt());
        System.out.println("-------------------------------");
        game.makeUserSetPlayerName();
        game.startGame();
    }
}


class GuessGame {
    Player p1 = new Player();
    Player p2 = new Player();
    Player p3 = new Player();
    int numberOfGames = 1;

    GuessGame(){}

    GuessGame(int numberOfGames){
        this.numberOfGames = numberOfGames;
    }

    public void gotWinner(Player p){
        System.out.println(p.name + " guessed the closest!");
        p.incScore();
        return;
    }

    public void playAGame(){
        Random random = new Random();
        int number = random.nextInt(10);

        int p1Guess = getAbsGuess(p1, number);
        int p2Guess = getAbsGuess(p2, number);
        int p3Guess = getAbsGuess(p3, number);

        int winner = Math.min(p1Guess, Math.min(p2Guess, p3Guess));
        
        if (winner == p1Guess){
            gotWinner(p1);
        }
        else if (winner == p2Guess){
            gotWinner(p2);
        }
        else{
            gotWinner(p3);
        }
        System.out.println("");
        return;
    }

    public int getAbsGuess(Player p, int n){
        System.out.print(getPlayerName(p) + " guess a number: ");
        return Math.abs(n - p.guessNumber());
    }
    
    public void congratulateWinner(Player p){
        System.out.println(p.name + " wins the series!");
        return;
    }

    public void findWinnerOfSeries(){
        int win = Math.max(p1.score, Math.max(p2.score, p3.score));
        if (win == p1.score){
            congratulateWinner(p1);
        }
        else if (win == p2.score){
            congratulateWinner(p2);
        }
        else{
            congratulateWinner(p3);
        }
    }

    public void startGame(){
        Random random = new Random();
        while (this.numberOfGames > 0){
            playAGame();
            --this.numberOfGames;
        }
        findWinnerOfSeries();
    }

    public void makeUserSetPlayerName(){
        System.out.println("Please enter 3 names :");
        setPlayerName(p1);
        setPlayerName(p2);
        setPlayerName(p3);
    }

    public void printPlayerNames(){
        System.out.println("Player 1 name: "+ getPlayerName(p1));
        System.out.println("Player 2 name: "+ getPlayerName(p2));
        System.out.println("Player 3 name: "+ getPlayerName(p3));
        return;
    }

    public void setPlayerName(Player p){
        Scanner sc = new Scanner(System.in);
        p.setName(sc.nextLine());
    }

    public String getPlayerName(Player p){
        return p.name;
    }
}


class Player {
    String name = "";
    int score = 0;

    Player(){}
 
    public void setName(String name){
        this.name = name;
        return;       
    }

    public void incScore(){
        ++this.score;
        return;
    }

    public void incScore(int v){
        this.score += v;
        return;
    }

    public int guessNumber(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}