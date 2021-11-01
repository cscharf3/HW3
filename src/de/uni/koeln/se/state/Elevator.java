package de.uni.koeln.se.state;


public class Elevator{
	
	public static int current_Floor=5;
	int dest_Floor;
	
	private Elv_States State = new Elv_States();
	
	public Elevator (int dest_floor)
	{
		this.dest_Floor=dest_floor;
	System.out.println("*** Destination floor is: "+ dest_Floor);
	arrive_atFloor();


	}

	private void arrive_atFloor() {
		State.Current_State = State.Idle;
		
		if(current_Floor < dest_Floor) {
			go_up();
		}
		else if(current_Floor > dest_Floor) {
			go_down();
		}
		else {
			// exit
			System.out.println("Arrived to destination Floor");
		}
	}
	
	public void go_up() {
		State.Current_State = State.Moving_up;
		current_Floor = current_Floor+1;
		System.out.println("Current Floor is " + current_Floor);
		if(current_Floor < dest_Floor) {
			go_up();
		}
		else {
			arrive_atFloor();
		}
		
	}
	public void go_down() {
		State.Current_State = State.Moving_down;
		current_Floor = current_Floor-1;
		System.out.println("Current Floor is " + current_Floor);
		
		if(current_Floor == dest_Floor) {
			arrive_atFloor();	
		}
		else if(current_Floor > dest_Floor) {
			go_down();
		}
	}
	

	
}