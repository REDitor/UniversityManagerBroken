package nl.inholland.universitymanager.data;

import nl.inholland.universitymanager.models.Grade;
import nl.inholland.universitymanager.models.Group;
import nl.inholland.universitymanager.models.Student;
import nl.inholland.universitymanager.models.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Database {


    private List<Student> students = new ArrayList<>();
    private List<Group> groups = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public Database() {
        // teachers
        teachers.add(new Teacher("Wim", "Wiltenburg", "willem.wiltenburg@inholland.nl", 500000));
        Teacher niels = new Teacher("Niels", "van der Zwet", "niels.vanDerZwet@inholland.nl", 400000);
        teachers.add(niels);


        // groups
        Group inf2a = new Group("INF2A");
        inf2a.setCoach(niels);
        groups.add(inf2a);


        // students
        Student piet = new Student("Piet", "de Vries", "121231@student.inholland.nl", inf2a);
        piet.getGrades().add(new Grade("Java Fundamentals", 10));
        piet.getGrades().add(new Grade("Maths", 7));
        students.add(piet);

        // students
        Student maartje = new Student("Maartje", "Hendriks", "122341@student.inholland.nl", inf2a);
        maartje.getGrades().add(new Grade("English", 8));
        maartje.getGrades().add(new Grade("Programming 1", 9));
        students.add(maartje);
    }
}
