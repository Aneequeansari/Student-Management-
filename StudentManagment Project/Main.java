import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Studentmanagement management = new Studentmanagement();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("----STUDENT MANAGEMENT SYSTEM----");
            System.out.println("1. ADD STUDENT");
            System.out.println("2. VIEW STUDENT");
            System.out.println("3. SEARCH STUDENT");
            System.out.println("4. UPDATE STUDENT");
            System.out.println("5. DELETE STUDENT");
            System.out.println("6. EXIT");
            System.out.print("Enter choice: ");

            int choice = -1; // dummy value and can easily detect wrong input , we can use 0 here
            if (sc.hasNextInt()) {  // check weather input us in int form or not
                choice = sc.nextInt();  // choice should be in int
                sc.nextLine();
            } else {
                System.out.println("Please enter a valid number.");
                sc.nextLine(); // discard invalid input
                continue; // it show the menu again and again
            }

            switch (choice) {
                case 1 -> management.addStudent();
                case 2 -> management.viewStudent();
                case 3 -> management.searchStudent();
                case 4 -> management.updateStudent();
                case 5 -> management.deleteStudent();
                case 6 -> {
                    System.out.println("Exiting....!");
                    return;
                }
                default -> System.out.println("Invalid choice...");
            }

            System.out.println("Press Enter to continue...");
            sc.nextLine();
        }
    }
}
