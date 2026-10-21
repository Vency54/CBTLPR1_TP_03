/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formulario;

import java.util.*;

/**
 *
* Dupla: João Victor Lima Venceslau - Rayssa Silva de Oliveira
 */
public class Pessoa {

    private static int kp = 0;
    private String nome;
    private char sexo;
    private int idade;

    public Pessoa() {
        this.nome = "";
        this.sexo = ' ';
        this.idade = 0;

    }

    public Pessoa(String Nome, char Sexo, int Idade) {
        this.nome = Nome;
        this.sexo = Sexo;
        this.idade = Idade;
    }

    public void setKp() {
        kp++;
    }

    public int getKp() {
        return kp;
    }

    public void setNome(String Nome) {
        this.nome = Nome;
    }

    public String getNome() {
        return nome;
    }

    public void setSexo(char Sexo) {
        this.sexo = Sexo;
    }

    public char getSexo() {
        return sexo;
    }

    public void setIdade(int Idade) {
        this.idade = Idade;
    }

    public int getIdade() {
        return idade;
    }
}
