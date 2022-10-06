public class Student {
    private String name;
    private String secondName;
    private int id;
    private int scores;

    public Student(String name, String secondName, int id, int scores) {
        this.name = name;
        this.secondName = secondName;
        this.id = id;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return id + ": " + name + " " + secondName + " - " + scores + " баллов";
    }
}
