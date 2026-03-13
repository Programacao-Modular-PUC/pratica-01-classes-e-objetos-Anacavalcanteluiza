package imc;

import java.util.Scanner;
import java.util.Calendar;

public class IMC {

    static class Data {
        int dia, mes, ano;

        Data(int dia, int mes, int ano) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        }
    }

    private String nome;
    private String sobrenome;
    private float altura;
    private float peso;
    private float imc;
    private Data dataNascimento;

    public IMC(String nome, String sobrenome, float altura, float peso, Data dataNascimento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.altura = altura;
        this.peso = peso;
        this.dataNascimento = dataNascimento;
    }

    public void calculaIMC() {
        imc = (float) (peso / Math.pow(altura, 2));
    }

    public int calculaIdade() {
        Calendar hoje = Calendar.getInstance();
        int idade = hoje.get(Calendar.YEAR) - dataNascimento.ano;

        if (hoje.get(Calendar.MONTH) + 1 < dataNascimento.mes ||
           (hoje.get(Calendar.MONTH) + 1 == dataNascimento.mes &&
            hoje.get(Calendar.DAY_OF_MONTH) < dataNascimento.dia)) {
            idade--;
        }
        return idade;
    }

    public String classificacao() {
        if (imc < 18.5) return "Abaixo do peso";
        else if (imc < 25) return "Peso normal";
        else if (imc < 30) return "Sobrepeso";
        else if (imc < 35) return "Obesidade grau 1";
        else if (imc < 40) return "Obesidade grau 2";
        else return "Obesidade grau 3";
    }

    public String getNome() { return nome; }
    public String getSobrenome() { return sobrenome; }
    public float getAltura() { return altura; }
    public float getPeso() { return peso; }
    public float getImc() { return imc; }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in).useLocale(java.util.Locale.US);
        IMC[] pessoas = new IMC[10];
        int count = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Nome: ");
            String nome = entrada.nextLine();
            System.out.print("Sobrenome: ");
            String sobrenome = entrada.nextLine();

            if (i > 0) {
                String atual = nome + sobrenome;
                String anterior = pessoas[i-1].getNome() + pessoas[i-1].getSobrenome();
                if (atual.equalsIgnoreCase(anterior)) {
                    System.out.println("Nome repetido, encerrando cadastro.");
                    break;
                }
            }

            System.out.print("Data de nascimento (dd/mm/aaaa): ");
            String dataStr = entrada.nextLine();
            String[] partes = dataStr.split("/");
            Data data = new Data(
                Integer.parseInt(partes[0]),
                Integer.parseInt(partes[1]),
                Integer.parseInt(partes[2])
            );

            System.out.print("Altura (ex: 1.70): ");
            float altura = Float.parseFloat(entrada.nextLine());
            System.out.print("Peso: ");
            float peso = Float.parseFloat(entrada.nextLine());

            IMC p = new IMC(nome, sobrenome, altura, peso, data);
            p.calculaIMC();
            pessoas[i] = p;
            count++;
        }

        System.out.println("\n");
        for (int i = 0; i < count; i++) {
            IMC p = pessoas[i];
            System.out.println("Cadastro " + (i + 1) + ":");
            System.out.println("Nome completo: " + p.getNome() + " " + p.getSobrenome());
            System.out.println("Nome de referência: " + p.getSobrenome() + ", " + p.getNome().toUpperCase());
            System.out.println("Idade: " + p.calculaIdade());
            System.out.printf("Peso: %.1f%n", p.getPeso());
            System.out.printf("Altura: %.2f%n", p.getAltura());
            System.out.printf("IMC: %.2f%n", p.getImc());
            System.out.println("Classificação: " + p.classificacao());
            System.out.println();
        }

        entrada.close();
    }
}