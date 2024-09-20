/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuankeempat;

/**
 *
 * @author Laura
 */
public class LauraException extends ArithmeticException {

    public LauraException(String s) {
        super(s);
    }

    public static int bagi(int a, int b) throws LauraException {
        if (b == 0) {
            throw new LauraException("Pembagian dengan nol tidak diperbolehkan.");
        }
        return a / b;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        try {
            int result = bagi(10, 0);
            System.out.println("Hasil: " + result);
        } catch (LauraException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
