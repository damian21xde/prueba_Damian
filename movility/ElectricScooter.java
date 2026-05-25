public class ElectricScooter extends VehPub
        implements GestCarga, AuditEmi {

    private final double precio;

    private int carga;

    public ElectricScooter(String id, int anio, String ubi,
                           boolean estado, double precio,
                           int carga) {

        super(id, anio, ubi, estado);

        this.precio = precio;
        this.carga = carga;
    }

    @Override
    public double calcCosto(double km) {
        return km * precio;
    }

    @Override
    public void genReporte() {

        System.out.println("---REPORTE — SCOOTER ELÉCTRICO---");

        System.out.printf("║  ID          : %-26s║%n", id);
        System.out.printf("║  Ubicación   : %-26s║%n", ubi);
        System.out.printf("║  Antigüedad  : %-2d años                ║%n", getEdad());
        System.out.printf("║  Batería     : %d%%                     ║%n", carga);

        System.out.printf("║  Estado      : %-5s                   ║%n",
                estado ? "Sí" : "No");
    }

    @Override
    public int getCapMax() {
        return 1;
    }

    @Override
    public void conectar(String idEst) {

        System.out.printf("[%s] Conectado a %s%n",
                id, idEst);
    }

    @Override
    public int getCarga() {
        return carga;
    }

    public void chargeTo(int porc) {

        carga = Math.min(100, porc);

        System.out.printf("[%s] Batería cargada al %d%%%n",
                id, carga);
    }

    @Override
    public double calcCO2(double km) {
        return 0.0;
    }
}