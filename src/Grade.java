public class Grade implements Comparable, Cloneable{
    @Override
    public int compareTo(Object o) {
        if((this.getTotal() - ((Grade)o).getTotal()) > 0)
            return 1;
        else
            if((this.getTotal() - ((Grade)o).getTotal()) == 0)
                return 0;
            else
                return -1;
    }

    private Double partialScore, examScore;
    private Student student;
    private String course; // Numele cursului

    public Double getPartialScore() {
        return partialScore;
    }

    public void setPartialScore(Double partialScore) {
        this.partialScore = partialScore;
    }

    public Double getExamScore() {
        return examScore;
    }



    public void setExamScore(Double examScore) {
        this.examScore = examScore;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Double getTotal() {
        /* TODO */
        return partialScore + examScore;
    }

    @Override
    public Grade clone() throws CloneNotSupportedException {
        return (Grade)super.clone();
    }

    @Override
    public String toString() {
        return "Grade{" +
                "partialScore=" + partialScore +
                ", examScore=" + examScore +
                ", student=" + student +
                ", course='" + course + '\'' +
                '}';
    }
}
