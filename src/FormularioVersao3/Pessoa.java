package FormularioVersao3;

/**
 *
* Dupla: João Victor Lima Venceslau - Rayssa Silva de Oliveira
 */

public class Pessoa {
    private static int kp;
    private String nome;
    private char sexo;
    private int idade;

    public Pessoa() {
        nome = "";
        sexo = ' ';
        idade = 0;
    }

    public Pessoa(String nome, char sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    }

    public void setKp() {
        kp++;
    }

    public static int getKp() {
        return kp;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public char getSexo() {
        return sexo;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }
}
