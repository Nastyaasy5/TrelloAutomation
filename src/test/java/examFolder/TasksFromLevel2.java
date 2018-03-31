package examFolder;

import java.util.*;

public class TasksFromLevel2 {

    public static void task1(){
        String string = "1 4 5 1 1 3";
        string = string.replace(" ", "");
        Set<Character> uniqChars = new HashSet<>();

        for(int i=0; i<string.length(); i++){
            uniqChars.add(string.charAt(i));
        }
        System.out.println("Quantity of unique chars: " + uniqChars.size());
    }

    public static void task2(){
        String string = "c:/WebServers/home/testsite/www/myfile.txt";
        int to = string.indexOf(".");
        int from = string.lastIndexOf("/");
        System.out.println("Name of the file: " + string.substring(from+1, to));
    }

    public static void task3(){
        String string = "Это ##тестовый пример## для задачи ##на## строки";

        string = string.replaceAll(" ##", " <");
        string = string.replaceAll("## ", "> ");

        System.out.println("Changed string is: " + string);
    }

    public static void task4(){
        String string = "someExampleHere";
        String upperCases = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String lowerCases = "qwertyuiopasdfghjklzxcvbnm";

        for(int i=0; i<string.length(); i++){
            String character = String.valueOf(string.charAt(i));

            if(upperCases.contains(character)){
                int index = upperCases.indexOf(character);
                string = string.replace(character, ("_" + String.valueOf(lowerCases.charAt(index))));
            }
        }

        System.out.println("Changed string: " + string);
    }

    public static void task5(){
        int firstVar = 3;
        int secondVar = 5;
        System.out.println("First variable: " + firstVar +
                "; second variable: " + secondVar);

        firstVar = firstVar + secondVar;
        secondVar = secondVar * 2;

        System.out.println("After changes: first variable = " + firstVar
               + "; second variable =  " + secondVar);

        int sum = firstVar + secondVar;
        System.out.println("Sum of variables = " + sum);

        if(firstVar>secondVar){
            System.out.println(firstVar + ">" + secondVar);
        } else if(firstVar<secondVar){
            System.out.println(firstVar + "<" + secondVar);
        }else {
            System.out.println(firstVar + "=" + secondVar);
        }
    }

    public static void task6() {
        List<Student> listOfStudents = new ArrayList<>();

        Student studentOne = new Student();
        Student studentTwo = new Student();
        Student studentThree = new Student();

        listOfStudents.add(studentOne);
        listOfStudents.add(studentTwo);
        listOfStudents.add(studentThree);

        studentOne.surname = "Grigoreva";
        studentOne.name = "Masha";
        studentOne.yearOfBirth = 1995;
        studentOne.course = 4;
        studentOne.groupNr = 501;
        studentOne.mathMark = 4;
        studentOne.biologyMark = 3;
        studentOne.chemistryMark = 2;
        studentOne.languageMark = 3;
        studentOne.historyMark = 4;

        studentThree.surname = "Baranik";
        studentThree.name = "Daria";
        studentThree.yearOfBirth = 1996;
        studentThree.course = 4;
        studentThree.groupNr = 501;
        studentThree.mathMark = 5;
        studentThree.biologyMark = 4;
        studentThree.chemistryMark = 3;
        studentThree.languageMark = 3;
        studentThree.historyMark = 5;

        studentTwo.surname = "Parta";
        studentTwo.name = "Makar";
        studentTwo.yearOfBirth = 1997;
        studentTwo.course = 5;
        studentTwo.groupNr = 402;
        studentTwo.mathMark = 5;
        studentTwo.biologyMark = 5;
        studentTwo.chemistryMark = 5;
        studentTwo.languageMark = 5;
        studentTwo.historyMark = 5;

        Collections.sort(listOfStudents, new CourseComparator());
        for(Student student : listOfStudents){
            System.out.println(student.name + " " + student.surname + " course: " + student.course);
        }
        //...
    }

    public static void main(String[] args) {
        //task1();
        //task2();
        //task3();
        //task4();
        //task5();
        //task6();
    }


}
