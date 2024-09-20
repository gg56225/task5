package model;

import java.util.List;

public class StudyGroup {
    private Teacher teacher;
    private List<Student> students;

    public StudyGroup(Teacher teacher, List<Student> students) {
        this.teacher = teacher;
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Teacher: ").append(teacher.getFirstName()).append(" ").append(teacher.getLastName()).append("\n");
        sb.append("Students:\n");
        for (Student student : students) {
            sb.append("- ").append(student.getFirstName()).append(" ").append(student.getLastName()).append("\n");
        }
        return sb.toString();
    }
}
