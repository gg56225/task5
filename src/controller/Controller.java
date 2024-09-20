package controller;

import model.*;
import service.DataService;
import service.StudyGroupService;
import view.StudentView;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final DataService service = new DataService();
    private final StudentView view = new StudentView();
    private final StudyGroupService studyGroupService = new StudyGroupService();
    public void createStudent(String firstName, String lastName, String middleName) {
        service.create(firstName, lastName, middleName, Type.STUDENT);
    }

    public void getAllStudent() {
        List<User> userList = service.getAllStudent();
        for (User user : userList) {
            Student student = (Student) user;
            view.printOnConsole(student);
        }
    }

    public void createStudyGroup() {

        System.out.println("Enter teacher details:");
        String teacherFirstName = readInput("First Name: ");
        String teacherLastName = readInput("Last Name: ");
        String teacherMiddleName = readInput("Middle Name (optional): ");


        System.out.println("Enter student IDs (separated by commas):");
        String studentIdsString = readInput("Student IDs: ");
        List<Integer> studentIds = parseStudentIds(studentIdsString);

        Teacher teacher = (Teacher) service.getUserById(Type.TEACHER, getTeacherId(teacherFirstName, teacherLastName));
        List<Student> students = new ArrayList<>();
        for (Integer studentId : studentIds) {
            Student student = (Student) service.getUserById(Type.STUDENT, studentId);
            if (student != null) {
                students.add(student);
            } else {
                System.out.println("Student with ID " + studentId + " not found.");
            }
        }

        StudyGroup studyGroup = studyGroupService.createStudyGroup(teacher, students);
        System.out.println("\nStudy Group created:");
        System.out.println(studyGroup);
    }

    private String readInput(String message) {
        System.out.print(message);
        return new java.util.Scanner(System.in).nextLine();
    }

    private List<Integer> parseStudentIds(String studentIdsString) {
        List<Integer> studentIds = new ArrayList<>();
        for (String idString : studentIdsString.split(",")) {
            try {
                studentIds.add(Integer.parseInt(idString.trim()));
            } catch (NumberFormatException e) {
                System.out.println("Invalid student ID format: " + idString);
            }
        }
        return studentIds;
    }

    private int getTeacherId(String firstName, String lastName) {
        User teacher = service.getUserById(Type.TEACHER, 1);
        if (teacher != null) {
            return teacher.getId();
        } else {
            System.out.println("Teacher not found.");
            return -1;
        }
    }
}

