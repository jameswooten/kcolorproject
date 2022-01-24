import java.util.ArrayList;
import java.awt.Color;

/** 
 * Represents Depth First Search with Heuristics
 */
public class DFS_Heuristic {
    State rootNode;
    Boolean solved;
    ArrayList<State> stateList;
    int backtracks;
    ArrayList<State> remainingStates;
    ArrayList<String> bestColor;

    
    /** 
     * Depth First Search function
     * @param stateList
     */
    public void runDFS(ArrayList<State> stateList) {

        this.rootNode = stateList.get(0);
        this.stateList = stateList;
        this.solved = false;
        this.backtracks = 0;
        this.remainingStates = new ArrayList<>();
        this.bestColor = new ArrayList<>();
        setupStates();
        addRemainingStates();

        for (String color : rootNode.getColorDomain()) {
            if(!this.solved) {
                rootNode.setColor(color);

                this.remainingStates.remove(rootNode);

                if(rootNode.next == null) {
                    rootNode.next = heuristicCalculate();
                }
                
    
                dFSUtility(rootNode.next);
            }
            continue;
        }
    }

    
    /** 
     * DFS Recursive Utility Function
     * @param current
     */
    public void dFSUtility(State current) {
        if(!this.solved) {
            for (String colors : findBestColor(current)) {

                if(!solved) {
                    current.setColor(colors);

                if(current.next == null && this.remainingStates.size() > 0) {
                    current.next = heuristicCalculate();
                }
               

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
        }
        if(!solved) {
            current.setColor(null);
        }
    }



    
    /** 
     * Checks for conflicts in list
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

    //Adds remaining states
    protected void addRemainingStates() {
        for (State state : this.stateList) {
            this.remainingStates.add(state);
        }
    }

    
    /** 
     * Calculates and returns the best state based on MRV Heuristic
     * @return State
     */
    protected State heuristicCalculate() {
        //Call MRV
        State bestHeuristic = calculateMRV();

        return bestHeuristic;


    }

    
    /** 
     * Finds the color that restricts the fewest neighbors and returns
     * @param a
     * @return ArrayList<String>
     */
    protected ArrayList<String> findBestColor(State a) {
        ArrayList<String> bestColors = new ArrayList<>();

        int initialConflict = 0;

        int lowestValue = 0;

        bestColors.add(a.getRemainingColors().get(0));

        for (State neighboring : a.getNeighbors()) {
            if(neighboring.getRemainingColors().contains(a.getRemainingColors().get(0))) {
                initialConflict++;
            }
        }

        lowestValue = initialConflict;

        for (String colorString : a.getRemainingColors()) {
            int count = 0;
           for (State neighborState : a.getNeighbors()) {
               if(neighborState.getRemainingColors().contains(colorString)) {
                count++;
               }
           }
           if(count < lowestValue) {
               lowestValue = count;
               bestColors.add(0, colorString);
           } else {bestColors.add(colorString);}
        }

        return bestColors;
        

    }

    
    /** 
     * Calculates the MRV Heuristic
     * @return State
     */
    protected State calculateMRV() {

        if(this.remainingStates.size() == 0) {
            return null;
        }

        State bestHeuristic = this.remainingStates.get(0);

        for (State state : remainingStates) {
            if(state.getRemainingColors().size() < bestHeuristic.getRemainingColors().size()) {
                bestHeuristic = state;
            } else if (state.getRemainingColors().size() == bestHeuristic.getRemainingColors().size()) {
                bestHeuristic = calculateDH(bestHeuristic, state);
            }
        }

        this.remainingStates.remove(bestHeuristic);
        return bestHeuristic;
    }

    
    /** 
     * Calculates the degree heuristic
     * @param a
     * @param b
     * @return State
     */
    protected State calculateDH(State a, State b) {
        int aCount = 0;
        for (State state : a.getNeighbors()) {
            if(state.getColor() == null) {
                aCount++;
            }
        }

        int bCount = 0;
        for (State state : b.getNeighbors()) {
            if(state.getColor() == null) {
                bCount++;
            }
        }

        if(aCount > bCount) {
            return a;
        } else {
            return b;
        }
        

    }

    /**
     * Sets all of the state.next to null to allow for heuristics
     */
    protected void setupStates() {
        for (State state : this.stateList) {
            state.next = null;
        }
    }

}