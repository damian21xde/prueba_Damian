import java.util.ArrayList;
import java.util.List;

public class GestFlota {

    private final List<VehPub> flota = new ArrayList<>();

    public void agregar(VehPub v) {

        flota.add(v);

        System.out.printf("Vehículo %s añadido a la flota.%n",
                v.getId());
    }

    public List<VehPub> getFlota() {
        return flota;
    }

    public void printReportes() {

        System.out.println("---REPORTES OPERATIVOS — FLOTA MOVILCITY---");
      

        for (VehPub v : flota) {

            v.genReporte();

            System.out.println();
        }
    }

    public double getCO2Total(double km) {

        double total = 0.0;

        for (VehPub v : flota) {

            if (v instanceof AuditEmi a) {

                total += a.calcCO2(km);
            }
        }

        return total;
    }

    public VehPub getMasOcup() {

        VehPub mas = null;

        int max = -1;

        for (VehPub v : flota) {

            if (v instanceof GestAbord g) {

                int ocu = g.getOcup();

                if (ocu > max) {

                    max = ocu;

                    mas = v;
                }
            }
        }

        return mas;
    }

    public void printCostos(double km) {

        System.out.printf("%n── Costos de recorrido (%.1f km) ──%n", km);

        for (VehPub v : flota) {

            System.out.printf("  [%s] Costo: $%.0f COP%n",
                    v.getId(), v.calcCosto(km));
        }
    }
}
