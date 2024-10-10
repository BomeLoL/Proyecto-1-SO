/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;


/**
 *
 * @author kevin
 */
public class Worker extends Thread {
    
    private double counterWorkDone=0; // Cuenta hasta que termina el trabajo, si llega a >= 1 entonces terminó la chamba fabricando una pieza y comienza otra nueva
    private Warehouse warehouse;
    private int workerType; // Tipo de trabajador. 0- placa base, 1- cpus, 2- ram, 3- fuentes de alimentacion, 4- tarjetas graficas, 5- ensambladores
    private int salaryPerHour; // Salario por hora del trabajador
    private Semaphore mutex; // Semaforo, exclusividad
    private int dayDuration; // Duracion del dia 
    private float salaryTotal=0; // Salario acumulado total
    private double productionPerDay; // Tiempo de produccion por dia,considero que sera 1/n donde n es el numero de dias que tarda en completar su labor, por eso se busca que el counterWorkDone se llegue a >=1 
    private String company; //Apple o MSI
    private boolean keepGoing=true; //Variable para detener un hilo 

    public Worker(Warehouse warehouse, int workerType, int salaryPerHour, Semaphore mutex, int dayDuration, double productionPerDay, String company) {
        this.warehouse = warehouse;
        this.workerType = workerType;
        this.salaryPerHour = salaryPerHour;
        this.mutex = mutex;
        this.dayDuration = dayDuration;
        this.productionPerDay = productionPerDay;
        this.company = company;
    }
    
    public void stopGoing() {
        this.keepGoing=false;
    } 
    
    public void Work(){
        counterWorkDone += this.productionPerDay;
        try{
            if (productionPerDay>=1){
                this.mutex.acquire();
                for(int i=1; i<productionPerDay; i++){
                    this.warehouse.AddComponent(this.workerType);
                    counterWorkDone=0;
                }
                this.mutex.release();
            }else{
                if (counterWorkDone>=1){
                    if(this.workerType==5){
                        this.mutex.acquire();
                        if(AssemblerVerificator() == true){
                            this.warehouse.CreatePC();
                        }
                        this.mutex.release();
                    }
                    else{
                        this.warehouse.AddComponent(this.workerType);
                        this.mutex.release();                        
                    }
                counterWorkDone=0;
                }
            }
        }
        catch(InterruptedException ex){
        }
        
    }
    
    public boolean AssemblerVerificator(){
        
        if (this.company.equals("Apple")){
            if(this.warehouse.getPcUntilSpecial()!=0){
                if(this.warehouse.getMotherboard() >= 2 && this.warehouse.getCpu()>=1 && this.warehouse.getRam()>=4 && this.warehouse.getPowerSupply() >=4){
                    return true;
                } else{
                    return false;
                }
            } else{
                if(this.warehouse.getMotherboard() >= 2 && this.warehouse.getCpu()>=1 && this.warehouse.getRam()>=4 && this.warehouse.getPowerSupply() >=4 && this.warehouse.getGraphicCard() >= 2){
                    return true;
                } else{
                    return false;
                }
            } 
        } else{
            if(this.warehouse.getPcUntilSpecial()!=0){
                if(this.warehouse.getMotherboard() >= 2 && this.warehouse.getCpu()>=3 && this.warehouse.getRam()>=4 && this.warehouse.getPowerSupply() >=6){
                    return true;
                }else{
                    return false;
                }
            }else{
                if(this.warehouse.getMotherboard() >= 2 && this.warehouse.getCpu()>=3 && this.warehouse.getRam()>=4 && this.warehouse.getPowerSupply() >=6 && this.warehouse.getGraphicCard()>=5){
                    return true;
                } else{
                    return false;
                }
            }
        }
    }
    
    public void getSalary(){
        try{
            this.mutex.acquire(); // se expropia para añadir el costo en el almacen
            this.warehouse.setCosts(this.warehouse.getCosts()+this.salaryPerHour*24);
            this.mutex.release();
            this.salaryTotal+=this.salaryPerHour*24;
        }catch(InterruptedException ex) {
            System.out.println("erorr en worker salary");
        }
    }
    
    @Override
    public void run(){
        
        while(this.keepGoing){
            try{
                getSalary();
                Work();
                sleep(this.dayDuration);
            }
            catch (Exception e){
            }
        }
        
    }

    public double getCounterWorkDone() {
        return counterWorkDone;
    }

    public void setCounterWorkDone(double counterWorkDone) {
        this.counterWorkDone = counterWorkDone;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public int getWorkerType() {
        return workerType;
    }

    public void setWorkerType(int workerType) {
        this.workerType = workerType;
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

    public double getProductionPerDay() {
        return productionPerDay;
    }

    public void setProductionPerDay(double productionPerDay) {
        this.productionPerDay = productionPerDay;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public boolean isKeepGoing() {
        return keepGoing;
    }

    public void setKeepGoing(boolean keepGoing) {
        this.keepGoing = keepGoing;
    }
    
}
