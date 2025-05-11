import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Student\n2. View Students\n3. Search by ID\n4. Update Student\n5. Delete Student\n6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    manager.addStudent(new Student(id, name, age));
                    break;
                case 2:
                    manager.viewStudents();
                    break;
                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    Student found = manager.searchById(searchId);
                    System.out.println(found != null ? found : "Not Found");
                    break;
                case 4:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("New Age: ");
                    int newAge = sc.nextInt();
                    manager.updateStudent(updateId, newName, newAge);
                    break;
                case 5:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    manager.deleteStudent(deleteId);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
            }
        } while (choice != 6);
        sc.close();
    }
}