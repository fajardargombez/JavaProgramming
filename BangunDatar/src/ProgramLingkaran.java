class Lingkaran extends BangunDatar {
    private int radius;
    Lingkaran(){
        namaBangun = "lingkaran";
        radius = input.nextInt();
        setKeliling();
        setLuas();
    }

    void setKeliling(){
        keliling = 2*radius*Math.PI;
    }
    
    void setLuas(){
        luas = Math.PI * Math.pow(radius, 2);
    }
    
}

public class ProgramLingkaran {

    public static void main(String[] args) {
        System.out.print("Masukkan nilai jari-jari lingkaran: ");
        Lingkaran bangun1 = new Lingkaran();
        bangun1.getKeliling();
        bangun1.getLuas();
    }
}