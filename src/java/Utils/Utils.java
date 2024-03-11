/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.sql.Date;
import java.util.List;
import java.util.Random;
import model.Booking;
import model.UsingRoom;

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

    //check Date in
    public static boolean checkDateInOfRoom(Booking booking) {
        UsingRoom usingRoom = new UsingRoom().getById(booking.getRoomNumber());
        List<Booking> bookingList = new Booking().getByRoomNum(booking.getRoomNumber());

        return checkOnBookingList(bookingList, booking) && checkOnUsingRoom(usingRoom, booking);
    }

    public static boolean checkOnUsingRoom(UsingRoom usingRoom, Booking booking) {
        if (usingRoom == null) {
            return true;
        }

        if (usingRoom.getDatein().before(booking.getDateIn())) {
            return usingRoom.getDateout().before(booking.getDateIn());
        } else {
            return usingRoom.getDatein().after(booking.getDateOut());
        }
    }

    public static boolean checkOnBookingList(List<Booking> bookingList, Booking booking) {
        if (!bookingList.isEmpty()) {
            bookingList.add(booking);
            Booking.sortByDateIn(bookingList);

            for (Booking b : bookingList) {
                System.out.println(b.toString());
            }
            int index = bookingList.indexOf(booking);
            int lastIndex = bookingList.size() - 1;
            if (index == 0) {
                return booking.getDateOut().before(bookingList.get(1).getDateIn());
            } else if (index == lastIndex) {
                return (booking.getDateIn().after(bookingList.get(lastIndex - 1).getDateOut()));
            } else {
                return (booking.getDateIn().after(bookingList.get(index - 1).getDateOut()) && booking.getDateOut().before(bookingList.get(index + 1).getDateIn()));
            }
        }
        return true;
    }

    // check Date in UsingRoom
    public static boolean checkDateInUsingRoom(UsingRoom usingRoom) {
        List<Booking> bookingList = new Booking().getByRoomNum(usingRoom.getRoomNum());

        if (bookingList.isEmpty() || bookingList.size() == 1) {
            return true;
        }

        Booking bookingFake = new Booking("", "", usingRoom.getRoomNum(), usingRoom.getDatein(), usingRoom.getDatein(), null, 0f, "");
        bookingList.add(bookingFake);
        Booking.sortByDateIn(bookingList);

        int index = bookingList.indexOf(bookingFake);
        int lastIndex = bookingList.size() - 1;

        if (index == 0) {
            return bookingFake.getDateOut().before(bookingList.get(1).getDateIn());
        } else if (index == lastIndex) {
            return (bookingFake.getDateIn().after(bookingList.get(lastIndex - 1).getDateOut()));
        } else {
            return (bookingFake.getDateIn().after(bookingList.get(index - 1).getDateOut()) && bookingFake.getDateOut().before(bookingList.get(index + 1).getDateIn()));
        }
    }

    public static void main(String[] args) {
        System.out.println(randomIdBooking("P101"));
    }
}
