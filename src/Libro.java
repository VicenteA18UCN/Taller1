public class Libro {
    private int id;
    private String nombre;
    private String autor;
    private String genero1;
    private String genero2;
    private int cantPaginas;
    private int anioPublicacion;
    private int stock;

    public Libro(int id, String nombre, String autor, String genero1, String genero2, int cantPaginas, int anioPublicacion, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.genero1 = genero1;
        this.genero2 = genero2;
        this.cantPaginas = cantPaginas;
        this.anioPublicacion = anioPublicacion;
        this.stock = stock;
    }

    public String toString()
    {
        return  "ID:" + this.id + "." + "\n" +
                "Titulo:" + this.nombre + "." + "\n" +
                "Autor:" + this.autor + "." + "\n" +
                "Genero/s:" + this.genero1 + "/" + this.genero2 + "\n" +
                "Cantidad de paginas:" + this.cantPaginas + "\n" +
                "Año publicación:" + this.anioPublicacion + "\n" +
                "Stock disponible:" + this.stock;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero1() {
        return genero1;
    }

    public void setGenero1(String genero1) {
        this.genero1 = genero1;
    }

    public String getGenero2() {
        return genero2;
    }

    public void setGenero2(String genero2) {
        this.genero2 = genero2;
    }

    public int getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
