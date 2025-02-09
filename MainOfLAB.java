package View;

import Controller.FunctionToCheck;
import Controller.FunctionOfStatistic;
import Controller.FunctionOfStudentDetails;

import java.io.File;

public class MainOfLAB {
    public static void main(String[] args) {
        int choice = 0;
        boolean checkChoice = false;

        do{
            System.out.println("-----------------MENU-----------------");
            System.out.println("1. Add New Registration");
            System.out.println("2. Update Registration Information");
            System.out.println("3. Display Registered List");
            System.out.println("4. Delete Registration Information");
            System.out.println("5. Search Participants by Name");
            System.out.println("6. Filter Data by Campus");
            System.out.println("7. Statistics of Registration Numbers by Location");
            System.out.println("8. Save Data to File ");
            System.out.println("0. Exit the Program ");
            System.out.println("");
            do{
                choice = FunctionToCheck.checkInteger("Input Your Choice: ");
                if (choice < 0 || choice > 8){
                    checkChoice = false;
                }
                else{
                    checkChoice = true;
                }
            }while (!checkChoice);
            switch (choice){
                // Add new Student
                case 1:{
                    FunctionOfStudentDetails.addStudentRegistration();
                    System.out.println("Done !!!");
                    break;
                }
                // Update Infor
                case 2:{
                    FunctionOfStudentDetails.updateTheInformation();
                    System.out.println("Done !!!");
                    break;
                }
                // Print List
                case 3:{
                    FunctionOfStudentDetails.printListStudent();
                    System.out.println("Done !!!");
                    break;
                }
                //Delete Student
                case 4:{
                    FunctionOfStudentDetails.deleteRegistrationInformation();
                    System.out.println("Done !!!");
                    break;
                }
                // Search Student By Name
                case 5:{
                    FunctionOfStudentDetails.searchByName();
                    System.out.println("Done !!!");
                    break;
                }
                // Filter Data
                case 6:{
                    FunctionOfStudentDetails.filterByCampus();
                    System.out.println("Done !!!");
                    break;
                }
                // Statistics Of Registration
                case 7:{
                    String pathToReadStudentFile = FunctionToCheck.checkString("Input The Path Of Student's File");
                    File read = new File(pathToReadStudentFile);
                    FunctionOfStudentDetails.readFromFile(read);

                    File fr = new File("D:\\MountainList.txt");
                    FunctionOfStatistic.readFromFile(fr);
                    FunctionOfStatistic.printListOfMountain();
                    FunctionOfStatistic.statisticParticipants();
                    System.out.println("Done !!!");
                    break;
                }
                // Filter Data By Campus
                case 8:{
                    String PathToSave = FunctionToCheck.checkString("Input The Path To Save: ");
                    File fw = new File(PathToSave);
                    FunctionOfStudentDetails.writeToFile(fw);
                    System.out.println("Done !!!");
                    break;
                }
                // Exit
                case 0:{
                    FunctionOfStudentDetails.Exit();
                    break;
                }
            }
        }while (true);

    }
}
