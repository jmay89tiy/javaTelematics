package com.company;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) throws Exception {

        VehicleInfo vehicleInfo = new VehicleInfo();

        System.out.println("Hello. I'll my name is JoshBot and I'll be assisting you today");
        System.out.println("Please enter your vehicle vin number");
        Scanner scanner = new Scanner(System.in);
        String vinInput = scanner.nextLine();
        vehicleInfo.setVin((vinInput));
        System.out.println(vehicleInfo.getVin());
        System.out.println("That's great, the vin number helps us learn a lot about your vehicle, but there are a few more questions we still need to ask so you get the best experience while here");
        System.out.println("Please enter the amount of miles traveled since your last oil change");
        String odomMilesTraveled = scanner.nextLine();
        vehicleInfo.setOdometerMilesTraveled(Double.parseDouble(odomMilesTraveled));
        System.out.println("Excellent, and how many gallons of gas did you consume?");
        String galConsumed = scanner.nextLine();
        vehicleInfo.setConsumption(Double.parseDouble(galConsumed));
        System.out.println("Please enter the odometer reading from your last oil change *check the little sticker on your windshield*");
        String odomInitial = scanner.nextLine();
        vehicleInfo.setOdometerInitialMiles(Double.parseDouble(odomInitial));
        System.out.println("And last but not least, what size engine are we working with today, in liters?");
        String engSize = scanner.nextLine();
        vehicleInfo.setEngineSize(Double.parseDouble(engSize));

        TelematicsService ts = new TelematicsService();
        ts.report(vehicleInfo);
    }
}
