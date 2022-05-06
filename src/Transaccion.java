public class Transaccion {

    private int id;
    private Usuario usuario;
    private String fechaTransaccion;
    private String fechaEntrega;
    private String fechaDevolución;
    private Usuario usuarioMasPrestamo;

    public Transaccion(int id, String fechaTransaccion, String fechaEntrega, String fechaDevolución, Usuario usuarioMasPrestamo) {
        this.id = id;
        this.fechaTransaccion = fechaTransaccion;
        this.fechaEntrega = fechaEntrega;
        this.fechaDevolución = fechaDevolución;
        this.usuarioMasPrestamo = usuarioMasPrestamo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaTransaccion() {
        return fechaTransaccion;
    }

    public Usuario getUsuarioMasPrestamo() {
        return usuarioMasPrestamo;
    }

    public void setUsuarioMasPrestamo(Usuario usuarioMasPrestamo) {
        this.usuarioMasPrestamo = usuarioMasPrestamo;
    }

    public void setFechaTransaccion(String fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getFechaDevolución() {
        return fechaDevolución;
    }

    public void setFechaDevolución(String fechaDevolución) {
        this.fechaDevolución = fechaDevolución;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
