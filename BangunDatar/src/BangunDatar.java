import java.util.Scanner;

abstract class BangunDatar {
    protected double luas, keliling;
    protected Scanner input = new Scanner(System.in);
    protected String namaBangun;
    abstract void setKeliling();
    abstract void setLuas();
    protected void getLuas(){
        printHasil("Luas", namaBangun, luas);
    }
    protected void getKeliling(){
        printHasil("Panjang keliling", namaBangun, keliling);
    }
    protected void printHasil(String atribut, String bangun, double nilai) {
        if (nilai == (int) nilai)
            System.out.printf("%s %s : %d\n", atribut, bangun, (int) nilai);
        else
            System.out.printf("%s %s : %.2f\n", atribut, bangun, nilai);
    }
        
}

