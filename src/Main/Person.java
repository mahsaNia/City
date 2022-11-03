package Main;

public class Person
{

    private String name ; // نام
    private String lastName ; // نام خانوادگی
    private String yearBirth ; // سال تولد
    private String birthplace ; //محل تولد
    private String job ; // شغل
    private String gender ; // جنسیت
    private double employmentSalary ; // حقوق استخدامی
    static int id = 1 ;
    private int personID ;

    public Person(int personID ,String name, String lastName, String yearBirth, String birthplace, String job,
                  String gender, double employmentSalary)
    {
        id++ ;
        this.personID = personID ;
        this.name = name;
        this.lastName = lastName;
        this.yearBirth = yearBirth;
        this.birthplace = birthplace;
        this.job = job;
        this.gender = gender;
        this.employmentSalary = employmentSalary;
    }

    public String getJob()
    {
        return job;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getYearBirth() {
        return yearBirth;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public String getGender() {
        return gender;
    }

    public double getEmploymentSalary() {
        return employmentSalary;
    }

    public int getPersonID() {
        return personID;
    }
}
