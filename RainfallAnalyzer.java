package qn4_naro;

import java.util.Random;

public class RainfallAnalyzer {
    public static void main(String[] args) {
        // Declare a single-dimensional array for 30 days of rainfall data
        double[] dailyRainfall = new double[30];
        Random randomGenerator = new Random();

        double totalRainfallSum = 0.0;
        int wetDaysCounter = 0;

        System.out.println("=== NARO IoT Sensor Array Data Logs ===");
        
        // Loop through the 30 days to generate and process readings
        for (int i = 0; i < dailyRainfall.length; i++) {
            // Generate a random rainfall reading between 0.0mm and 60.0mm
            dailyRainfall[i] = 0.0 + (60.0 * randomGenerator.nextDouble());
            
            // Print the daily reading formatted to two decimal places
            System.out.printf("Day %d Sensor Reading: %.2f mm\n", (i + 1), dailyRainfall[i]);

            // Accumulate the running total
            totalRainfallSum += dailyRainfall[i];

            // Count the day as a wet day if rainfall exceeds 30.0mm
            if (dailyRainfall[i] > 30.0) {
                wetDaysCounter++;
            }
        }

        // Calculate the monthly average
        double averageDailyRainfall = totalRainfallSum / dailyRainfall.length;

        // Determine the regional classification based on environmental limits
        String climateClassification;
        if (totalRainfallSum <= 300.0) {
            climateClassification = "Dry Category";
        } else if (totalRainfallSum < 600.0) {
            climateClassification = "Normal Category";
        } else {
            climateClassification = "Flood Risk Warning Level";
        }

        // Print the final analysis report
        System.out.println("\n=== Monthly Analytical Summary Report ===");
        System.out.printf("Total Accumulated Rainfall: %.2f mm\n", totalRainfallSum);
        System.out.printf("Calculated Daily Average  : %.2f mm\n", averageDailyRainfall);
        System.out.println("Total Number of Wet Days  : " + wetDaysCounter);
        System.out.println("Seasonal Climate Status   : " + climateClassification);
    }
}