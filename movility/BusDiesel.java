public class BusDiesel extends VehPub
        implements AuditEmi, GestAbord {

    private static final double CO2 = 2.68;

    private final int capMax;
    private final double cons;
    private final double precio;
    private int ocup;

    public BusDiesel(String id, int anio, String ubi,
                     boolean estado, int capMax,
                     double cons, double precio) {

        super(id, anio, ubi, estado);

        this.capMax = capMax;
        this.cons = cons;
        this.precio = precio;
        this.ocup = 0;
    }

    @Override
    public double calcCosto(double km) {
        return cons * km * precio;
    }

    @Override
    public void genReporte() {

        System.out.println("---REPORTE — BUS DIÉSEL---");
        System.out.printf("║  ID          : %-26s║%n", id);
        System.out.printf("║  Ubicación   : %-26s║%n", ubi);
        System.out.printf("║  Antigüedad  : %-2d años                ║%n", getEdad());
        System.out.printf("║  Capacidad   : %-3d pasajeros           ║%n", capMax);
        System.out.printf("║  Ocupación   : %-3d pasajeros           ║%n", ocup);
        System.out.printf("║  Consumo     : %.2f L/km               ║%n", cons);
        System.out.printf("║  Precio      : $%.0f COP/L          ║%n", precio);
        System.out.printf("║  Estado      : %-5s                   ║%n", estado ? "Sí" : "No");
    }

    @Override
    public int getCapMax() {
        return capMax;
    }

    @Override
    public double calcCO2(double km) {
        return cons * km * CO2;
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
}