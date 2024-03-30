import java.util.ArrayList;
import java.util.Scanner;

class Rafaalpaper {
    String nama;
    String tema;
    int harga;

    public Rafaalpaper(String nama, String tema, int harga) {
        this.nama = nama;
        this.tema = tema;
        this.harga = harga;
    }

    public void tampilkan() {
        System.out.println("Nama : " + nama);
        System.out.println("Tema : " + tema);
        System.out.println("Harga  : " + harga);
    }
}

class WallpaperBiasa extends Rafaalpaper {
    public WallpaperBiasa(String nama, String tema, int harga) {
        super(nama, tema, harga);
    }

    @Override
    public void tampilkan() {
        super.tampilkan();
        System.out.println("Jenis : Wallpaper Biasa");
    }
}

class WallpaperPremium extends Rafaalpaper {
    String fiturPremium;

    public WallpaperPremium(String nama, String tema, int harga, String fiturPremium) {
        super(nama, tema, harga);
        this.fiturPremium = fiturPremium;
    }

    @Override
    public void tampilkan() {
        super.tampilkan();
        System.out.println("Jenis : Wallpaper Premium");
        System.out.println("Fitur Premium: " + fiturPremium);
    }
}

public class App {
    static ArrayList<Rafaalpaper> rafaalpapers = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("|  1. Menu Pendataan Data Wallpaper     |");
            System.out.println("|  2. Keluar                            |");
            System.out.print("Pilihan Anda : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Menu_CRUD();
                    break;
                case 2:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        }
        System.out.println("Terima Kasih Sudah menggunakan program :D ");
    }

    static void Menu_CRUD() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("| 1. Tambah Data Wallpaper              |");
            System.out.println("| 2. Tampilkan Data Wallpaper           |");
            System.out.println("| 3. Edit Data Wallpaper                |");
            System.out.println("| 4. Hapus Data Wallpaper               |");
            System.out.println("| 5. Kembali ke Menu Utama              |");
            System.out.print("Pilihan Anda : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    tambah_wallpaper();
                    break;
                case 2:
                    tampilkan_wallpaper();
                    break;
                case 3:
                    edit_wallpaper();
                    break;
                case 4:
                    hapus_wallpaper();
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        }
    }

    static void tambah_wallpaper() {
        System.out.print("Masukkan Nama Wallpaper : ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Tema Wallpaper : ");
        String tema = scanner.nextLine();
        System.out.print("Masukkan Harga Wallpaper  : ");
        int harga = scanner.nextInt();

        System.out.print("Apakah ini wallpaper premium? (Y/N): ");
        String premiumChoice = scanner.next();
        scanner.nextLine();
        if (premiumChoice.equalsIgnoreCase("Y")) {
            System.out.print("Masukkan Fitur Premium: ");
            String fiturPremium = scanner.nextLine();
            WallpaperPremium wallpaperPremium = new WallpaperPremium(nama, tema, harga, fiturPremium);
            rafaalpapers.add(wallpaperPremium);
        } else {
            WallpaperBiasa wallpaperBiasa = new WallpaperBiasa(nama, tema, harga);
            rafaalpapers.add(wallpaperBiasa);
        }

        System.out.println("Wallpaper berhasil ditambahkan ");
    }

    static void tampilkan_wallpaper() {
        if (rafaalpapers.isEmpty()) {
            System.out.println("Tidak ada wallpaper yang tersedia.");
            return;
        }

        System.out.println("\n===== Daftar Wallpaper =====");
        for (int i = 0; i < rafaalpapers.size(); i++) {
            System.out.println("Wallpaper " + (i + 1) + ":");
            rafaalpapers.get(i).tampilkan();
            System.out.println("---------------------------");
        }
    }

    static void edit_wallpaper() {
        if (rafaalpapers.isEmpty()) {
            System.out.println("Tidak ada wallpaper yang tersedia untuk diperbarui.");
            return;
        }

        System.out.println("\n===== Perbarui wallpaper =====");
        tampilkan_wallpaper();
        System.out.print("Masukkan nomor wallpaper yang ingin diperbarui: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index < 1 || index > rafaalpapers.size()) {
            System.out.println("Nomor wallpaper tidak valid.");
            return;
        }

        edit_wallpaper(index);
    }

    static void edit_wallpaper(int index) {
        tampilkan_wallpaper();
        System.out.print("Masukkan nama baru wallpaper : ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan tema baru wallpaper : ");
        String tema = scanner.nextLine();
        System.out.print("Masukkan harga baru wallpaper  : ");
        int harga = scanner.nextInt();
        scanner.nextLine();

        if (rafaalpapers.get(index - 1) instanceof WallpaperPremium) {
            System.out.print("Masukkan fitur premium baru: ");
            String fiturPremium = scanner.nextLine();
            ((WallpaperPremium) rafaalpapers.get(index - 1)).fiturPremium = fiturPremium;
        }

        Rafaalpaper updatedWallpaper;
        if (rafaalpapers.get(index - 1) instanceof WallpaperPremium) {
            updatedWallpaper = new WallpaperPremium(nama, tema, harga, ((WallpaperPremium) rafaalpapers.get(index - 1)).fiturPremium);
        } else {
            updatedWallpaper = new WallpaperBiasa(nama, tema, harga);
        }
        rafaalpapers.set(index - 1, updatedWallpaper);
        System.out.println("Wallpaper berhasil diperbarui.");
    }

    static void hapus_wallpaper() {
        if (rafaalpapers.isEmpty()) {
            System.out.println("\nData wallpaper kosong.");
            return;
        }

        System.out.println("\n===== Hapus wallpaper =====");
        tampilkan_wallpaper();
        System.out.print("Masukkan nomor wallpaper yang ingin dihapus : ");
        int index = scanner.nextInt();
        if (index < 1 || index > rafaalpapers.size()) {
            System.out.println("Nomor wallpaper tidak valid.");
            return;
        }

        rafaalpapers.remove(index - 1);
        System.out.println("Wallpaper berhasil dihapus.");
    }
}
