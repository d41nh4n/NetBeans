package model;

import dal.NumberUserDao;
import java.util.ArrayList;

/**
 * Represents the many-to-many relationship between Customer and UsingRoom. This
 * class serves as the intermediary between Customer and UsingRoom through the
 * NumberUser table.
 */
public class NumberUser {

    private ArrayList<Customer> customers;
    private UsingRoom usingRoom;

    public NumberUser() {
        this.customers = new ArrayList<>();
    }

    public NumberUser(ArrayList<Customer> customers, UsingRoom usingRoom) {
        this.customers = customers;
        this.usingRoom = usingRoom;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public UsingRoom getUsingRoom() {
        return usingRoom;
    }

    public void setUsingRoom(UsingRoom usingRoom) {
        this.usingRoom = usingRoom;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public int insert(NumberUser numberUser) {
        return new NumberUserDao().insert(numberUser);
    }

    public int delete(Customer customer) {
        return new NumberUserDao().delete(customer.getId());
    }

    public NumberUser getByRoom(Room room) {
        return new NumberUserDao().getByRoomNumber(room.getRoomNum());
    }
    
    public int delete(NumberUser numberUser){
        return new NumberUserDao().delete(numberUser.getUsingRoom().getRoomNum());
    }
}
