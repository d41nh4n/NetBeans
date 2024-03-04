/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.sql.Date;
import java.util.Random;

/**
 *
 * @author Dai Nhan
 */
public class Utils {

    public static Date convertStringToDate(String dateString) {
        return Date.valueOf(dateString);
    }

    public static String randomIdBooking(String roomNumber) {
        Random random = new Random();
        char floor = roomNumber.charAt(1);
        int id;
        switch (floor) {
            case '1':
                id = random.nextInt(1000) + 1000;
                break;
            case '2':
                id = random.nextInt(1000) + 2000;
                break;
            case '3':
                id = random.nextInt(1000) + 3000;
                break;
            case '4':
                id = random.nextInt(1000) + 4000;
                break;
            case '5':
                id = random.nextInt(1000) + 5000;
                break;
            case '6':
                id = random.nextInt(1000) + 6000;
                break;
            default:
                id = -1; // or handle this case appropriately
        }
        return String.valueOf(id);
    }

    public static float parseFloatParameter(String parameter) {
        if (parameter != null && !parameter.trim().isEmpty()) {
            try {
                return Float.parseFloat(parameter.trim());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return 0.0f;
    }

    public static int parseIntParameter(String id) {
        try {
            return Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static boolean parseBooleanParameter(String parameter) {
        return parameter.equalsIgnoreCase("true");
    }
    
    public static void main(String[] args) {
        System.out.println(randomIdBooking("P101"));
    }
}
