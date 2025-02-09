package Controller;

import Model.MountainDetails;
import Model.StudentDetails;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FunctionOfStatistic {
    static List<MountainDetails> listMoutain = new ArrayList<>();

    // Create the function to statistic
    public static void readFromFile(File file){
       try {
           FileReader fr = new FileReader(file);
           BufferedReader br = new BufferedReader(fr);
           String line;
           br.readLine();
           while((line = br.readLine()) != null){
               // Tách dữ liệu theo khoảng trắng
               String [] parts = line.split("\\s{2,}");
               if(parts.length == 3){
                   String mountainCode = parts[0].trim();
                   String mountainName = parts[1].trim();
                   String province = parts[2].trim();
//                   // Xử lí cột description (nếu có)
//                   StringBuilder description = new StringBuilder();
//                   while( (line = br.readLine()) != null && !line.trim().isEmpty()){
//                       description.append(line.trim()).append(" ");
//                   }

                   // Thêm đối tượng vào list
                   MountainDetails mountain = new MountainDetails(mountainCode, mountainName, province);
                   listMoutain.add(mountain);
               }
           }
       }
       catch (Exception e){
           e.printStackTrace();
       }
    }

    // Create the function to print the statistic of participants
    public static void statisticParticipants(){
        for(StudentDetails student : FunctionOfStudentDetails.list){
            for(MountainDetails mountain : listMoutain){
                if(student.getMountainCode().equalsIgnoreCase(mountain.getMountainCode())){
                    mountain.setNumberOfParticipants(mountain.getNumberOfParticipants() + 1);
                    mountain.setTotalOfCost(mountain.getTotalOfCost() + student.getTuitionFee());
                }
            }
        }

        System.out.println("----------------------------------------------------------------------");
        System.out.println("Peak name          | Number Of Participants    | Total Cost");
        for(MountainDetails statistics : listMoutain){
            if(statistics.getNumberOfParticipants() != 0){
                System.out.println(statistics.toStringStatistics());
            }
        }
        System.out.println("----------------------------------------------------------------------");
    }

    // Create the function to print the statistic of mountain
    public static void printListOfMountain(){
        if(listMoutain.isEmpty()){
            System.out.println("List Is Empty !!!");
        }
        else{
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Code                   | Mountain's Name       | Province");
            for(MountainDetails mountain : listMoutain){
                System.out.println(mountain.toStringMountainInfo());
            }
            System.out.println("----------------------------------------------------------------------");
        }
    }

}
