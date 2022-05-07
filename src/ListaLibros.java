public class ListaLibros {
    private Libro[] listaLibros;
    private int cantidadLibros;
    private int max;

    public ListaLibros(int max) {
        this.listaLibros = new Libro[max];
        this.cantidadLibros = 0;
        this.max = max;
    }

    public boolean agregar(Libro libro) {
        if (this.cantidadLibros == this.max) {
            return false;
        }

        for (int i = 0; i < this.cantidadLibros; i++) {
            Libro libroNew = this.listaLibros[i];

            if (libroNew.getId() == libro.getId()) ;
            {
                return false;
            }
        }
        this.listaLibros[this.cantidadLibros] = libro;
        this.cantidadLibros++;

        return true;

    }

    public Libro buscar(int id) {
        for (int i = 0; i < this.cantidadLibros; i++) {
            Libro libro = this.listaLibros[i];

            if (libro.getId() == id) {
                return libro;
            }

        }
        return null;
    }

    public boolean reducir(int id) {
        for (int i = 0; i < this.cantidadLibros; i++) {
            Libro libro = this.listaLibros[i];

            if (libro.getId() == id && libro.getStock() > 0) {
                libro.setStock(libro.getStock() - 1);
                return true;
            }

        }
        return false;
    }

    public int getCantidadLibros() {
        return cantidadLibros;
    }

    public void setCantidadLibros(int cantidadLibros) {
        this.cantidadLibros = cantidadLibros;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
