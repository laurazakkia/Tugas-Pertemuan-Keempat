/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuankeempat;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laura
 */
public class Utama {
    public static void main(String[] args)  {
        try {
            throw new LauraException("Coba duls");
        } catch (LauraException ex) {
            System.out.println("Ditangkap : " +String.valueOf(ex));
        }
    }
}
 