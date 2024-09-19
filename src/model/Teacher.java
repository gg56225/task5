package model;

public class Teacher extends User {

    public Teacher(String firstName, String lastName, String middlename, int teacherId) {
        super(firstName, lastName, middlename);
        this.teacherId = teacherId;
    }

    private int teacherId;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
