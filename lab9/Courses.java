package Innerclass;

interface Assignments {
    default void executeTask() {
        System.out.println("Assignments done");
    }
}

interface Quizzes {
    default void executeTask() {
        System.out.println("Quizzes done");
    }
}

abstract class course {
    String courseName;

    course(String courseName) {
        this.courseName = courseName;
    }

    abstract void startCourse();
}

class SmartCourse extends course implements Assignments, Quizzes {

    SmartCourse(String name) {
        super(name);
    }
    @Override
    void startCourse() {
        System.out.println("Starting course: " + courseName);
    }
    @Override
    public void executeTask() {
        System.out.println("Course Tasks ");
        Assignments.super.executeTask();
        Quizzes.super.executeTask();
    }

    void guestInstructor() {
        Runnable guest = new Runnable() {
            @Override
            public void run() {
                System.out.println("Guest Instructor");
            }
        };
        guest.run();
    }
}
public class Courses {
    public static void main(String[] args) {

        SmartCourse course = new SmartCourse("OOPs");
        course.startCourse();
        course.executeTask();
        course.guestInstructor();
    }
}
