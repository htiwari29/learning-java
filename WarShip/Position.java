import java.util.*;  

public class Position {
    Coordinate firstCoordinate = new Coordinate();
    Coordinate secondCoordinate = new Coordinate();
    Coordinate thirdCoordinate = new Coordinate();

    public Boolean findCoordinate(int x, int y){
        if (firstCoordinate.getXCoordinate() == x && firstCoordinate.getYCoordinate() == y){
            return true;
        }
        else if (secondCoordinate.getXCoordinate() == x && secondCoordinate.getYCoordinate() == y){
            return true;
        }
        else if (thirdCoordinate.getXCoordinate() == x && thirdCoordinate.getYCoordinate() == y){
            return true;
        }
        else{
            return false;
        }
    }

    public void deleteCoordinate(int x, int y){
        if (firstCoordinate.getXCoordinate() == x && firstCoordinate.getYCoordinate() == y){
            firstCoordinate.setXCoordinate(-1);
            firstCoordinate.setYCoordinate(-1);
        }
        else if (secondCoordinate.getXCoordinate() == x && secondCoordinate.getYCoordinate() == y){
            secondCoordinate.setXCoordinate(-1);
            secondCoordinate.setYCoordinate(-1);
        }
        else{
            thirdCoordinate.setXCoordinate(-1);
            thirdCoordinate.setYCoordinate(-1);
        }
        return;
    }

    public void setCoordinates(int val){
        Random random = new Random();
        int x = random.nextInt(val - 1) + 1;
        int y = random.nextInt(val - 1) + 1;
        int d = random.nextInt(2);
        secondCoordinate.setXCoordinate(x);
        secondCoordinate.setYCoordinate(y);
        secondCoordinate.setDCoordinate(d);
        firstCoordinate.setDCoordinate(d);
        thirdCoordinate.setDCoordinate(d);

        if (d == 0){
            firstCoordinate.setXCoordinate(x-1);
            firstCoordinate.setYCoordinate(y);    
            thirdCoordinate.setXCoordinate(x+1);
            thirdCoordinate.setYCoordinate(y);
        }
        else{
            firstCoordinate.setXCoordinate(x);
            firstCoordinate.setYCoordinate(y-1);
            thirdCoordinate.setXCoordinate(x);
            thirdCoordinate.setYCoordinate(y+1);
        }
    }
}

class Coordinate {
    private int x = -1;
    private int y = -1;
    private int d = -1;

    public int getXCoordinate(){
        return x;
    }

    public void setXCoordinate(int val){
        x = val;
        return;
    }

    public int getYCoordinate(){
        return y;
    }

    public void setYCoordinate(int val){
        y = val;
        return;
    }

    public int getDCoordinate(){
        return d;
    }

    public void setDCoordinate(int val){
        d = val;
        return;
    }
}