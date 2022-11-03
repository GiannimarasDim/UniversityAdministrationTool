package gr.aueb.cf.teachersapp.model;

public class Student {

	public int Id ;
    public String Firstname;
    public String Lastname ;
    
    public Student() {}
    
    
	public Student(int id, String firstname, String lastname) {
		super();
		Id = id;
		Firstname = firstname;
		Lastname = lastname;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
    
    
}
