package collection.sortingcollection;

	public class Student implements Comparable<Student>{
		
		private int studentId;
		private String studentName;
		private float studentMarks;
		
		public Student() {
			// TODO Auto-generated constructor stub
		}

		public Student(int studentId, String studentName, float studentMarks) {
			super();
			this.studentId = studentId;
			this.studentName = studentName;
			this.studentMarks = studentMarks;
		}

		public int getStudentId() {
			return studentId;
		}

		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}

		public String getStudentName() {
			return studentName;
		}

		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}

		public float getStudentMarks() {
			return studentMarks;
		}

		public void setStudentMarks(float studentMarks) {
			this.studentMarks = studentMarks;
		}
		
		public int compareTo(Student st) {
			if(this.studentMarks == st.studentMarks)
				return 0;
			else
				return this.studentMarks > st.studentMarks ? 1 : -1;
		}
		
		
		

	}





}
