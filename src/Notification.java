public class Notification {
    Grade grade;
    String nume;

    public Notification(Grade grade, String nume) {
        this.grade = grade;
        this.nume = nume;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "grade=" + grade +
                ", nume='" + nume + '\'' +
                '}';
    }
}
