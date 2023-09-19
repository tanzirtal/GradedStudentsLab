package lab;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Classroom {


    private Student[] students;

    private static final int CLASS_SIZE = 30; //defines size of default constructor below, line 24

    public Classroom(int maxNumberOfStudents){
        this.students = new Student[maxNumberOfStudents];
    }
    //create instantiate Classroom to students array
    public Classroom(Student[] students){
        this.students = students;
    }
    //initializes array with the CLASS_SIZE variable line 13
    public Classroom(){
        this.students = new Student[CLASS_SIZE];
    }
    //ENCAPSULAAAAATIONNNNNN, copies the student[] so we don't mess w the initial value
    public Student[] getStudents() { //how do I get rid of the [null] value when initializing this in Main? -- count how many non-null Student objs, create array of that, copy only non-null Student objs to new array (HOW?)
        Student[] copyArray = new Student[students.length];
        for (int i = 0; i < students.length; i++) {
            copyArray[i] = students[i];
        }
        return copyArray;
    }

    //This may include null values from the array due to it (possibly) taking up a space in the indices of students[], how do you avoid this? -- can use a counter variable or add another loop to count actual number of students
    public double getAverageExamScore() {
        double temp = 0.0; //init value that will hold avg value
        int totalStudents = students.length;
        for (int i = 0; i < totalStudents; i++) { //sum the average scores of students using getAverageExamScore() method from Students class
            temp += students[i].getAverageExamScore();
        }
        return temp/students.length; //manually divide total sum of all averages by the amount of students[]
    }

    //add a Student to the null (or first) position in the students[]. If there are no more spaces as dictated by maxNumberOfStudents, student cannot be added
    //experienced that when trying to add a student and I didn't not maxNumberOfStudents = 1, changed it to =2 and VOILA
    public void addStudent(Student student){
        for(int i = 0; i < students.length; i++){
            if(students[i] == null) {
                students[i] = student;
                break; //learned to add this the hard way after running removeStudent() without this...... basically forces to exit the loop without adding the Student obj to all OTHER null values as well
            }
        }
    }

    //
    public void removeStudent(String firstName, String lastName){
        for (int i = 0; i < students.length; i++){
            if (students[i] != null && students[i].getFirstName().equals(firstName) && students[i].getLastName().equals(lastName)){ //checks if Student is not null and matches firstName && lastName values in students[]
                for (int x = i; x < students.length - 1; x++){ //shifts the remaining students one position back (overwriting the removed index) no GAPS
                    students[x] = students[x + 1];
                }
                students[students.length - 1] = null; //last student is now NULL :))), previously the last student's name was duped
                break;
            }
        }
    }
    //this is where I started to get lost in what to do
    //need to review this code and figure out the concepts: Array.sort() method, Comparator util
    public Student[] getStudentsByScore() {
        Student[] sortedStudents = this.students.clone(); //copies students[] to not mess with values

        Arrays.sort(sortedStudents, new Comparator<Student>() { //how does Arrays.Sort() sort the array? Ex: alphabetically etc.?
            @Override
            public int compare(Student s1, Student s2) {
                //handles null student values
                if (s1 == null) return -1;
                if (s2 == null) return 1;
                //get avg scores for both students being compared
                double score1 = s1.getAverageExamScore();
                double score2 = s2.getAverageExamScore();
                //compare average scores to rank the students
                if (score1 > score2) return 1;
                if (score1 < score2) return -1;

                //if averages are the same, next comparison is by name. This will sort them alphabetically
                String name1 = s1.getFirstName().toLowerCase() + s1.getLastName().toLowerCase();
                String name2 = s2.getFirstName().toLowerCase() + s2.getLastName().toLowerCase();
                return name1.compareTo(name2);
            }
        });

        return sortedStudents;
    }

    //1000% lost as to what is being accomplished here - how are hashmaps being used here (WHAT IS ONE?), why are the returned values descending from F-A and not from A-F
    //need to review this code
    public Map<Student, String> getGradeBook() {
        Map<Student, String> gradeBook = new HashMap<>();
        Student[] sortedStudents = getStudentsByScore();

        int totalStudents = 0;
        for (Student s : sortedStudents) {
            if (s != null) totalStudents++;
        }

        for (int i = 0; i < totalStudents; i++) {
            if (sortedStudents[i] != null) {
                String grade;


                int reverseIndex = totalStudents - i - 1;

                if (reverseIndex < 0.1 * totalStudents) grade = "A";
                else if (reverseIndex < 0.29 * totalStudents) grade = "B";
                else if (reverseIndex < 0.5 * totalStudents) grade = "C";
                else if (reverseIndex < 0.89 * totalStudents) grade = "D";
                else grade = "F";

                gradeBook.put(sortedStudents[i], grade);


                System.out.println(sortedStudents[i].getFirstName() + " " + sortedStudents[i].getLastName() +
                        " has an average score of " + sortedStudents[i].getAverageExamScore() +
                        " and got a grade of " + grade);
            }
        }

        return gradeBook;
    }


    public static void main(String[] args) {
//        String firstName = "Tanny";
//        String lastName = "Tal";
//        Double[] examScores = {100.00,69.69,96.00,54.35,64.33};
//        Student student = new Student(firstName, lastName, examScores);
//
//        String output = student.getExamScores();
//
//        System.out.println(output);
//
//        student.addExamScore(99.99);
//        output = student.getExamScores();
//        System.out.println(output);
//
//        student.setExamScore(0, 50.00 );
//        output = student.getExamScores();
//        System.out.println(output);
//
//
//        Double averageScore = student.getAverageExamScore();
//
//        System.out.println("Your average score: " + averageScore);
//
//        String outputString = student.toString();
//
//        System.out.println(outputString);

//        Double[] s1Scores = { 100.0, 150.0 };
//        Double[] s2Scores = { 225.0, 25.0 };
//
//        Student s1 = new Student("student", "one", s1Scores);
//        Student s2 = new Student("student", "two", s2Scores);
//
//        Student[] students = {s1,s2};
//        Classroom classroom = new Classroom(students);
//
//        double output = classroom.getAverageExamScore();
//
//        System.out.println(output);
        int maxNumberOfStudents = 6;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores1 = { 100.0, 90.0, 70.0, 83.0 };
        Double[] examScores2 = { 80.0, 65.0, 50.0, 100.0 };
        Double[] examScores3 = { 80.0, 65.0, 50.0, 100.0 };
        Double[] examScores4 = { 70.0, 65.0, 50.0, 100.0 };
        Double[] examScores5 = { 20.0, 65.0, 50.0, 100.0 };
        Double[] examScores6 = { 30.0, 65.0, 50.0, 100.0 };
        Student student1 = new Student("Leon", "Hunter", examScores1);
        Student student2 = new Student("Tanny", "Tal", examScores2);
        Student student3 = new Student("Betty", "Moop", examScores3);
        Student student4 = new Student("Ian", "Shoop", examScores4);
        Student student5 = new Student("Kanon", "Doop", examScores5);
        Student student6 = new Student("Earl", "Foop", examScores6);


        Student[] preEnrollment = classroom.getStudents();
        classroom.addStudent(student1);
        classroom.addStudent(student2);
        classroom.addStudent(student3);
        classroom.addStudent(student4);
        classroom.addStudent(student5);
        classroom.addStudent(student6);
        Student[] postEnrollment = classroom.getStudents();

        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

//        System.out.println("===========================");
//        System.out.println(preEnrollmentAsString);
//        System.out.println("===========================");
//        System.out.println(postEnrollmentAsString);

//        classroom.removeStudent("Leon", "Hunter");

        System.out.println(Arrays.toString(classroom.getStudents()));
        classroom.getGradeBook();

    }







}
