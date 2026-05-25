import java.time.Year;

public abstract class VehPub {

    protected String id;
    protected int anio;
    protected String ubi;
    protected boolean estado;

    public VehPub(String id, int anio,
                  String ubi, boolean estado) {
        this.id = id;
        this.anio = anio;
        this.ubi = ubi;
        this.estado = estado;
    }

    public int getEdad() {
        return Year.now().getValue() - anio;
    }

    public abstract double calcCosto(double km);

    public abstract void genReporte();

    public abstract int getCapMax();

    public String getId() {
        return id;
    }

    public String getUbi() {
        return ubi;
    }

    public boolean isEstado() {
        return estado;
    }
}
    