public class BusElec extends VehPub
        implements AuditEmi, GestAbord, GestCarga {

    private final int capMax;
    private final double kwhKm;
    private final double precioKwh;

    private int ocup;
    private int carga;
    private String est;

    public BusElec(String id, int anio, String ubi,
                   boolean estado, int capMax,
                   double kwhKm, double precioKwh,
                   int cargaIni) {

        super(id, anio, ubi, estado);

        this.capMax = capMax;
        this.kwhKm = kwhKm;
        this.precioKwh = precioKwh;
        this.ocup = 0;
        this.carga = cargaIni;
        this.est = null;
    }

    @Override
    public double calcCosto(double km) {
        return kwhKm * km * precioKwh;
    }

    @Override
    public void genReporte() {

        System.out.println("---REPORTE — BUS ELÉCTRICO---");
        System.out.printf("║  ID          : %-26s║%n", id);
        System.out.printf("║  Ubicación   : %-26s║%n", ubi);
        System.out.printf("║  Antigüedad  : %-2d años                ║%n", getEdad());
        System.out.printf("║  Capacidad   : %-3d pasajeros           ║%n", capMax);
        System.out.printf("║  Ocupación   : %-3d pasajeros           ║%n", ocup);
        System.out.printf("║  Consumo     : %.1f kWh/km             ║%n", kwhKm);
        System.out.printf("║  Precio      : $%.0f COP/kWh         ║%n", precioKwh);
        System.out.printf("║  Batería     : %d%%                     ║%n", carga);
        System.out.printf("║  Estación    : %-26s║%n",
                est != null ? est : "Desconectado");
        System.out.printf("║  Estado      : %-5s                   ║%n",
                estado ? "Sí" : "No");
    }

    @Override
    public int getCapMax() {
        return capMax;
    }

    @Override
    public double calcCO2(double km) {
        return 0.0;
    }

    @Override
    public boolean subirPas(int cant) {

        if (ocup + cant > capMax) {

            System.out.printf("[%s] Capacidad superada (%d/%d)%n",
                    id, ocup, capMax);

            return false;
        }

        ocup += cant;

        System.out.printf("[%s] Subieron %d pasajeros. Ocupación: %d/%d%n",
                id, cant, ocup, capMax);

        return true;
    }

    @Override
    public int getOcup() {
        return ocup;
    }

    @Override
    public void conectar(String idEst) {

        this.est = idEst;

        System.out.printf("[%s] Conectado a estación: %s%n",
                id, idEst);
    }

    @Override
    public int getCarga() {
        return carga;
    }

    public void cargar(int porc) {

        this.carga = Math.min(100, porc);

        System.out.printf("[%s] Batería cargada al %d%%%n",
                id, carga);
    }
}
