/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import java.util.concurrent.Semaphore;

/**
 *
 * @author kevin
 */
public class Global {
    final static Semaphore mutexApple = new Semaphore(1);
    final static Semaphore mutexMSI = new Semaphore(1);
    
    public static Semaphore getMutexApple() {
        return mutexApple;
    }

    public static Semaphore getMutexMSI() {
        return mutexMSI;
    }
}
