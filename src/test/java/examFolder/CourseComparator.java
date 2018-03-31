package examFolder;

import java.util.Comparator;

public class CourseComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if(o1.course > o2.course) {
            return -1;
        } else {
            return 1;
        }
    }
}

