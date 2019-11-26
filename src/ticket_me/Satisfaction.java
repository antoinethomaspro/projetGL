package ticket_me;

public class Satisfaction {
	 private  int id;
     private int Note;
     private Technicians technicien;

    public Satisfaction() {

    } 
     
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNote() {
		return Note;
	}
	public void setNote(int note) {
		Note = note;
	}
	public Technicians getTechnicien() {
		return technicien;
	}
	public void setTechnicien(Technicians technicien) {
		this.technicien = technicien;
	}


}
