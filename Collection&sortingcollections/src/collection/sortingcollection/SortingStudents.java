package collection.sortingcollection;

import java.util.ArrayList;
import java.util.Collections;


public class SortingStudents {

		public static void main(String[] args) {
			Student st = new Student(34542,"Ram",45.55f);
			Student st1 = new Student(34543,"Kavi",55.68f);
			Student st2 = new Student(34544,"Raja",45.97f);
			ArrayList<Student> data = new ArrayList<Student>();
			data.add(st);
			data.add(st1);
			data.add(st2);
			
			System.out.println("Elements of the arraylist");
			for(Student std:data) {
				System.out.println(std.getStudentId() + "\t" + std.getStudentName() + "\t" + std.getStudentMarks());
			}
			
			Collections.sort(data);
			
			System.out.println("Elements of students after sort");
			for(Student std:data) {
				System.out.println(std.getStudentId() + "\t" + std.getStudentName() + "\t" + std.getStudentMarks());
			}
		}

	}

}
