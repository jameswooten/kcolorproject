 import java.util.ArrayList;

 /**
  * Represents the Depth First Search with Heuristics, Forward Checking, and Singleton Propogation
  */
public class DFS_FC_Singleton_Heuristic extends DFS_Heuristic {


    
    /** 
     * DFS Recursive Utility Function
     * @param current
     */
    @Override
    public void dFSUtility(State current) {
        if(!this.solved) {

            removeNeighborColors(current);


            //Iterate over all the available colors
            for (String colors : current.getRemainingColors()) {

                if(solved) {
                    continue;
                }

                if(!this.solved) {
                    current.setColor(colors);
                

                    if(current.next == null && this.remainingStates.size() > 0) {
                        current.next = heuristicCalculate();
                    }
               

                    if(current.next != null) {
                        dFSUtility(current.next);

                    } 
                    else {

                        if(isConflicts()) {
                            current.setColor(null);
                            return;

                        } else {
                            this.solved = true;
                            for (State state : this.stateList) {
                                System.out.println(state.getName());
                                System.out.println(state.getColor());
                            }
                            return;
                        }
                    }
                }
            }

        }       
                
        if(!solved) {
            this.backtracks++;
            current.setColor(null);
        }       
        
    }

    
    /** 
     * adjusts available color domain
     * @param current
     */
    public void  removeNeighborColors(State current) {

        current.copyRemainingColors();

        ArrayList<String> fcColors = new ArrayList<>();

        for (State neighbor : current.getNeighbors()) {

            if(neighbor.getColor() != null) {
                fcColors.add(neighbor.getColor());
            }
        }
        for (String color : fcColors) {

            current.removeRemainingColor(color);
        }
    }
}

