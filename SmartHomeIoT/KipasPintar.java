/** Kipas pintar yang merespons suhu ruangan dan dapat dimonitor/dikendalikan. */
public class KipasPintar extends PerangkatIoT implements Monitorable, Controllable {
    public static final double BATAS_SUHU_PANAS = 28.0;
    private int kecepatanKipas;

    public KipasPintar(String idPerangkat, String namaPerangkat, String lokasi, int kecepatanKipas) {
        super(idPerangkat, namaPerangkat, lokasi);
        setKecepatanKipas(kecepatanKipas);
    }

    public int getKecepatanKipas() { return kecepatanKipas; }

    public void setKecepatanKipas(int kecepatanKipas) {
        if (kecepatanKipas < 0 || kecepatanKipas > 3) {
            throw new IllegalArgumentException("Kecepatan kipas harus berada pada rentang 0-3.");
        }
        this.kecepatanKipas = kecepatanKipas;
    }

    @Override
    public void evaluasiKondisi(double suhu) {
        if (suhu >= BATAS_SUHU_PANAS) {
            setAktif(true);
            setKecepatanKipas(3);
            System.out.println("Suhu panas. Kipas otomatis menyala pada kecepatan 3.");
        } else {
            setAktif(false);
            setKecepatanKipas(0);
            System.out.println("Suhu normal. Kipas otomatis mati.");
        }
    }

    @Override
    public void aturStatus(boolean aktif) {
        setAktif(aktif);
        if (aktif && kecepatanKipas == 0) {
            setKecepatanKipas(1);
        } else if (!aktif) {
            setKecepatanKipas(0);
        }
        System.out.println(aktif ? "Kipas berhasil dinyalakan." : "Kipas berhasil dimatikan.");
    }

    @Override
    public void tampilkanMonitoring() {
        System.out.println("Status kipas     : " + getStatus());
        System.out.println("Kecepatan kipas  : " + kecepatanKipas);
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Kecepatan kipas  : " + kecepatanKipas);
    }
}
