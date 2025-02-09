package Controller;

import Model.StudentDetails;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FunctionOfStudentDetails {
    static List<StudentDetails> list = new ArrayList<>();

    //1. Create the function to add student
    public static void addStudentRegistration(){
        boolean checkDuplicateID = false;
        String studentID = "";
        do{
                checkDuplicateID = false;
                studentID = FunctionToCheck.inputStudentID("Input Student's ID: ");

                for(StudentDetails studentDetails : list){
                    if (studentDetails.getStudentID().equalsIgnoreCase(studentID)){
                        checkDuplicateID = true;
                        System.out.println("This ID Already Exist. Please Enter The Different ID !!!");
                        break;
                    }
                }

        }while (checkDuplicateID);

        String studentName = FunctionToCheck.inputStudentName("Input Student's Name: ");
        String studentPhoneNumber = FunctionToCheck.inputPhoneNumber("Input Student's Phone Number: ");
        String studentEmail = FunctionToCheck.inputStudentEmail("Input Student's Email: ");
        String mountainCode = FunctionToCheck.inputMountainCode("Input Mountain Code: ");
        double tuitionFee = 6000000;
        if (Validation.ViettelVNPTValidPhoneNumber(studentPhoneNumber)){
            tuitionFee = 6000000*0.65;
        }

        StudentDetails student = new StudentDetails(studentID, studentName, studentPhoneNumber, studentEmail, mountainCode, tuitionFee);
        list.add(student);
    }

    //2. Create the function to update
    public static void updateTheInformation(){
        boolean checkValidID = false;
        boolean checkValidInput = false;
        int choice = 0;
        String inputIDToSearch = "";
        if(list.isEmpty()){
            System.out.println("No Students Have Registered yet !!!");
        }
        else{
            do{
                System.out.println("1. Input ID To Update");
                System.out.println("2. Back To Menu");
                do{
                    try{
                        choice = FunctionToCheck.checkInteger("Input Your Choice: ");
                        if(choice < 1 || choice > 2){
                            throw new Exception();
                        }
                        else{
                            checkValidInput = true;
                        }
                    }
                    catch (Exception e){
                        System.out.println("Please Input Again (1-2) !!!");
                        checkValidInput = false;
                    }
                }while(checkValidInput == false);

                switch (choice){
                    case 1:{
                        boolean studentFound = false;
                        inputIDToSearch = FunctionToCheck.checkString("Input ID To Search: ");

                        for (StudentDetails studentDetails : list){
                            if (studentDetails.getStudentID().equalsIgnoreCase(inputIDToSearch)){
                                studentFound = true;
                                System.out.println(studentDetails);
                                // Input new ID
                                String newID = FunctionToCheck.inputStudentID("Input Student's ID: ");
                                if(!newID.isEmpty()){
                                    studentDetails.setStudentID(newID);
                                }
                                else if(newID.isEmpty()) {
                                    studentDetails.setStudentID(studentDetails.getStudentID());
                                }

                                // Input new name
                                String newName = FunctionToCheck.inputStudentName("Input Student's Name: ");
                                if(!newName.isEmpty()){
                                    studentDetails.setName(newName);
                                }
                                else if(newName.isEmpty()) {
                                    studentDetails.setName(studentDetails.getName());
                                }

                                // Input new phoneNumber
                                String newPhoneNumber = FunctionToCheck.inputPhoneNumber("Input Student's Phone Number: ");
                                if(!newPhoneNumber.isEmpty()){
                                    studentDetails.setPhoneNumber(newPhoneNumber);
                                }
                                else if(newPhoneNumber.isEmpty()) {
                                    studentDetails.setPhoneNumber(studentDetails.getPhoneNumber());
                                }

                                // Input new Email
                                String newEmail = FunctionToCheck.inputStudentEmail("Input Student's Email: ");
                                if(!newEmail.isEmpty()){
                                    studentDetails.setEmail(newEmail);
                                }
                                else if(newEmail.isEmpty()) {
                                    studentDetails.setEmail(studentDetails.getEmail());
                                }

                                // Input new mountain code
                                String newMountainCode = FunctionToCheck.inputMountainCode("Input Mountain Code: ");
                                if(!newMountainCode.isEmpty()){
                                    studentDetails.setMountainCode(newMountainCode);
                                }
                                else if(newMountainCode.isEmpty()) {
                                    studentDetails.setMountainCode(studentDetails.getMountainCode());
                                }
                            }
                        }
                        if(studentFound == false){
                            System.out.println("This Student's ID Is Not Exist !!!");
                        }
                        break;
                    }

                    case 2:{
                        break;
                    }
                }
            }while (choice != 2);

        }
    }

    //3. Create the function to display the List
    public static void printListStudent(){
        if(list.isEmpty()){
            System.out.println("No Students Have Registered yet !!!");
        }
        else{
            for(StudentDetails studentDetails : list){
                System.out.println(studentDetails);
            }
        }
    }

    //4. Create the function to delete information of student
    public static void deleteRegistrationInformation(){
        StudentDetails deletedInformation = null;
        int choice = 0;
        boolean checkInputValid = false;
        if(list.isEmpty()){
            System.out.println("No Students Have Registered yet !!!");
        }
        else{
            String inputIDToSearch = FunctionToCheck.checkString("Input ID To Delete: ");
            for(StudentDetails studentDetails : list){
                if(studentDetails.getStudentID().equalsIgnoreCase(inputIDToSearch)){
                    System.out.println(studentDetails);
                    deletedInformation = studentDetails;
                    break;
                }
            }

            if(deletedInformation == null){
                System.out.println("This Student's ID Is Not Exist !!!");
                System.out.println("Do You Want To Input Again ?");
                System.out.println("1. Yes");
                System.out.println("2. No (Back To The Menu)");
                do{
                    try{
                        choice = FunctionToCheck.checkInteger("Input Your Choice: ");
                        if(choice < 1 || choice > 2){
                            throw new Exception();
                        }
                        else{
                            checkInputValid = true;
                        }
                    }
                    catch (Exception e){
                        System.out.println("Please Input Again (1-2)!!!");
                        checkInputValid = false;
                    }
                }while (!checkInputValid);

                switch (choice){
                    case 1:{
                        deleteRegistrationInformation();
                        break;
                    }
                    case 2:{
                        return;
                    }
                }
            }

            do{
                try {
                    System.out.println("Are You Sure To Delete ???");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    choice = FunctionToCheck.checkInteger("Input Your Choice: ");
                    if (choice < 1 || choice > 2){
                        throw new Exception();
                    }
                    else{
                        checkInputValid = true;
                    }
                }
                catch (Exception e){
                    System.out.println("Please Input Again (1-2) !!! ");
                    checkInputValid = false;
                }
            }while (checkInputValid == false);
            switch (choice){
                case 1:{
                    list.remove(deletedInformation);
                    break;
                }
                case 2:{
                    return;
                }
            }

        }
    }

    //5. Create the function to search participants by name
    public static void searchByName(){
        String inputNameToSearch = "";
        boolean checkChoice = false;
        boolean checkFoundStudent = false;
        int choice = 0;
        if(list.isEmpty()){
            System.out.println("No Students Have Registered yet !!!");
        }
        else{
            inputNameToSearch = FunctionToCheck.inputStudentName("Input Student's Name To Search: ");
            for(StudentDetails studentDetails : list){
                if (studentDetails.getName().equalsIgnoreCase(inputNameToSearch)){
                    System.out.println(studentDetails);
                    checkFoundStudent = true;
                }
            }


            // If input invalid Student's Name, User can re-choice.
            if(checkFoundStudent == false){
                System.out.println("This Student's Name Is Not Exist !!!");
                System.out.println("Do You Want To Input Again ?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                do{
                    try {
                        choice = FunctionToCheck.checkInteger("Input Your Choice: ");
                        if(choice < 1 || choice > 2){
                            throw new Exception();
                        }
                        else{
                            checkChoice = true;
                        }
                    }
                    catch (Exception e){
                        System.out.println("Please Input Again (1-2)");
                        checkChoice = false;
                    }
                }while (checkChoice == false);
                switch (choice){
                    case 1:{
                        searchByName();
                        break;
                    }
                    case 2:{
                        return;
                    }
                }
            }

            do{
                System.out.println("1. Search Again");
                System.out.println("2. Back To Menu");
                try {
                    choice = FunctionToCheck.checkInteger("Input Your Choice: ");
                    if(choice < 1 || choice > 2){
                        throw new Exception();
                    }
                    else{
                        checkChoice = true;
                    }
                }
                catch (Exception e){
                    System.out.println("Please Input Again (1-2) !!!");
                    checkChoice = false;
                }
            }while (!checkChoice);
            switch (choice){
                case 1:{
                    searchByName();
                    break;
                }
                case 2:{
                    return;
                }
            }

        }

    }

    //6. Create the function to filter the data by campus
    public static void filterByCampus(){
       String inputCampus = "";
       boolean checkCampus = false;
       boolean checkChoice = false;
       int choice = 0;
       if(list.isEmpty()){
           System.out.println("No Students Have Registered yet !!!");
       }
       else{
           System.out.println("Cần Thơ = C/c");
           System.out.println("Sài Gòn = S/s");
           System.out.println("Quy Nhơn = Q/q");
           System.out.println("Đà Nẵng = D/d");
           System.out.println("Hà Nội = H/h");
           inputCampus = FunctionToCheck.checkString("Input Campus To Search: ");
           for(StudentDetails studentDetails : list){
               if(studentDetails.getStudentID().trim().substring(0,1).equalsIgnoreCase(inputCampus)){
                   System.out.println(studentDetails);
                   checkCampus = true;
               }
           }
           if(checkCampus == false){
               System.out.println("This Campus Is Not Exist !!!");
               System.out.println("Do You Want To Input Again ?");
               System.out.println("1. Yes");
               System.out.println("2. No (Back To Menu)");
               do{
                   try {
                       choice = FunctionToCheck.checkInteger("Input Your Choice: ");
                       if (choice < 1 || choice > 2){
                           throw new Exception();
                       }
                       else{
                           checkChoice = true;
                       }
                   }
                   catch (Exception e){
                       System.out.println("Please Input Again (1-2) !!!");
                       checkChoice = false;
                   }
               }while (checkChoice == false);

               switch (choice){
                   case 1:{
                       filterByCampus();
                       break;
                   }
                   case 2:{
                       return;
                   }
               }
           }

           do{
               System.out.println("1. Filter The Campus Again");
               System.out.println("2. Back To Menu");
               try {
                   choice = FunctionToCheck.checkInteger("Input Your Choice: ");
                   if(choice < 1 || choice > 2){
                       throw new Exception();
                   }
                   else{
                       checkChoice = true;
                   }
               }
               catch (Exception e){
                   System.out.println("Please Input Again (1-2) !!!");
                   checkChoice = false;
               }
           }while (checkChoice == false);

           switch (choice){
               case 1:{
                   filterByCampus();
                   break;
               }
               case 2:{
                   return;
               }
           }
       }

    }

    //7. Create the function to work with file (Read From File)
    public static void readFromFile(File file){
        try{
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            StudentDetails object = null;
            while(true){
                Object oj = ois.readObject();
                if (oj == null) {
                    break;
                }
                if(oj != null){
                    object = (StudentDetails) oj;
                    list.add(object);
                }
            }
            ois.close();
        }
        catch (Exception e){
            e.printStackTrace();

        }
    }

    //8. Create the function to work with file (Write file to laptop)
    public static void  writeToFile(File file){
        try {
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);

            for (StudentDetails studentDetails : list){
                oos.writeObject(studentDetails);
            }

            oos.flush();
            oos.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    //9. Create the function to Exit
    public static void Exit(){
        int choiceToExit = 0;
        boolean checkToExit = false;
        System.out.println("Really to Exit ???");

        do{
            System.out.println("1. Yes ");
            System.out.println("2. No ( Back to menu ) ");

            do {
                try {
                    choiceToExit = FunctionToCheck.checkInteger("Input your choice: ");
                    if (choiceToExit < 1 || choiceToExit > 2){
                        throw new Exception();
                    }
                    checkToExit = true;
                }
                catch (Exception e){
                    System.out.println("Input again 1 or 2 !!!");
                    checkToExit = false;
                }
            }while (checkToExit == false);

            switch (choiceToExit){
                case 1:{
                    System.out.println("");
                    System.out.println("<3 <3 <3 <3 <3 <3 GOOD BYE <3 <3 <3 <3 <3 <3 ");
                    System.exit(0);
                    break;
                }
                case 2: {
                    break;
                }
            }
        }while (choiceToExit != 2);
    }

}
