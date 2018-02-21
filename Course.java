import java.util.*;
public class Course {

	private String name;
	private ArrayList<Student> students = new ArrayList<Student>();
	
	public Course (String text){
		name=text;
	}
	
	public void addStudent (Student s){
		students.add(s);
	}
	
	public String getName(){
		return name;
	}
	
	public void printStudents (){
		for(int i=0; i<students.size(); i++)
		System.out.println(students.get(i).getName());
		
	}
	
	//**********************
	
	public String getStudentNames(){
		String output = "" ;
		for (int i=0; i<students.size();i++){
			output+= students.get(i).getName();
			output+= '\n';
			
		}
		return output;
	}
}
