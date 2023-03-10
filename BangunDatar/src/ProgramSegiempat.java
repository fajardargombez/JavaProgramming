class Segiempat extends BangunDatar {
    private int panjang, lebar;
    Segiempat(){
        namaBangun = "segi empat";
        panjang = input.nextInt();
        lebar = input.nextInt();
        setKeliling();
        setLuas();
    }

    void setKeliling(){
        keliling = 2*(panjang+lebar);
    }
    
    public void getDiagonal(){
        double x = Math.pow((Math.pow(panjang, 2) + Math.pow(lebar, 2)), 0.5);
        printHasil("Panjang diagonal", namaBangun, x);
    }

    void setLuas(){
        luas = panjang * lebar;
    }

}

public class ProgramSegiempat {

    public static void main(String[] args) {
        System.out.print("Masukkan nilai panjang dan lebar segi empat dipisahkan dengan spasi: ");
        Segiempat bangun1 = new Segiempat();
        bangun1.getKeliling();
        bangun1.getDiagonal();
        bangun1.getLuas();
    }
}