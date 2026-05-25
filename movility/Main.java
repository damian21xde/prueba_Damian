public class Main {

    public static void main(String[] args) {

        GestFlota gf = new GestFlota();

        BusDiesel b1 = new BusDiesel(
                "DB-001", 2018, "Terminal Norte", true,
                80, 0.35, 4_800);

        BusDiesel b2 = new BusDiesel(
                "DB-002", 2015, "Estación Estadio", true,
                80, 0.38, 4_800);

        BusElec e1 = new BusElec(
                "EAB-001", 2022, "Corredor BRT Sur", true,
                160, 1.8, 620, 85);

        BusElec e2 = new BusElec(
                "EAB-002", 2023, "Corredor BRT Norte", true,
                160, 1.8, 620, 72);

        CableCar c1 = new CableCar(
                "CC-001", 2016, "Estación Acevedo", true,
                10, 1_200, 90);

        CableCar c2 = new CableCar(
                "CC-002", 2019, "Estación Santo Domingo", true,
                10, 1_200, 88);

        ElectricScooter s1 = new ElectricScooter(
                "SC-001", 2024, "Estación Intermodal Sur", true,
                150, 95);

        ElectricScooter s2 = new ElectricScooter(
                "SC-002", 2024, "Estación Intermodal Norte", true,
                150, 40);

        System.out.println("\n ---INICIALIZANDO FLOTA MOVILCITY---");

        gf.agregar(b1);
        gf.agregar(b2);
        gf.agregar(e1);
        gf.agregar(e2);
        gf.agregar(c1);
        gf.agregar(c2);
        gf.agregar(s1);
        gf.agregar(s2);

        System.out.println("\n ---ESCENARIOS DE PRUEBA---");

        double costoB = b1.calcCosto(12.5);

        System.out.printf("%n[PRUEBA 1] BusDiesel DB-001, 12.5 km:%n");
        System.out.printf("  Costo calculado : $%.0f COP%n", costoB);
        System.out.printf("  Costo esperado  : $21,000 COP  %s%n",
                (costoB == 21_000) ? "✓ CORRECTO" : "✗ ERROR");

        double costoE = e1.calcCosto(8);
        double co2E = e1.calcCO2(8);

        System.out.printf("%n[PRUEBA 2] BusElec EAB-001, 8 km:%n");
        System.out.printf("  Costo calculado : $%.0f COP%n", costoE);
        System.out.printf("  Costo esperado  : $8,928 COP   %s%n",
                (costoE == 8_928) ? "✓ CORRECTO" : "✗ ERROR");

        System.out.printf("  CO₂ directo     : %.1f kg       %s%n",
                co2E, (co2E == 0.0) ? "✓ CORRECTO" : "✗ ERROR");

        double costoC = c1.calcCosto(3);

        System.out.printf("%n[PRUEBA 3] CableCar CC-001, 3 segmentos:%n");
        System.out.printf("  Costo calculado : $%.0f COP%n", costoC);
        System.out.printf("  Costo esperado  : $3,600 COP   %s%n",
                (costoC == 3_600) ? "✓ CORRECTO" : "✗ ERROR");

        System.out.println("\n ---SIMULACIÓN DE ABORDAJE---");

        b1.subirPas(45);
        b2.subirPas(30);

        e1.subirPas(120);
        e2.subirPas(85);

        c1.subirPas(8);
        c2.subirPas(6);
        c1.subirPas(5);

        System.out.println("\n --- GESTIÓN DE CARGA ELÉCTRICA ---");

        e2.conectar("ESTACION-BRT-NORTE-01");
        e2.cargar(100);

        s2.conectar("DOCK-INTERMODAL-NORTE-07");
        s2.chargeTo(95);

        c1.conectar("SUBESTACION-ACEVEDO");

        System.out.println("\n --- PRUEBA 4: REPORTES OPERATIVOS ---");

        gf.printReportes();

        System.out.println("\n --- PRUEBA 5: TOTAL CO₂ FLOTA (12.5 km) ---");

        double total = gf.getCO2Total(12.5);

        System.out.printf("CO₂ total: %.2f kg%n", total);

        System.out.println("\n --- VEHÍCULO CON MAYOR OCUPACIÓN ---");

        VehPub mas = gf.getMasOcup();

        if (mas != null && mas instanceof GestAbord g) {

            System.out.printf("Vehículo más ocupado: %s con %d pasajeros%n",
                    mas.getId(), g.getOcup());
        }

        System.out.println("\n --- DEMOSTRACIÓN POLIMORFISMO ---");

        VehPub[] vec = { b1, e1, c1, s1 };

        for (VehPub v : vec) {

            System.out.printf("  %-10s [%-7s] → $%.0f COP%n",
                    v.getClass().getSimpleName(),
                    v.getId(),
                    v.calcCosto(10));
        }

        gf.printCostos(10);
    }
}
