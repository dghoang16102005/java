/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jd55;

import java.util.HashMap;

/**
 *
 * @author Duong Hoang
 */
public class DoctorMangager {
    private HashMap<String, Doctor> doctorDatabase;

    public DoctorMangager() {
        doctorDatabase = new HashMap<>();
    }
    
    private boolean checkAvailability(int availability) {
        return availability >= 0; // Trả về true nếu >= 0, false nếu < 0
    }
    
        public void addDoctor(Doctor doctor)  {
     
        if (doctorDatabase == null) {
            System.out.println("Database does not exist");
        }
        
    
        if (doctor == null) {
            System.out.println("Data does not exist");
        }
        
        String code = doctor.getCode(); 
        
     
        if (code == null) {
            System.out.println("Doctor code cannot be empty");
        }
        
    
        if (doctorDatabase.containsKey(code)) {
            System.out.println("Doctor code [" + code + "] is duplicate");
        }
        
 
        if (!checkAvailability(doctor.getAvailability())) {
           System.out.println("Availability must be >= 0");
        }
        
      
        doctorDatabase.put(code, doctor);
    
}
        
        public void updateDoctor(Doctor doctor)  {
       
        if (doctorDatabase == null) {
            System.out.println("Database does not exist");
        }
        
     
        if (doctor == null) {
            System.out.println("Data doesn't exist");
        }
        
        String code = doctor.getCode(); 
        
   
        if (code == null || !doctorDatabase.containsKey(code)) {
          System.out.println("Doctor code doesn't exist");
        }

   
        Doctor currentDoctor = doctorDatabase.get(code);
        
     
        if (doctor.getName() != null) {
            currentDoctor.setName(doctor.getName().trim()); 
        }
        
        if (doctor.getSpecialization() != null) {
            currentDoctor.setSpecialization(doctor.getSpecialization().trim()); 
        }
        
      
        int newAvailability = doctor.getAvailability();
        if (newAvailability >= 0) { //
            if (!checkAvailability(newAvailability)) {
               System.out.println("Availability must be >= 0");
            }
            currentDoctor.setAvailability(newAvailability);
        }
        }
        
    public void deleteDoctor(Doctor doctor) {
            
        
        String code = doctor.getCode(); 
        if (doctorDatabase == null) {
            System.out.println("Database does not exist");
        }
        
      
        if (doctor == null) {
            System.out.println("Data doesn't exist");
        }
        
       
        
       
        if ((code == null) || !doctorDatabase.containsKey(code)) {
            System.out.println("Doctor code doesn't exist");
        }
        
      
        doctorDatabase.remove(code);
  
    }

    public HashMap<String, Doctor> searchDoctor(String input) {
     
        if (doctorDatabase == null) {
            System.out.println("Database does not exist");
        }
        
        
        HashMap<String, Doctor> result = new HashMap<>();
        
    
        
        String searchKeyword = (input== null ? "" : input.trim().toLowerCase());
        
    
        for (Doctor doctor : doctorDatabase.values()) {
     
            String searchableText = (doctor.getCode() + " " + 
                                   doctor.getName() + " " + 
                                   doctor.getSpecialization()).toLowerCase();
            
       
            if (searchableText.contains(searchKeyword)) {
                result.put(doctor.getCode(), doctor); 
            }
        }
        
        return result; 
    }
        
    public void displayAllDoctors() {



        if (doctorDatabase == null) {
            System.out.println("No doctors in database.");
       
        }
        
        
        System.out.printf("%-12s | %-20s | %-25s | %-12s%n", 
                         "Code", "Name", "Specialization", "Availability");
        System.out.println("------------------------------------------------------------------------");
        
      
        for (Doctor doctor : doctorDatabase.values()) {
            System.out.println(doctor); 
        }

    }
    
     public Doctor getDoctorByCode(String code) {
        return doctorDatabase.get(code); 
    }
    
    
}

