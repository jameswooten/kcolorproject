import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;

public class MapNodeCreation {
    
    
    /** 
     * Creates and orders the Australian territories
     * @param colorDomain
     * @return ArrayList<State>
     */
    public ArrayList<State> generateAustraliaNodes(ArrayList<String> colorDomain) {

        //Create map
        ArrayList<State> mapOrdered = new ArrayList<>();

        //Generate each of the territories
        State westernAustralia = new State("Western Australia", "WA",colorDomain);
        State northernTerritory = new State("Northern Territory", "NT",colorDomain);
        State southAustralia = new State("South Australia", "SA",colorDomain);
        State queensland = new State("Queensland", "Q",colorDomain);
        State newSouthWales = new State("New South Wales", "NSW",colorDomain);
        State victoria= new State("Victoria", "V",colorDomain);
        State tasmania= new State("Tasmania", "T",colorDomain);

        //Add territories to the map
        mapOrdered.add(westernAustralia);
        mapOrdered.add(northernTerritory);
        mapOrdered.add(southAustralia);
        mapOrdered.add(queensland);
        mapOrdered.add(newSouthWales);
        mapOrdered.add(victoria);
        mapOrdered.add(tasmania);

        //Add the neighbors for each state
        westernAustralia.addNeighbor(northernTerritory);
        westernAustralia.addNeighbor(southAustralia);

        northernTerritory.addNeighbor(westernAustralia);
        northernTerritory.addNeighbor(southAustralia);
        northernTerritory.addNeighbor(queensland);

        southAustralia.addNeighbor(westernAustralia);
        southAustralia.addNeighbor(northernTerritory);
        southAustralia.addNeighbor(queensland);
        southAustralia.addNeighbor(newSouthWales);
        southAustralia.addNeighbor(victoria);

        queensland.addNeighbor(northernTerritory);
        queensland.addNeighbor(southAustralia);
        queensland.addNeighbor(newSouthWales);

        newSouthWales.addNeighbor(queensland);
        newSouthWales.addNeighbor(southAustralia);
        newSouthWales.addNeighbor(victoria);

        victoria.addNeighbor(southAustralia);
        victoria.addNeighbor(newSouthWales);

        //Randomly order the map by selecting a random value in the OrderedList
        ArrayList<State> mapRandom = new ArrayList<>();

        //Select the root node in the list

        Random rng = new Random();

        int selection = rng.nextInt(mapOrdered.size());

        State temp = mapOrdered.get(selection);

        mapRandom.add(temp);
        mapOrdered.remove(selection);

        while (!mapOrdered.isEmpty()) {

            selection = rng.nextInt(mapOrdered.size());

            temp.next = mapOrdered.get((selection));

            mapRandom.add(temp.next);
            mapOrdered.remove(selection);

            temp = temp.next;

        }

        return mapRandom;
    }

    
    /** 
     * Generates and orders the US States
     * @param colorDomain
     * @return ArrayList<State>
     */
    public ArrayList<State> generateAmericaNodes(ArrayList<String> colorDomain) {
        //Create map
        ArrayList<State> mapOrdered = new ArrayList<>();

        State alabama = new State("alabama", "AL", colorDomain);
        State alaska = new State("alaska", "AK",colorDomain);
        State arizona = new State("arizona","AZ", colorDomain);
        State arkansas = new State("arkansas","AR", colorDomain);
        State california = new State("california", "CA",colorDomain);
        State colorado = new State("colorado", "CO",colorDomain);
        State connecticut = new State("connecticut","CT", colorDomain);
        State delaware = new State("delaware", "DE",colorDomain);
        State florida = new State("florida", "FL",colorDomain);
        State georgia = new State("georgia","GA", colorDomain);
        State hawaii = new State("hawaii", "HI",colorDomain);
        State idaho = new State("idaho", "ID", colorDomain);
        State illinois = new State("illinois", "IL",colorDomain);
        State indiana = new State("indiana", "IN",colorDomain);
        State iowa = new State("iowa", "IA",colorDomain);
        State kansas = new State("kansas","KS", colorDomain);
        State kentucky = new State("kentucky", "KY",colorDomain);
        State louisiana = new State("louisiana", "LA",colorDomain);
        State maine = new State("maine", "ME",colorDomain);
        State maryland = new State("maryland", "MD",colorDomain);
        State massachusetts = new State("massachusetts", "MA",colorDomain);
        State michigan = new State("michigan", "MI",colorDomain);
        State minnesota = new State("minnesota", "MN",colorDomain);
        State mississippi = new State("mississippi", "MS",colorDomain);
        State missouri = new State("missouri", "MO",colorDomain);
        State montana = new State("montana", "MT",colorDomain);
        State nebraska = new State("nebraska", "NE",colorDomain);
        State nevada = new State("nevada", "NV", colorDomain);
        State newHampshire = new State("newHampshire", "NH",colorDomain);
        State newJersey = new State("newJersey", "NJ",colorDomain);
        State newMexico = new State("newMexico", "NM",colorDomain);
        State newYork = new State("newYork", "NY",colorDomain);
        State northCarolina = new State("northCarolina", "NC",colorDomain);
        State northDakota = new State("northDakota", "ND",colorDomain);
        State ohio = new State("ohio", "OH",colorDomain);
        State oklahoma = new State("oklahoma", "OK",colorDomain);
        State oregon = new State("oregon", "OR",colorDomain);
        State pennsylvania = new State("pennsylvania", "PA",colorDomain);
        State rhodeIsland = new State("rhodeIsland", "RI",colorDomain);
        State southCarolina = new State("southCarolina", "SC",colorDomain);
        State southDakota = new State("southDakota", "SD",colorDomain);
        State tennessee = new State("tennessee", "TN",colorDomain);
        State texas = new State("texas", "TX",colorDomain);
        State utah = new State("utah", "UT",colorDomain);
        State vermont = new State("vermont", "VT",colorDomain);
        State virginia = new State("virginia", "VA",colorDomain);
        State washington = new State("washington", "WA",colorDomain);
        State westVirginia = new State("westVirginia", "WV",colorDomain);
        State wisconsin = new State("wisconsin", "WI",colorDomain);
        State wyoming = new State("wyoming", "WY",colorDomain);

        mapOrdered.add(alabama);
        mapOrdered.add(alaska);
        mapOrdered.add(arizona);
        mapOrdered.add(arkansas);
        mapOrdered.add(california);
        mapOrdered.add(colorado);
        mapOrdered.add(connecticut);
        mapOrdered.add(delaware);
        mapOrdered.add(florida);
        mapOrdered.add(georgia);
        mapOrdered.add(hawaii);
        mapOrdered.add(idaho);
        mapOrdered.add(illinois);
        mapOrdered.add(indiana);
        mapOrdered.add(iowa);
        mapOrdered.add(kansas);
        mapOrdered.add(kentucky);
        mapOrdered.add(louisiana);
        mapOrdered.add(maine);
        mapOrdered.add(maryland);
        mapOrdered.add(massachusetts);
        mapOrdered.add(michigan);
        mapOrdered.add(minnesota);
        mapOrdered.add(mississippi);
        mapOrdered.add(missouri);
        mapOrdered.add(montana);
        mapOrdered.add(nebraska);
        mapOrdered.add(nevada);
        mapOrdered.add(newHampshire);
        mapOrdered.add(newJersey);
        mapOrdered.add(newMexico);
        mapOrdered.add(newYork);
        mapOrdered.add(northCarolina);
        mapOrdered.add(northDakota);
        mapOrdered.add(ohio);
        mapOrdered.add(oklahoma);
        mapOrdered.add(oregon);
        mapOrdered.add(pennsylvania);
        mapOrdered.add(rhodeIsland);
        mapOrdered.add(southCarolina);
        mapOrdered.add(southDakota);
        mapOrdered.add(tennessee);
        mapOrdered.add(texas);
        mapOrdered.add(utah);
        mapOrdered.add(vermont);
        mapOrdered.add(virginia);
        mapOrdered.add(washington);
        mapOrdered.add(westVirginia);
        mapOrdered.add(wisconsin);
        mapOrdered.add(wyoming);

        

         alabama.addNeighbor(mississippi);
         alabama.addNeighbor(tennessee);
         alabama.addNeighbor(florida);
         alabama.addNeighbor(georgia);

         arizona.addNeighbor(nevada);
         arizona.addNeighbor(newMexico);
         arizona.addNeighbor(utah);
         arizona.addNeighbor(california);
         arizona.addNeighbor(colorado);

         arkansas.addNeighbor(oklahoma);
         arkansas.addNeighbor(tennessee);
         arkansas.addNeighbor(texas);
         arkansas.addNeighbor(louisiana);
         arkansas.addNeighbor(mississippi);
         arkansas.addNeighbor(missouri);

         california.addNeighbor(oregon);
         california.addNeighbor(arizona);
         california.addNeighbor(nevada);

         colorado.addNeighbor(newMexico);
         colorado.addNeighbor(oklahoma);
         colorado.addNeighbor(utah);
         colorado.addNeighbor(wyoming);
         colorado.addNeighbor(arizona);
         colorado.addNeighbor(kansas);
         colorado.addNeighbor(nebraska);

         connecticut.addNeighbor(newYork);
         connecticut.addNeighbor(rhodeIsland);
         connecticut.addNeighbor(massachusetts);

         delaware.addNeighbor(newJersey);
         delaware.addNeighbor(pennsylvania);
         delaware.addNeighbor(maryland);

         florida.addNeighbor(georgia);
         florida.addNeighbor(alabama);

         georgia.addNeighbor(northCarolina);
         georgia.addNeighbor(southCarolina);
         georgia.addNeighbor(tennessee);
         georgia.addNeighbor(alabama);
         georgia.addNeighbor(florida);

         idaho.addNeighbor(utah);
         idaho.addNeighbor(washington);
         idaho.addNeighbor(wyoming);
         idaho.addNeighbor(montana);
         idaho.addNeighbor(nevada);
         idaho.addNeighbor(oregon);

         illinois.addNeighbor(kentucky);
         illinois.addNeighbor(missouri);
         illinois.addNeighbor(wisconsin);
         illinois.addNeighbor(indiana);
         illinois.addNeighbor(iowa);
         illinois.addNeighbor(michigan);

         indiana.addNeighbor(michigan);
         indiana.addNeighbor(ohio);
         indiana.addNeighbor(illinois);
         indiana.addNeighbor(kentucky);

         iowa.addNeighbor(nebraska);
         iowa.addNeighbor(southDakota);
         iowa.addNeighbor(wisconsin);
         iowa.addNeighbor(illinois);
         iowa.addNeighbor(minnesota);
         iowa.addNeighbor(missouri);

         kansas.addNeighbor(nebraska);
         kansas.addNeighbor(oklahoma);
         kansas.addNeighbor(colorado);
         kansas.addNeighbor(missouri);

         kentucky.addNeighbor(tennessee);
         kentucky.addNeighbor(virginia);
         kentucky.addNeighbor(westVirginia);
         kentucky.addNeighbor(illinois);
         kentucky.addNeighbor(indiana);
         kentucky.addNeighbor(missouri);
         kentucky.addNeighbor(ohio);

         louisiana.addNeighbor(texas);
         louisiana.addNeighbor(arkansas);
         louisiana.addNeighbor(mississippi);

         maine.addNeighbor(newHampshire);

         maryland.addNeighbor(virginia);
         maryland.addNeighbor(westVirginia);
         maryland.addNeighbor(delaware);
         maryland.addNeighbor(pennsylvania);

         massachusetts.addNeighbor(newYork);
         massachusetts.addNeighbor(rhodeIsland);
         massachusetts.addNeighbor(vermont);
         massachusetts.addNeighbor(connecticut);
         massachusetts.addNeighbor(newHampshire);

         michigan.addNeighbor(ohio);
         michigan.addNeighbor(wisconsin);
         michigan.addNeighbor(illinois);
         michigan.addNeighbor(indiana);
         michigan.addNeighbor(minnesota);

         minnesota.addNeighbor(northDakota);
         minnesota.addNeighbor(southDakota);
         minnesota.addNeighbor(wisconsin);
         minnesota.addNeighbor(iowa);
         minnesota.addNeighbor(michigan);

         mississippi.addNeighbor(louisiana);
         mississippi.addNeighbor(tennessee);
         mississippi.addNeighbor(alabama);
         mississippi.addNeighbor(arkansas);

         missouri.addNeighbor(nebraska);
         missouri.addNeighbor(oklahoma);
         missouri.addNeighbor(tennessee);
         missouri.addNeighbor(arkansas);
         missouri.addNeighbor(illinois);
         missouri.addNeighbor(iowa);
         missouri.addNeighbor(kansas);
         missouri.addNeighbor(kentucky);

         montana.addNeighbor(southDakota);
         montana.addNeighbor(wyoming);
         montana.addNeighbor(idaho);
         montana.addNeighbor(northDakota);

         nebraska.addNeighbor(missouri);
         nebraska.addNeighbor(southDakota);
         nebraska.addNeighbor(wyoming);
         nebraska.addNeighbor(colorado);
         nebraska.addNeighbor(iowa);
         nebraska.addNeighbor(kansas);

         nevada.addNeighbor(idaho);
         nevada.addNeighbor(oregon);
         nevada.addNeighbor(utah);
         nevada.addNeighbor(arizona);
         nevada.addNeighbor(california);

         newHampshire.addNeighbor(vermont);
         newHampshire.addNeighbor(maine);
         newHampshire.addNeighbor(massachusetts);

         newJersey.addNeighbor(pennsylvania);
         newJersey.addNeighbor(delaware);
         newJersey.addNeighbor(newYork);

         newMexico.addNeighbor(oklahoma);
         newMexico.addNeighbor(texas);
         newMexico.addNeighbor(utah);
         newMexico.addNeighbor(arizona);
         newMexico.addNeighbor(colorado);

         newYork.addNeighbor(pennsylvania);
         newYork.addNeighbor(rhodeIsland);
         newYork.addNeighbor(vermont);
         newYork.addNeighbor(connecticut);
         newYork.addNeighbor(massachusetts);
         newYork.addNeighbor(newJersey);

         northCarolina.addNeighbor(tennessee);
         northCarolina.addNeighbor(virginia);
         northCarolina.addNeighbor(georgia);
         northCarolina.addNeighbor(southCarolina);

         northDakota.addNeighbor(southDakota);
         northDakota.addNeighbor(minnesota);
         northDakota.addNeighbor(montana);

         ohio.addNeighbor(michigan);
         ohio.addNeighbor(pennsylvania);
         ohio.addNeighbor(westVirginia);
         ohio.addNeighbor(indiana);
         ohio.addNeighbor(kentucky);

         oklahoma.addNeighbor(missouri);
         oklahoma.addNeighbor(newMexico);
         oklahoma.addNeighbor(texas);
         oklahoma.addNeighbor(arkansas);
         oklahoma.addNeighbor(colorado);
         oklahoma.addNeighbor(kansas);

         oregon.addNeighbor(nevada);
         oregon.addNeighbor(washington);
         oregon.addNeighbor(california);
         oregon.addNeighbor(idaho);

         pennsylvania.addNeighbor(newYork);
         pennsylvania.addNeighbor(ohio);
         pennsylvania.addNeighbor(westVirginia);
         pennsylvania.addNeighbor(delaware);
         pennsylvania.addNeighbor(maryland);
         pennsylvania.addNeighbor(newJersey);

         rhodeIsland.addNeighbor(massachusetts);
         rhodeIsland.addNeighbor(newYork);
         rhodeIsland.addNeighbor(connecticut);

         southCarolina.addNeighbor(northCarolina);
         southCarolina.addNeighbor(georgia);

         southDakota.addNeighbor(nebraska);
         southDakota.addNeighbor(northDakota);
         southDakota.addNeighbor(wyoming);
         southDakota.addNeighbor(iowa);
         southDakota.addNeighbor(minnesota);
         southDakota.addNeighbor(montana);

         tennessee.addNeighbor(mississippi);
         tennessee.addNeighbor(missouri);
         tennessee.addNeighbor(northCarolina);
         tennessee.addNeighbor(virginia);
         tennessee.addNeighbor(alabama);
         tennessee.addNeighbor(arkansas);
         tennessee.addNeighbor(georgia);
         tennessee.addNeighbor(kentucky);

         texas.addNeighbor(newMexico);
         texas.addNeighbor(oklahoma);
         texas.addNeighbor(arkansas);
         texas.addNeighbor(louisiana);

         utah.addNeighbor(nevada);
         utah.addNeighbor(newMexico);
         utah.addNeighbor(wyoming);
         utah.addNeighbor(arizona);
         utah.addNeighbor(colorado);
         utah.addNeighbor(idaho);

         vermont.addNeighbor(newHampshire);
         vermont.addNeighbor(newYork);
         vermont.addNeighbor(massachusetts);

         virginia.addNeighbor(northCarolina);
         virginia.addNeighbor(tennessee);
         virginia.addNeighbor(westVirginia);
         virginia.addNeighbor(kentucky);
         virginia.addNeighbor(maryland);

         washington.addNeighbor(oregon);
         washington.addNeighbor(idaho);

         westVirginia.addNeighbor(pennsylvania);
         westVirginia.addNeighbor(virginia);
         westVirginia.addNeighbor(kentucky);
         westVirginia.addNeighbor(maryland);
         westVirginia.addNeighbor(ohio);

         wisconsin.addNeighbor(michigan);
         wisconsin.addNeighbor(minnesota);
         wisconsin.addNeighbor(illinois);
         wisconsin.addNeighbor(iowa);

         wyoming.addNeighbor(nebraska);
         wyoming.addNeighbor(southDakota);
         wyoming.addNeighbor(utah);
         wyoming.addNeighbor(colorado);
         wyoming.addNeighbor(idaho);
         wyoming.addNeighbor(montana);

         //Randomly order the map by selecting a random value in the OrderedList
        ArrayList<State> mapRandom = new ArrayList<>();

        //Select the root node in the list

        Random rng = new Random();

        int selection = rng.nextInt(mapOrdered.size());

        State temp = mapOrdered.get(selection);

        mapRandom.add(temp);
        mapOrdered.remove(selection);

        while (!mapOrdered.isEmpty()) {

            selection = rng.nextInt(mapOrdered.size());

            temp.next = mapOrdered.get((selection));

            mapRandom.add(temp.next);
            mapOrdered.remove(selection);

            temp = temp.next;

        }

        return mapRandom;
    }

}
