import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Group {

    private String ID;

    private Assistant assistant;

    private Comparator<Student> comp;

    private ArrayList<Student> students;


    public Group(String ID, Assistant assistant, Comparator<Student> comp) {
        this.ID = ID;
        this.assistant = assistant;
        this.comp = comp;
    }
    public Group(String ID, Assistant assistant) {
        this.ID = ID;
        this.assistant = assistant;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Comparator<Student> getComp() {
        return comp;
    }

    public void setComp(Comparator<Student> comp) {
        this.comp = comp;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public Assistant getAssistant() {
        return assistant;
    }

    public void setAssistant(Assistant assistant) {
        this.assistant = assistant;
    }

    @Override
    public String toString() {
        return "Group{" +
                "ID='" + ID + '\'' +
                ", assistant=" + assistant +
                ", comp=" + comp +
                ", students=" + students +
                '}';
    }
}
