
package ex01;



class TrianguloRetangulo {

    private float h;
    private float c1;
    private float c2;

    public TrianguloRetangulo(float c1, float c2){
        this.c1 = c1;
        this.c2 = c2;
    }

    public double calculaArea(){
        return (c1 * c2) / 2;
    }

    public double calculaHipotenusa(){
        h = (float) Math.sqrt((c1 * c1) + (c2 * c2));
        return h;
    }
}

public class Ex01 {

    public static void main(String[] args) {

        TrianguloRetangulo t = new TrianguloRetangulo(3,4);

        System.out.println("Área: " + t.calculaArea());
        System.out.println("Hipotenusa: " + t.calculaHipotenusa());
    }
}