public class Emprendedores {

    private String nombre;
    private String documento;
    private String sector;
    private String ciudad;

    public Emprendedores(String nombre, String documento, String sector, String ciudad) {
        this.nombre = nombre;
        this.documento = documento;
        this.sector = sector;
        this.ciudad = ciudad;
    }

    public String getCiudad() {
        return ciudad;
    }


    public String getSector() {
        return sector;
    }


    public Emprendedores(String nombre, String documento, Proyecto proyecto, String sector,
                         String ciudad) {
        this.nombre = nombre;
        this.documento = documento;
        this.sector = sector;
        this.ciudad = ciudad;
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


    public void setSector(String sector) {
        this.sector = sector;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
