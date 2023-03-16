public class Buku {
    // Attribute
    private String namaBuku, isbn, jenisBuku, namaPengarang, namaPenerbit, tahunTerbit, jumlahHalaman;
    // Setter
    public void setNamaBuku(String s) {
        this.namaBuku = s;
    }
    
    public void setNamaPengarang(String s) {
        this.namaPengarang = s;
    }
    
    public void setNamaPenerbit(String s) {
        this.namaPenerbit = s;
    }

    public void setTahunTerbit(String s) {
        this.tahunTerbit = s;
    }
    
    public void setJumlahHalaman(String s) {
        this.jumlahHalaman = s;
    }

    public void setIsbn(String s) {
        this.isbn = s;
    }
    
    public void setJenisBuku(String s) {
        this.jenisBuku = s;
    }
    
    // Display book specification
    public void printBuku() {
        System.out.printf("Nama Buku     : %s\n", namaBuku);
        System.out.printf("Pengarang     : %s\n", namaPengarang);
        System.out.printf("Penerbit      : %s\n", namaPenerbit);
        System.out.printf("Tahun Terbit  : %s\n", tahunTerbit);
        System.out.printf("Jumlah Halaman: %s hal.\n", jumlahHalaman);
        System.out.printf("ISBN          : %s\n", isbn);
        System.out.printf("Jenis Buku    : %s\n", jenisBuku);
    }

}
