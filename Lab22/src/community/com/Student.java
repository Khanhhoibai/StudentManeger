package community.com;

import java.io.Serializable;
import java.util.Objects;

/**
 * Student class
 * 
 * @author viettuts.vn
 */
public class Student implements Comparable<Student>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String clas;
	private String age;
	/* điểm trung bình của sinh viên */
	private double gpa;

	public Student() {
	}

	public Student(int id, String name, String clas, String age, double gpa) {
		super();
		this.id = id;
		this.name = name;
		this.clas = clas;
		this.age = age;
		this.gpa = gpa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClas() {
		return clas;
	}

	public void setClas(String clas) {
		this.clas = clas;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, clas, gpa, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(age, other.age) && Objects.equals(clas, other.clas)
				&& Double.doubleToLongBits(gpa) == Double.doubleToLongBits(other.gpa) && id == other.id
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", clas=" + clas + ", age=" + age + ", gpa=" + gpa + "]";
	}

	public int compareTo(Student o) {
		return (int) (this.getGpa() - o.getGpa());
	}

	public String getInform() {
		return this.id + "," + this.name + "," + this.age + "," + this.clas + "," + this.gpa;
	}

}
