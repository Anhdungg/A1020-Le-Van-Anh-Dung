package models;

public class Student {
    String id;
    String name;
    String dateOfBirth;
    String gender;
    String nameClass;

    public Student(){

    }

    public Student(String id, String name, String gender, String dateOfBirth, String nameClass) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.nameClass = nameClass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getYearOfBirth(){
        return this.dateOfBirth.substring(this.dateOfBirth.length()-4);
    }

    public String getMonthOfBirth(){
        return this.dateOfBirth.substring(this.dateOfBirth.indexOf("/")+1, this.dateOfBirth.lastIndexOf("/"));
    }

    public String getDayOfBirth(){
        return this.dateOfBirth.substring(0, this.dateOfBirth.indexOf("/"));
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public String getDataWriteFile(){
        return this.id+","+this.name+","+this.gender+","+this.dateOfBirth +","+this.nameClass;
    }
    @Override
    public String toString() {
        return "Id: " + this.id +
                ", Name: " + this.name +
                ", Gender: " + this.gender +
                ", Day of birth: " + this.dateOfBirth +
                ", Class: " + this.nameClass;
    }
}
