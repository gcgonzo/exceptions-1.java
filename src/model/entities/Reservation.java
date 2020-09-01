package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	// Foi usado o static para não colocarem outra formatação em outra parte do programa
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		
		long diff = checkOut.getTime() - checkIn.getTime();//calcula a diferença entre as datas em milisegundos
		//return TimeUnit.DAYS.convert(diff, TimeUnit.MICROSECONDS);//comando para converter milisegundos para dias
		 return TimeUnit.MILLISECONDS.toDays(diff);
	}
	
	public void updateDates(Date chekIn, Date chekOut) {
		this.checkIn = chekIn;
		this.checkOut = chekOut;
	}

	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", CheckIn: "
				+ sdf.format(checkIn)
				+", CheckOut: "
				+sdf.format(checkOut)
				+", "
				+ duration()
				+ " nights";
	}
}
