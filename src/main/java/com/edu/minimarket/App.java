package com.edu.minimarket;
/** Classe principal do MiniMarket. 
 * @author Davi Carvalho, Pericles Gomes e Larissa Jales
 * @version 1.0 
 * @since Realese 01 da aplicação 
 */

public class App {
    public static void main(String[] args) {
        try {
            AppTerminal.iniciarPrograma();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado!");
        }
    }
}
