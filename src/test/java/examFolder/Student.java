package examFolder;

public class Student {
    public String surname;
    public String name;
    public int yearOfBirth;
    public int course;
    public int groupNr;
    public int mathMark;
    public int biologyMark;
    public int chemistryMark;
    public int languageMark;
    public int historyMark;

    public Student() {
        this.surname = surname;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.course = course;
        this.groupNr = groupNr;
        this.mathMark = mathMark;
        this.biologyMark = biologyMark;
        this.chemistryMark = chemistryMark;
        this.languageMark = languageMark;
        this.historyMark = historyMark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", course=" + course +
                ", groupNr=" + groupNr +
                ", mathMark=" + mathMark +
                ", biologyMark=" + biologyMark +
                ", chemistryMark=" + chemistryMark +
                ", languageMark=" + languageMark +
                ", historyMark=" + historyMark +
                '}';
    }
}
