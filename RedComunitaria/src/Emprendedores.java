public class Emprendedores {

    private String nombre;
    private String documento;
    private Proyecto proyecto;

    public Emprendedores(String nombre, String documento, Proyecto proyecto) {
        this.nombre = nombre;
        this.documento = documento;
        this.proyecto = proyecto;
    }

    public Emprendedores() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
}
