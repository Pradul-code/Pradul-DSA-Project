import java.util.*;

class Student {
    int id;
    String name;
    String course;
    double cgpa;

    Student(int id, String name, String course, double cgpa) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.cgpa = cgpa;
    }

    void display() {
        System.out.println(id + " | " + name + " | " + course + " | " + cgpa);
    }
}

public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    static HashMap<Integer, Student> map = new HashMap<>();
    static int nextId = 101;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Sort by CGPA");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter CGPA: ");
                    double cgpa = sc.nextDouble();
                    sc.nextLine();

                    if (cgpa < 0 || cgpa > 10) {
                        System.out.println("Invalid CGPA!");
                        break;
                    }

                    Student s = new Student(nextId++, name, course, cgpa);

                    students.add(s);
                    map.put(s.id, s);

                    System.out.println("Student Added! ID: S" + s.id);
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (Student st : students) {
                            st.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int searchId = sc.nextInt();

                    Student found = map.get(searchId);

                    if (found != null) {
                        found.display();
                    } else {
                        System.out.println("Student Not Found!");
                    }
                    break;

                case 4:
                    students.sort(
                        Comparator.comparingDouble(
                            (Student st) -> st.cgpa
                        ).reversed()
                    );

                    System.out.println("Students Sorted by CGPA:");
                    for (Student st : students) {
                        st.display();
                    }
                    break;

                case 5:
                    System.out.print("Enter Student ID: ");
                    int deleteId = sc.nextInt();

                    Student deleted = map.remove(deleteId);

                    if (deleted != null) {
                        students.remove(deleted);
                        System.out.println("Student Deleted!");
                    } else {
                        System.out.println("Student Not Found!");
                    }
                    break;

                case 6:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}