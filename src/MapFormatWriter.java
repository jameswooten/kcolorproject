import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class MapFormatWriter {
    
    /** 
     * Writes a formatted file to be uploaded to https://mapchart.net/usa.html for visualization
     * @param stateList
     * @param colorDomain
     * @param fileNameInput
     */
    protected static void writeToTxt(ArrayList<State> stateList, ArrayList<String> colorDomain, String fileNameInput) {
        String prefix = "{\"groups\":{\"#cc0000\":{\"label\":\"\",\"paths\":[";
        ArrayList<State> blueList = new ArrayList<>();
        ArrayList<State> greenList = new ArrayList<>();
        ArrayList<State> redList = new ArrayList<>();
        ArrayList<State> yellowList = new ArrayList<>();
        for (State state : stateList) {
            if(state.getColor() != null) {

            switch (state.getColor()) {
                case "Blue":
                    blueList.add(state);
                    break;
                case "Red":
                    redList.add(state);
                    break;
                case "Green":
                    greenList.add(state);
                    break;
                case "Yellow":
                    yellowList.add(state);
                    break;
                default:
                    break;
            }
            }
        }
        try
        {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileNameInput + ".txt"), "UTF-8"));
            StringBuffer oneLine = new StringBuffer();
            oneLine.append(prefix);


            for (State state : redList) {
                oneLine.append("\"");
                oneLine.append(state.getCode());
                oneLine.append("\"");
                if(redList.get(redList.size() - 1) != state) {
                    oneLine.append(",");
                }
                
            }

            oneLine.append("]},\"#0868ac\":{\"label\":\"\",\"paths\":[");

            for (State state : blueList) {
                oneLine.append("\"");
                oneLine.append(state.getCode());
                oneLine.append("\"");
                if(blueList.get(blueList.size() - 1) != state) {
                    oneLine.append(",");
                }
                
            }

            oneLine.append("]},\"#38761d\":{\"label\":\"\",\"paths\":[");

            for (State state : greenList) {
                oneLine.append("\"");
                oneLine.append(state.getCode());
                oneLine.append("\"");
                if(greenList.get(greenList.size() - 1) != state) {
                    oneLine.append(",");
                }
                
            }

            oneLine.append("]},\"#ddee00\":{\"label\":\"\",\"paths\":[");

            for (State state : yellowList) {
                oneLine.append("\"");
                oneLine.append(state.getCode());
                oneLine.append("\"");
                if(yellowList.get(yellowList.size() - 1) != state) {
                    oneLine.append(",");
                }
                
            }

            oneLine.append("]}},\"title\":\"\",\"hidden\":[\"Guam\",\"Northern_Mariana_Islands\",\"Puerto_Rico\",\"American_Samoa\",\"United_States_Virgin_Islands\",\"Marshall_Islands\",\"Palau\",\"Federated_States_of_Micronesia\"],\"background\":\"#ffffff\",\"borders\":\"#000000\",\"legendFont\":\"Helvetica\",\"legendFontColor\":\"#000000\",\"legendBgColor\":\"#00000000\",\"areBordersShown\":true,\"defaultColor\":\"#d1dbdd\",\"labelsColor\":\"#000000\",\"strokeWidth\":\"medium\",\"usTerritoriesShown\":false,\"usFasShown\":false,\"legendPosition\":\"bottom_right\",\"legendSize\":\"medium\",\"legendStatus\":\"show\",\"scalingPatterns\":true,\"legendRowsSameColor\":true}");

            bw.write(oneLine.toString());
            bw.flush();
            bw.close();
        }
        catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }
}
