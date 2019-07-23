import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        Set<String> parkingLot = new HashSet<>();

        String input = "";

        while (!"END".equals(input = reader.readLine())) {
            String[] data = input.split("[, ]+");
            String command = data[0];
            String carNumber = data[1];

            if (command.equals("IN")) {
                parkingLot.add(carNumber);
            } else {
                parkingLot.remove(carNumber);
            }
        }

        if (parkingLot.size() > 0) {
            for (String s : parkingLot) {
                System.out.println(s);
            }
        } else {
            System.out.println("Parking Lot is Empty");
        }
    }
}
