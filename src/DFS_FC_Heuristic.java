import java.util.ArrayList;

/** 
 * Represents Depth First Search with Forward Checking and Heuristics
 */
public class DFS_FC_Heuristic extends DFS_Heuristic {


    
    /** 
     * Recursive DFS Utility
     * @param current
     */
    @Override
    public void dFSUtility(State current) {
        if(!this.solved) {

            removeNeighborColors(current);


            for (String colors : current.getRemainingColors()) {

                if(solved) {
                    continue;
                }

                if(!this.solved) {
                    current.setColor(colors);
                

                    //Get next heuristic state from list if not empty
                    if(current.next == null && this.remainingStates.size() > 0) {
                        current.next = heuristicCalculate();
                    }
               

                    if(current.next != null) {
                        dFSUtility(current.next);

                    } 
                    else {

                        //Backtrack
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
     * Removes constrained colors from domain
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