import java.awt.Color;
import java.util.ArrayList;

/** 
 * Represents the DFS Search with Forward Checking
 * @author James Wooten
 * @version 1.0
 */
public class DepthFirstSearch_FC extends DepthFirstSearch{

    ArrayList<State> solution = new ArrayList<>();
    
    
    
    /** 
     * Recursive DFS Call Utility
     * @param current
     */
    @Override
    public void dFSUtility(State current) {
        if(!super.solved) {

            //Forward Check color domain
            removeNeighborColors(current);

            //Iterate over colors
            for (String colors : current.getRemainingColors()) {

                if(!this.solved) {
                    current.setColor(colors);

                    if(current.next != null) {

                        //Recursive call
                        dFSUtility(current.next);

                    } 
                    else {

                        if(isConflicts()) {
                            current.setColor(null);
                            return;

                        } 
                        else {
                            //Print out and store solution
                            for (State state : super.stateList) {
                                System.out.println(state.getName());
                                System.out.println(state.getColor());

                                State temp = new State(state.getName(), state.getCode(), state.getColorDomain());
                                temp.setColor(state.getColor());

                                this.solution.add(temp);
                                this.solved = true;
                            }
                            return;
                        }                      
                    }
                }
            }
            if(!solved) {
                this.backtracks++;
            }
        }
        if (!solved) {
            current.setColor(null);
        }
    }

    
    /** 
     * Adjusts available domain of colors for current
     * @param current
     */
    public void  removeNeighborColors(State current) {

        //Get original colors
        current.copyRemainingColors();

        ArrayList<String> fcColors = new ArrayList<>();

        //Remove any of the neighbor colors
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
