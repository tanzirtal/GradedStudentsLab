package lab;
import java.util.ArrayList;
import java.util.Arrays;

public class Student {

    // class variables
    public String firstName;
    public String lastName;
    public ArrayList<Double> examScores = new ArrayList<>();

    //default constructor
    public Student(String firstName, String lastName, Double[] examScoresArray){
        this.examScores = new ArrayList<>(Arrays.asList(examScoresArray));
        this.firstName = firstName;
        this.lastName = lastName;
        }

    //getters setters below
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    //size of array is returned to reflect num exams
    public int getNumberOfExamsTaken(){
        return this.examScores.size();
    }
    // sum of all exam scores taken by student obj
    public double getTotalExamScore(){
            Double temp = 0.0;
            for (int i = 0; i< this.examScores.size(); i++){
                temp += examScores.get(i);
            }
            return temp;
    }
    //returns score of exam by parsing thru the set array
    public String getExamScores() {
        String temp = "";
        for (int i = 0; i < this.examScores.size(); i++){
            temp += "Exam #" + (i + 1) + " -> " + examScores.get(i) + "\n";
        }
        return temp;
    }
    //arraylist method .add() used to append the examScore array index
    public void addExamScore(double examScore){
        this.examScores.add(examScore);
    }
    // arraylist method .set() used to replace an index in the examScore array index
    public void setExamScore(int examNumber, double newScore){
            this.examScores.set(examNumber, newScore);
    }
    //loop to create summation of examScores, then divide all of them by the total number of exams
    public double getAverageExamScore(){
            double temp = 0.0;
            double size = this.examScores.size();
            for(int i = 0 ; i < size; i++){
                temp += this.examScores.get(i);
            }
            return temp/size;
    }

    //creating string statements by appending multiple outputs to stringOutput variable
    //starts as Student Name [first] [last]
    //Goes to Student Name [first] [last] Average: [avgExamScore] ......... etc.
    @Override //quick note on Override usage, in this case toString() is a default java Object class method. In order for it to do what we want, we have to override it
    public String toString(){
        String stringOutput = "Student Name: " + firstName + " " + lastName + "\n";

        stringOutput += "Average: " + getAverageExamScore() + "\n";

        stringOutput += "Exam Scores: \n";

        for (int i = 0; i < this.examScores.size(); i++){
            stringOutput += "Exam #" + (i + 1) + " -> " + examScores.get(i) + "\n";
        }



        return stringOutput;

    }

}
