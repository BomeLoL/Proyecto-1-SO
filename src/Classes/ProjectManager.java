/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Classes;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author andreaV 
 */
public class ProjectManager implements Runnable {
    
    private int remainingDays; 
    private double salary; 
    private int infractions; 
    private double infractionDeduction; 
    private Semaphore daysSemaphore; 
    private boolean isWatchingAnime; 
    private final int workhours = 8; 
    private final int animeWorlHours = 16; 
    private Random random; 
    

    public ProjectManager(int remainingDays, Semaphore daysSemaphore) {
        this.remainingDays = remainingDays;
        this.salary = 40; // $40 por hora, trabaje o vea anime
        this.infractions = 0;
        this.infractionDeduction = 0;
        this.daysSemaphore = daysSemaphore;
        this.isWatchingAnime = false;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int hour = 0; hour < 24; hour++) {
            if (hour < animeWorlHours) {  // Las primeras 16 horas del día alterna entre ver anime y trabajar
                if (hour % 2 == 0) {
                    watchAnime(hour);
                } else {
                    workOnProject(hour);
                }
            } else if (hour < animeWorlHours + workhours) { // Últimas 8 horas del día las invierte en actualizar el contador de días
                try {
                    updateDaysCounter();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

  
    private void watchAnime(int hour) {
        isWatchingAnime = true;
        System.out.println("PM está viendo anime a la hora: " + hour);
    }

    
    private void workOnProject(int hour) {
        isWatchingAnime = false;
        System.out.println("PM está trabajando en el proyecto a la hora: " + hour);
    }

    
    private void updateDaysCounter() throws InterruptedException {
        daysSemaphore.acquire(); 
        try {
            remainingDays--;
            System.out.println("PM actualiza el contador. Días restantes: " + remainingDays);
        } finally {
            daysSemaphore.release(); 
        }
    }

    
    public void receiveInfraction() {
        infractions++;
        infractionDeduction += 100;
        System.out.println("PM recibe una infracción. Total infracciones: " + infractions + ". Deducción total: $" + infractionDeduction);
    }

   
    public int getRemainingDays() {
        return remainingDays;
    }

    public void setRemainingDays(int remainingDays) {
        this.remainingDays = remainingDays;
    }

    
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

 
    public int getInfractions() {
        return infractions;
    }

    public void setInfractions(int infractions) {
        this.infractions = infractions;
    }

   
    public double getInfractionDeduction() {
        return infractionDeduction;
    }

    public void setInfractionDeduction(double infractionDeduction) {
        this.infractionDeduction = infractionDeduction;
    }

 
    public Semaphore getDaysSemaphore() {
        return daysSemaphore;
    }

    public void setDaysSemaphore(Semaphore daysSemaphore) {
        this.daysSemaphore = daysSemaphore;
    }

    
    public boolean isWatchingAnime() {
        return isWatchingAnime;
    }
}
    
    
    
    
            
    











