import java.io.*;
import java.util.*;

public class BattleShip {
    Position pos = new Position();
    String name = "";
    int health = 0;

    public Boolean deletePosition(int x, int y){
        if (pos.findCoordinate(x, y)){
            pos.deleteCoordinate(x, y);
            setHealth();
            return true;
        }
        else{
            return false;
        }
    }

    public void setHealth(){
        health = 0;
        if (pos.firstCoordinate.getXCoordinate() != -1){
            ++health;
        }
        if (pos.secondCoordinate.getXCoordinate() != -1){
            ++health;
        }
        if (pos.thirdCoordinate.getXCoordinate() != -1){
            ++health;
        }
    }

    public void setPosition(int val){
        pos.setCoordinates(val);
        return;
    }

    public Position getPosition(){
        return pos;
    }

    public void setName(){
        Random random = new Random();
        char fLetter = (char)(random.nextInt(91-65) + 65);
        char sLetter = (char)(random.nextInt(123-97) + 97);
        int tLetter = random.nextInt(10);
        int foLetter = random.nextInt(8);
        name = Character.toString(fLetter) + Character.toString(sLetter) + Character.toString(tLetter) + Character.toString(foLetter);
        return;
    }

    public Boolean deleteBattleship(){
        setHealth();
        if (health == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public String getName(){
        if (name.equals("")){
            setName();
        }
        return name;
    }
}