import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class PemesananTiket {
    public static void pesanTiket(){
        Scanner input = new Scanner(System.in);

        System.out.println("Selamat datang di Pemesanan Tiket!");
        System.out.print("Masukkan nama pemesan: ");
        String pemesan = input.nextLine();

        String jenisTiket = "";
        System.out.println("Pilih jenis tiket: "); //menampilkan pilihan jenis tiket
        System.out.println("1. CAT 8");
        System.out.println("2. CAT 1");
        System.out.println("3. FESTIVAL");
        System.out.println("4. VIP");
        System.out.println("5. UNLIMITED EXPERIENCE");
        System.out.print("Masukkan pilihan: ");
        int pilihan = input.nextInt();

        
        switch (pilihan) { //menentukan jenis tiket berdasarkan pilihan user
            case 1:
                jenisTiket = "CAT 8";
                break;
            case 2:
                jenisTiket = "CAT 1";
                break;
            case 3:
                jenisTiket = "FESTIVAL";
                break;
            case 4:
                jenisTiket = "VIP";
                break;
            case 5:
                jenisTiket = "UNLIMITED EXPERIENCE";
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }

        TiketKonser tiket = null;
        switch (pilihan) { //membuat objek jenisTiket berdasarkan pilihan dari user
            case 1:
                tiket = new CAT8();
                break;
            case 2:
                tiket = new CAT1();
                break;
            case 3:
                tiket = new FESTIVAL();
                break;
            case 4:
                tiket = new VIP();
                break;
            case 5:
                tiket = new VVIP();
                break;
        }
        
        input.close();

        String kodeBooking = generateKodeBooking(); //membuat kode pemesanan
        String tanggalPemesanan = getCurrentDate(); //mengambil tanggal pemesanan
        double totalHarga = tiket.harga();          //mendapatkan harga tiket sesuai dengan jenis yang dipilih
        
        System.out.println("\n----- Detail Pemesanan -----");
        System.out.println("Nama Pemesan: " + pemesan);
        System.out.println("Kode Booking: " + kodeBooking);
        System.out.println("Tanggal Pesanan: " + tanggalPemesanan);
        System.out.println("Tiket yang dipesan: " + jenisTiket);
        System.out.println("Total harga: " + totalHarga + " USD");
    }
    public static String generateKodeBooking() {
        StringBuilder sb = new StringBuilder();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        int length = 8;

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }

    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date currentDate = new Date();
        return dateFormat.format(currentDate);
        
    } 
}
