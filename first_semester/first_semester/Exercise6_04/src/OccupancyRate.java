import java.util.Scanner;


public class OccupancyRate {

	public static void main(String[] args)
	{
	// Find a hotels occupancy rate
	// Occupancy rate: no. rooms occupied / total rooms
	// Ask for total floors
	// Then loop through each floor, asking for no. of occupied rooms in each
	double occupancyRate;
	double totalFloors, totalRooms = 0, totalOccupancy = 0, totalRoomsOnFloor, occupiedRoomsOnFloor;
	Scanner key = new Scanner(System.in);
	System.out.println("How many floors in the hotel?");
	totalFloors = key.nextInt();
	for (int i = 1; i <= totalFloors; i++)
	{
	System.out.println("Floor number " + i);
	System.out.println("How many total rooms on this floor?");
	totalRoomsOnFloor = key.nextInt();
	System.out.println("How many occupied rooms on this floor?");
	occupiedRoomsOnFloor = key.nextInt();
	totalRooms += totalRoomsOnFloor;
	totalOccupancy += occupiedRoomsOnFloor;
	}
	occupancyRate = (totalOccupancy / totalRooms);
	System.out.println("Occupancy rate is: " + (int) (occupancyRate * 100) + "%");
	}
}
