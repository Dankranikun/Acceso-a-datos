/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parte2;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Dankrani
 */
public class Parte2_3 {

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            int num1 = 0, num2 = 0;

            System.out.println("Introduce num1: ");
            num1 = scan.nextInt();
            do {
                System.out.println("Introduce num2: ");
                num2 = scan.nextInt();
            } while (num2 <= 0);
            System.out.println(num1 + "/" + num2 + "=" + (num1 / num2));

        } catch (Exception e) {
            System.err.println("No se ha podido realizar la operación.");
        }
    }

}
