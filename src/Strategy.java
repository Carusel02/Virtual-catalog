import java.util.ArrayList;

public interface Strategy {

    abstract public Student getStrategy(ArrayList<Grade> grades);
}
