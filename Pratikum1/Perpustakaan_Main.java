import java.util.Scanner;

public class Perpustakaan_Main {
    private static Scanner input = new Scanner(System.in);
    private static int pilih;
    /* 
    Table of book attributes
    Index numbers and their associate attributes
    ||     0    |       1       |       2      |      3      |       4       |   5  |     6     ||
    || namaBuku | namaPengarang | namaPenerbit | tahunTerbit | jumlahHalaman | isbn | jenisBuku || 
    */
    private static String[][] daftarBuku = {
    {"1984","George Orwell","Immortal Publishing","2023","468","9786237778981","Fiksi"},
    {"A Gift For Yourself","Samanta Elsener Dan Shita Dewi","Baca","2023","213","9786026486882","Psikologi"},
    {"Aplikasi Perkantoran Era Industrialisasi 4.0","Imam Heryanto & Hernawati","Informatika","2023","568","9786237131656","Teknologi"},
    {"Bahagia Beragama Bersama Gus Baha","Khoirul Anam","Elex Media Komputindo","2022","160","9786230034763","Agama"},
    {"Banjir Besar Zaman Nabi Nuh","Manshur Abdul Hakim","Alvabet","2023","336","9786232201439","Agama"},
    {"Bui","Alan Th","Kepustakaan Populer Gramedia","2023","428","9786024819293","Fiksi"},
    {"Ca-Bau-Kan (Hanya Sebuah Dosa)","Remy Sylado","Kepustakaan Populer Gramedia","2023","392","9786024818753","Fiksi"},
    {"Cara Kerja Ilmu Filsafat dan Filsafat Ilmu","A. Setyo Wibowo","Kepustakaan Populer Gramedia","2022","392","9786024819101","Filsafat"},
    {"Chicken Soup For The Soul: Kekuatan Memaafkan","Amy Newmark","Gramedia Pustaka Utama","2018","504","9786020375083","Agama"},
    {"China: Warisan Klasik dan Daya Dinamis yang Menggetarkan Dunia","Jusra Chandra","Gramedia Pustaka Utama","2020","176","9786020636399","Sejarah"},
    {"Desain Grafis dengan Canva untuk Pemula","Jubilee Enterprise","Elex Media Komputindo","2021","200","9786230027710","Teknologi"},
    {"Dramaturgi Politik Indonesia","Muhamad Sulham","Intrans Publishing","2021","142","9786025328169","Politik"},
    {"Ekonomi Politik Daulat Rakyat Indonesia: Pancasila Sebagai Acuan Paradigma","Francis Wahono","Penebit Buku Kompas","2020","352","9786232410749","Politik"},
    {"Filosofi Montessori","Rosalynn Tamara","Bentang Pustaka","2022","100","9786022919179","Filsafat"},
    {"Filosofi Teras (Edisi Baru)","Henry Manampiring","Penerbit Buku Kompas","2022","298","9786233463034","Filsafat"},
    {"Heidegger dan Mistik Keseharian","F. Budi Hardiman","Kepustakaan Populer Gramedia","2020","228","9786024813437","Filsafat"},
    {"Indonesia Tidak Pernah Dijajah","Batara R Hutagalung","Matapadi","2018","256","9786021634257","Sejarah"},
    {"Kerudung Merah Kirmizi","Remy Sylado","Kepustakaan Populer Gramedia","2023","680","9786024818777","Fiksi"},
    {"Kitab Membaca Mikroekspresi dan Gesture","Intan Wulansari","Psikologi Corner","2023","144","9786234003659","Psikologi"},
    {"Komunikasi Politik dalam Pilkada Langsung: Teori dan Praktik Edisi Revisi","Dr. Mahi M. Hikmat, M.Si","Simbiosa Rekatama Media","2020","310","9786027973893","Politik"},
    {"Machine Learning Tingkat Dasar dan Lanjut Edisi-2","Dr. Suyanto, S.T., M.Sc.","Informatika","2023","504","9786237131663","Teknologi"},
    {"MEMAHAMI TRAUMA Dengan Perhatian Khusus pada Masa Kanak-Kanak","Prof. Irwanto, Ph.D., Hani Kumala, M.Psi.,","Gramedia Pustaka Utama","2022","160","9786020658957","Psikologi"},
    {"Mengeksplorasi Fungsi VLOOKUP, HLOOKUP, dan LOOKUP Excel","Yudhy Wicaksono & Solusi Kantor","Elex Media Komputindo","2022","224","9786230031748","Teknologi"},
    {"Merdeka Sejak Hati","A Fuadi","Gramedia Pustaka Utama","2019","300","9786020622965","Agama"},
    {"Muhammad: Kisah Hidup Nabi Berdasarkan Sumber Klasik","Martin Lings","Serambi","2016","524","9786022900689","Agama"},
    {"Negara Hukum Dalam Pemikiran Politik","Dr. Thomas Tokan Pureklolon, M.Ph., M.M., M.Si.","Pt Kanisius","2020","346","SCOOP211571","Politik"},
    {"Panduan Lengkap SPSS 26","Singgih Santoso","Elex Media Komputindo","2020","520","9786230019975","Teknologi"},
    {"Panggil Aku Kartini Saja","Pramoedya Ananta Toer","Lentera Dipantara","2015","262","97997312116","Fiksi"},
    {"Pasang Surut Kerajaan-Kerajaan Di Pulau Jawa Zaman Klasik","The Syaeful Cahyadi","Sociality","2021","264","9786232447240","Sejarah"},
    {"Psikologi Kesehatan - Konsep, Masalah, dan Pemikiran Untuk Indonesia","Eunike Sri Tyas Suci","Penerbit Buku Kompas","2022","516","9786233466783","Psikologi"},
    {"Sang Dewi Api (The Burning God)","R.F. Kuang","Gramedia Pustaka Utama","2023","672","9786020668826","Fiksi"},
    {"Segala Sesuatu Yang Perlu Anda Ketahui Tentang Filsafat","Peter Gibson","Gramedia Pustaka Utama","2020","260","SCOOPG198326","Filsafat"},
    {"Sejarah dan Peradaban Mesir Kuno","Jonar T.h Situmorang, M.a","Andi Offset","2021","214","9786233140461","Sejarah"},
    {"Seni Sederhana Menaklukkan Negative Vibes","Coky Aditya Z","Penerbit Noktah","2023","182","9786236175385","Psikologi"},
    {"Sutan Syahrir: Perdana Menteri Pertama","Endang Kristin, dkk.","Bee Media","2022","72","9786236358887","Sejarah"},
    {"The Righteous Mind","Jonathan Haidt","Kepustakaan Populer Gramedia","2020","480","9786024814915","Politik"},
    {"The World Until Yesterday (2018)","Jared Diamond","Kepustakaan Populer Gramedia","2018","616","9786024247256","Sejarah"},
    {"Tuntunan Manasik Haji Nabi","Syaikh Muhammad Nashiruddin al-Albani","Qisthi Press","2019","139","SCOOPG182587","Agama"},
    {"Ungkap Rahasia Taklukkan Microsoft Excel 2019","Alfa Hartoko","Elex Media Komputindo","2023","368","9786230046292","Teknologi"},
    {"Yang Muda Yang Bekerja","Andika Hazrumy","Gramedia Pustaka Utama","2020","304","9786020649528","Politik"}
    };
    
    private static void memilihJenisBuku(){
        System.out.println("==============PERPUSTAKAAN=============");
        System.out.println("Pilih jenis buku yang mau anda cari:");
        System.out.println("(1) Teknologi");
        System.out.println("(2) Filsafat");
        System.out.println("(3) Sejarah");
        System.out.println("(4) Agama");
        System.out.println("(5) Psikologi");
        System.out.println("(6) Politik");
        System.out.println("(7) Fiksi");
        String pilihanJenis = "";
        do{
            memintaInput();
        switch (pilih) {
            case 1: pilihanJenis = "Teknologi"; break;
            case 2: pilihanJenis = "Filsafat"; break;
            case 3: pilihanJenis = "Sejarah"; break;
            case 4: pilihanJenis = "Agama"; break;
            case 5: pilihanJenis = "Psikologi"; break;
            case 6: pilihanJenis = "Politik"; break;
            case 7: pilihanJenis = "Fiksi"; break;
            default: cobaLagi(); break;
        }
        } while (pilihanJenis == "");
        memilihBuku(pilihanJenis);
    }

    private static void memilihBuku(String pilihanJenis) {
    // This array will records the position of selected books
    int[] indexBuku = new int[6];
    System.out.printf("\nPilih judul buku yang mau anda cari:\n");
    int jumlahBuku = 0;
    for (int i = 0; i < daftarBuku.length; i++) {
        if (daftarBuku[i][6] == pilihanJenis){
        indexBuku[jumlahBuku] = i;
        System.out.printf("(%d) \"%s\"\n",++jumlahBuku, daftarBuku[i][0]);
        }
    }
    System.out.printf("\n(0) Ke menu Sebelumnya\n");

    int indexPilihanBuku = -1;
    do{
        memintaInput();
        if (pilih >= 0 && pilih <= jumlahBuku){
            break;
        }
        cobaLagi();
    } while (true);
    if (pilih == 0){
    System.out.println();
    memilihJenisBuku();
    } else {
    indexPilihanBuku = indexBuku[pilih - 1];
    lihatBuku(daftarBuku[indexPilihanBuku]);
    }
    }

    private static void lihatBuku(String[] pilihanBuku){
        Buku objBuku = new Buku();
        objBuku.setNamaBuku(pilihanBuku[0]);
        objBuku.setNamaPengarang(pilihanBuku[1]);
        objBuku.setNamaPenerbit(pilihanBuku[2]);
        objBuku.setTahunTerbit(pilihanBuku[3]);
        objBuku.setJumlahHalaman(pilihanBuku[4]);
        objBuku.setIsbn(pilihanBuku[5]);
        objBuku.setJenisBuku(pilihanBuku[6]);
        System.out.println();
        objBuku.printBuku();
        System.out.println();
        while (true) {
            System.out.println("Apakah anda mau mencari buku lagi? (1) Ya atau (2) Tidak");
            memintaInput();
            if (pilih == 1 || pilih == 2){
                break;
            }
            cobaLagi();
        }
        if (pilih == 1){
        System.out.println();
        memilihJenisBuku();
        }
    }

    private static void memintaInput() {
        System.out.print("Masukkan angka: ");
        pilih = input.nextInt();
    }    
    
    private static void cobaLagi() {
        System.out.printf("Angka yang anda masukkan tidak dikenali. Silahkan coba lagi\n");
    }

    public static void main(String[] args) {
        memilihJenisBuku();
    }
}