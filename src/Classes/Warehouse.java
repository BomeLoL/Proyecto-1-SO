    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Interfaces.Global;
import Interfaces.Interface;

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
                if (this.company.equals("Apple")){
                    Interface.getWarehouse_ProduPlacabase_Apple().setText(Integer.toString(motherboard));
                }else{
                    Interface.getWarehouse_ProduPlacabase_MSI().setText(Integer.toString(motherboard));
                }
            }
            else {System.out.println("Drive lleno!! PLACA BASE");        
            }
        } else if (type == 1){
            if(this.cpu<20){
                this.cpu+=1;
                if (this.company.equals("Apple")){
                    Interface.getWarehouse_ProduCPU_Apple().setText(Integer.toString(cpu));
                }else{ 
                    Interface.getWarehouse_ProduCPU_MSI().setText(Integer.toString(cpu));
                }
            }
            else {System.out.println("Drive lleno!! CPU");        
            }
        
        } else if (type == 2){
            if(this.ram<55){
                this.ram+=1;
                if (this.company.equals("Apple")){
                    Interface.getWarehouse_ProdumemoRAM_Apple().setText(Integer.toString(ram));
                }else{ 
                    Interface.getWarehouse_ProdumemoRAM_MSI().setText(Integer.toString(ram));
                }
            }
            else {System.out.println("Drive lleno!! RAM");        
            }
        } else if (type == 3){
            if(this.powerSupply<35){
                this.powerSupply+=1;
              if (this.company.equals("Apple")){
                    Interface.getWarehouse_FuenteAlimen_Apple().setText(Integer.toString(powerSupply));
                }else{ 
                    Interface.getWarehouse_FuenteAlimen_MSI().setText(Integer.toString(powerSupply));
                }
            }
            else {System.out.println("Drive lleno!! BATERIA");        
            }
        } else if (type == 4){
            if(this.graphicCard<10){
                this.graphicCard+=1;
              if (this.company.equals("Apple")){
                    Interface.getWrehouse_TarjeGrafi_Apple().setText(Integer.toString(graphicCard));
                }else{ 
                    Interface.getWrehouse_TarjeGrafi_MSI().setText(Integer.toString(graphicCard));
                }
            }
            else {System.out.println("Drive lleno!! GRAFICA");        
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
                Interface.getWarehouse_Apple_PC_Regular().setText(Integer.toString(pcRegular));
            }
            else{
                graphicCard-=2;
                pcSpecial+=1;
                pcUntilSpecial=5;
                Interface.getWarehouse_Apple_PC_Special().setText(Integer.toString(pcSpecial));
            }
            Interface.getWarehouse_FuenteAlimen_Apple().setText(Integer.toString(powerSupply));
            Interface.getWarehouse_ProduCPU_Apple().setText(Integer.toString(cpu));
            Interface.getWarehouse_ProduPlacabase_Apple().setText(Integer.toString(motherboard));
            Interface.getWarehouse_ProdumemoRAM_Apple().setText(Integer.toString(ram));
            Interface.getWrehouse_TarjeGrafi_Apple().setText(Integer.toString(graphicCard));
        }
        else{
            motherboard-=2;
            cpu-=3;
            ram-=4;
            powerSupply-=6;
            if (pcUntilSpecial!=0){
                pcRegular+=1;
                pcUntilSpecial-=1;
                Interface.getWarehouse_MSI_PC_Regular().setText(Integer.toString(pcRegular));
            }
            else{
                graphicCard-=5;
                pcSpecial+=1;
                pcUntilSpecial=6;
                Interface.getWarehouse_MSI_PC_Special().setText(Integer.toString(pcSpecial));
            }
            Interface.getWarehouse_FuenteAlimen_MSI().setText(Integer.toString(powerSupply));
            Interface.getWarehouse_ProduCPU_MSI().setText(Integer.toString(cpu));
            Interface.getWarehouse_ProduPlacabase_MSI().setText(Integer.toString(motherboard));
            Interface.getWarehouse_ProdumemoRAM_MSI().setText(Integer.toString(ram));
            Interface.getWrehouse_TarjeGrafi_MSI().setText(Integer.toString(graphicCard));
        }
        //System.out.println("especial "+this.pcSpecial);  
        //System.out.println("regular "+this.pcRegular);   


    }
    
    public void calculateProfitRegular(float profit){
        if (this.company.equals("Apple")){
            setIncome(getIncome() + 100000);
            setUtility(getIncome()- getCosts());
            Interface.getApple_Gain_Counter().setText(Integer.toString((int) getIncome())+"$");
            Interface.getApple_Utility_Counter().setText(Integer.toString((int) ((int) getIncome() - getCosts()))+"$");
            Global.addApple((int) getUtility(), (Global.getDaycounter()-1)/2);

        }
        else{
            setIncome(getIncome()+180000);
            setUtility(getIncome()- getCosts());
            Interface.getMSI_Gain_Counter().setText(Integer.toString((int) getIncome())+"$");
            Interface.getMSI_Utility_Counter().setText(Integer.toString((int) ((int) getIncome() - getCosts()))+"$");
            Global.addMSI((int) getUtility(), (Global.getDaycounter()-1)/2);

        }
    }
    
    public void calculateProfitSpecial(float profit){
        if (this.company.equals("Apple")){
            setIncome(getIncome() + 150000);
            setUtility(getIncome()- getCosts());
            Interface.getApple_Gain_Counter().setText(Integer.toString((int) getIncome())+"$");
            Interface.getApple_Utility_Counter().setText(Integer.toString((int) ((int) getIncome() - getCosts()))+"$");
        }
        else{
            setIncome(getIncome()+250000);
            setUtility(getIncome()- getCosts());
            Interface.getMSI_Utility_Counter().setText(Integer.toString((int) ((int) getIncome() - getCosts()))+"$");
            Global.addMSI((int) getUtility(), (Global.getDaycounter()-1)/2);
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


