public class ListaPeliculas {
    private Pelicula[] listaPeliculas;
    private int cantidadPeliculas;
    private int max;

    public ListaPeliculas(int max) {
        listaPeliculas = new Pelicula[max];
        this.cantidadPeliculas = 0;
        this.max = max;
    }
    public boolean agregar(Pelicula pelicula) {
        if (this.cantidadPeliculas == this.max) {
            return false;
        }

        for (int i = 0; i < this.cantidadPeliculas; i++) {

            Pelicula peliculaNew = this.listaPeliculas[i];

            if (peliculaNew.getId() == pelicula.getId()) ;
            {
                return false;
            }
        }
        this.listaPeliculas[this.cantidadPeliculas] = pelicula;
        this.cantidadPeliculas++;
        return true;
    }

    public Pelicula buscar(int id)
        {
            for (int i = 0; i < this.cantidadPeliculas; i++)
            {
                Pelicula pelicula = this.listaPeliculas[i];

                if (pelicula.getId() == id)
                {
                    return pelicula;
                }
            }
            return null;
        }

    public Pelicula reducir(int id) {
        for (int i = 0; i < this.cantidadPeliculas; i++) {
            Pelicula pelicula = this.listaPeliculas[i];

            if (pelicula.getId() == id && pelicula.getStock() > 0) {
                pelicula.setStock(pelicula.getStock() - 1);
            }

        }
        return null;
    }


    public int getCantidadPeliculas() {
        return cantidadPeliculas;
    }

    public void setCantidadPeliculas(int cantidadPeliculas) {
        this.cantidadPeliculas = cantidadPeliculas;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
