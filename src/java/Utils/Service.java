/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.sql.Date;
import java.util.List;
import model.Booking;
import model.Room;
import model.UsingRoom;

/**
 *
 * @author Dai Nhan
 */
public class Service {

    public static Float countTotalPrice(Date dateIn, Date dateOut, String roomNum) {
        long differenceInMilliseconds = dateOut.getTime() - dateIn.getTime();
        int daysUse = (int) (differenceInMilliseconds / (1000 * 60 * 60 * 24));
        float total;
        Room room = new Room().getById(roomNum);
        if (daysUse < 27) {
            total = room.getPricePerDay() * daysUse;
        } else {
            total = room.getPricePerMonth() * countMonth(daysUse);
        }
        return total;
    }

    private static int countMonth(int days) {
        if (days <= 30 && days >= 27) {
            return 1;
        } else {
            int month = 0;
            int daysTemp = days;
            while (daysTemp > 0) {
                System.out.println(daysTemp);
                System.out.println(month);
                daysTemp -= 30;
                System.out.println(daysTemp);
                month++;
            }
            return month;
        }
    }

    public static void main(String[] args) {
        Date datei = new Date(1900, 10, 1);
        Date dateo = new Date(1900, 13, 1);
        Service s = new Service();
        System.out.println(s.countTotalPrice(datei, dateo, "P101"));
    }
}
