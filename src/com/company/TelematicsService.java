package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;


public class TelematicsService {

    void report(VehicleInfo vehicleInfo) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(vehicleInfo);
        System.out.println(json);

        try {
            File file = new File((vehicleInfo.getVin()) + ".json");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(json); // this is our json string per above
            fileWriter.close(); //close() cleans up and commits changes
        } //If Java doesn't find the file it will create it for us
        catch (IOException ex) { //A general exception that covers many errors
            ex.printStackTrace();
        }

        // this reads all the json files one at a time.

        File file = new File(".");
        List<VehicleInfo> vehicleInfos = new ArrayList<>();
        for (File f : file.listFiles()) {
            if (f.getName().endsWith(".json")) {
                // Now you have a File object named "f".
                // You can use this to create a new instance of Scanner
                String fileJsonContent = new String(Files.readAllBytes(f.toPath()));
                ObjectMapper mapper2 = new ObjectMapper();
                VehicleInfo vi = mapper2.readValue(fileJsonContent, VehicleInfo.class);
                vehicleInfos.add(vi);
                // above maps vehicleInfo and reads the te value of json in vehicleInfo
            }
        }




        // read in html as a string like we do above

        int total = vehicleInfos.size();

        String html = Dashboard.HTML_TOP.replace("%count%", String.valueOf(total));

        StringBuilder htmlString = new StringBuilder(html);

        for (VehicleInfo vehicleInfo1 : vehicleInfos) {
             html = Dashboard.TABLE_ROW_HTML.replace("%vin%", vehicleInfo1.getVin());
             html = html.replace("%odometer%", String.valueOf(vehicleInfo1.getOdometerMilesTraveled()));
             html = html.replace("%consumption%", String.valueOf(vehicleInfo1.getConsumption()));
             html = html.replace("%lastoilchange%", String.valueOf(vehicleInfo1.getOdometerInitialMiles()));
             html = html.replace("%enginesize%", String.valueOf(vehicleInfo1.getEngineSize()));

             htmlString.append(html);
        }

        htmlString.append(Dashboard.HTML_FOOTER);
       // htmlString.append(Dashboard.TABLE_ROW_HTML);

        try (PrintWriter out = new PrintWriter("Dashboard.html")) {
            out.println(htmlString.toString());
            out.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Caught it!");
        }


           // will be replaced

        //build up a string for all vehicle infos





       // htmlString.replaceFirst("REPLACE_Vin", Integer.toString(vehicleInfos.get(0).getVin()));
//        htmlString.replaceAll("REPLACE_VinAverage", Integer.toString(vehicleInfos.get(0).get()));
//         htmlString.replaceFirst("REPLACE_OdomMilesTraveled", Double.toString(vehicleInfos.get(0).getOdometerMilesTraveled()));
//         htmlString.replaceFirst("REPLACE_Consumption", Double.toString(vehicleInfos.get(0).getConsumption()));
//         htmlString.replaceFirst("REPLACE_OdomInitialMiles", Double.toString(vehicleInfos.get(0).getOdometerInitialMiles()));
//         htmlString.replaceFirst("REPLACE_EngineSize", Double.toString(vehicleInfos.get(0).getEngineSize()));

//        try {
//            File newDashboard = new File("dashboard.html");
//            FileWriter fileWriter = new FileWriter(newDashboard);
//            //fileWriter.write(); //Very simple!
//            fileWriter.write("File IO is cool and not scary!");
//            fileWriter.close(); //close() cleans up and commits changes
//        } //If Java doesn't find the file it will create it for us
//        catch (IOException ex) { //A general exception that covers many errors
//            ex.printStackTrace();
//        }
    }
}
