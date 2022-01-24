import java.util.ArrayList;
/**
 * This class represents the CSP Search with Forward Checking and Singleton Propogation
 */
public class DepthFirstSearch_FC_Singleton extends DepthFirstSearch_FC {
    
    /** 
     * Recursion call for DFS 
     * @param current the current state
     */
    @Override
    public void dFSUtility(State current) {

        //Check if already solves
        if(!super.solved) {

            //Forward Check Domains
            removeNeighborColors(current);


            //Iterate over strings
            for (String colors : current.getRemainingColors()) {


                //Check for solve
                if(!this.solved) {

                    current.setColor(colors);

                    

                    //If not at the end of list
                    if(current.next != null) {

                        for (State state : this.stateList) {
                            if(state.getRemainingColors().size() == 1 && state.getColor() == null) {
                                state.setColor(state.getRemainingColors().get(0));
                            }
                        }

                        //Recursive DFS call
                        dFSUtility(current.next);

                    } else {

                        //Check for conflict
                        if(isConflicts()) {

                            //Backtrack if conflict
                            current.setColor(null);
                            return;

                        } else {
                            //Print solution
                            for (State state : this.stateList) {
                                System.out.println(state.getName());
                                System.out.println(state.getColor());
                            }
                            this.solved = true;
                        }
                        return;

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
     * Removes constrained colors from domain
     * @param current the current state
     */
    @Override
    public void  removeNeighborColors(State current) {

        //Get available colors from starting domain
        current.copyRemainingColors();

        ArrayList<String> fcColors = new ArrayList<>();

        //Remove any neighbor's colors
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