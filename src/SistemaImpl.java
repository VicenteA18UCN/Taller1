import ucn.ArchivoEntrada;
import ucn.Registro;

public class SistemaImpl implements Sistema {
    private final int cantMaxLibros = 15;
    private final int cantMaxPeliculas = 15;
    private final int cantMaxUsuarios = 15;

    private final int cantMaxTransaccionUsuario = 2;
    private final ListaLibros listaLibros;
    private final ListaPeliculas listaPeliculas;
    private final ListaUsuarios listaUsuarios;
    public SistemaImpl() {
        this.listaLibros = new ListaLibros(this.cantMaxLibros);
        this.listaPeliculas = new ListaPeliculas(this.cantMaxPeliculas);
        this.listaUsuarios = new ListaUsuarios(this.cantMaxUsuarios);
    }

    public boolean lecturaUsuarios(String nombreArchivo)
    {
        try
        {
            ArchivoEntrada archivo = new ArchivoEntrada(nombreArchivo);

            while(!archivo.isEndFile()) {
                Registro linea = archivo.getRegistro();

                String nombre = linea.getString();
                String apellidoPat = linea.getString();
                String apellidoMat = linea.getString();
                String rut = linea.getString();
                String nickname = linea.getString();
                String contrasena = linea.getString();
                String membresia = linea.getString();
                if (membresia.equals("")) {
                    membresia = "Normal";
                }

                Usuario usuario = new Usuario(nombre, apellidoPat, apellidoMat, rut, nickname, contrasena, membresia);
                this.listaUsuarios.agregar(usuario);
            }

            archivo.close();

            return this.listaUsuarios.getCantidadUsuarios() == this.cantMaxUsuarios;


        }
        catch(Exception ignored)
        {
            return false;
        }
    }


    public boolean lecturaLibro(String nombreArchivo)
    {
        try {
            ArchivoEntrada archivo = new ArchivoEntrada(nombreArchivo);

            while (!archivo.isEndFile()) {
                Registro linea = archivo.getRegistro();

                int id = linea.getInt();
                String nombre = linea.getString();
                String autor = linea.getString();
                String genero1 = linea.getString();
                String genero2 = linea.getString();// preguntar a alguien que como quedaria la cosa si esto es vacio
                int cantPaginas = linea.getInt();
                int anioPublicacion = linea.getInt();
                int stock = linea.getInt();

                Libro libro = new Libro(id, nombre, autor, genero1, genero2, cantPaginas, anioPublicacion, stock);
                this.listaLibros.agregar(libro);
            }

            archivo.close();

            return this.listaLibros.getCantidadLibros() == this.cantMaxLibros;
        } catch (Exception ignored) {
            return false;
        }

    }

    public boolean lecturaPeliculas(String nombreArchivo)
    {
        try
        {
            ArchivoEntrada archivo = new ArchivoEntrada(nombreArchivo);
            while (!archivo.isEndFile())
            {
                Registro linea = archivo.getRegistro();
                int id = linea.getInt();
                String nombre = linea.getString();
                String director = linea.getString();
                String genero1 = linea.getString();
                String genero2 = linea.getString();
                int cantHoras = linea.getInt();
                int cantMinutos = linea.getInt();
                int anioEstreno = linea.getInt();
                int stock = linea.getInt();
                Pelicula pelicula = new Pelicula(id,nombre,director,genero1,genero2,cantHoras,cantMinutos,anioEstreno,stock);
                this.listaPeliculas.agregar(pelicula);
            }
            archivo.close();

            return this.listaPeliculas.getCantidadPeliculas() == this.cantMaxPeliculas;
        } catch(Exception ignored){
            return false;
        }
    }
    public boolean iniciarSesion(String nickname, String contrasena)
    {
        if(listaUsuarios.verificarContrasena(contrasena) && listaUsuarios.verificarNickname(nickname))
        {
            return  true;
        }
        return  false;
    }

    //public  boolean tipoProducto(int )

    public boolean registrarUsuario(String nombre, String apellidoPat, String apellidoMat, String rut, String nickname, String contrasena)
    {
        Usuario usuario = new Usuario(nombre,apellidoPat,apellidoMat,rut,nickname,contrasena,"Normal" );
        return this.listaUsuarios.agregar(usuario);
    }

    public Usuario obtenerUsuario(String nickname, String contrasena)
    {
        // Quizas para verificar solo hay que poner el metodo iniaciarSesion primero
        Usuario usuario = this.listaUsuarios.obtener(nickname,contrasena); // Tengo que verificar que el nickname y la contraseña sean correctas en el main.

        return usuario;
   }

   public String[] verLibros()
   {
       int n = this.listaLibros.getCantidadLibros();

       if (n == 0)
       {
           return null;
       }

       String[] infoLibros = new String[n];

       for(int i = 0; i < n; i++)
       {
           Libro libro = this.listaLibros.buscar(i);
           infoLibros[i] = libro.toString();
       }

       return infoLibros;
   }

    public String[] verPeliculas()
    {
        int n = this.listaPeliculas.getCantidadPeliculas();

        if (n == 0) {
            return null;
        }

        String[] infoPeliculas = new String[n];

        for (int i = 0; i < n; i++) {
            Pelicula pelicula = this.listaPeliculas.buscar(i);
            infoPeliculas[i] = pelicula.toString();
        }

        return infoPeliculas;
    }

    public void arrendarProducto()
    {

    }


}
