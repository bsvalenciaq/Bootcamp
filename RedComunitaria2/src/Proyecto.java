public class Proyecto {
    private String nombre;
    private String descripcion;
    private NIvelInnovacion nivelInnovacion;
    private EstadoProyecto estado;
    private Emprendedores emprendedor;

    public Proyecto(String nombre, String descripcion, NIvelInnovacion nIvelInnovacion, EstadoProyecto estado, Emprendedores emprendedor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nivelInnovacion = nIvelInnovacion;
        this.estado = estado;
        this.emprendedor = emprendedor;
    }

    public Proyecto() {
    }

    public void mostrarResumen() {
        System.out.println("Registro exitoso\n");
        System.out.println("Emprendedor     ");
        System.out.println("\tNombre: " + this.emprendedor.getNombre());
        System.out.println("\tDocumento: " + this.emprendedor.getDocumento());
        System.out.println("\tSector: " + this.emprendedor.getSector());
        System.out.println("\tCiudad: " + this.emprendedor.getCiudad());
        System.out.println("\nProyecto");
        System.out.println("\tNombre: " + this.nombre);
        System.out.println("\tDescripcion: " + this.descripcion);
        System.out.println("\tNivel de Innovacion: " + this.nivelInnovacion);
        System.out.println("\tEstado: " + this.estado);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public NIvelInnovacion getNivelInnovacion() {
        return nivelInnovacion;
    }

    public void setNivelInnovacion(NIvelInnovacion nivelInnovacion) {

        this.nivelInnovacion = nivelInnovacion;

    }

    public EstadoProyecto getEstado() {
        return estado;
    }

    public void setEstado(EstadoProyecto estado) {
        this.estado = estado;
    }

    public Emprendedores getEmprendedor() {
        return emprendedor;
    }

    public void setEmprendedor(Emprendedores emprendedor) {
        this.emprendedor = emprendedor;
    }
}
