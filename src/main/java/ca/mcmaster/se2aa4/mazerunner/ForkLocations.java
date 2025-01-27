package ca.mcmaster.se2aa4.mazerunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ForkLocations{
    private HashMap<List<Integer>,Integer> forkLocations=new HashMap<List<Integer>,Integer>();
    
    public boolean addForkLocations(int[] position){
        List<Integer> positionKey = Arrays.stream(position).boxed().toList();
        if(forkLocations.containsKey(positionKey)){
            forkLocations.put(positionKey,forkLocations.get(positionKey)+1);
            if(forkLocations.get(positionKey)==4){
                forkLocations.remove(positionKey);
                return false;
            }
        }
        else{
            forkLocations.put(positionKey, 1);
        }
        return true;
    }

}