import java.util.*;

public class mainHero {
    static Scanner input = new Scanner(System.in);
    static String inputString;
    static int inputValue;
    static String name;
    static double hp, atk, def;
    static double p1MaxHp, p2MaxHp;

    private static void inputNama() {
        System.out.print("Masukkan nama anda: ");
        inputString = input.nextLine();
    }
    private static void inputNilai(String attribute, int minValue, int maxValue){
        while (true) {
            System.out.printf("Masukkan nilai %s [%d-%d]: ", attribute, minValue, maxValue);
            inputValue = input.nextInt();
            if (inputValue >= minValue && inputValue <= maxValue)
                break;
            System.out.println("Nilai yang anda inputkan tidak valid.");
        }
    }
    private static void displayCurrentHealth(Hero player1, Hero player2) {
        System.out.printf("%s: %.0f/%.0f HP\n", player1.getName(), player1.getHp(), p1MaxHp);
        System.out.printf("%s: %.0f/%.0f HP\n\n", player2.getName(), player2.getHp(), p2MaxHp);
    }

    private static void battle(Hero attacker, Hero defender) {
        double defenderHp = defender.getHp();
        double hpLost = 0;
        System.out.printf("%s menyerang %s.\n", attacker.getName(), defender.getName());
        if (Math.random()>attacker.getLuck()){
            System.out.println("Penyerangan tidak berhasil.\n");
        } else {
            if (Math.random()>defender.getLuck()) {
                System.out.printf("%s tidak berhasil melindungi.\n", defender.getName());
                hpLost = attacker.getAtk();
            } else {
                System.out.printf("%s berhasil melindungi.\n", defender.getName());
                hpLost = (attacker.getAtk()<=defender.getDef()) ? 0 : attacker.getAtk()-defender.getDef();
            }
            System.out.printf("%s kehilangan %.0f HP.\n\n",defender.getName(), hpLost);
        }
        defender.setHp((defenderHp <= hpLost) ? 0 : defenderHp - hpLost);
    }
    public static void main(String[] args) {
        System.out.println("== PERMAINAN ADU HERO ==\n");
        Hero player1 = new Hero();
        inputNama();
        player1.setName(inputString);
        inputNilai("HP", 30, 50);
        player1.setHp((double) inputValue);
        inputNilai("Attack", 1, 20);
        player1.setAtk((double) inputValue);
        inputNilai("Defense", 1, 10);
        player1.setDef((double) inputValue);
        player1.setLuck();
        System.out.println("Siapakah lawan anda: ");
        System.out.println("[1] CPU");
        System.out.println("[2] Pemain Lain");
        int pilihan = 0;
        while (pilihan == 0) {
            System.out.printf("Masukkan angka: ");
            pilihan = input.nextInt();
            if (pilihan == 1 || pilihan == 2)
                break;
            System.out.println("Angka yang anda inputkan tidak valid.");
        }
        switch (pilihan) {
            case 1:
                name = "CPU";
                hp = 30 + Math.floor(Math.random()*21);
                atk = 1 + Math.floor(Math.random()*20);
                def = 1 + Math.floor(Math.random()*10);
                System.out.println("Inilah lawan anda!");
                System.out.printf("%-4s: %s\n","Nama", name);
                System.out.printf("%-4s: %.0f\n","HP",hp);
                System.out.printf("%-4s: %.0f\n","ATK",atk);
                System.out.printf("%-4s: %.0f\n","DEF",def);
                break;
        
            case 2:
                input.nextLine();
                inputNama();
                name = inputString;
                inputNilai("HP", 30, 50);
                hp = (double) inputValue;
                inputNilai("Attack", 1, 20);
                atk = (double) inputValue;
                inputNilai("Defense", 1, 10);
                def = (double) inputValue;
                break;
        }
        Hero player2 = new Hero(name, hp, atk, def);

        boolean isPlayer1Turn = (Math.random()<0.5) ? false : true;
        System.out.printf("%s menyerang terlebih dahulu.\n", (isPlayer1Turn) ? player1.getName() : player2.getName());
        p1MaxHp = player1.getHp();
        p2MaxHp = player2.getHp();
        displayCurrentHealth(player1, player2);
        int counter = 0;
        do{
        if (counter%2 == 0)
            System.out.printf("== RONDE %2d ==\n\n", counter/2 + 1);
        if (isPlayer1Turn) {
                battle(player1, player2);
                isPlayer1Turn = false;
        } else {
                battle(player2, player1);
                isPlayer1Turn = true;
        }
        if (counter % 2 == 1 || player1.getHp()==0 || player2.getHp()==0){
            displayCurrentHealth(player1, player2);
        }
        counter++;
        } while (player1.getHp()>0 && player2.getHp()>0);
        System.out.println("** Petarungan selesai **");
        System.out.printf("%s menang!", (player2.getHp()==0) ? player1.getName() : player2.getName());
    }
}