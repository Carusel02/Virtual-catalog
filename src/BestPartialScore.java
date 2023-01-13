import java.util.ArrayList;

public class BestPartialScore implements Strategy{
    @Override
    public Student getStrategy(ArrayList<Grade> grades) {
        double max = 0;

        for( Grade x : grades) {
            if(x.getPartialScore() > max)
                max = x.getPartialScore();
        }

        for( Grade x : grades) {
            if(x.getPartialScore() == max)
                return x.getStudent();
        }

        return null;
    }
}
