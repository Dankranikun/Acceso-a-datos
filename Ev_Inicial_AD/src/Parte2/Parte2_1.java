/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parte2;

import java.util.Scanner;

/**
 *
 * @author Dankrani
 */
public class Parte2_1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1, num2;
        
        System.out.println("Introduce num1: ");
        num1 = scan.nextInt();
        System.out.println("Introduce num2: ");
        num2 = scan.nextInt();
        
        System.out.println(num1 + "/" + num2 + "=" + (num1/num2));
    }

}
