package imc;

import java.util.Scanner;

public class IMC {

    // atributos
    private String nome;
    private String sobrenome;
    private int idade;
    private float altura;
    private float peso;
    private float imc;

    public IMC(String nome, String sobrenome, int idade, float altura, float peso) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }

    public void calculaIMC() {
        imc = (float) (peso / Math.pow(altura, 2));
    }

    public void informaObesidade() {
        if (imc == 0) {
            System.out.println("Calcule o IMC primeiro");
            return;
        }
        if (imc < 18.5) {
            System.out.println("Abaixo do peso");
        } else if (imc < 25) {
            System.out.println("Peso normal");
        } else if (imc < 30) {
            System.out.println("Sobrepeso");
        } else if (imc < 35) {
            System.out.println("Obesidade grau 1");
        } else if (imc < 40) {
            System.out.println("Obesidade grau 2");
        } else {
            System.out.println("Obesidade grau 3");
        }
    }

    public String getNome(){ return nome; }
    public String getSobrenome() { return sobrenome; }
    public int getIdade() { return idade; }
    public float getAltura() { return altura; }
    public float getPeso() { return peso; }
    public float getImc() { return imc; }

    public void setNome(String nome) { this.nome = nome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }
    public void setIdade(int idade) { this.idade = idade; }
    public void setAltura(float altura) { this.altura = altura; }
    public void setPeso(float peso) { this.peso = peso; }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in).useLocale(java.util.Locale.US);

        System.out.print("Nome: ");
        String nome = entrada.nextLine();
        System.out.print("Sobrenome: ");
        String sobrenome = entrada.nextLine();
        System.out.print("Idade: ");
        int idade = entrada.nextInt();
        System.out.print("Altura (ex: 1.70): ");
        float altura = entrada.nextFloat();
        System.out.print("Peso: ");
        float peso = entrada.nextFloat();

        IMC p = new IMC(nome, sobrenome, idade, altura, peso);
        p.calculaIMC();

        System.out.println("\n" + p.getNome() + " " + p.getSobrenome());
        System.out.printf("IMC: %.2f%n", p.getImc());
        p.informaObesidade();

        entrada.close();
    }
}