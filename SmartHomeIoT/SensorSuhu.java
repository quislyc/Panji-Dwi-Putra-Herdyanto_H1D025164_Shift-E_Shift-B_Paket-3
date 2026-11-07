/** Sensor suhu untuk simulasi rumah pintar. */
public class SensorSuhu extends PerangkatIoT implements Monitorable {
    private double suhuTerukur;

    public SensorSuhu(String idPerangkat, String namaPerangkat) {
        super(idPerangkat, namaPerangkat);
        suhuTerukur = 0.0;
    }

    public SensorSuhu(String idPerangkat, String namaPerangkat, String lokasi) {
        super(idPerangkat, namaPerangkat, lokasi);
        suhuTerukur = 0.0;
    }

    public double getSuhuTerukur() { return suhuTerukur; }

    public void setSuhuTerukur(double suhuTerukur) {
        this.suhuTerukur = suhuTerukur;
    }

    @Override
    public void evaluasiKondisi(double nilaiSensor) {
        setSuhuTerukur(nilaiSensor);
        if (nilaiSensor >= -10.0 && nilaiSensor <= 60.0) {
            setAktif(true);
            System.out.println("Sensor berhasil membaca suhu ruangan.");
        } else {
            setAktif(false);
            System.out.println("Pembacaan sensor tidak valid.");
        }
    }

    @Override
    public void tampilkanMonitoring() {
        System.out.println("Suhu terukur     : " + suhuTerukur + " Celsius");
        System.out.println("Status sensor    : " + getStatus());
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Suhu terukur     : " + suhuTerukur + " Celsius");
    }
}
