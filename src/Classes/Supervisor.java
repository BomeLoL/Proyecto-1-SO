/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author kevin
 */
public class Supervisor extends Thread {
    private int salaryPerHour;
    private Semaphore mutex;
    private int dayDuration;
    private float salaryTotal=0;
    private Warehouse warehouse;
    private String currentActivity = "Trabajando";
    private int randomTime = 0;
    private double hours;
    private ProjectManager pm;

    public Supervisor(int salaryPerHour, Semaphore mutex, int dayDuration, Warehouse warehouse, ProjectManager pm) {
        this.salaryPerHour = salaryPerHour;
        this.mutex = mutex;
        this.dayDuration = dayDuration;
        this.warehouse = warehouse;
        this.hours = this.dayDuration/24;
        this.pm = pm;
    }

   
    @Override
    
    public void run(){
        while(true){
        
            if (this.warehouse.getDeadlineCounter() <=0){
                try{
                    this.currentActivity = "Enviando Computadoras";
                    sleep(this.dayDuration);
                    this.mutex.acquire();
                    this.warehouse.setDeadlineCounter(this.warehouse.getDeadline());
                    if(this.warehouse.getPcRegular() <= 0 && this.warehouse.getPcSpecial() <=0){
                        System.out.println("No se entrego ninguna computadora");
                    } else{
                        if(this.warehouse.getPcRegular()>0){
                            this.warehouse.calculateProfitRegular(this.warehouse.getPcRegular());
                            this.warehouse.setPcRegular(0);
                        }
                        if(this.warehouse.getPcSpecial()>0){
                            this.warehouse.calculateProfitSpecial(this.warehouse.getPcSpecial());
                            this.warehouse.setPcSpecial(0);
                        }
                    }
                    this.mutex.release();
                } catch(InterruptedException ex){
                    System.out.println("error en director");
                }
            } else if(this.warehouse.getDeadlineCounter()>0){
                Random random = new Random();
                while((this.randomTime = random.nextInt(24)) == 0){
                    this.randomTime = random.nextInt(24);
                }
                
                for (int i=1; i <=24; i++){
                    try{
                        this.currentActivity = "Trabajando";
                        if(i==this.randomTime){
                            this.currentActivity="Revisando al PM";
                            if(this.randomTime <= 16){
                                System.out.println("LO ATRAPE SI O SI");
                            }
                            mutex.acquire();
                            boolean keepGoing = checkPM();
                            if(!keepGoing){
                                sleep((long) (this.hours/(60/17)));
                            keepGoing = checkPM();
                            }
                            if(!keepGoing){
                                sleep((long)(this.hours/60/17));
                            keepGoing = checkPM();
                            }
                            mutex.release();
                        }
                        sleep((long) (this.hours/(60/35))); //Se llevan los 35 minutos que se requieren
                    }catch(InterruptedException ex){
                        System.out.println("error de director en el run");
                    }
                }
            }
            getSalarySupervisor();
        }

    }
    
    public void getSalarySupervisor() {
        try{
            this.mutex.acquire();
            this.warehouse.setCosts(this.warehouse.getCosts()+this.salaryPerHour*24); //al costo le sumo lo que gano el empleado ese dia            
            this.mutex.release();
            this.salaryTotal+=this.salaryPerHour*24;
            
        }catch(InterruptedException ex) {
                System.out.println("Error!!! del Director en obtenerSalario ");
        }
            
    }
    
    
    public boolean checkPM(){
        if(this.getPm().getStatus().equals("Viendo anime")){
                this.getPm().setFaults(this.getPm().getFaults() + 1);
                this.getPm().setMoneyDeducted(this.getPm().getMoneyDeducted()+ 100);
                this.getPm().setSalaryTotal(this.getPm().getSalaryTotal()- 100);
                return true;
        } else{
            return false;
        }        
    }
    
    public int getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(int salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public Semaphore getMutex() {
        return mutex;
    }

    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }

    public int getDayDuration() {
        return dayDuration;
    }

    public void setDayDuration(int dayDuration) {
        this.dayDuration = dayDuration;
    }

    public float getSalaryTotal() {
        return salaryTotal;
    }

    public void setSalaryTotal(float salaryTotal) {
        this.salaryTotal = salaryTotal;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public String getCurrentActivity() {
        return currentActivity;
    }

    public void setCurrentActivity(String currentActivity) {
        this.currentActivity = currentActivity;
    }

    public int getRandomTime() {
        return randomTime;
    }

    public void setRandomTime(int randomTime) {
        this.randomTime = randomTime;
    }

    public ProjectManager getPm() {
        return pm;
    }

    public void setPm(ProjectManager pm) {
        this.pm = pm;
    }

    
}

