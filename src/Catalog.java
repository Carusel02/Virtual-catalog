import java.util.ArrayList;
import java.util.List;

public class Catalog implements Subject{

    private static Catalog object = null;
    ArrayList<Course> cursuri = new ArrayList<>();

    ArrayList<Observer> observers = new ArrayList<>();

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public static Catalog getInstance() {
        if (object == null)
            object = new Catalog();
        return object;
    }

    public void addCourse(Course course) { /* TODO */
        cursuri.add(course);
    }

    public void removeCourse(Course course) { /* TODO */
        cursuri.remove(course);
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Grade grade) {
        Notification notif = new Notification(grade, grade.getStudent().toString());
        grade.getStudent().getMother().update(notif);
        grade.getStudent().getFather().update(notif);
    }

    public ArrayList<Course> getCursuri() {
        return cursuri;
    }

    public void setCursuri(ArrayList<Course> cursuri) {
        this.cursuri = cursuri;
    }
}