import java.util.*;
public class Registry {

	private ArrayList<Course> courses = new ArrayList<Course>();
	
	public Registry(){
		
		courses.add(new Course ("Math"));
		courses.add(new Course ("Java"));
		courses.add(new Course ("Databases"));
		courses.add(new Course ("Econometrics"));
	}
	
	public String[] getCourseNames(){
		
		String[] names = new String[4];
		for (int i=0; i<courses.size();i++){
			names [i] = courses.get(i).getName();
		}
		return names;
	}
	
	public Course getCourse (String title) {
		for(int i=0; i<courses.size(); i++)
			if (title.equals(courses.get(i).getName()))
				return courses.get(i);
			return null;
	}
		
	
		public void printAllStudents(){
			for (int i=0;i<courses.size();i++){
				System.out.println(courses.get(i).getName());
				System.out.println("------------------");
				courses.get(i).printStudents();
			}
		}
		
		//************************************************//
		
		public String getCourseStudents(){
			String output = "";
			for (int i=0;i<courses.size();i++){
				output += courses.get(i).getName();
				output += '\n';
				output += courses.get(i).getStudentNames();
				output += '\n';
			}
			return output;
		}
		
	}

