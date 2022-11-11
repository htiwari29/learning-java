import java.util.*;

public class BattleGrid {
    int gridSize = 5;
    int numberOfBattleship = gridSize;
    int numberOfLives = gridSize * 3;
    int totalHealth = 0;
    HashMap<String, BattleShip> battleshipPosition = new HashMap<>();

    public void start(){
        setGridSize();
    }

    public void startPlaying(){
        while (numberOfLives > 0){
            
        }
    }

    public getAllHealth(){
        
    }

    public void setNumberOfLives(){
        System.out.print("Enter number of Missiles you want (INTEGER) greater than" + gridSize * 3 + " : ");
        Scanner sc = new Scanner(System.in);
        numberOfLives = sc.nextInt();
        startPlaying();
        return;
    }
    
    public void setGridSize(){
        System.out.print("Enter the battle grid size (INTEGER) greater than 5: ");
        Scanner sc = new Scanner(System.in);
        gridSize = sc.nextInt();
        setNumberOfBattleShip();
        return;
    }

    public void setNumberOfBattleShip(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter enemy battleship count (INTEGER) less than " + (gridSize+1) + " : ");
        int x = sc.nextInt();
        if (x < 1 || x > gridSize){
            x = 1;
        }
        numberOfBattleship = x;
        createBattleships();
        return;
    }

    public BattleShip createOneBattleship(){
        BattleShip temp = new BattleShip();
        temp.setName();
        temp.setPosition();
        temp.setHealth();
        return temp;
    }

    public void createBattleships(){
        for (int i=0; i<numberOfBattleship; i++){
            BattleShip foo = createOneBattleship();
            battleshipPosition.put(foo.getName(), foo);
        }
        setNumberOfLives();
        return;
    }
}