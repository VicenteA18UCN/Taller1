public class Usuario {
    private String nombre;
    private String apellidoPat;
    private String apellidoMat;
    private String rut;
    private String nickname;
    private String contrasena;
    private String membresia;
    private boolean advertencia;
    private ListaLibros arriendosLibros;
    private ListaPeliculas arriendosPeliculas;


    public Usuario(String nombre, String apellidoPat, String apellidoMat, String rut, String nickname, String contrasena, String membresia) {
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.rut = rut;
        this.nickname = nickname;
        this.contrasena = contrasena;
        this.membresia = membresia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getMembresia() {
        return membresia;
    }

    public void setMembresia(String membresia) {
        this.membresia = membresia;
    }

    public boolean isAdvertencia() {
        return advertencia;
    }

    public void setAdvertencia(boolean advertencia) {
        this.advertencia = advertencia;
    }

    public ListaLibros getArriendosLibros() {
        return arriendosLibros;
    }

    public void setArriendosLibros(ListaLibros arriendosLibros) {
        this.arriendosLibros = arriendosLibros;
    }

    public ListaPeliculas getArriendosPeliculas() {
        return arriendosPeliculas;
    }

    public void setArriendosPeliculas(ListaPeliculas arriendosPeliculas) {
        this.arriendosPeliculas = arriendosPeliculas;
    }
}
