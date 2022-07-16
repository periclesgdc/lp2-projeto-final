package com.edu.minimarket;

public class App {
    public static void main(String[] args) {
        try {
            AppTerminal.iniciarPrograma();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado!");
        }
    }
}
