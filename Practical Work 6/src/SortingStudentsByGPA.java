import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<Student> {

    public void quickSort(Student[] students, int left, int right) {
        int leftMarker = left;
        int rightMarker = right;
        Student pivot = students[(leftMarker + rightMarker) / 2];
        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (compare(students[leftMarker], pivot) > 0) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (compare(students[rightMarker], pivot) < 0) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    Student tmp = students[leftMarker];
                    students[leftMarker] = students[rightMarker];
                    students[rightMarker] = tmp;
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < right) {
            quickSort(students, leftMarker, right);
        }
        if (left < rightMarker) {
            quickSort(students, left, rightMarker);
        }
    }

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getScores(), o2.getScores());
    }
}
