import java.util.ArrayList;
import java.util.Scanner;

public class Rafaalpaper {
    // ArrayList untuk menyimpan data
    private static ArrayList<String> data = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            // Menampilkan menu
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Data Wallpaper");
            System.out.println("2. Tampilkan Data Wallpaper");
            System.out.println("3. Update Data Wallpaper");
            System.out.println("4. Hapus Data Wallpaper");
            System.out.println("5. Exit Program");
            System.out.print(">> : ");
            
            // Membaca pilihan pengguna
            int choice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline character dari buffer

            // Memproses pilihan pengguna
            switch (choice) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    tampilkanData();
                    break;
                case 3:
                    perbaruiData();
                    break;
                case 4:
                    hapusData();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
        System.out.println("Program selesai!");
        System.out.println("Terimakasih Telah Menggunakan Program :D");
    }

    // Method untuk menambahkan data ke ArrayList
    private static void tambahData() {
        System.out.print("Masukkan Data Wallpaper Baru: ");
        String newData = scanner.nextLine();
        data.add(newData);
        System.out.println("Data Wallpaper berhasil ditambahkan!");
    }

    // Method untuk menampilkan data dari ArrayList
    private static void tampilkanData() {
        if (data.isEmpty()) {
            System.out.println("Tidak ada data wallpaper/Kosong");
        } else {
            System.out.println("List Data Wallpaper:");
            for (String item : data) {
                System.out.println(item);
            }
        }
    }

    // Method untuk memperbarui data dalam ArrayList
    private static void perbaruiData() {
        if (data.isEmpty()) {
            System.out.println("Tidak ada data wallpaper/Kosong");
        } else {
            tampilkanData();
            System.out.print("Pilih Nomor Wallpaper Yang ingin DiUpdate(Dimulai dari 0) : ");
            int index = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline character dari buffer
            if (index >= 0 && index < data.size()) {
                System.out.print("Masukkan Data Wallpaper Baru : ");
                String newData = scanner.nextLine();
                data.set(index, newData);
                System.out.println("Data Wallpaper Berhasil DiUpdate!");
            } else {
                System.out.println("Nomor Data Tidak Ada/Tidak Valid");
            }
        }
    }

    // Method untuk menghapus data dari ArrayList
    private static void hapusData() {
        if (data.isEmpty()) {
            System.out.println("Tidak ada data wallpaper/Kosong");
        } else {
            tampilkanData();
            System.out.print("Pilih Nomor Wallpaper Yang ingin Dihapus(Dimulai dari 0) : ");
            int index = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline character dari buffer
            if (index >= 0 && index < data.size()) {
                data.remove(index);
                System.out.println("Data Wallpaper Berhasil Dihapus!");
            } else {
                System.out.println("Nomor Data Tidak Ada/Tidak Valid");
            }
        }
    }
}
