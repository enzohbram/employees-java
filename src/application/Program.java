package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employees;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employees> list = new ArrayList<>();
		
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			System.out.println("Employee #" + (i+1));
			System.out.print("Id: ");
			int ID = sc.nextInt();
			while (hasId(list, ID)) {
				System.out.print("Id already taken. Try again: ");
				ID = sc.nextInt();
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			list.add(new Employees(ID, name, salary));
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Enter the employee id that will have salary increase :");
		int ID = sc.nextInt();
		Employees emp = list.stream().filter(x -> x.getID() == ID).findFirst().orElse(null);
		if (emp == null) {
			System.out.println("This id does not exist!");
		}
		else {
			System.out.println("Enter the percentage: ");
			double percent = sc.nextDouble();
			emp.increaseSalary(percent);
		}
		
		System.out.println();
		System.out.println("List of employees");
		for (Employees empls : list) {
			System.out.println(empls);
		}
				
		sc.close();
	}

	public static boolean hasId(List<Employees> list, int id) {
		Employees emp = list.stream().filter(x -> x.getID() == id).findFirst().orElse(null);
		return emp != null;
	}
	
}
