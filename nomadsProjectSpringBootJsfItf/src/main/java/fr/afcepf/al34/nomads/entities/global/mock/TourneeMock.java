package fr.afcepf.al34.nomads.entities.global.mock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TourneeMock implements Comparable<TourneeMock> {
	private Date date;
	private Date timeStart;
	private Date timeEnd;
	private String lieu;
	private String id;

	
	public TourneeMock(String id, Date date, Date timeStart, Date timeEnd, String lieu) {
		this();
		setId(id);
		setDate(date);
		setTimeStart(timeStart);
		setTimeEnd(timeEnd);
		setLieu(lieu);
	}

	public TourneeMock() {
		super();
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}

	public Date getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTimeStartString() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");

		return dateFormat.format(getTimeStart());
	}

	public String getDateStartString() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		return dateFormat.format(getDate());
	}

	public String getDateStartStringForSorting() {
		return getDateStartString()+";"+getTimeStartString();
	}

	public String getDateStartStringDisplay() {
		DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy");

		return dateFormat.format(getDate());
	}

	public boolean isDay(String date) {

		return date.equals(getDateStartString());
	}

	public int compareTo(TourneeMock tourner) {
		int c=tourner.getDate().compareTo(getDate());
		if(c==0) {
			c=tourner.getTimeStart().compareTo(getTimeStart());
		}
		return c;
	}

}
