package com.example.keabilabonnement;

public class ConsoleInformation {
    public static void Print(){
        System.out.println("""
                KEABilAbonnement
                
                Powered by Spring and Thymeleaf
                
                Authors:
                    Stefan Andreas Jensen aka Harry Maguire
                    Martin Hansen aka Pepsi Martin
                    Murat Kaan aka Djengis Kaan
                    Nikki Deleuran aka Nikki Delorian
                
                Endpoints:
                    Root: http://localhost:8080/
                    Agreement overview: http://localhost:8080/overview
                    Create agreement: http://localhost:8080/rental/new
                    Create damage report: http://localhost:8080/report/new
                """);
    }
}
