package Controller;

import java.util.Scanner;

public class FunctionToCheck {
    public static String checkString(String statement){
        System.out.print(statement);
        String inputString = new Scanner(System.in).nextLine();
        return inputString;
    }

    public static int checkInteger (String statement){
        boolean checkInteger = false;
        int inputInteger = 0;
        do{
            try{
                String temp = checkString(statement);
                inputInteger = Integer.parseInt(temp);
                checkInteger = true;
            }
            catch (Exception e){
                System.out.println("Please Input Valid Integer !!!");
                checkInteger = false;
            }

        }while (!checkInteger);
        return inputInteger;
    }

    public static String inputStudentID(String statement){
        boolean checkID = false;
        String inputID = "";
        do{
                inputID = checkString(statement);
                if(inputID.isEmpty()){
                    return "";
                }
                if (Validation.validStudentID(inputID)){
                    checkID = true;
                }
                else{
                    System.out.println("Please Input Valid Student's ID !!!");
                    checkID = false;
                }
        }while (!checkID);
        return inputID;
    }

    public static String inputStudentName(String statement){
        boolean checkName = false;
        String inputName = "";
        do{
               inputName = checkString(statement);
               if (inputName.isEmpty()){
                   return "";
               }
               if (Validation.validName(inputName)){
                   checkName = true;
               }
               else{
                   System.out.println("Please Input Valid Student's Name !!!");
                   checkName = false;
               }

        }while (!checkName);
        return inputName;
    }

    public static String inputPhoneNumber(String statement){
        boolean checkPhone = false;
        String inputPhoneNumber = "";
        do{

                inputPhoneNumber = checkString(statement);
                if(inputPhoneNumber.isEmpty()){
                    return "";
                }
                if (Validation.validPhoneNumber(inputPhoneNumber)){
                    checkPhone = true;
                }
                else{
                    System.out.println("Please Input Valid Phone Number !!!");
                    checkPhone = false;
                }

        }while (!checkPhone);
        return inputPhoneNumber;
    }

    public static String inputStudentEmail(String statement){
        boolean checkEmail = false;
        String inputEmail = "";
        do{
                inputEmail = checkString(statement);
                if(inputEmail.isEmpty()){
                    return "";
                }
                if(Validation.validEmail(inputEmail)){
                    checkEmail = true;
                }
                else{
                    System.out.println("Please Input Valid Email !!!");
                    checkEmail = false;
                }

        }while (!checkEmail);
        return inputEmail;
    }

    public static String inputMountainCode (String statement){
        boolean checkMountainCode = false;
        String inputMountainCode = "";
        do{
                inputMountainCode = checkString(statement);
                if(inputMountainCode.isEmpty()){
                    return "";
                }
                if(Validation.validMountainPeak(inputMountainCode)){
                    checkMountainCode=true;
                }
                else {
                    System.out.println("Please Input Valid Mountain Code !!!");
                    checkMountainCode = false;
                }


        }while (!checkMountainCode);
        return inputMountainCode;
    }




}








