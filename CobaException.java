/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuankeempat;

/**
 *
 * @author Laura
 */
public class CobaException {

    // Metode dengan throws untuk pembagian
    public int bagiBilangan(int a, int b) throws ArithmeticException {
        return a / b; // Potensi ArithmeticException
    }

    public static void main(String[] args) {
        CobaException belajar = new CobaException();

        // Menggunakan try-catch untuk menangani ArithmeticException
        try {
            int hasil1 = belajar.bagiBilangan(10, 0); 
            System.out.println("Hasil: " + hasil1);
        } catch (ArithmeticException e) {
            System.out.println("Error: Pembagian dengan nol tidak diperbolehkan.");
        }
    }
}