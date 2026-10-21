/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora;

import javax.swing.SwingUtilities;

/**
 * Construir o Form abaixo e possibilitar o cálculo das operações de divisão,
 * multiplicação, subtração e adição.
 *
 *
 * Dupla: João Victor Lima Venceslau - Rayssa Silva de Oliveira
 *
 * @author User
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Interface().setVisible(true));

    }

}
