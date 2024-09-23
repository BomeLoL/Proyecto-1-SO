/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Classes.Worker;
import DataEstructure.List;
import Interfaces.Global;

/**
 *
 * @author kevin
 */
public class Company {
    private String name;
    private Warehouse warehouse;
    private List listMotherboard;
    private List listCPU;
    private List listRAM;
    private List listPowerSupply;
    private List listGraphic;
    private List listAssembler;
    private int dayDuration;
    
    public Company(String name, Warehouse warehouse,  int dayDuration) {
        this.name = name;
        this.warehouse = warehouse;
        this.listMotherboard = new List();
        this.listCPU = new List();;
        this.listRAM = new List();;
        this.listPowerSupply = new List();;
        this.listGraphic = new List();;
        this.listAssembler = new List();;
        this.dayDuration = dayDuration;
    }
    
    public void AddWorker(int type, int quantity){
        if(type==0){
            for (int i=0; i<quantity; i++){
                if (this.name.equals("Apple")){
                    Worker motherboardApple=new Worker(getWarehouse(),0,20,Global.getMutexApple(),getDayDuration(),0.5,getName());
                    getListMotherboard().insertBegin(motherboardApple);
                    motherboardApple.start();
                }
                else{
                    Worker motherboardMSI=new Worker(getWarehouse(),0,20,Global.getMutexMSI(),getDayDuration(),0.34,getName());
                    getListMotherboard().insertBegin(motherboardMSI);
                    motherboardMSI.start();
                }
            }
        }
        if(type==1){
            for (int i=0; i<quantity; i++){
                if (this.name.equals("Apple")){
                    Worker cpuApple=new Worker(getWarehouse(),1,26,Global.getMutexApple(),getDayDuration(),0.5,getName());
                    getListCPU().insertBegin(cpuApple);
                    cpuApple.start();
                }
                else{
                    Worker cpuMSI=new Worker(getWarehouse(),1,26,Global.getMutexMSI(),getDayDuration(),0.34,getName());
                    getListCPU().insertBegin(cpuMSI);
                    cpuMSI.start();
                }
            }
        }
        if(type==2){
            for (int i=0; i<quantity; i++){
                if (this.name.equals("Apple")){
                    Worker ramApple=new Worker(getWarehouse(),2,40,Global.getMutexApple(),getDayDuration(),3,getName());
                    getListRAM().insertBegin(ramApple);
                    ramApple.start();
                }
                else{
                    Worker ramMSI=new Worker(getWarehouse(),2,40,Global.getMutexMSI(),getDayDuration(),2,getName());
                    getListRAM().insertBegin(ramMSI);
                    ramMSI.start();
                }
            }
        }
        if(type==3){
            for (int i=0; i<quantity; i++){
                if (this.name.equals("Apple")){
                    Worker powerApple=new Worker(getWarehouse(),3,16,Global.getMutexApple(),getDayDuration(),3,getName());
                    getListPowerSupply().insertBegin(powerApple);
                    powerApple.start();
                }
                else{
                    Worker powerMSI=new Worker(getWarehouse(),3,16,Global.getMutexMSI(),getDayDuration(),3,getName());
                    getListPowerSupply().insertBegin(powerMSI);
                    powerMSI.start();
                }
            }
        }
        if(type==4){
            for (int i=0; i<quantity; i++){
                if (this.name.equals("Apple")){
                    Worker graphicApple=new Worker(getWarehouse(),4,34,Global.getMutexApple(),getDayDuration(),0.34,getName());
                    getListGraphic().insertBegin(graphicApple);
                    graphicApple.start();
                }
                else{
                    Worker graphicMSI=new Worker(getWarehouse(),4,34,Global.getMutexMSI(),getDayDuration(),0.34,getName());
                    getListGraphic().insertBegin(graphicMSI);
                    graphicMSI.start();
                }
            }
        }
        if(type==5){
            for (int i=0; i<quantity; i++){
                if (this.name.equals("Apple")){
                    Worker assemblerApple=new Worker(getWarehouse(),5,50,Global.getMutexApple(),getDayDuration(),0.5,getName());
                    getListAssembler().insertBegin(assemblerApple);
                    assemblerApple.start();
                }
                else{
                    Worker assemblerMSI=new Worker(getWarehouse(),5,50,Global.getMutexMSI(),getDayDuration(),0.5,getName());
                    getListAssembler().insertBegin(assemblerMSI);
                    assemblerMSI.start();
                }
            }
        }
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public int getDayDuration() {
        return dayDuration;
    }

    public void setDayDuration(int dayDuration) {
        this.dayDuration = dayDuration;
    }

    public List getListMotherboard() {
        return listMotherboard;
    }

    public void setListMotherboard(List listMotherboard) {
        this.listMotherboard = listMotherboard;
    }

    public List getListCPU() {
        return listCPU;
    }

    public void setListCPU(List listCPU) {
        this.listCPU = listCPU;
    }

    public List getListRAM() {
        return listRAM;
    }

    public void setListRAM(List listRAM) {
        this.listRAM = listRAM;
    }

    public List getListPowerSupply() {
        return listPowerSupply;
    }

    public void setListPowerSupply(List listPowerSupply) {
        this.listPowerSupply = listPowerSupply;
    }

    public List getListGraphic() {
        return listGraphic;
    }

    public void setListGraphic(List listGraphic) {
        this.listGraphic = listGraphic;
    }

    public List getListAssembler() {
        return listAssembler;
    }

    public void setListAssembler(List listAssembler) {
        this.listAssembler = listAssembler;
    }
    
    
}


