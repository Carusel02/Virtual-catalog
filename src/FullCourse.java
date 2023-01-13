import java.util.ArrayList;

public class FullCourse extends Course{

    public FullCourse(FullCourse.FullCourseBuilder fullCourseBuilder) {
        super(fullCourseBuilder);
    }
    @Override
    public ArrayList<Student> getGraduatedStudents() {
        ArrayList<Student> vector = new ArrayList<>();

        for(Grade x : getGrade()) {
            if( x.getPartialScore() >= 3 && x.getExamScore() >= 2) {
                vector.add(x.getStudent());
            }
        }

        return vector;
    }

    public static class FullCourseBuilder extends Course.CourseBuilder {


        public FullCourseBuilder(String name) {
            super(name);
        }

        @Override
        public Course build() {
            return new FullCourse(this);
        }
    }
}
