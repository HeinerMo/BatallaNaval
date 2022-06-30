package entity;

import java.util.ArrayList;

import java.awt.Dimension;

public class CPU {

    private ArrayList<Ship> shipsCPU;
    private ArrayList<Dimension> position;

    public CPU() {
        position= new ArrayList<>();
        shipsCPU=new ArrayList<>();

        for(int i=0;i<10;i++){
        for(int j=0;j<10;j++){
            position.add(new Dimension(i, j));
        }    
        }
    }

    public void locateShips() {
        shipsCPU.add(new SmallShip(0, 0));
        shipsCPU.add(new SmallShip(1, 0));
        shipsCPU.add(new SmallShip(2, 0));

        shipsCPU.add(new MediumShip(0, 1));
        shipsCPU.add(new MediumShip(1, 1));
        shipsCPU.add(new MediumShip(2, 1));

        shipsCPU.add(new LargeShip(0, 4));
        shipsCPU.add(new LargeShip(1, 4));
        shipsCPU.add(new LargeShip(2, 4));
    }

    public Dimension generateNewPosition() {
        int index=0,x=0,y=0;
        index = (int) (Math.random() * (position.size() - 1));
        if(position.size()>0){
        x=position.get(index).width;
        y=position.get(index).height;
        position.remove(index);
        }

        System.out.print(x);
        System.out.println(" "+y);
        return new Dimension(x, y);
    }

    public void checkBullet(int x, int y){
		for (Ship ss:shipsCPU){
			ss.checkBullet(x, y);
		}
	}
}
