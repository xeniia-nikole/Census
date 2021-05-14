package Census;

public class Person {
    private String name;
    private String surname;
    private Integer age;
    private Sex sex;
    private Education education;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Person(String name, String surname, Integer age, Sex sex, Education education) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
        this.education = education;
    }

    @Override
    public String toString() {
        return "\n- Person:\nName:" + getName() +
                "\nSurname: " + getSurname() +
                "\nSex: " + getSex() +
                "\nAge: " + getAge() +
                "\nEducation: " + getEducation();
    }
}
