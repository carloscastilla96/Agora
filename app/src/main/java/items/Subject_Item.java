package items;

import java.io.Serializable;

public class Subject_Item implements Serializable {

	private int color;
	String schedule;
	String nameSubject;
	String classroom;
	private static final long serialVersionUID = 5L;

	/**
	 * los items contienen solo la información de cada Materia. los nombres de
	 * las variables son lo sufientemente claros para saber que se está almacenando
	 * 
	 * @author Andres
	 *
	 */
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	private int r;
	private int g;
	private int b;

	public Subject_Item(String schedule, String nameSubject, String classroom, int r, int g, int b) {
		this.r=r;
		this.g=g;
		this.b=b;
		this.schedule = schedule;
		this.classroom = classroom;
		this.nameSubject = nameSubject;
		this.color = r;
	}

	public String getSchedule() {
		return schedule;
	}

	public String getNameSubject() {
		return nameSubject;
	}

	public String getClassroom() {
		return classroom;
	}

	public int getColor() {
		return color;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

}
