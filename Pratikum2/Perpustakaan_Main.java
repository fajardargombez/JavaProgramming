import java.util.Scanner;

public class Perpustakaan_Main {
    private static Scanner input = new Scanner(System.in);
    private static int pilih;
    /* 
    Table of book attributes
    Index numbers and their associate attributes
    ||     0    |       1       |       2      |      3      |       4       |   5  |     6     |     7    ||
    || namaBuku | namaPengarang | namaPenerbit | tahunTerbit | jumlahHalaman | isbn | jenisBuku | sinopsis ||
    */
    private static String[][] daftarBuku = {
    {"1984","George Orwell","Immortal Publishing","2023","468","9786237778981","Fiksi", "Bercerita tentang Winston Smith yang merupakan seorang anggota partai Sosing yang berkuasa di negara Oceania."},
    {"A Gift For Yourself","Samanta Elsener Dan Shita Dewi","Baca","2023","213","9786026486882","Psikologi", "Luangkan waktu untuk mengenal diri sendiri dan temukan tujuan hidupmu melalui self-discovery!"},
    {"Aplikasi Perkantoran Era Industrialisasi 4.0","Imam Heryanto & Hernawati","Informatika","2023","568","9786237131656","Teknologi", "Buku ini didesain untuk membantu menyelesaikan pekerjaan atau tugas administrasi perkantoran dengan memanfaatkan software perkantoran."},
    {"Bahagia Beragama Bersama Gus Baha","Khoirul Anam","Elex Media Komputindo","2022","160","9786230034763","Agama", "Bersama Gus Baha, agama terasa sangat mudah untuk dipahami dan diamalkan."},
    {"Banjir Besar Zaman Nabi Nuh","Manshur Abdul Hakim","Alvabet","2023","336","9786232201439","Agama", "Kisah air bah besar pertama pada zaman kuno terkenal di sejumlah bangsa di dunia."},
    {"Bui","Alan Th","Kepustakaan Populer Gramedia","2023","428","9786024819293","Fiksi", "Bui menceritakan satu fragmen penting dalam liku-liku hidup seorang tokoh bernama Paku."},
    {"Ca-Bau-Kan (Hanya Sebuah Dosa)","Remy Sylado","Kepustakaan Populer Gramedia","2023","392","9786024818753","Fiksi","Ca-Bau-Kan (Hanya Sebuah Dosa) adalah kisah cinta antara perempuan Betawi dan pedagang Tionghoa dalam latar awal abad ke-20 hingga pascakemerdekaan Indonesia."},
    {"Cara Kerja Ilmu Filsafat dan Filsafat Ilmu","A. Setyo Wibowo","Kepustakaan Populer Gramedia","2022","392","9786024819101","Filsafat","Buku ini merupakan salah satu buku penujang pendidikan yang sangat direkomendasikan untuk para akademisi."},
    {"Chicken Soup For The Soul: Kekuatan Memaafkan","Amy Newmark","Gramedia Pustaka Utama","2018","504","9786020375083","Agama","Buku ini membahas mengenai 'Kekuatan Memaafkan' yang berisikan 101 kisah tentang mengikhlaskan, sehingga membuat hidup menjadi lebih baik."},
    {"China: Warisan Klasik dan Daya Dinamis yang Menggetarkan Dunia","Jusra Chandra","Gramedia Pustaka Utama","2020","176","9786020636399","Sejarah","Buku ini akan menyajikan perkembangan alam pemikiran peradaban China dalam bentuknya yang murni serta bersahaja."},
    {"Desain Grafis dengan Canva untuk Pemula","Jubilee Enterprise","Elex Media Komputindo","2021","200","9786230027710","Teknologi","Buku ini dapat membantu Anda membuat desain menarik dalam waktu singkat memakai Canva."},
    {"Dramaturgi Politik Indonesia","Muhamad Sulham","Intrans Publishing","2021","142","9786025328169","Politik","Dunia ini panggung sandiwara, kira-kira demikian kalimat lugas untuk menggambarkan interaksi sosial masyarakat dan apalagi politisi dalam memanfaatkan ruang komunikasi politiknya.  Bahkan, tidak jarang, penyajiannya seolah tergambar seperti beragam peran dan kisah, baik yang nyata ada maupun sebaliknya."},
    {"Ekonomi Politik Daulat Rakyat Indonesia: Pancasila Sebagai Acuan Paradigma","Francis Wahono","Penebit Buku Kompas","2020","352","9786232410749","Politik","Buku ini berusaha mencari bentuk baru dari sintesis milenial lampau dari para bapak ibu pendiri bangsa, utamanya Soekarno-Hatta, ke sintesis milenial kini."},
    {"Filosofi Montessori","Rosalynn Tamara","Bentang Pustaka","2022","100","9786022919179","Filsafat","Filosofi Montessori merupakan salah satu buku parenting yang sangat cocok digunakan sebagai bahan bacaan untuk mengedukasikan anak."},
    {"Filosofi Teras (Edisi Baru)","Henry Manampiring","Penerbit Buku Kompas","2022","298","9786233463034","Filsafat","Buku yang pertama kali diterbitkan pada 2019 ini mengajarkan kita tentang pengendalian emosi negatif yang ada dalam diri kita."},
    {"Heidegger dan Mistik Keseharian","F. Budi Hardiman","Kepustakaan Populer Gramedia","2020","228","9786024813437","Filsafat","Buku ini adalah pengantar pada pemikiran Heidegger yang tertuang dalam bukunya, Sein und Zeit. Semoga pengantar buku ini bukan hanya merangsang studi filsafat pada umumnya dan pemikiran Heidegger pada khususnya, melainkan juga membantu pembaca untuk lebih bersikap meditatif terhadap kehidupan."},
    {"Indonesia Tidak Pernah Dijajah","Batara R Hutagalung","Matapadi","2018","256","9786021634257","Sejarah","Buku ini hadir untuk memperkuat pemahaman bangsa Indonesia mengenai fakta yang sebenarnya terjadi. Batara menyuarakan secara kritis sejarah bangsa Indonesia dan menghidupkan kembali sukma nasionalisme yang mulai pudar di kalangan anak bangsa dewasa ini. Dia juga membeberkan fakta-fakta sejarah kolonial Belanda di Indonesia yang terkesan didiamkan selama ini."},
    {"Kerudung Merah Kirmizi","Remy Sylado","Kepustakaan Populer Gramedia","2023","680","9786024818777","Fiksi","Dengan latar belakang masa Orde Baru dan awal reformasi, novel ini menggambarkan secara telanjang liku-liku seorang pengusaha memanfaatkan oknum aparat keamanan dan para bandit untuk mencapai tujuannya."},
    {"Kitab Membaca Mikroekspresi dan Gesture","Intan Wulansari","Psikologi Corner","2023","144","9786234003659","Psikologi","Dengan buku ini, anda bisa menambah wawasan bagaimana mendeteksi kebohongan melalui bahasa tubuh, bahasa verbal, serta bagaimana menganalisis kebohongan melalui alat uji kebohongan."},
    {"Komunikasi Politik dalam Pilkada Langsung: Teori dan Praktik Edisi Revisi","Dr. Mahi M. Hikmat, M.Si","Simbiosa Rekatama Media","2020","310","9786027973893","Politik","Buku yang ditulis oleh Mahi M. Hikmat ini mengupas tentang komunikasi politik, baik secara teori maupun praktik."},
    {"Machine Learning Tingkat Dasar dan Lanjut Edisi-2","Dr. Suyanto, S.T., M.Sc.","Informatika","2023","504","9786237131663","Teknologi","Buku ini memberi Anda gambaran holistik dan simpel mengenai konsep dasar machine learning, teknik-teknik dan metode-metode tingkat dasar dan tingkat lanjut, serta aplikasinya dalam berbagai bidang terkini."},
    {"Memahami Trauma Dengan Perhatian Khusus pada Masa Kanak-Kanak","Prof. Irwanto, Ph.D., Hani Kumala, M.Psi.,","Gramedia Pustaka Utama","2022","160","9786020658957","Psikologi","Buku kecil ini mencoba untuk menjelaskan mengenai trauma psikologis sebagaimana yang dipahami oleh klinisi di bidang kesehatan mental."},
    {"Mengeksplorasi Fungsi VLOOKUP, HLOOKUP, dan LOOKUP Excel","Yudhy Wicaksono & Solusi Kantor","Elex Media Komputindo","2022","224","9786230031748","Teknologi","Bagi Anda yang ingin mempelajari lebih dalam mengenai fungsi excel tersebut, buku “Mengeksplorasi Fungsi VLOOKUP, HLOOKUP, dan LOOKUP Excel” sangat cocok untuk Anda baca. Buku ini menjelaskan secara lengkap mengenai ketiga fungsi tersebut dalam microsoft excel."},
    {"Merdeka Sejak Hati","A Fuadi","Gramedia Pustaka Utama","2019","300","9786020622965","Agama","Buku ini ditulis oleh Ahmad Fuadi (lahir 30 Desember 1973) yang merupakan seorang novelis, pekerja sosial, dan mantan wartawan dari Indonesia."},
    {"Muhammad: Kisah Hidup Nabi Berdasarkan Sumber Klasik","Martin Lings","Serambi","2016","524","9786022900689","Agama","Ketika membaca buku ini, kita akan merasakan semacam efek kimia pada narasi dan komposisi bahasa yang terkombinasi dengan keakuratan serta gairah sastrawi."},
    {"Negara Hukum Dalam Pemikiran Politik","Dr. Thomas Tokan Pureklolon, M.Ph., M.M., M.Si.","Pt Kanisius","2020","346","SCOOP211571","Politik","Buku ini merupakan sebuah buku ajar wajib pada Program Pascasarjana Ilmu Politik FISIP UI untuk mata kuliah Pemikiran Politik."},
    {"Panduan Lengkap SPSS 26","Singgih Santoso","Elex Media Komputindo","2020","520","9786230019975","Teknologi","Buku Panduan Lengkap SPSS 26 karya Singgih Santoso ini adalah buku tentang software statistik yang berisi panduan untuk memanfaatkan software tersebut."},
    {"Panggil Aku Kartini Saja","Pramoedya Ananta Toer","Lentera Dipantara","2015","262","97997312116","Fiksi","Buku ini mengajak mengingat Kartini, tapi bukan dari sudut pandang domestik rumah seperti dia adalah gadis pingitan lalu dinikahkan secara paksa lalu melahirkan lalu mati."},
    {"Pasang Surut Kerajaan-Kerajaan Di Pulau Jawa Zaman Klasik","The Syaeful Cahyadi","Sociality","2021","264","9786232447240","Sejarah","Buku ini menyampaikan sekilas tentang sejarah Raja Jawa sejak kerajaan pertama didirikan di Jawa. Dengan penjelasan yang detail dan kronologis, buku ini mudah dipahami dan cocok dibaca di waktu senggang Anda."},
    {"Psikologi Kesehatan - Konsep, Masalah, dan Pemikiran Untuk Indonesia","Eunike Sri Tyas Suci","Penerbit Buku Kompas","2022","516","9786233466783","Psikologi","Buku Psikologi Kesehatan: Konsep, Masalah, dan Pemikiran untuk Indonesia membahas berbagai masalah kesehatan dari perspektif biopsikososiokultural."},
    {"Sang Dewi Api (The Burning God)","R.F. Kuang","Gramedia Pustaka Utama","2023","672","9786020668826","Fiksi","Setelah berhasil menyelamatkan negara Nikan dalam perang saudara yang brutal, Fang Runin malah dikhianati para sekutu."},
    {"Segala Sesuatu Yang Perlu Anda Ketahui Tentang Filsafat","Peter Gibson","Gramedia Pustaka Utama","2020","260","SCOOPG198326","Filsafat","Sebuah pengantar yang pas untuk mahasiswa maupun orang awam, buku ini menyajikan konsep-konsep yang Anda perlukan untuk memahami persoalan-persoalan dasar."},
    {"Sejarah dan Peradaban Mesir Kuno","Jonar T.h Situmorang, M.a","Andi Offset","2021","214","9786233140461","Sejarah","Buku ini memberikan penjelasan yang cukup lengkap dan luas seputar peradaban Mesir Kuno, terlebih mengenai Dinasti Kerajaan Firaun, mulai dari Raja Firaun pada Zaman Abraham, Yusuf, dan Musa, hingga Gereja Sampah di Mesir."},
    {"Seni Sederhana Menaklukkan Negative Vibes","Coky Aditya Z","Penerbit Noktah","2023","182","9786236175385","Psikologi","Buku ini akan menjadi solusi bagi Anda untuk belajar mengendalikan berbagai macam emosi, mulai dari amarah, takut, sedih, malu, hingga bahagia. Segera praktikkan berbagai tips dan metode terapinya!"},
    {"Sutan Syahrir: Perdana Menteri Pertama","Endang Kristin, dkk.","Bee Media","2022","72","9786236358887","Sejarah","Sutan Sjahrir adalah sang pahlawan besar, kita tidak boleh melupakan jasa-jasa dan pengorbanan beliau untuk Republik Indonesia kita yang tercinta ini. Nah oleh karena itu, yuk sama-sama kita ikuti cerita perjuangannya di buku ini!"},
    {"The Righteous Mind","Jonathan Haidt","Kepustakaan Populer Gramedia","2020","480","9786024814915","Politik","The Righteous Mind menjelaskan tentang Moral Foundation Theory (MFT) yang dibuat oleh Jonathan Haidt, digunakan untuk memahami fenomena keterbelahan politik."},
    {"The World Until Yesterday (2018)","Jared Diamond","Kepustakaan Populer Gramedia","2018","616","9786024247256","Sejarah","Banyak hal-hal yang kita bisa pelajari dari manusia yang telah lampau. Gagasan tersebut merupakan ide awal dari sang penulis, Jared Diamond dalam menulis buku yang berjudul “The World Until Yesterday”. Sebagai manusia modern ia ingin mempelajari keunggulan praktik-praktik hidup yang masih dijalani masyarakat-masyarakat tradisional."},
    {"Tuntunan Manasik Haji Nabi","Syaikh Muhammad Nashiruddin al-Albani","Qisthi Press","2019","139","SCOOPG182587","Agama","Tuntunan Manasik Haji Nabi ini merupakan karya ulama pakar hadis ternama, Syaikh Muhammad Nashiruddin al-Albani, yang membahas seputar pelaksanaan manasik haji Nabi s.a.w."},
    {"Ungkap Rahasia Taklukkan Microsoft Excel 2019","Alfa Hartoko","Elex Media Komputindo","2023","368","9786230046292","Teknologi","Microsoft Excel 2019 merupakan penyempurnaan dari Excel versi sebelumnya. Buku ini bisa menjadi solusi bagi Anda yang ingin menguasai pengolahan data menggunakan formula Excel 2019. Dalam buku ini diungkap habis seluruh fasilitas, menu, dan tab dalam Excel 2019."},
    {"Yang Muda Yang Bekerja","Andika Hazrumy","Gramedia Pustaka Utama","2020","304","9786020649528","Politik","Dalam Yang Muda yang Bekerja, Andika mengisahkan suka, duka, dan segala tantangan yang harus dihadapinya sebagai pemimpin muda dalam kancah politik Indonesia."}
    };

    private static Buku[] objBukus = new Buku[100];
    private static int bukuCounter = 0;
    private static final int JUMLAH_BUKU_ASLI = daftarBuku.length;

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
        System.out.printf("Jumlah objek buku sekarang: %d\n", bukuCounter);
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
    for (int i = 0; i < JUMLAH_BUKU_ASLI; i++) {
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
    lihatBuku(objBukus[indexPilihanBuku]);
    }
    }

    private static void lihatBuku(Buku pilihanBuku){
        pilihanBuku.printBuku();
        System.out.printf("Jumlah kata: %d\n\n", pilihanBuku.getJumlahKataSinopsis());
        pilihanMenu(pilihanBuku);
    }

    private static void copy(Buku pilihanBuku){
        objBukus[bukuCounter] = new Buku(pilihanBuku);
        objBukus[bukuCounter].printBuku();
        System.out.printf("Jumlah objek buku sekarang: %d\n\n", ++bukuCounter);
        pilihanMenu(pilihanBuku);
    }

    private static void pilihanMenu(Buku pilihanBuku){
        while (true) {
            System.out.println("Apa yang anda mau lakukan selanjutnya:");
            System.out.println("[1] Duplikasi objek buku");
            System.out.println("[2] Kembali mencari buku");
            System.out.println("[3] Keluar");
            memintaInput();
            if (pilih == 1 || pilih == 2 || pilih == 3){
                break;
            }
            cobaLagi();
        }
        if (pilih == 1){
        System.out.println();
        copy(pilihanBuku);
        } else if (pilih == 2){
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
        while (bukuCounter < daftarBuku.length)
            objBukus[bukuCounter] = new Buku(daftarBuku[bukuCounter++]); 
            memilihJenisBuku();
    }
}