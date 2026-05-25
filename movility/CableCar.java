public class CableCar extends VehPub
        implements GestAbord, GestCarga, AuditEmi {

    private final int capMax;
    private final double precio;

    private int ocup;
    private int carga;

    public CableCar(String id, int anio, String ubi,
                     boolean estado, int capMax,
                     double precio, int carga) {

        super(id, anio, ubi, estado);

        this.capMax = capMax;
        this.precio = precio;
        this.carga = carga;
        this.ocup = 0;
    }

    @Override
    public double calcCosto(double km) {
        return km * precio;
    }

    @Override
    public void genReporte() {

        System.out.println("---REPORTE — CABLECAR---");
        System.out.printf("║  ID          : %-26s║%n", id);
        System.out.printf("║  Ubicación   : %-26s║%n", ubi);
        System.out.printf("║  Antigüedad  : %-2d años                ║%n", getEdad());
        System.out.printf("║  Capacidad   : %-3d pasajeros           ║%n", capMax);
        System.out.printf("║  Ocupación   : %-3d pasajeros           ║%n", ocup);
        System.out.printf("║  Carga       : %d%%                     ║%n", carga);
        System.out.printf("║  Estado      : %-5s                   ║%n",
                estado ? "Sí" : "No");
    }

    @Override
    public int getCapMax() {
        return capMax;
    }

    @Override
    public boolean subirPas(int cant) {

        if (ocup + cant > capMax) {

            System.out.printf("[%s] Capacidad superada (%d/%d)%n",
                    id, ocup, capMax);

            return false;
        }

        ocup += cant;

        System.out.printf("[%s] Subieron %d pasajeros%n",
                id, cant);

        return true;
    }

    @Override
    public int getOcup() {
        return ocup;
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

    @Override
    public double calcCO2(double km) {
        return 0.0;
    }
}