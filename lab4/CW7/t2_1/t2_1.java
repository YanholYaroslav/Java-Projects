/**
* CW7
* lab4 t2_1.
* Run file t2_1.java to check the result.
* @author Yaroslav Yanhol
*/
package lab4.CW7.t2_1;

import java.util.Random;

public class t2_1 {

    public static void main(String args[]) {

        Student[] tStudentArray = Student.createStudentArray(7);

        String[] firstnames = {
            "John", "Mary", "David", "Anna", "Michael", "Sarah", "James"
        };
        String[] lastnames = {
            "Smith", "Johnson", "Brown", "Williams", "Jones", "Davis", "Miller"
        };
        String[] faculties = {
            "Radiophysics", "Cybernetics", "Mechanics and Mathematics", "Physics"
        };
        String[] groups = {
            "Mathematics", "Computer mathematics", "Computer mechanics", 
            "Statistics", "Education", "Mechanics", 
        };

        Random random = new Random();

        for (int i = 0; i < tStudentArray.length; i++) {

            // Base info
            tStudentArray[i].setId(i + 1);
            tStudentArray[i].setFirstname(firstnames[i]);
            tStudentArray[i].setLastname(lastnames[i]);
            tStudentArray[i].setFaculty(faculties[random.nextInt(faculties.length)]);
            tStudentArray[i].setGroup(groups[random.nextInt(groups.length)]);

            // Birthdate generation
            int year = random.nextInt(4) + 2001;
            int month = random.nextInt(12) + 1;
            int day = random.nextInt(31) + 1;
            String birthdate = String.format(
                "%04d.%02d.%02d", year, month, day);
            tStudentArray[i].setBirthdate(birthdate);

            // Phone numbers generation
            String regionCode = "0" + (random.nextInt(6) + 32);
            String phoneNumber = regionCode + String.format(
                "%07d", random.nextInt(10000000));
            tStudentArray[i].setPhoneNumber(phoneNumber);

            // Course number generation
            int course = random.nextInt(4) + 1;
            tStudentArray[i].setCourse(course);
        }

        System.out.println();
        System.out.println("List of students: ");
        for (Student student : tStudentArray) {
            student.ConsoleOut();
        }

        System.out.println();
        System.out.println("\nTask A): ");
        String selectedFaculty = faculties[random.nextInt(faculties.length)];
        System.out.println("List of students in the " 
                + selectedFaculty + " faculty: ");
        for (Student student : tStudentArray) {
            if (student.getFaculty().equals(selectedFaculty)) {
                student.ConsoleOut();
            }
        }

        System.out.println();
        System.out.println("\nTask B): ");
        for (String faculty : faculties){
            System.out.println("\n" + faculty + " faculty: ");
            for (Student student : tStudentArray) {
                if (student.getFaculty().equals(faculty)) {
                    student.ConsoleOut();
                }
            }
        }
        for (int c = 1; c < 5; c++){
            System.out.println("\n" + c + " course: ");
            for (Student student : tStudentArray) {
                if (student.getCourse() == c) {
                    student.ConsoleOut();
                }
            }
        }
        
        System.out.println();
        System.out.println("\nTask C): ");
        int year = random.nextInt(4) + 2001;
        System.out.println("\nBorn after " + year + " year: ");
        for (Student student : tStudentArray) {
            String currentBirthDate = student.getBirthdate();
            String[] dateParts = currentBirthDate.split("\\.");
            if (Integer.parseInt(dateParts[0]) > year) {
                student.ConsoleOut();
            }
        }
        
        System.out.println();
        System.out.println("\nTask D): ");
        for (String group : groups){
            System.out.println("\n" + group + " group: ");
            for (Student student : tStudentArray) {
                if (student.getGroup().equals(group)) {
                    student.ConsoleOut();
                }
            }
        }
        System.out.println();

    }
    
}
