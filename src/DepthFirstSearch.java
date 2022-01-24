import java.util.ArrayList;
import java.awt.Color;
/**
 * Represents Depth First Search
 */
public class DepthFirstSearch {
    State rootNode;
    Boolean solved;
    ArrayList<State> stateList;
    int backtracks;

    
    /** 
     * Runs DFS Search
     * @param stateList
     */
    public void runDFS(ArrayList<State> stateList) {
        this.rootNode = stateList.get(0);
        this.stateList = stateList;
        this.solved = false;
        this.backtracks = 0;

        //Call recursive call for each color
        for (String color : rootNode.getColorDomain()) {
            if(!this.solved) {
                rootNode.setColor(color);
    
                dFSUtility(rootNode.next);
            }
            continue;
        }
    }

    
    /** 
     * Recursion utility function
     * @param current
     */
    public void dFSUtility(State current) {
        if(!this.solved) {
            for (String colors : current.getColorDomain()) {

                if(!solved) {
                    current.setColor(colors);

                    if(current.next != null) {
                        dFSUtility(current.next);
                    } else {
                        if(isConflicts()) {
                            return;
                        } else {
                            this.solved = true;
                            for (State state : this.stateList) {
                                System.out.println(state.getName());
                                System.out.println(state.getColor());
                            }
                        }
                    }
                }
            }
            if(!solved) {
                this.backtracks++;
            }
            return;
        }
        return;
    }



    
    /** 
     * Checks if there is a conflict in the list
     * @return boolean
     */
    protected boolean isConflicts() {

        for (State state : this.stateList) {

            if(state.getColor() == null) {
                continue;
            }

            for (State neighbor : state.getNeighbors()) {
                if(neighbor.getColor() == null) {
                    continue;
                }
                
                if(neighbor.getColor().equals(state.getColor())) {
                    return true;
                }
            }
        }
        return false;
    }

}
