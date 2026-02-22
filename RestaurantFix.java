package dua.fix;

public class RestaurantFix {
    // 1. Mengubah attribute menjadi private
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    private static byte id = 0;

    public RestaurantFix() {
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }

    public void tambahMenuMakanan(String nama, double harga, int stok) {
        this.nama_makanan[id] = nama;
        this.harga_makanan[id] = harga;
        this.stok[id] = stok;
    }

    public void tampilMenuMakanan() {
        for (int i = 0; i <= id; i++) {
            if (!isOutOfStock(i)) {
                System.out.println(nama_makanan[i] + "[" + stok[i] + "]" + "\tRp. " + harga_makanan[i]);
            }
        }
    }

    // 2. Validasi stok (stok tidak boleh negatif atau pengurangan)
    public boolean isOutOfStock(int id) {
        return stok[id] == 0;
    }

    public static void nextId() {
        id++;
    }

    // 3. Penambahan Fitur Pemesanan Menu
    public void pesanMenu(String nama, int jumlahPesan) {
        int idMenu = -1;
        // Mencari id menu berdasarkan nama
        for (int i = 0; i <= id; i++) {
            if (nama_makanan[i].equals(nama)) {
                idMenu = i;
                break;
            }
        }

        // Cek menu dan stok
        if (idMenu == -1) {
            System.out.println("Menu " + nama + " tidak ditemukan.");
        } else if (stok[idMenu] >= jumlahPesan) {
            // 4. Stok otomatis berkurang
            stok[idMenu] -= jumlahPesan;
            System.out.println("Pesanan " + nama + " sebanyak " + jumlahPesan + " berhasil.");
            System.out.println("Total Harga: Rp. " + (harga_makanan[idMenu] * jumlahPesan));
        } else {
            // 5. Pesan ditolak jika stok tidak cukup
            System.out.println("Stok " + nama + " tidak cukup. Stok tersisa: " + stok[idMenu]);
        }
    }
}