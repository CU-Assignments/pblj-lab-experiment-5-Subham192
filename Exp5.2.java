import java.io.*;
class Student implements Serializable {
private static final long serialVersionUID = 1L;
private int id;
private String name;
private double gpa:
public Student(int id, String name, double gpa) {
this.id = id;
this.name = name;
this.gpa = gpa;
}
public int getId() {
return id;
}
public String getName() {
  return name;
}
public double getGpa() {
return gpa;
}
@Override
public String toString() {
return "Student ID: " + id + ", Name: " + name + ", GPA: " + gpa;
}
}
public class StudentSerializationDemo {
public static void serializeStudent(Student student, String filename) {
try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
oos.writeObject(student);
System.out.println("Student object has been serialized and saved to file.");
} catch (FileNotFoundException e) {
System.out.println("Error: File not found.");
} catch (IOException e) {
System.out.println("Error: IO Exception occurred.");
}
}
public static Student deserializeStudent(String filename) {
try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
Student student = (Student) ois.readObject();
System.out.println("Student object has been deserialized.");
return student;
} catch (FileNotFoundException e) {
System.out.println("Error: File not found.");
} catch (IOException e) {
System.out.println("Error: IO Exception occurred.");
} catch (ClassNotFoundException e) {
System.out.println("Error: Class not found.");
}
return null;
}
public static void main(String[] args) {
Student student = new Student(1, "John Doe", 3.75);
  String filename = "student.ser";
serializeStudent(student, filename);
Student deserializedStudent = deserializeStudent(filename);
if (deserializedStudent != null) {
  System.out.println("Deserialized Student Details:");
System.out.println(deserializedStudent);
}
deserializeStudent("non_existent_file.ser");
}
}
