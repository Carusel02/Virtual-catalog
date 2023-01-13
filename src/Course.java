import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public abstract class Course {

    private String name;

    private Teacher teacher;

    private HashSet<Assistant> assistants;

    private ArrayList<Grade> grade; // vector de note
    private HashMap<String, Group> dictionary; // vector cu grupe
    private int credit;

    private Strategy s;

    public void setS(Strategy s) {
        this.s = s;
    }

    public HashSet<Assistant> getAssistants() {
        return assistants;
    }

    public void setAssistants(HashSet<Assistant> assistants) {
        this.assistants = assistants;
    }
    public void addAssistant(String ID, Assistant assistant) {
        dictionary.get(ID).setAssistant(assistant);
        assistants.add(assistant);
    }

    public void addAssistant(Assistant assistant) {
        assistants.add(assistant);
    }

    public void addStudent(String ID, Student student) {
        dictionary.get(ID).getStudents().add(student);
    }

    public void addGroup(Group group) {
        dictionary.put(group.getID(), group);
    }

    public void addGroup(String ID, Assistant assistant) {
        Group group = new Group(ID, assistant);
        dictionary.put(ID, group);
    }

    public void addGroup(String ID, Assistant assist, Comparator<Student> comp) {
        Group group = new Group(ID, assist, comp);
        dictionary.put(ID, group);
    }

    public Grade getGrade(Student student) {
        for (Grade x : grade) {
            if (x.getStudent().toString().equals(student.toString())) {
                return x;
            }
        }
        return null;
    }

    public void addGrade(Grade grade) {
        this.grade.add(grade);
    }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> vector = new ArrayList<>();

        for (Group grupa : dictionary.values()) {
            vector.addAll(grupa.getStudents());
        }

        return vector;
    }

    public HashMap<Student, Grade> getAllStudentGrades() {
        HashMap<Student, Grade> vector = new HashMap<>();

        for (Grade x : grade) {
            vector.put(x.getStudent(), x);
        }

        return vector;
    }

    public abstract ArrayList<Student> getGraduatedStudents();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Grade> getGrade() {
        return grade;
    }

    public void setGrade(ArrayList<Grade> grade) {
        this.grade = grade;
    }

    public Course() {
        this.name = "";
    }

    public Course(CourseBuilder builder) {
        this.name = builder.name;
        this.teacher = builder.teacher;
        this.assistants = builder.assistants;
        this.dictionary = builder.dictionary;
        this.grade = builder.grade;
        this.credit = builder.credit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", teacher=" + teacher +
                ", assistants=" + assistants +
                ", grade=" + grade +
                ", dictionary=" + dictionary +
                ", credit=" + credit +
                ", s=" + s +
                '}';
    }

    public abstract static class CourseBuilder {
        private String name;

        private Teacher teacher;

        private HashSet<Assistant> assistants;

        private ArrayList<Grade> grade; // vector de note
        private HashMap<String, Group> dictionary; // vector cu grupe
        private int credit;

        public CourseBuilder(String name) {
            this.name = name;
        }

        public CourseBuilder teacher(Teacher teacher) {
            this.teacher = teacher;
            return this;
        }

        public CourseBuilder assistants(HashSet<Assistant> assistants) {
            this.assistants = assistants;
            return this;
        }

        public CourseBuilder grade(ArrayList<Grade> grade) {
            this.grade = grade;
            return this;
        }

        public CourseBuilder dictionary(HashMap<String, Group> dictionary) {
            this.dictionary = dictionary;
            return this;
        }

        public CourseBuilder credit(int credit) {
            this.credit = credit;
            return this;
        }

        public abstract Course build();

    }

    public Course(Strategy s) {
        this.s = s;
    }

    public Student getBestStudent() {
        return s.getStrategy(getGrade());
    }

    private Snapshot snapshot;

    public void makeBackup() throws CloneNotSupportedException {
        this.snapshot = new Snapshot(this.grade);
    }

    public void undo() {
        this.grade = snapshot.getNotes();

    }
    public void show() {
        System.out.println(this.snapshot.getNotes());
    }
    private static class Snapshot {

        private ArrayList<Grade> notes;

        public Snapshot(ArrayList<Grade> grade) throws CloneNotSupportedException {

            this.notes = new ArrayList<>();

            for(Grade copiere : grade) {
                Grade copie = copiere.clone();
                notes.add(copie);
            }


        }

        public ArrayList<Grade> getNotes() {
            return notes;
        }



    }
}
