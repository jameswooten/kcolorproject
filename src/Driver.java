import java.util.ArrayList;

import javax.swing.text.AttributeSet.ColorAttribute;
import javax.xml.transform.Templates;

import java.awt.Color;

public class Driver {    
    
    /** 
     * Runs the k-Color Map program
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // runHeuristicAus();

        // runHeuristicNonAus();

        // runNonHeuristicUS();

        runHeuristicUS();

        // runDF_US();

        // runDF_H_US();

    }

    /**
     * Runs non Heuristic US Map searches
     */
    private static void runNonHeuristicUS() {
        
        //Start Time
        long startTime = System.currentTimeMillis();

        //Create lists for map and colors
        ArrayList<String> colorDomain = new ArrayList<>();
        ArrayList<State> usStateList = new ArrayList<>();

        //Add initial Color Domain
        colorDomain.add("Blue");
        colorDomain.add("Green");
        colorDomain.add("Red");
        colorDomain.add("Yellow");
      

        //Create Australia
        MapNodeCreation map = new MapNodeCreation();
        usStateList =  map.generateAmericaNodes(colorDomain);

        //Create Objects
        DepthFirstSearch_FC dfs_fc = new DepthFirstSearch_FC();
        DepthFirstSearch_FC_Singleton dfs_fc_singleton = new DepthFirstSearch_FC_Singleton();

        
        //Run DFS with Forward Checking
        startTime = System.currentTimeMillis();

        dfs_fc.runDFS(usStateList);


        //Time and Print information
        long endTime = System.currentTimeMillis();

        System.out.println("--DONE FC--");

        System.out.println("Runtime: " + (endTime - startTime) + " milliseconds");
        System.out.println(dfs_fc.solved);
        System.out.println(dfs_fc.backtracks);
        MapFormatWriter.writeToTxt(usStateList, colorDomain, "US_Map_FC");

        //Reset Map
        resetColors(usStateList);

        //Run DFS with FC and Singleton Domains
        startTime = System.currentTimeMillis();

        dfs_fc_singleton.runDFS(usStateList);

        endTime = System.currentTimeMillis();

        System.out.println("--DONE Singleton--");

        System.out.println("Runtime: " + (endTime - startTime) + " milliseconds");
        System.out.println(dfs_fc_singleton.solved);
        System.out.println(dfs_fc_singleton.backtracks);
        MapFormatWriter.writeToTxt(usStateList, colorDomain, "US_Map_Singleton");
    }

    
    /**
     * Runs Heuristic US Map searches
     */
    private static void runHeuristicUS() {
        
        //Start Time
        long startTime = System.currentTimeMillis();

        //Create lists for map and colors
        ArrayList<String> colorDomain = new ArrayList<>();
        ArrayList<State> usStateList = new ArrayList<>();

        //Add initial Color Domain
        colorDomain.add("Blue");
        colorDomain.add("Green");
        colorDomain.add("Red");
        colorDomain.add("Yellow");
      

        //Create Australia
        MapNodeCreation map = new MapNodeCreation();
        usStateList =  map.generateAmericaNodes(colorDomain);

        //Create Objects
        DFS_FC_Heuristic dfs_fc = new DFS_FC_Heuristic();
        DFS_FC_Singleton_Heuristic dfs_fc_singleton = new DFS_FC_Singleton_Heuristic();

        
        //Run DFS with Forward Checking
        startTime = System.currentTimeMillis();

        dfs_fc.runDFS(usStateList);


        //Time and Print information
        long endTime = System.currentTimeMillis();

        System.out.println("--DONE FC--");

        System.out.println("Runtime: " + (endTime - startTime) + " milliseconds");
        System.out.println(dfs_fc.solved);
        System.out.println(dfs_fc.backtracks);
        MapFormatWriter.writeToTxt(usStateList, colorDomain, "US_Map_FC");

        //Reset Map
        resetColors(usStateList);

        //Run DFS with FC and Singleton Domains
        startTime = System.currentTimeMillis();

        dfs_fc_singleton.runDFS(usStateList);

        endTime = System.currentTimeMillis();

        System.out.println("--DONE Singleton--");

        System.out.println("Runtime: " + (endTime - startTime) + " milliseconds");
        System.out.println(dfs_fc_singleton.solved);
        System.out.println(dfs_fc_singleton.backtracks);
        MapFormatWriter.writeToTxt(usStateList, colorDomain, "US_Map_Singleton");
    }

    
    /**
     * Runs non Heuristic DFS US Map search
     */
    private static void runDF_US() {

        
        //Create lists for map and colors
        ArrayList<String> colorDomain = new ArrayList<>();
        ArrayList<State> usStateList = new ArrayList<>();

        //Add initial Color Domain
        colorDomain.add("Blue");
        colorDomain.add("Green");
        colorDomain.add("Red");
        colorDomain.add("Yellow");
      

        //Create Australia
        MapNodeCreation map = new MapNodeCreation();
        usStateList =  map.generateAmericaNodes(colorDomain);

        DepthFirstSearch dfs = new DepthFirstSearch();

        long startTime = System.currentTimeMillis();

        //Run Depth First Search
        dfs.runDFS(usStateList);

        //Time and Print information
        long endTime = System.currentTimeMillis();

        System.out.println("--DONE DFS--");

        System.out.println("Runtime: " + (endTime - startTime) + " milliseconds");
        System.out.println(dfs.solved);
        System.out.println(dfs.backtracks);
        MapFormatWriter.writeToTxt(usStateList, colorDomain, "US_Map_DFS");
    }


    
    /**
     * Runs Heuristic US DFS Map search
     */
    private static void runDF_H_US() {

        
        //Create lists for map and colors
        ArrayList<String> colorDomain = new ArrayList<>();
        ArrayList<State> usStateList = new ArrayList<>();

        //Add initial Color Domain
        colorDomain.add("Blue");
        colorDomain.add("Green");
        colorDomain.add("Red");
        colorDomain.add("Yellow");
      

        //Create Australia
        MapNodeCreation map = new MapNodeCreation();
        usStateList =  map.generateAmericaNodes(colorDomain);

        DFS_Heuristic dfs = new DFS_Heuristic();

        long startTime = System.currentTimeMillis();

        //Run Depth First Search
        dfs.runDFS(usStateList);

        //Time and Print information
        long endTime = System.currentTimeMillis();

        System.out.println("--DONE DFS--");

        System.out.println("Runtime: " + (endTime - startTime) + " milliseconds");
        System.out.println(dfs.solved);
        System.out.println(dfs.backtracks);
        MapFormatWriter.writeToTxt(usStateList, colorDomain, "US_Map_DFS");
    }


    
    /**
     * Runs non Heuristic AUS Map searches
     */
    private static void runNonHeuristicAus() {

        //Start Time
        long startTime = System.currentTimeMillis();

        //Create lists for map and colors
        ArrayList<String> colorDomain = new ArrayList<>();
        ArrayList<State> ausStateList = new ArrayList<>();

        //Add initial Color Domain
        colorDomain.add("Blue");
        colorDomain.add("Green");
        colorDomain.add("Red");
      

        //Create Australia
        MapNodeCreation map = new MapNodeCreation();
        ausStateList =  map.generateAustraliaNodes(colorDomain);

        //Create Objects
        DepthFirstSearch dfs = new DepthFirstSearch();
        DepthFirstSearch_FC dfs_fc = new DepthFirstSearch_FC();
        DepthFirstSearch_FC_Singleton dfs_fc_singleton = new DepthFirstSearch_FC_Singleton();

        //Run Depth First Search
        dfs.runDFS(ausStateList);

        //Time and Print information
        long endTime = System.currentTimeMillis();

        System.out.println("--DONE DFS--");

        System.out.println("Runtime: " + (endTime - startTime) + " milliseconds");
        System.out.println(dfs.solved);
        System.out.println(dfs.backtracks);

        //Reset Map
        resetColors(ausStateList);
        
        //Run DFS with Forward Checking
        startTime = System.currentTimeMillis();

        dfs_fc.runDFS(ausStateList);


        //Time and Print information
        endTime = System.currentTimeMillis();

        System.out.println("--DONE FC--");

        System.out.println("Runtime: " + (endTime - startTime) + " milliseconds");
        System.out.println(dfs_fc.solved);
        System.out.println(dfs_fc.backtracks);

        //Reset Map
        resetColors(ausStateList);

        //Run DFS with FC and Singleton Domains
        startTime = System.currentTimeMillis();

        dfs_fc_singleton.runDFS(ausStateList);

        endTime = System.currentTimeMillis();

        System.out.println("--DONE Singleton--");

        System.out.println("Runtime: " + (endTime - startTime) + " milliseconds");
        System.out.println(dfs_fc_singleton.solved);
        System.out.println(dfs_fc_singleton.backtracks);
    }


    
    /**
     * Runs Heuristic AUS Map searches
     */
    private static void runHeuristicAus() {

        //Start Time
        long startTime = System.currentTimeMillis();

        //Create lists for map and colors
        ArrayList<String> colorDomain = new ArrayList<>();
        ArrayList<State> ausStateList = new ArrayList<>();

        //Add initial Color Domain
        colorDomain.add("Blue");
        colorDomain.add("Green");
        colorDomain.add("Red");
      

        //Create Australia
        MapNodeCreation map = new MapNodeCreation();
        ausStateList =  map.generateAustraliaNodes(colorDomain);

        //Create Objects
        DFS_Heuristic dfs = new DFS_Heuristic();
        DFS_FC_Heuristic dfs_fc = new DFS_FC_Heuristic();
        DFS_FC_Singleton_Heuristic dfs_fc_singleton = new DFS_FC_Singleton_Heuristic();

        //Run Depth First Search
        dfs.runDFS(ausStateList);

        //Time and Print information
        long endTime = System.currentTimeMillis();

        System.out.println("--DONE DFS--");

        System.out.println("Runtime: " + (endTime - startTime) + " milliseconds");
        System.out.println(dfs.solved);
        System.out.println(dfs.backtracks);

        //Reset Map
        resetColors(ausStateList);
        
        //Run DFS with Forward Checking
        startTime = System.currentTimeMillis();

        dfs_fc.runDFS(ausStateList);


        //Time and Print information
        endTime = System.currentTimeMillis();

        System.out.println("--DONE FC--");

        System.out.println("Runtime: " + (endTime - startTime) + " milliseconds");
        System.out.println(dfs_fc.solved);
        System.out.println(dfs_fc.backtracks);

        //Reset Map
        resetColors(ausStateList);

        //Run DFS with FC and Singleton Domains
        startTime = System.currentTimeMillis();

        dfs_fc_singleton.runDFS(ausStateList);

        endTime = System.currentTimeMillis();

        System.out.println("--DONE Singleton--");

        System.out.println("Runtime: " + (endTime - startTime) + " milliseconds");
        System.out.println(dfs_fc_singleton.solved);
        System.out.println(dfs_fc_singleton.backtracks);
    }

    
    /** 
     * Resets all the colors of the states
     * @param states
     */
    public static void resetColors(ArrayList<State> states) {
       for (State state : states) {
           state.setColor(null);
       } 
    }
}
