package dua.fix;

public class RestaurantFixMain {
    public static void main(String[] args) {
        RestaurantFix menu = new RestaurantFix();
        
        // Menambah Menu
        menu.tambahMenuMakanan("Pizza", 250000, 10);
        RestaurantFix.nextId();
        menu.tambahMenuMakanan("Spaghetti", 80000, 20);
        RestaurantFix.nextId();
        menu.tambahMenuMakanan("Tenderloin Steak", 60000, 20);
        RestaurantFix.nextId();
        menu.tambahMenuMakanan("Chicken Steak", 45000, 20);

        System.out.println(" MENU AWAL ");
        menu.tampilMenuMakanan();
        
        System.out.println("\n TES PEMESANAN ");
        // Jika pemesanan Berhasil
        menu.pesanMenu("Pizza", 5);
        
        // Jika stok tidak cukup
        menu.pesanMenu("Tenderloin Steak", 25);

        System.out.println("\n MENU SETELAH PEMESANAN ");
        menu.tampilMenuMakanan();
    }
}