package sample;

public class StudentRecord {

    public String ID;
    public float midterm;
    public float assignments;
    public float finalExam;
    public char letterGrade;
    public float finalMark;

    public StudentRecord(String ID, float midterm,float assignments, float finalExam){
        this.ID = ID;
        this.midterm = midterm;
        this.assignments = assignments;
        this.finalExam = finalExam;
        calculateGrade();
    }

    private void calculateGrade(){
        finalMark = (float) ((assignments * 0.2) + (midterm * 0.3) + (finalExam * 0.5));

        if(finalMark < 50){
            letterGrade = 'F';
        }else if ((finalMark >= 50) && (finalMark <= 59)){
            letterGrade = 'D';
        }else if ((finalMark >= 60) && (finalMark <= 69)){
            letterGrade = 'C';
        }else if ((finalMark >= 70) && (finalMark <= 79)){
            letterGrade = 'B';
        }else{
            letterGrade = 'A';
        }
    }

    public String getID(){
        return this.ID;
    }

    public float getAssignments(){
        return  this.assignments;
    }

    public float getMidterm(){
        return this.midterm;
    }

    public float getFinalExam(){
        return  this.finalExam;
    }

    public char getLetterGrade(){
        return this.letterGrade;
    }

    public float getFinalMark(){
        return  this.finalMark;
    }
}
