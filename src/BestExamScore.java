import java.util.ArrayList;

public class BestExamScore implements Strategy{
    @Override
    public Student getStrategy(ArrayList<Grade> grades) {
        double max = 0;
        Student stud = null;

        for( Grade x : grades) {
            if(x.getExamScore() > max) {
                max = x.getExamScore();
                stud = x.getStudent();
            }
        }

        return stud;
    }
}
