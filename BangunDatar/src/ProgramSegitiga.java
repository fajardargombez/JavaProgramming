class Segitiga extends BangunDatar {
    private int sisi1,sisi2,sisi3;
    Segitiga(){
        namaBangun = "segitiga";
        sisi1 = input.nextInt();
        sisi2 = input.nextInt();
        sisi3 = input.nextInt();
        setKeliling();
        setLuas();
    }

    void setKeliling(){
        keliling = this.sisi1+this.sisi2+this.sisi3;
    }
    
    void setLuas(){
        double s = 0.5 * keliling;
        luas = Math.pow(s*(s-sisi1)*(s-sisi2)*(s-sisi3), 0.5);
    }

}

public class ProgramSegitiga {

    public static void main(String[] args) {
        System.out.println("Masukkan nilai panjang masing-masing sisi segitiga dipisahkan dengan spasi:");
        Segitiga bangun1 = new Segitiga();
        bangun1.getKeliling();
        bangun1.getLuas();
    }
}