import java.util.ArrayList;

public class BestTotalScore implements Strategy{
    @Override
    public Student getStrategy(ArrayList<Grade> grades) {
        double max = 0;

        for( Grade x : grades) {
            if(x.getTotal() > max)
                max = x.getTotal();
        }

        for( Grade x : grades) {
            if(x.getTotal() == max)
                return x.getStudent();
        }

        return null;
    }
}
