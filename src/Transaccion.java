import java.util.Calendar;

public class Transaccion {

    private int id;
    private String tipoTransaccion;
    private Usuario usuario;
    private String tipoProducto;
    private Calendar fechaTransaccion;
    private Calendar fechaEntrega;
    private Calendar fechaDevolución;
    private Usuario usuarioMasPrestamo;
    private int idProducto;
    private boolean atraso;

    public Transaccion(int id, String tipoTransaccion, Usuario usuario, String tipoProducto, Calendar fechaTransaccion, Calendar fechaEntrega, Calendar fechaDevolución, int idProducto, boolean atraso) {
        this.id = id;
        this.tipoTransaccion = tipoTransaccion;
        this.usuario = usuario;
        this.tipoProducto = tipoProducto;
        this.fechaTransaccion = fechaTransaccion;
        this.fechaEntrega = fechaEntrega;
        this.fechaDevolución = fechaDevolución;
        this.idProducto = idProducto;
        this.atraso = atraso;
    }

    public Transaccion(int id, String tipoTransaccion, Usuario usuario, String tipoProducto, Calendar fechaTransaccion, Calendar fechaEntrega, int idProducto) {
        this.id = id;
        this.tipoTransaccion = tipoTransaccion;
        this.usuario = usuario;
        this.tipoProducto = tipoProducto;
        this.fechaTransaccion = fechaTransaccion;
        this.fechaEntrega = fechaEntrega;
        this.idProducto = idProducto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Calendar fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public Calendar getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Calendar fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Calendar getFechaDevolución() {
        return fechaDevolución;
    }

    public void setFechaDevolución(Calendar fechaDevolución) {
        this.fechaDevolución = fechaDevolución;
    }

    public Usuario getUsuarioMasPrestamo() {
        return usuarioMasPrestamo;
    }

    public void setUsuarioMasPrestamo(Usuario usuarioMasPrestamo) {
        this.usuarioMasPrestamo = usuarioMasPrestamo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

     public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public boolean getAtraso(){return atraso;}

    public void setAtraso(boolean atraso) {
        this.atraso = atraso;
    }
}