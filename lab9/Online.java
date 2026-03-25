package Innerclass;

interface RecordedCourse {
    default void playVideo() {
        System.out.println("Playing recorded video...");
    }
}
interface LiveCourse {
    default void playVideo() {
        System.out.println("Streaming live session...");
    }
}
abstract class Course {
    String courseName;

    Course(String name) {
        courseName = name;
    }

    abstract void startCourse();
}
class HybridCourse extends Course implements RecordedCourse, LiveCourse {

    HybridCourse(String name) {
        super(name);
    }

    // Must implement abstract method
    @Override
    void startCourse() {
        System.out.println("Starting hybrid course: " + courseName);
    }

    // Resolve conflict (both interfaces have playVideo)
    @Override
    public void playVideo() {
        System.out.println("Hybrid Course Video Mode:");

        RecordedCourse.super.playVideo();
        LiveCourse.super.playVideo();
    }
}
public class Online {
    public static void main(String[] args) {

        HybridCourse course = new HybridCourse("OOP in Java");

        course.startCourse();
        course.playVideo();
    }
}
