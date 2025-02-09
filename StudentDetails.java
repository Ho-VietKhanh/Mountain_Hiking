package Model;

import java.io.Serializable;

public class StudentDetails implements Serializable {
    private String studentID;
    private String name;
    private String phoneNumber;
    private String email;
    private String mountainCode;
    private double tuitionFee;


    public StudentDetails(String studentID, String name, String phoneNumber, String email, String mountainCode, double tuitionFee) {
        this.studentID = studentID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.mountainCode = mountainCode;
        this.tuitionFee = tuitionFee;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMountainCode() {
        return mountainCode;
    }

    public void setMountainCode(String mountainCode) {
        this.mountainCode = mountainCode;
    }

    public double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    @Override
    public String toString() {
        return studentID +"--------" + name +"--------" + phoneNumber +"--------" + email +"--------" + mountainCode +"--------" + tuitionFee;
    }
}
