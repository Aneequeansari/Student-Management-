public class Student{
    private final int id;
    private int age;
    private String name;
    private final String course;
    private final String branch;
    private String year;

    public Student(int id, int age, String name, String course, String branch, String year){
        this.id = id;
        this.age = age;
        this.name = name;
        this.course = course;
        this.branch = branch;
        this.year = year;
    }
//getter to read the data

    public int getId(){
        return id;
    }
    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }
    public String getCourse(){
        return course;
    }
    public String getBranch(){
        return branch;
    }
    public String getYear(){
        return year;
    }

    //setter to update the data
    public void setAge(int age){
        this.age = age;
    }
    public void setYear(String year){
        this.year = year;
    }
    public void setName(String name){
        this.name = name;
    }

    public void display(){
        System.out.println("ID: " + id + ",\n Age: " + age + ",\n Name: " + name +  ",\n Course: " + course + ",\n Branch: " + branch + ",\n Year: " + year);
    }

    //convert obj to text  to save into file
    public String toFileString(){
        return id + " , " + age + " , " + name + " , " + course + " , " + branch + " , " + year + " , ";  // use to split like id-101 , age-21,...and soo on
    }

    // convert text to obj  to read from file
    public static Student fromFileString(String line){   // we defined a method to create Student object
        String[] parts = line.split(",");
        return new Student(   // obj
                Integer.parseInt(parts[0].trim()),  // convert string to int
                Integer.parseInt(parts[1].trim()),   // convert string to int
                parts[2].trim(),
                parts[3].trim(),
                parts[4].trim(),
                parts[5].trim() );
    }
}



//for testing code ,just remove 'public' from above
// public class Main {
//     public static void main(String[] args) {
//         Student s = new Student(1, 20, "Aneeque Ansari", "B.Tech", "CSE", "2nd Year");
//         s.display();
//     }
// }      