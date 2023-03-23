public class Buku {
    // Attribute
    private String namaBuku, namaPengarang, namaPenerbit, tahunTerbit, jumlahHalaman, isbn, jenisBuku, sinopsis;
    private int jumlahKataSinopsis;
    // Constructor Method
    public Buku(String[] barisBuku){
        this.namaBuku = barisBuku[0];
        this.namaPengarang = barisBuku[1];
        this.namaPenerbit = barisBuku[2];
        this.tahunTerbit = barisBuku[3];
        this.jumlahHalaman = barisBuku[4];
        this.isbn = barisBuku[5];
        this.jenisBuku = barisBuku[6];
        this.sinopsis = barisBuku[7];
        this.jumlahKataSinopsis = hitungKataSinopsis(this.sinopsis);
    }  

    public Buku(Buku objBuku){
        this.namaBuku = objBuku.namaBuku;
        this.namaPengarang = objBuku.namaPengarang;
        this.namaPenerbit = objBuku.namaPenerbit;
        this.tahunTerbit = objBuku.tahunTerbit;
        this.jumlahHalaman = objBuku.jumlahHalaman;
        this.isbn = objBuku.isbn;
        this.jenisBuku = objBuku.jenisBuku;
        this.sinopsis = objBuku.sinopsis;
        this.jumlahKataSinopsis = objBuku.jumlahKataSinopsis;
        System.out.println("Objek buku yang anda pilih telah terduplikasi dengan sempurna");
    }

    // Display book specification
    public void printBuku() {
        System.out.printf("\nNama Buku     : %s\n", namaBuku);
        System.out.printf("Pengarang     : %s\n", namaPengarang);
        System.out.printf("Penerbit      : %s\n", namaPenerbit);
        System.out.printf("Tahun Terbit  : %s\n", tahunTerbit);
        System.out.printf("Jumlah Halaman: %s hal.\n", jumlahHalaman);
        System.out.printf("ISBN          : %s\n", isbn);
        System.out.printf("Jenis Buku    : %s\n", jenisBuku);
        System.out.printf("%s\n",sinopsis);
    }

    public int getJumlahKataSinopsis(){
        return this.jumlahKataSinopsis;
    }

    public int hitungKataSinopsis(String sinopsis){
        int hitung=0;
        char ch[] = new char[sinopsis.length()];
        for (int i=0 ; i<ch.length ; i++){
            ch[i] = sinopsis.charAt(i);
            if ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')||(i==0)&&(ch[i]!=' '))
                hitung++;
        }
        return hitung;
    }

}