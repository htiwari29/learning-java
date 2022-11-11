import java.util.*;

public class BattleGrid {
    int gridSize = 5;
    int numberOfBattleship = gridSize;
    int numberOfLives = numberOfBattleship * 3;
    int score = 0;
    HashMap<String, BattleShip> battleshipPosition = new HashMap<>();

    public void start(){
        setGridSize();
        startPlaying();
    }

    public void oneTurn(){
        System.out.println("");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter X coordinate: ");
        int x = sc.nextInt();
        System.out.print("Enter Y coordinate: ");
        int y = sc.nextInt();
        // check every BattleShip for x, y
        checkBattleships(x, y);
        ++score;
    }

    public void checkBattleships(int x, int y){
        for (HashMap.Entry<String, BattleShip> hm : battleshipPosition.entrySet()){
            String name = hm.getKey();
            BattleShip battleship = hm.getValue();

            if (battleship.deletePosition(x, y)){
                System.out.println("Hit");
                if (battleship.deleteBattleship()){
                    battleshipPosition.remove(name);
                    numberOfBattleship--;
                    System.out.println("You've destroyed " + name + "!");
                    System.out.println("------------------------------------\n");
                }
                return;
            }
            else {
                System.out.println("Miss");
                return;
            }
        }

        // battleshipPosition.forEach((name, battleship) -> 
        // if (battleship.deletePosition()){
        //     System.out.println("Hit");
        //     if (battleship.deleteBattleship()){
        //         battleshipPosition.remove(name);
        //         numberOfBattleship--;
        //         System.out.println("You've destroyed " + name + "!");
        //     }
        //     return;
        // }
        // else {
        //     System.out.println("Miss");
        //     return;
        // });
    }

    public void startPlaying(){
        while (numberOfLives > 0){
            oneTurn();
            if (numberOfBattleship == 0){
                System.out.println("Congratulations! You've destroyed all enemy Battleships in " + score + " strikes!\n");
                return;
            }
            numberOfLives--;
        }
        System.out.println(numberOfBattleship + " enemy Battleships left! Unfortunately you've run out of missiles!\n");
        return;
    }

    public void setNumberOfLives(){
        System.out.print("Enter number of Missiles you want (INTEGER) greater than " + numberOfBattleship * 3 + " : ");
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
        System.out.print("Enter enemy battleship count (INTEGER) less than " + gridSize + " : ");
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
        temp.setPosition(gridSize);
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