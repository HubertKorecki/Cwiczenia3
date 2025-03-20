import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

    class Student {
        public String fname;
        public String lname;
        public String indexNumber;
        public String email;
        public String address;
        public List<Integer> grades;
        public List<StudentGroup> groups;

        public Student(String fname, String lname, String indexNumber, String email, String address, List<Integer> grades) {
            this.fname = fname;
            this.lname = lname;
            this.indexNumber = indexNumber;
            this.email = email;
            this.address = address;
            this.grades = grades;
            this.groups = new ArrayList<>();
        }

        public void assignToGroup(StudentGroup group) {
            if (!groups.contains(group)) {
                groups.add(group);
                group.addStudent(this);
            }
        }
    }

    class StudentGroup {
        public String name;
        public List<Student> students;

        public StudentGroup(String name) {
            this.name = name;
            this.students = new ArrayList<>();
        }

        public void addStudent(Student student) {
            if (!students.contains(student)) {
                students.add(student);
            }
        }
    }

    public class Main {
        public static void main(String[] args) {
            List<Integer> grades = new ArrayList<>();
            grades.add(4);
            grades.add(5);
            grades.add(3);
            grades.add(4);

            Student student1 = new Student("Jan", "Kowalski", "s12345", "jan.kowalski@example.com", "ul. Warszawska 10", grades);
            Student student2 = new Student("Hubert", "Korecki", "s33672", "s33672@pjwstk.edu.pl", "ul. Nowogrodzka", grades);

            StudentGroup group1 = new StudentGroup("Informatyka 2025");
            student1.assignToGroup(group1);
            student2.assignToGroup(group1);

            System.out.println("Student " + student2.fname + " należy do grup:");
            for (StudentGroup g : student2.groups) {
                System.out.println("- " + g.name);
            }

            System.out.println("Grupa " + group1.name + " zawiera studentów:");
            for (Student s : group1.students) {
                System.out.println("- " + s.fname + " " + s.lname);
            }
        }
    }
