package Study.Session_5.Students_Comparable;

import java.util.Comparator;

public class StudentGradeComparator implements Comparator<Student> {
    @Override
    public int compare(Student first, Student second) {
        int result = Double.compare(second.getGrade(), first.getGrade());

        if (result == 0) {
            result = Integer.compare(first.getId(), second.getId());
        }

        return result;
    }
}
