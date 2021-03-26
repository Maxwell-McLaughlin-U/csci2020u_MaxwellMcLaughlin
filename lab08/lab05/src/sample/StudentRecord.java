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
            this.letterGrade = 'F';
        }else if ((finalMark >= 50) && (finalMark <= 59)){
            this.letterGrade = 'D';
        }else if ((finalMark >= 60) && (finalMark <= 69)){
            this.letterGrade = 'C';
        }else if ((finalMark >= 70) && (finalMark <= 79)){
            this.letterGrade = 'B';
        }else{
            this.letterGrade = 'A';
        }
    }

    public String getID(){
        return this.ID;
    }

    public String getAssignments(){
        return  Float.toString(this.assignments);
    }

    public String getMidterm(){ return Float.toString(this.midterm); }

    public String getFinalExam(){
        return  Float.toString(this.finalExam);
    }

    public char getLetterGrade(){ return this.letterGrade; }

    public String getFinalMark(){
        return  Float.toString(this.finalMark);
    }

    public void setID(String enter){
        this.ID = enter;
    }

    public void setAssignments(Float enter){
        this.assignments = enter;
        calculateGrade();
    }

    public void setMidterm(Float enter){
        this.midterm = enter;
        calculateGrade();
    }

    public void setFinal(Float enter){
        this.finalExam = enter;
        calculateGrade();
    }

    public String toString(){
        return this.ID + "," +this.assignments + "," + this.midterm + "," +this.finalExam;
    }
}
