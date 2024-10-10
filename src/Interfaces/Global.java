/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import java.util.concurrent.Semaphore;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
/**
 *
 * @author kevin
 */
public class Global {
    final static XYSeries Apple = new XYSeries("Apple");
    final static XYSeries MSI = new XYSeries("MSI");
    final static XYSeriesCollection dataset = new XYSeriesCollection();
    final static Semaphore mutexApple = new Semaphore(1);
    final static Semaphore mutexMSI = new Semaphore(1);
    private static int daycounter = 0;
    
    public static Semaphore getMutexApple() {
        return mutexApple;
    }

    public static Semaphore getMutexMSI() {
        return mutexMSI;
    }

    public static int getDaycounter() {
        return daycounter;
    }

    public static void setDaycounter(int daycounter) {
        Global.daycounter = daycounter;
    }
    
    public static XYSeries getApple() {
        return Apple;
    }

    public static XYSeries getMSI() {
        return MSI;
    }
    
    public static XYSeriesCollection getDataset() {
        return dataset;
    }
       
    public static void addApple(int num1, int num2){
        getApple().add(num1, num2);
    }
    
    public static void addMSI(int num1, int num2){
        getMSI().add(num1, num2);
    }   
 
}



























































//