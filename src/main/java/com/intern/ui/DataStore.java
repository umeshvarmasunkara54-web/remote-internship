package com.intern.ui;

import com.intern.ui.models.Evaluation;
import com.intern.ui.models.Internship;
import com.intern.ui.models.Mentor;
import com.intern.ui.models.Student;
import com.intern.ui.models.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataStore {
    public static final ObservableList<Internship> internships = FXCollections.observableArrayList();
    public static final ObservableList<Task> tasks = FXCollections.observableArrayList();
    public static final ObservableList<Student> students = FXCollections.observableArrayList();
    public static final ObservableList<Mentor> mentors = FXCollections.observableArrayList();
    public static final ObservableList<Evaluation> evaluations = FXCollections.observableArrayList();

    static {
        // mentors
        Mentor m1 = new Mentor("Dr. Rao", "rao@example.com");
        Mentor m2 = new Mentor("Ms. Priya", "priya@example.com");
        mentors.addAll(m1, m2);

        // students
        Student s1 = new Student("Amit Sharma", "amit@example.com");
        Student s2 = new Student("Neha Verma", "neha@example.com");
        students.addAll(s1, s2);

        // internships (note: mentor stored by name for simplicity)
        internships.add(new Internship("Software Engineering Intern", m1.getName(), "Dec 2025 - Feb 2026"));
        internships.add(new Internship("Data Science Intern", m2.getName(), "Jan 2026 - Mar 2026"));

        // tasks
        tasks.add(new Task("Setup project repo"));
        tasks.add(new Task("Implement login screen"));

        // evaluations (sample)
        evaluations.add(new Evaluation(internships.get(0).getId(), 8, "Good progress"));
    }
}
