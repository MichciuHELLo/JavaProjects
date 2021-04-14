package hackerRank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
//import java.util.PriorityQueue;


class Student{
	private int id;
	private String name;
	private double cgpa;
	
	public Student(int id, String name, double cgpa) {
		//super();
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
	}
	
	public int getID() { return id; }
	
	public String getName() { return name; }
	
	public double getCGPA() { return cgpa; }
}


class Priorities{
	public List<Student> getStudents(List<String> events) {
		PriorityQueue<Student> Q = new PriorityQueue(Comparator.comparing(Student::getCGPA).reversed().thenComparing(Student::getName).thenComparing(Student::getID));
		
		List<Student>students = new ArrayList<>();
		for(String e : events) {
			Scanner scan = new Scanner(System.in);
			String event = scan.next();
			
			if(event == "ENTER") {
				double cgpa = scan.nextDouble();
				String name = scan.next();
				int id = scan.nextInt();
				Student student = new Student(id, name, cgpa);
				Q.add(student);
			}
			else if(event == "SERVED") {
				Student first = Q.poll();
			}
			scan.close();
		}
		
		Student first = Q.poll();
		if(first == null) {
			return students;
		}
		else {
			while(first != null) {
				students.add(first);
				first = Q.poll();
			}
			return students;
		}
	}
}


public class PriorityQueue {
	private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
