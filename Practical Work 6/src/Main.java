import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void sort(Student[] students) {
        for (int i = 1; i < students.length; i++) {
            Student t = students[i];
            int j = i - 1;
            for (; j >= 0 && students[j].getScores() > t.getScores(); j--) {
                students[j + 1] = students[j];
            }
            students[j + 1] = t;
        }
    }

    public static ArrayList<Student> merge(ArrayList<Student> left, Student delimiter, ArrayList<Student> right) {
        ArrayList<Student> students = new ArrayList<>(left);
        students.add(delimiter);
        students.addAll(right);
        return students;
    }

    public static ArrayList<Student> mergeSort(ArrayList<Student> students) {
        if(students.size() < 2) {
            return students;
        }

        Student delimiter = students.get(0);
        ArrayList<Student> left = new ArrayList<>();
        ArrayList<Student> right = new ArrayList<>();

        for(int i = 1; i < students.size(); i++) {
            Student student = students.get(i);
            if(student.getScores() < delimiter.getScores()) {
                left.add(student);
            } else {
                right.add(student);
            }
        }
        return merge(mergeSort(left), delimiter, mergeSort(right));
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student("Дмитрий", "Мельчаков", 1, 90),
                new Student("Иван", "Иванов", 2, 79),
                new Student("Ярослав", "Тихонов", 3, 83),
                new Student("Антон", "Чехов", 4, 94),
                new Student("Михаил", "Алексеев", 5, 68)
        };

        Student[] mergeStudents = {
                new Student("Алексей", "Смирнов", 6, 81),
                new Student("Василий", "Тёркин", 7, 52),
                new Student("Александр", "Невский", 8, 65),
                new Student("Николай", "Романов", 9, 87),
                new Student("Арсений", "Ложкин", 10, 75)
        };

//        sort(students);

//        SortingStudentsByGPA sortingStudentsByGPA = new SortingStudentsByGPA();
//        sortingStudentsByGPA.quickSort(students, 0, students.length - 1);
//
//        for(Student student : students) {
//            System.out.println(student);
//        }

        ArrayList<Student> studentList = new ArrayList<>(List.of(students));
        studentList.addAll(List.of(mergeStudents));
        studentList = mergeSort(studentList);
        studentList.forEach(System.out::println);
    }
}
