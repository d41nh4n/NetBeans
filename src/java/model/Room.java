package model;

import dal.RoomDao;
import java.util.List;

/**
 *
 * @author Dai Nhan
 */
public class Room {

    private String roomNum;
    private boolean available;
    private int idType;
    private String typeName;
    private Float pricePerMonth;
    private Float pricePerDay;
    private UsingRoom usingRoom;

    public Room() {
    }

    public Room(String roomNum, boolean available, int idType, String typeName, Float pricePerMonth, Float pricePerDay) {
        this.roomNum = roomNum;
        this.available = available;
        this.idType = idType;
        this.typeName = typeName;
        this.pricePerMonth = pricePerMonth;
        this.pricePerDay = pricePerDay;
        this.usingRoom = null;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Float getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(Float pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    public Float getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Float pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public UsingRoom getUsingRoom() {
        return usingRoom;
    }

    public void setUsingRoom(UsingRoom usingRoom) {
        this.usingRoom = usingRoom;
    }

    public void checkIn(UsingRoom usingRoom) {
        setAvailable(false);
        this.usingRoom = usingRoom;
    }

    public void checkOut() {
        setAvailable(true);
        this.usingRoom = null;
    }

    @Override
    public String toString() {
        return "Room{" + "roomNum=" + roomNum + ", available=" + available + ", idType=" + idType + ", typeName=" + typeName + ", pricePerMonth=" + pricePerMonth + ", pricePerDay=" + pricePerDay + ", usingRoom=" + usingRoom + '}';
    }

    public List<Room> getAll() {
        List<Room> list = new RoomDao().getAll();
        UsingRoom usingRoom = new UsingRoom();
        for (Room room : list) {
            UsingRoom temp = usingRoom.getById(room.getRoomNum());
            if (temp != null) {
                room.checkIn(temp);
            }
        }
        return list;
    }

    public Room getById(String id) {
        Room room = new RoomDao().getById(id);
        UsingRoom usingRoom = new UsingRoom().getById(id);
        if (room != null) {
            room.setUsingRoom(usingRoom);
        }
        return room;
    }

    public static void main(String[] args) {
   
        System.out.println(new Room().getById("P101"));
    }
}
