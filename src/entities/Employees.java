package entities;

public class Employees {

	private Integer ID;
	private String name;
	private double salary;
	
	public Employees(Integer iD, String name, double salary) {
		ID = iD;
		this.name = name;
		this.salary = salary;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}
	
	public void increaseSalary (double percent) {
		salary += percent / 100 * salary;
	}
	
	public String toString() {
		return ID + ", " 
				+  name 
				+ ", "
				+ String.format("%.2f%n", salary);
	}
	
}
