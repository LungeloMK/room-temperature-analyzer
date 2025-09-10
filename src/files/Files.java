package files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Files {

    public static void main(String[] args) {
        File inputFile = new File("roomtemps.txt");
        File outputFile = new File("temps_summary.txt");

        HashMap<String, Double> roomAverages = new HashMap<>();
        double totalSum = 0;
        int totalCount = 0;

        String hottestRoom = "";
        double hottestAvg = Double.MIN_VALUE;

        // Decimal formats
        DecimalFormat df2 = new DecimalFormat("0.00");   // for per-room averages
        DecimalFormat df3 = new DecimalFormat("0.000");  // for overall average
        DecimalFormat df1 = new DecimalFormat("0.0");    // for hottest room value

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String room = parts[0]; // first element is the room number
                double sum = 0;

                // process the 5 temperature readings
                for (int i = 1; i < parts.length; i++) {
                    double value = Double.parseDouble(parts[i]);
                    sum += value;
                    totalSum += value;
                    totalCount++;
                }

                double avg = sum / (parts.length - 1);
                roomAverages.put(room, avg);

                // check if this is the hottest room
                if (avg > hottestAvg) {
                    hottestAvg = avg;
                    hottestRoom = room;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        double overallAverage = totalSum / totalCount;

        // Write to temps_summary.txt
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("Per-room averages:\n");
            for (Map.Entry<String, Double> entry : roomAverages.entrySet()) {
                bw.write(entry.getKey() + ": " + df2.format(entry.getValue()) + "\n");
            }
            bw.write("\nOverall average: " + df3.format(overallAverage) + "\n");
            bw.write("Hottest room: " + hottestRoom + " (" + df1.format(hottestAvg) + ")\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("temps_summary.txt generated successfully.");
    }
}
