/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jd55;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Duong Hoang
 */
public class DoctorRunning {
    
    DoctorMangager manager = new DoctorMangager();
    
    public void showMenu() {
        System.out.println("\n===== DOCTOR MANAGEMENT PROGRAM =====");
        System.out.println("1. Add Doctor");
        System.out.println("2. Update Doctor");
        System.out.println("3. Delete Doctor");
        System.out.println("4. Search Doctor");
        System.out.println("5. Exit");
        System.out.println("=====================================");
    }
    private void handleAddDoctor() {
        System.out.println("\n--- ADD DOCTOR ---");
      
        String code = Validation.getString("Enter Code: ");
        String name = Validation.getString("Enter Name: ");
        String specialization = Validation.getString("Enter Specialization: ");
        int availability = Validation.getInteger("Enter Availability (>=0): ", 0, Integer.MAX_VALUE);
        
    
        Doctor newDoctor = new Doctor(code, name, specialization, availability);
        
        try {
         
            manager.addDoctor(newDoctor);
        } catch (Exception e) {
            
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void handleUpdateDoctor() {
        System.out.println("\n--- UPDATE DOCTOR ---");
        
        
        String code = Validation.getString("Enter Code to update: ");
        
    
        Doctor existingDoctor = manager.getDoctorByCode(code);
        if (existingDoctor == null) {
            System.out.println("Doctor code does not exist");
            return;
        }
        
      
        System.out.println("\nCurrent information:");
        System.out.printf("%-12s | %-20s | %-25s | %-12s%n", 
                         "Code", "Name", "Specialization", "Availability");
        System.out.println("------------------------------------------------------------------------");
        System.out.println(existingDoctor);
        
        System.out.println("\nEnter new information (press Enter to keep current value):");
        
       
        String newName = Validation.getString("New Name: ");
        String newSpecialization = Validation.getString("New Specialization: ");
        Integer newAvailability = Validation.getInteger("New Availability: ",0,Integer.MAX_VALUE);
        
        
        Doctor updateDoctor = new Doctor();
        updateDoctor.setCode(code); 
        
        // update name nếu rỗng thì lấy tên cũ và nếu không rỗng thì lấy tên mới 
        updateDoctor.setName(newName.isEmpty() ? existingDoctor.getName() : newName);
        
        
        updateDoctor.setSpecialization(newSpecialization.isEmpty() ? 
                                     existingDoctor.getSpecialization() : newSpecialization);
        
        
        updateDoctor.setAvailability(newAvailability == null ? 
                                   existingDoctor.getAvailability() : newAvailability);
        
        try {
           
            manager.updateDoctor(updateDoctor);
               
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void handleDeleteDoctor() {
        System.out.println("\n--- DELETE DOCTOR ---");
        
        
        String code = Validation.getString("Enter Code to delete: ");
        
      
        Doctor doctorToDelete = manager.getDoctorByCode(code);
        if (doctorToDelete == null) {
            System.out.println("Doctor code does not exist");
            return;
        }
        
       
        System.out.println("\nDoctor to be deleted:");
        System.out.printf("%-12s | %-20s | %-25s | %-12s%n", 
                         "Code", "Name", "Specialization", "Availability");
        System.out.println("------------------------------------------------------------------------");
        System.out.println(doctorToDelete);
        
      
//        System.out.print("Are you sure you want to delete this doctor? (Y/N): ");
//        String confirm = SCANNER.nextLine().trim().toUpperCase();
        
//        if (confirm.equals("Y")) {
//            try {
//           
//                if (manager.deleteDoctor(doctorToDelete)) {
//                    System.out.println("Doctor deleted successfully!");
//                }
//            } catch (Exception e) {
//                System.out.println("Error: " + e.getMessage());
//            }
//        } else {
//            System.out.println("Delete operation cancelled.");
//        }
        try {
            manager.deleteDoctor(doctorToDelete);
            System.out.println("\nDeleted Doctor has code : " + doctorToDelete.getCode() +" successfully");
            
        } catch (Exception e) {
              System.out.println("Error: " + e.getMessage());
           }
    }
        
        
        private void handleSearchDoctor() {
        System.out.println("\n--- SEARCH DOCTOR ---");
        
    
        String keyword = Validation.getString("Enter search keyword: ");
        
        try {
          
            HashMap<String, Doctor> results = manager.searchDoctor(keyword);
            
            if (results.isEmpty()) {
                System.out.println("No doctors found matching: " + keyword);
            } else {
                System.out.println("\nSearch results (" + results.size() + " found):");
                System.out.printf("%-12s | %-20s | %-25s | %-12s%n", 
                                 "Code", "Name", "Specialization", "Availability");
                System.out.println("------------------------------------------------------------------------");
                
           
                for (Doctor doctor : results.values()) {
                    System.out.println(doctor);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    

    
    
    
    
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DoctorRunning running = new DoctorRunning();
        
        int choice;
        
        do {
            running.showMenu(); 
            choice = Validation.getInteger("Enter your choice (1-5): ", 1, 5);
            
           
            switch (choice) {
                case 1:
                    running.handleAddDoctor();    
                    break;
                case 2:
                    running.handleUpdateDoctor(); 
                    break;
                case 3:
                    running.handleDeleteDoctor(); 
                    break;
                case 4:
                    running.handleSearchDoctor(); 
                    break;
                case 5:
                    System.out.println("Thank you for using Doctor Management System!");
                    break;
            }
        } while (choice != 5); 
    


    }
    
}
