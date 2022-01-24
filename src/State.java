import java.util.ArrayList;
import java.awt.Color;
/**
 * This class represents a state (or territory) on the map
 * @author James Wooten
 * @version 1.0
 */
public class State {
    private String name = "";
    boolean fcCheck = false;
    State next ;
    private String color;
    private String code;
    private ArrayList<String> colorDomain;
    private ArrayList<String> removedColors;
    private ArrayList<String> remainingColors;
    private ArrayList<State> neighbors = new ArrayList<>();

    /**
     * Constructor that takes the name of the state, state code, and available color domain
     * @param name the name of the state
     * @param code the state code
     * @param availableColors the domain of colors 
     */
    public State(String name, String code,ArrayList<String> availableColors) {
        this.name = name;
        this.code = code;
        this.neighbors = new ArrayList<>();
        this.colorDomain = availableColors;
        this.removedColors = new ArrayList<>();
        this.remainingColors = new ArrayList<>();
        copyRemainingColors();
        this.next = null;
    }

    
    /** 
     * Getter for name
     * @return String name of State
     */
    public String getName() {
        return name;
    }

    
    /** 
     * Getter for list of constraint neighbors
     * @return ArrayList<State> the neighbors
     */
    public ArrayList<State> getNeighbors() {
        return neighbors;
    }

    
    /** 
     * Getter for the State code
     * @return String the state code
     */
    public String getCode() {
        return this.code;
    }

    
    /** 
     * 
     * @param neighbors
     */
    public void setNeighbors(ArrayList<State> neighbors) {
        this.neighbors = neighbors;
    }

    
    /** 
     * @param neighbor
     */
    public void addNeighbor(State neighbor) {
        this. neighbors.add(neighbor);
    }

    
    /** 
     * @param availableColors
     */
    public void copyColorDomain(ArrayList<String> availableColors){
        for(int i = 0; i < colorDomain.size(); i++) {
            this.colorDomain.add(availableColors.get(i));
        }
    }

    
    /** 
     * @param newColor
     */
    public void addColorDomain(String newColor) {
        this.colorDomain.add(newColor);
    }

    public void copyRemainingColors() {
        this.remainingColors.clear();
        for (String color : colorDomain) {
            this.remainingColors.add(color);
        }
    }

    
    /** 
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    
    /** 
     * @return ArrayList<String>
     */
    public ArrayList<String> getRemovedColors() {
        return removedColors;
    }

    
    /** 
     * @return ArrayList<String>
     */
    public ArrayList<String> getRemainingColors() {
        return remainingColors;
    }

    
    /** 
     * @param color
     */
    public void removeRemainingColor(String color) {
        this.remainingColors.remove(color);
    }

    
    /** 
     * @return ArrayList<String>
     */
    public ArrayList<String> getColorDomain() {
        return colorDomain;
    }

    
    /** 
     * @return String
     */
    public String getColor() {
        return color;
    }

    
    /** 
     * @param color
     */
    public void addRemovedColor(String color) {
        this.removedColors.add(color);
    }

    public void clearRemovedColors() {
        this.removedColors.clear();
    }
    
}
