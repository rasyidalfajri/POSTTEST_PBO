import java.util.ArrayList;
import java.util.Scanner;
public class Wallpaper {

    private static ArrayList<String> data = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Menambahkan beberapa data saat program dimulai
        data.add("Wallpaper Tema Abstrak");
        data.add("Wallpaper Tema Alam");
        data.add("Wallpaper Tema Angkasa");

        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu Pendataan Toko Wallpaper 'Rafaalpaper':");
            System.out.println("1. Tambah Data Wallpaper");
            System.out.println("2. Tampilkan Data Wallpaper");
            System.out.println("3. Update Data Wallpaper");
            System.out.println("4. Hapus Data Wallpaper");
            System.out.println("5. Exit Program");
            System.out.print(">> : ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 

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

    private static void tambahData() {
        System.out.print("Masukkan Data Wallpaper Baru: ");
        String newData = scanner.nextLine();
        data.add(newData);
        System.out.println("Data Wallpaper berhasil ditambahkan!");
    }

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

    private static void perbaruiData() {
        if (data.isEmpty()) {
            System.out.println("Tidak ada data wallpaper/Kosong");
        } else {
            tampilkanData();
            System.out.print("Pilih Nomor Wallpaper Yang ingin DiUpdate(Dimulai dari 0) : ");
            int index = scanner.nextInt();
            scanner.nextLine(); 
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

    private static void hapusData() {
        if (data.isEmpty()) {
            System.out.println("Tidak ada data wallpaper/Kosong");
        } else {
            tampilkanData();
            System.out.print("Pilih Nomor Wallpaper Yang ingin Dihapus(Dimulai dari 0) : ");
            int index = scanner.nextInt();
            scanner.nextLine(); 
            if (index >= 0 && index < data.size()) {
                data.remove(index);
                System.out.println("Data Wallpaper Berhasil Dihapus!");
            } else {
                System.out.println("Nomor Data Tidak Ada/Tidak Valid");
            }
        }
    }
}


