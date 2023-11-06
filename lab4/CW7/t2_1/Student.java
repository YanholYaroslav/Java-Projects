/**
* CW7
* lab4 Student class implementation.
* Run file t2_1.java to check the result.
* @author Yaroslav Yanhol
*/
package lab4.CW7.t2_1;

public class Student {

    private int id;
    private String lastname;
    private String firstname;
    private String patronymic;
    private String birthdate;
    private String address;
    private String phoneNumber;
    private String faculty;
    private int course;
    private String group;

    Student(int id, String lastname, String firstname, String patronymic, 
            String birthdate, String address, String phoneNumber, String faculty, 
            int course, String group) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.patronymic = patronymic;
        this.birthdate = birthdate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    Student(int id) {
        this.id = id;
    }

    Student() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id: " + id +
                ", lastname: '" + lastname + '\'' +
                ", firstname: '" + firstname + '\'' +
                ", patronymic: '" + patronymic + '\'' +
                ", birthdate: " + birthdate +
                ", address: '" + address + '\'' +
                ", phoneNumber: " + phoneNumber +
                ", faculty: '" + faculty + '\'' +
                ", course: " + course +
                ", group: '" + group + '\'' +
                '}';
    }

    public void ConsoleOut() {
        System.out.println(this.toString());
    }

    public static Student[] createStudentArray(int size) {
        Student[] students = new Student[size];
        for (int i = 0; i < size; i++) {
            students[i] = new Student();
        }
        return students;
    }

}
