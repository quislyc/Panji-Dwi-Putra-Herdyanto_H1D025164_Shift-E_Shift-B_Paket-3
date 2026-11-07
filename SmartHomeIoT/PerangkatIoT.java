/**
 * Kelas abstrak dasar untuk seluruh perangkat pada simulasi Smart Home IoT.
 */
public abstract class PerangkatIoT {
    public static final String STATUS_AKTIF = "AKTIF";
    public static final String STATUS_NONAKTIF = "NONAKTIF";

    private final String idPerangkat;
    private String namaPerangkat;
    private String lokasi;
    private boolean aktif;

    public PerangkatIoT(String idPerangkat, String namaPerangkat) {
        this(idPerangkat, namaPerangkat, "Belum ditentukan");
    }

    public PerangkatIoT(String idPerangkat, String namaPerangkat, String lokasi) {
        this.idPerangkat = idPerangkat;
        this.namaPerangkat = namaPerangkat;
        this.lokasi = lokasi;
        this.aktif = false;
    }

    public String getIdPerangkat() { return idPerangkat; }
    public String getNamaPerangkat() { return namaPerangkat; }
    public String getLokasi() { return lokasi; }
    public boolean isAktif() { return aktif; }

    public void setNamaPerangkat(String namaPerangkat) { this.namaPerangkat = namaPerangkat; }
    public void setLokasi(String lokasi) { this.lokasi = lokasi; }
    protected void setAktif(boolean aktif) { this.aktif = aktif; }

    public String getStatus() {
        return aktif ? STATUS_AKTIF : STATUS_NONAKTIF;
    }

    public void tampilkanInfo() {
        System.out.println("ID Perangkat     : " + idPerangkat);
        System.out.println("Nama             : " + namaPerangkat);
        System.out.println("Lokasi           : " + lokasi);
        System.out.println("Status           : " + getStatus());
    }

    /** Menilai nilai sensor dan memperbarui state perangkat. */
    public abstract void evaluasiKondisi(double nilaiSensor);
}
