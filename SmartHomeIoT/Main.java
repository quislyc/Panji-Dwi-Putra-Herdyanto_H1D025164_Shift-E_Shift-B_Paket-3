/** Titik masuk dan demonstrasi seluruh konsep OOP pada proyek. */
public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  SMART HOME IoT MONITORING SYSTEM");
        System.out.println("========================================");

        SensorSuhu sensor = new SensorSuhu("SNS-01", "Sensor Suhu", "Ruang Tamu");
        LampuPintar lampu = new LampuPintar("LMP-01", "Lampu Utama", "Ruang Tamu", 80);
        KipasPintar kipas = new KipasPintar("KPS-01", "Kipas Pintar", "Ruang Tamu", 0);

        System.out.println("\n--- PEMBACAAN SENSOR ---");
        double suhuRuangan = 30.5;
        double intensitasCahaya = 220.0;
        sensor.evaluasiKondisi(suhuRuangan);
        lampu.evaluasiKondisi(intensitasCahaya);
        kipas.evaluasiKondisi(sensor.getSuhuTerukur());

        System.out.println("\n--- POLIMORFISME MELALUI ABSTRACT CLASS ---");
        PerangkatIoT[] perangkat = {sensor, lampu, kipas};
        for (PerangkatIoT item : perangkat) {
            item.tampilkanInfo();
            System.out.println("----------------------------------------");
        }

        System.out.println("\n--- POLIMORFISME MELALUI INTERFACE ---");
        Monitorable monitor = kipas;
        Controllable kontrol = kipas;
        monitor.tampilkanMonitoring();
        kontrol.aturStatus(false);
        monitor.tampilkanMonitoring();

        System.out.println("\n--- KONTROL LAMPU MANUAL ---");
        Controllable kontrolLampu = lampu;
        kontrolLampu.aturStatus(false);
        lampu.tampilkanInfo();

        System.out.println("\nSimulasi Smart Home IoT selesai.");
    }
}
