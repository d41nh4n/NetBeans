/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.Booking;
import model.UsingRoom;

/**
 *
 * @author Dai Nhan
 */
public class Service {

    public boolean checkDateInOfRoom(Booking booking) {
        UsingRoom usingRoom = new UsingRoom().getById(booking.getRoomNumber());
        List<Booking> bookingList = new Booking().getByRoomNum(booking.getRoomNumber());

        return checkOnBookingList(bookingList, booking) && checkOnUsingRoom(usingRoom, booking);
    }

    public boolean checkOnUsingRoom(UsingRoom usingRoom, Booking booking) {
        if (usingRoom == null) {
            return true;
        }

        if (usingRoom.getDatein().before(booking.getDateIn())) {
            return usingRoom.getDateout().before(booking.getDateIn());
        } else {
            return usingRoom.getDatein().after(booking.getDateOut());
        }
    }

    public boolean checkOnBookingList(List<Booking> bookingList, Booking booking) {
        if (!bookingList.isEmpty()) {
            bookingList.add(booking);
            Booking.sortByDateIn(bookingList);

            for (Booking b : bookingList) {
                System.out.println(b.toString());
            }
            int index = bookingList.indexOf(booking);
            System.out.println(index);
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

    public static void main(String[] args) {
        Date dateIn = new Date(2023 - 1900, 9, 29); // Năm 2023, tháng 10 (index bắt đầu từ 0), ngày 29
        Date dateOut = new Date(2023 - 1900, 10, 1); // Năm 2023, tháng 11 (index bắt đầu từ 0), ngày 1

        Service s = new Service();

        System.out.println(s.checkDateInOfRoom(new Booking("", "", "P101", dateIn, dateOut, dateIn, 0f, "")));
    }
}
