package community.com;
 
import java.io.Serializable;
import java.util.Objects;
 
/**
 * Student class
 * 
 * @author viettuts.vn
 */
public class Student implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private String name;
    private String clas;
    private int age;
    /* điểm trung bình của sinh viên */
    private double gpa;
	
 
    public Student() {
    }
 
    public Student(int id, String name,String clas, int age, double gpa) {
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
    public int getAge() {
        return age;
    }
 
    public void setAge(int age) {
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
        return Objects.hash(id, name, clas, age,gpa);
    }
    @Override
    public String toString() {
        return "Student [code=" + id + ", fullName=" + name + ", birthYear=" + age + ", className="
                + clas + ", averageGrade=" + gpa + "]";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && age ==student.age && Double.compare(student.gpa, gpa) == 0  && name.equals(student.name)   && clas.equals(student.clas);
}
    public int compareTo(Student o) {
        return (int) (this.getGpa() - o.getGpa());
    }
    public String getInfo() {
        return this.id + "," + this.name + "," + this.age + "," + this.clas + "," +  this.gpa;
    }

}
















