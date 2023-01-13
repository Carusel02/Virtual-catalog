import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class PartialCourse extends Course {

    public PartialCourse(PartialCourseBuilder partialCourseBuilder) {
        super(partialCourseBuilder);
    }

    @Override
    public ArrayList<Student> getGraduatedStudents() {
        ArrayList<Student> vector = new ArrayList<>();

        for(Grade x : getGrade()) {
            if( x.getTotal() >= 5) {
                vector.add(x.getStudent());
            }
        }

        return vector;
    }

    public static class PartialCourseBuilder extends Course.CourseBuilder {


        public PartialCourseBuilder(String name) {
            super(name);
        }

        @Override
        public Course build() {
            return new PartialCourse(this);
        }
    }
}
