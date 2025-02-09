package Controller;

public class Validation {

    public static boolean validStudentID(String studentID){
        return studentID.matches("[dDqQsScChH][eEaAsS]\\d{6}");
    }

    public static boolean validName (String studentName){
        return studentName.matches("^.{2,20}$");
    }

    public static boolean ViettelVNPTValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("(03[2-9]\\d{7})|" +  // Viettel
                "(086\\d{7})|" +     // Viettel
                "(09[6-8]\\d{7})|" + // Viettel
                "(07[0-9]\\d{7})|" + // VNPT
                "(088\\d{7})|" +     // VNPT
                "(09[1,4]\\d{7})");  // VNPT
    }

    public static boolean validPhoneNumber ( String phoneNumber){
        return phoneNumber.matches("(03[2-9]\\d{7})|"+
                                         "(05[6,8-9]\\d{7})|"+
                                         "(07[0,6-9]\\d{7})|"+
                                         "(08[1-9]\\d{7})|"+
                                         "(09[0-4,6-9]\\d{7})");
    }

    public static boolean validEmail(String email){
        return email.matches("^[a-zA-Z0-9](\\.?[a-zA-Z0-9_-])*@gmail\\.com$"); // Dấu * có nghĩa là có thể xuất hiện 0 hoặc nhiều lần
    }

    public static boolean validMountainPeak(String mountainPeak){
        return mountainPeak.matches("([1-9])|(1[1-3]) ");
    }



}
