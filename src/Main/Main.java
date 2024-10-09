/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Classes.Company;
import Classes.Warehouse;
import Interfaces.Interface;

/**
 *
 * @author kevin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
 
    
    public static void main(String[] args) {
        //esto son datos temporales de prueba, despues lo borramos
        
        Interface inter = new Interface();
        inter.setVisible(true);
      
        Warehouse warehouseApple = new Warehouse(5, "Apple",5,5);
        Company apple = new Company("Apple",warehouseApple,1000);
        apple.AddWorker(1, 5);
        apple.AddWorker(0, 5);
        apple.AddWorker(2, 5);
        apple.AddWorker(3, 2);
        apple.AddWorker(4, 1);
        apple.AddWorker(5, 5);

        //Interface ui = new Interface();
        //ui.setVisible(true);
    }
    
}
