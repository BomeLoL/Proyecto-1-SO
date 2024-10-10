/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Classes;

import Interfaces.Global;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author andreaV 
 */
public class ProjectManager extends Thread {
    private int salaryPerHour;
    private int dayDuration;
    private float salaryTotal=0;
    private int hours;
    private Semaphore mutex;
    private Warehouse warehouse;
    private String status = "Trabajando";
    private int moneyDeducted = 0;
    private int faults = 0;

    public ProjectManager(int salaryPerHour, int dayDuration, Semaphore mutex, Warehouse warehouse) {
        this.salaryPerHour = salaryPerHour;
        this.dayDuration = dayDuration;
        this.hours = this.dayDuration/24;
        this.mutex = mutex;
        this.warehouse = warehouse;
    }
    

    @Override
    public void run() {
    
        while(true){
            //primero se hace que pasen las 16 horas
            for (int i=1; i<=16; i++){
                try{
                    this.status="Trabajando";
                    sleep(this.hours/2); //espera media hora
                    this.status="Viendo anime";
                    sleep(this.hours/2);
                } catch (InterruptedException ex){
                    System.out.println("error en el project manager 1");
                }
            }
        this.status="Trabajando";
        try{
            //ya pasaron las 16 horas, ahora trabaja durante 8 horas
            sleep(this.hours*8); //pasan las 8 horas y baja el contador
            this.mutex.acquire();
            if(this.warehouse.getDeadlineCounter()>0){
                this.warehouse.setDeadlineCounter(this.warehouse.getDeadlineCounter()-1);
            }
            Global.setDaycounter(Global.getDaycounter()+1);
            this.warehouse.setCosts(this.warehouse.getCosts()+this.salaryPerHour*24);
            this.mutex.release();
            this.salaryTotal+=this.salaryPerHour*24;
        } catch (InterruptedException ex){
            System.out.println("error en el project manager 2");
        }
        }
        
    }

    public int getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(int salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
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

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public Semaphore getMutex() {
        return mutex;
    }

    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMoneyDeducted() {
        return moneyDeducted;
    }

    public void setMoneyDeducted(int moneyDeducted) {
        this.moneyDeducted = moneyDeducted;
    }

    public int getFaults() {
        return faults;
    }

    public void setFaults(int faults) {
        this.faults = faults;
    }
    
}
    
    
    
    
    
    
    
           








