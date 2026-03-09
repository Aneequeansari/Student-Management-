import java.io.*;   // for file reading writing like File,BufferReader,Filereader
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Studentmanagement {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private final String FILE_NAME = "Student.txt";  // file name where student data is stored, final is used so that it cannot be changed

    public Studentmanagement(){
        loadFromFile();   // automatically load data when studentManagement is created
    }

    private void loadFromFile() {  // it will load data from file
        File file = new File(FILE_NAME);  // a File obj name file
        if(!file.exists()){  // if no file skip it  , this is used to prevent error cause when we run program first time student.txt does not exist
            return;
        }
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){  // opening the file student.txt using bufferreader
            //above try - Open the file named Student.txt using a BufferedReader for efficient reading. And automatically close it after reading is done.
            // BufferReader is a class that is used to read text from character
            String line;
            while((line = reader.readLine()) != null){  // read the line until end
                students.add(Student.fromFileString(line));  // convert a line in student obj and adds in student lists
                // ex if in line there is 101,21.... so on , it convert it into id = 101,age = 21... so on like this
            }
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }



    // Add student
    public void addStudent(){
        System.out.println("Enter ID: ");
        int id = sc.nextInt();
        for (Student s : students) {  // this prevent id duplication
            if (s.getId() == id) {
                System.out.println("ERROR ❌ !!! . ID already exists. Please use a unique ID.");
                return;
            }
        }
        System.out.println("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Name: ");
        String name = sc.nextLine();

        System.out.println("Enter Course: ");
        String course = sc.nextLine();

        System.out.println("Enter Branch: ");
        String branch = sc.nextLine();

        System.out.println("Enter Year: ");
        String year = sc.nextLine();

        students.add(new Student(id, age, name, course, branch, year));
        System.out.println("Student Added Successfully!!");
        saveToFile();  // used to save an updated data
    }

    private void saveToFile() {
        try(PrintWriter writer = new PrintWriter((new FileWriter(FILE_NAME)))) {  // used to write data in student.txt file
            for(Student s : students){
                writer.println(s.toFileString());  // convert obj into text
                //toFileString() converts the student object to a COMMA SEPARATED VALUE-style string (like 101,20,Ali,CS,IT,2nd).
            }
        } catch (IOException e) {
            System.out.println("Error saving data" + e.getMessage());
        }
    }

    //view student
    public void viewStudent(){
        if(students.isEmpty()){
            System.out.println("...Student not found...!");
            return;
        }
        for(Student s : students){
            s.display();
        }
    }

    //search student
    public void searchStudent(){
        System.out.println("Enter ID to search:...!");
        int id = sc.nextInt();
        for (Student s : students) {
            if (s.getId() == id) {
                s.display();
                return;
            }
        }
        System.out.println("Student not found...!");
    }
    //update student
// branch and cource are not here cause it is fixed
    public void updateStudent(){
        System.out.println("Enter ID to update:...!");
        int id = sc.nextInt();
        for(Student s : students){
            if(s.getId() == id){
                sc.nextLine();

                System.out.println("Enter new Name: ");
                s.setName(sc.nextLine());

                System.out.println("Enter new Age: ");
                s.setAge(sc.nextInt());
                sc.nextLine();

                System.out.println("Enter new Year: ");
                s.setYear(sc.nextLine());

                System.out.println("Updated Successfully...!");
                saveToFile();  // used to save an updated data
                return;
            }
        }
        System.out.println("Student not found...!");
    }


    //Delete student
//Iterator is used to avoid ConcurrentModificationException
    public void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getId() == id) {
                iterator.remove();
                System.out.println("Deleted successfully!");
                saveToFile();  // used to save an updated data
                return;
            }
        }
        System.out.println("Student not found...!");
    }
}
