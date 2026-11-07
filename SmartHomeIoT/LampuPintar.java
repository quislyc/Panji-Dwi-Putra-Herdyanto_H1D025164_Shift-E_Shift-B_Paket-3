/** Lampu pintar yang menyala otomatis ketika intensitas cahaya rendah. */
public class LampuPintar extends PerangkatIoT implements Controllable {
    private int tingkatKecerahan;

    public LampuPintar(String idPerangkat, String namaPerangkat, String lokasi, int tingkatKecerahan) {
        super(idPerangkat, namaPerangkat, lokasi);
        setTingkatKecerahan(tingkatKecerahan);
    }

    public int getTingkatKecerahan() { return tingkatKecerahan; }

    public void setTingkatKecerahan(int tingkatKecerahan) {
        if (tingkatKecerahan < 0 || tingkatKecerahan > 100) {
            throw new IllegalArgumentException("Kecerahan harus berada pada rentang 0-100.");
        }
        this.tingkatKecerahan = tingkatKecerahan;
    }

    @Override
    public void evaluasiKondisi(double intensitasCahaya) {
        if (intensitasCahaya < 300.0) {
            setAktif(true);
            System.out.println("Ruangan gelap. Lampu dinyalakan.");
        } else {
            setAktif(false);
            System.out.println("Ruangan cukup terang. Lampu dimatikan.");
        }
    }

    @Override
    public void aturStatus(boolean aktif) {
        setAktif(aktif);
        System.out.println(aktif ? "Lampu berhasil dinyalakan secara manual." : "Lampu berhasil dimatikan secara manual.");
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Kecerahan       : " + tingkatKecerahan + "%");
    }
}
