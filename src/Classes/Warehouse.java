    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Interfaces.Global;

/**
 *
 * @author kevin
 */
public class Warehouse {
    private int motherboard = 0;
    private int cpu = 0;
    private int ram = 0;
    private int powerSupply = 0;
    private int graphicCard = 0;
    private int pcRegular = 0;
    private int pcSpecial = 0;
    private int pcUntilSpecial;
    private String company;
    private double income = 0;
    private double costs = 0;
    private double utility = 0;
    private int deadline;
    private int deadlineCounter; 

    public Warehouse(int pcUntilSpecial, String company) {
        this.pcUntilSpecial = pcUntilSpecial;
        this.company = company;

    }

    public void AddComponent(int type){
        if (type == 0){
            if(this.motherboard<25){
                this.motherboard+=1;
            }
        } else if (type == 1){
            if(this.cpu<20){
                this.cpu+=1;
            }
        } else if (type == 2){
            if(this.ram<55){
                this.ram+=1;
            }
        } else if (type == 3){
            if(this.powerSupply<35){
                this.powerSupply+=1;
            }
        } else if (type == 4){
            if(this.graphicCard<10){
                this.graphicCard+=1;
            }
        }
    }
    
    public void CreatePC(){
        if (this.company.equals("Apple")){
            motherboard-=2;
            cpu-=1;
            ram-=4;
            powerSupply-=4;        
            if (pcUntilSpecial!=0) {
                pcRegular+=1;
                pcUntilSpecial-=1;
            }
            else{
                graphicCard-=2;
                pcSpecial+=1;
                pcUntilSpecial=5;
            }
        }
        else{
            motherboard-=2;
            cpu-=3;
            ram-=4;
            powerSupply-=6;
            if (pcUntilSpecial!=0){
                pcRegular+=1;
                pcUntilSpecial-=1;
            }
            else{
                graphicCard-=5;
                pcSpecial+=1;
                pcUntilSpecial=6;
            }
        }
        //System.out.println("especial "+this.pcSpecial);  
        //System.out.println("regular "+this.pcRegular);        

    }
    
    public void calculateProfitRegular(float profit){
        if (this.company.equals("Apple")){
            setIncome(getIncome() + income*100000);
            setUtility(getIncome()- getCosts());
            Global.addApple((int) getUtility(), (Global.getDaycounter()-1)/2);

        }
        else{
            setIncome(getIncome()+income*180000);
            setUtility(getIncome()- getCosts());
            Global.addMSI((int) getUtility(), (Global.getDaycounter()-1)/2);
        }
    }
    
    public void calculateProfitSpecial(float profit){
        if (this.company.equals("Apple")){
            setIncome(getIncome() + income*150000);
            setUtility(getIncome()- getCosts());
        }
        else{
            setIncome(getIncome()+income*250000);
            setUtility(getIncome()- getCosts());
        }
    }

    public int getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(int motherboard) {
        this.motherboard = motherboard;
    }

    public int getCpu() {
        return cpu;
    }

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(int powerSupply) {
        this.powerSupply = powerSupply;
    }

    public int getGraphicCard() {
        return graphicCard;
    }

    public void setGraphicCard(int graphicCard) {
        this.graphicCard = graphicCard;
    }

    public int getPcRegular() {
        return pcRegular;
    }

    public void setPcRegular(int pcRegular) {
        this.pcRegular = pcRegular;
    }

    public int getPcSpecial() {
        return pcSpecial;
    }

    public void setPcSpecial(int pcSpecial) {
        this.pcSpecial = pcSpecial;
    }

    public int getPcUntilSpecial() {
        return pcUntilSpecial;
    }

    public void setPcUntilSpecial(int pcUntilSpecial) {
        this.pcUntilSpecial = pcUntilSpecial;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getCosts() {
        return costs;
    }

    public void setCosts(double costs) {
        this.costs = costs;
    }

    public double getUtility() {
        return utility;
    }

    public void setUtility(double utility) {
        this.utility = utility;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public int getDeadlineCounter() {
        return deadlineCounter;
    }

    public void setDeadlineCounter(int deadlineCounter) {
        this.deadlineCounter = deadlineCounter;
    }

}


