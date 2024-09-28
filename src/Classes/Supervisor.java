/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

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
    private String currentActivity;
    private int randomTime;
    private ProjectManager pm;

    public Supervisor(int salaryPerHour, Semaphore mutex, int dayDuration, Warehouse warehouse, String currentActivity, int randomTime, ProjectManager pm, int randomHourdDay) {
        this.salaryPerHour = salaryPerHour;
        this.mutex = mutex;
        this.dayDuration = dayDuration;
        this.warehouse = warehouse;
        this.currentActivity = currentActivity;
        this.randomTime = randomTime;
        this.pm = pm;
    }
   
    @Override
    
    public void run(){
        while(true){
            if(this.warehouse.getDeadlineCounter()> 0){
                try{
                    Random random = new Random();
                    int randomNumber = (int) (random.nextDouble()*dayDuration);
                    setRandomTime(randomNumber);
                    sleep(this.randomTime);
                    if (checkPM() == true){
                        this.mutex.acquire();
                        this.mutex.release();
                    }else{
                        int timeLeft = dayDuration - getRandomTime();
                        if (timeLeft!=0){
                            sleep(timeLeft);
                        }
                    }
                    this.mutex.acquire();
                    this.warehouse.setDeadlineCounter(this.warehouse.getDeadlineCounter()-1);
                    this.mutex.release();
                }
                catch(InterruptedException ex){
                    
                }
            
            }else if (this.warehouse.getDeadlineCounter() == 0){
                try{
                    this.mutex.acquire();
                    this.warehouse.setDeadlineCounter(this.warehouse.getDeadline());
                    sleep(this.dayDuration);
                    this.mutex.release();
                }
                catch(InterruptedException ex){
                    
                }
            }
        }
    }
    
    public boolean checkPM(){
        return true;
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

