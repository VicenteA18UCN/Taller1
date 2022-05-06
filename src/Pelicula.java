public class Pelicula {
    private int id;
    private String nombre;
    private String director;
    private String genero1;
    private String genero2;
    private int cantHoras;
    private int cantMinutos;
    private int anioEstreno;
    private int stock;

    public Pelicula(int id, String nombre, String director, String genero1,int cantHoras, int cantMinutos, int anioEstreno, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.director = director;
        this.genero1 = genero1;
        this.cantHoras = cantHoras;
        this.cantMinutos = cantMinutos;
        this.anioEstreno = anioEstreno;
        this.stock = stock;
    }
    public Pelicula(int id, String nombre, String director, String genero1, String genero2, int cantHoras, int cantMinutos, int anioEstreno, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.director = director;
        this.genero1 = genero1;
        this.genero2 = genero2;
        this.cantHoras = cantHoras;
        this.cantMinutos = cantMinutos;
        this.anioEstreno = anioEstreno;
        this.stock = stock;
    }

    public String toString()
    {
        return "ID:" + this.id + "." + "\n" +
                "Titulo:" + this.nombre + "." + "\n" +
                "Director:" + this.director + "." + "\n" +
                "Genero/s:" + this.genero1 + "/" + this.genero2 + "\n" +
                "Duración:" + this.cantMinutos + " minutos." + "\n" +
                "Año estreno:" + this.anioEstreno + "\n" +
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getCantHoras() {
        return cantHoras;
    }

    public void setCantHoras(int cantHoras) {
        this.cantHoras = cantHoras;
    }

    public int getCantMinutos() {
        return cantMinutos;
    }

    public void setCantMinutos(int cantMinutos) {
        this.cantMinutos = cantMinutos;
    }

    public int getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(int anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
