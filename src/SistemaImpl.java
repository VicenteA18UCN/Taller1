import ucn.ArchivoEntrada;
import ucn.Registro;
import java.util.Calendar;
import java.util.Date;


public class SistemaImpl implements Sistema {
    private final int cantMaxLibros = 15;
    private final int cantMaxPeliculas = 15;
    private final int cantMaxUsuarios = 15;
    private final int cantMaxTransacciones = 15;

    private final int cantMaxTransaccionUsuario = 2;
    private final ListaLibros listaLibros;
    private final ListaPeliculas listaPeliculas;
    private final ListaUsuarios listaUsuarios;
    private final ListaTransaccion listaTransaccion;

    public SistemaImpl() {
        this.listaLibros = new ListaLibros(this.cantMaxLibros);
        this.listaPeliculas = new ListaPeliculas(this.cantMaxPeliculas);
        this.listaUsuarios = new ListaUsuarios(this.cantMaxUsuarios);
        this.listaTransaccion = new ListaTransaccion((this.cantMaxTransacciones));
    }

    /**
     * Este metodo lee el archivo de Usuarios.
     * @param nombreArchivo
     * @return
     */


    public boolean lecturaUsuarios(String nombreArchivo) {
        try {
            ArchivoEntrada archivo = new ArchivoEntrada(nombreArchivo);

            while (!archivo.isEndFile()) {
                Registro linea = archivo.getRegistro();
                cantDatos = linea.lenght();



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


        } catch (Exception ignored) {
            return false;
        }
    }
    /*
    public boolean lecturaUsuarios(String nombreArchivo) {

        try {
            ArchivoEntrada archivo = new ArchivoEntrada(nombreArchivo);

            while (!archivo.isEndFile()) {
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


        } catch (Exception ignored) {
            return false;
        }
    }
*/

    public boolean lecturaLibros(String nombreArchivo) {
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

    public boolean lecturaPeliculas(String nombreArchivo) {
        try {
            ArchivoEntrada archivo = new ArchivoEntrada(nombreArchivo);
            while (!archivo.isEndFile()) {
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
                Pelicula pelicula = new Pelicula(id, nombre, director, genero1, genero2, cantHoras, cantMinutos, anioEstreno, stock);
                this.listaPeliculas.agregar(pelicula);
            }
            archivo.close();

            return this.listaPeliculas.getCantidadPeliculas() == this.cantMaxPeliculas;
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean iniciarSesion(String nickname, String contrasena) {
        if (listaUsuarios.verificarContrasena(contrasena) && listaUsuarios.verificarNickname(nickname)) {
            return true;
        }
        return false;
    }

    //public  boolean tipoProducto(int )

    public boolean registrarUsuario(String nombre, String apellidoPat, String apellidoMat, String rut, String nickname, String contrasena) {
        Usuario usuario = new Usuario(nombre, apellidoPat, apellidoMat, rut, nickname, contrasena, "Normal");
        return this.listaUsuarios.agregar(usuario);
    }

    public Usuario obtenerUsuario(String nickname, String contrasena) {
        // Quizas para verificar solo hay que poner el metodo iniaciarSesion primero
        Usuario usuario = this.listaUsuarios.obtener(nickname, contrasena); // Tengo que verificar que el nickname y la contraseña sean correctas en el main.

        return usuario;
    }

    public boolean comprobar(String contraseñaNew)
    {
        char c;
        boolean upperCase = false;
        boolean lowerCase = false;
        boolean number = false;
        for(int i = 0; i < contraseñaNew.length(); i++)
        {
            c = contraseñaNew.charAt(i);
            if(Character.isDigit(c))
            {
                number = true;
            }
            else if (Character.isUpperCase(c))
            {
                upperCase = true;
            }
            else if (Character.isLowerCase(c))
            {
                lowerCase = true;
            }
            if(upperCase && lowerCase && number)
            {
                return true;
            }

        }
        return false;
    }
    public boolean cambiarContrasena(String nickname, String contrasena, String contrasenaNew)
    {
        Usuario usuario = this.listaUsuarios.obtener(nickname, contrasena);

        if (contrasenaNew.equals(contrasena) || contrasenaNew.length() <= 6)
        {
            return false;
        }
        if (!comprobar(contrasenaNew))
        {
            return false;
        }

        return true;
    }

    public String[] verLibros() {
        int cantLibros = this.listaLibros.getCantidadLibros();

        if (cantLibros == 0) {
            return null;
        }

        String[] infoLibros = new String[cantLibros];

        for (int i = 0; i <= cantLibros; i++) {
            Libro libro = this.listaLibros.buscar(i);
            infoLibros[i] = libro.toString();
        }

        return infoLibros;
    }

    public String[] verPeliculas() {
        int cantPeliculas = this.listaPeliculas.getCantidadPeliculas();

        if (cantPeliculas == 0) {
            return null;
        }

        String[] infoPeliculas = new String[cantPeliculas];

        for (int i = 0; i <= cantPeliculas; i++) {
            Pelicula pelicula = this.listaPeliculas.buscar(i);
            infoPeliculas[i] = pelicula.toString();
        }

        return infoPeliculas;
    }

    public boolean puedeArrendar(Usuario usuario) {
        String membresia = usuario.getMembresia();
        int cantArriendos = usuario.getCantArriendos();
        if (membresia.equals("Vip") && cantArriendos <= 2) {
            return true;
        }
        if (!membresia.equals("Vip") && cantArriendos == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean arrendarLibro(String nickname, int idLibro, Calendar fechaTransaccion) //Deberiamos Cambiar el rut por nickname
    {

        Usuario usuario = this.listaUsuarios.obtenerNickname(nickname);
        Libro libro = this.listaLibros.buscar(idLibro);


        if (usuario == null) {
            return false;
        }
        if (libro.getStock() == 0) {
            return false;

        }

        boolean puedeArrendar = puedeArrendar(usuario);
        if (puedeArrendar) {
            Calendar fechaEntrega = fechaTransaccion;
            fechaEntrega.add(Calendar.DAY_OF_MONTH, +1);
            int idTransaccion = listaTransaccion.getCantTransacciones() + 1;
            Transaccion transaccion = new Transaccion(idTransaccion, "Prestamo", usuario, "Libro", fechaTransaccion, fechaEntrega, idLibro);
            boolean agregar = listaTransaccion.agregar(transaccion);
            boolean reducir = listaLibros.reducir(idLibro);
            usuario.setArriendosLibros(listaLibros);

            if (agregar && reducir) {
                return true;
            }
        }

        return false;

    }

    public boolean arrendarPelicula(String nickname, int idPelicula, Calendar fechaTransaccion) {
        Usuario usuario = this.listaUsuarios.obtenerNickname(nickname);
        Pelicula pelicula = this.listaPeliculas.buscar(idPelicula);
        //Innecesario
        if (usuario == null) {
            return false;
        } //Innecesario
        if (pelicula.getStock() == 0) {
            return false;

        }

        Calendar fechaEntrega = fechaTransaccion;
        fechaEntrega.add(Calendar.DAY_OF_MONTH, +1);
        int idTransaccion = listaTransaccion.getCantTransacciones() + 1;
        Transaccion transaccion = new Transaccion(idTransaccion, "Prestamo", usuario, "Pelicula", fechaTransaccion, fechaEntrega, idPelicula);
        boolean agregar = listaTransaccion.agregar(transaccion);
        boolean reducir = listaPeliculas.reducir(idPelicula);
        usuario.setArriendosPeliculas(listaPeliculas);

        if (agregar && reducir) {
            return true;
        }

        return false;

    }

    public boolean devolverLibro(int id,Calendar fechaEntrega) // de transaccion
    {
        boolean atraso = false;
        Transaccion transaccion = this.listaTransaccion.buscar(id);
        if (transaccion != null) {
            Libro libro = this.listaLibros.buscar(transaccion.getIdProducto());
            Usuario usuario = transaccion.getUsuario();

            libro.setStock(libro.getStock() + 1);
            if (transaccion.getFechaDevolución().after(transaccion.getFechaEntrega())) {
                usuario.setAdvertencia(true);
                atraso = true;
            }

            int idTransaccion = listaTransaccion.getCantTransacciones() + 1;
            Transaccion newTransaccion = new Transaccion(idTransaccion, "Devolucion", usuario, "Libro", transaccion.getFechaTransaccion(), fechaEntrega, transaccion.getFechaDevolución(), libro.getId(),atraso);
            listaTransaccion.agregar(newTransaccion);
            return true;
        }
        return false;


    }


    public boolean devolverPelicula(int id, Calendar fechaEntrega) // de transaccion
    {
        Transaccion transaccion = this.listaTransaccion.buscar(id);
        boolean atraso = false;

        if (transaccion != null) {
            Pelicula pelicula = this.listaPeliculas.buscar(transaccion.getIdProducto());
            Usuario usuario = transaccion.getUsuario();
            pelicula.setStock(pelicula.getStock() + 1);
            if (transaccion.getFechaDevolución().after(transaccion.getFechaEntrega())) {
                usuario.setAdvertencia(true);
                atraso = true;
            }
            int idTransaccion = listaTransaccion.getCantTransacciones() + 1;
            Transaccion newTransaccion = new Transaccion(idTransaccion, "Devolucion", usuario, "Libro", transaccion.getFechaTransaccion(), fechaEntrega, transaccion.getFechaDevolución(), pelicula.getId(),atraso);
            listaTransaccion.agregar(newTransaccion);

            return true;
        }
        return false;
    }

    public int estTransacciones2022() {
        int estTransaccciones2022 = 0;
        int cantTransacciones = listaTransaccion.getCantTransacciones();
        for (int i = 0; i <= cantTransacciones; i++) {
            Transaccion transaccion = this.listaTransaccion.buscar(i);
            if (transaccion.getFechaEntrega().after(01 - 01 - 2022)) {
                estTransaccciones2022 = estTransaccciones2022 + 1;
            }
        }
        return estTransaccciones2022;
    }

    public String[] estadisticas() {
        int cantUsuarios = this.listaUsuarios.getCantidadUsuarios();
        String[] usuarios = new String[cantUsuarios];
        String[] listaCompleta = new String[cantUsuarios];
        int[] prestamosUsuarios = new int[cantUsuarios];
        int cantTransacciones = this.listaTransaccion.getCantTransacciones();
        int usuariosid = 0;
        int mayor = -1;
        int cantMayores = 0;

        for (int i = 0; i <= cantTransacciones; i++)
        {
            boolean agregar = true;
            Transaccion transaccion = this.listaTransaccion.buscar(i);
            boolean atraso = transaccion.getAtraso();
            if (transaccion.getTipoProducto().equals("Libro") && !atraso) {
                Usuario usuario = transaccion.getUsuario();
                for (int j = 0; j < usuariosid; j++)
                {
                    if(usuario.getRut().equals(usuarios[j]))
                    {
                        agregar = false;
                        prestamosUsuarios[j] = prestamosUsuarios[usuariosid]+1;
                    }
                }
                if (agregar)
                {
                    usuarios[usuariosid] = usuario.getRut();
                    prestamosUsuarios[usuariosid] = prestamosUsuarios[usuariosid]+1;
                    usuariosid = usuariosid + 1;

                }

            }
        }
        for(int i=0; i<= usuariosid; i++)
        {
            if(prestamosUsuarios[i] >= mayor)
            {
                mayor = prestamosUsuarios[i] + 0;
            }
        }
        for(int i=0; i<= usuariosid; i++)
        {
            if(prestamosUsuarios[i] == mayor)
            {
                Usuario usuarioM = listaUsuarios.obtener(usuarios[i]);
                listaCompleta[cantMayores] = usuarioM.getNombre();
                listaCompleta[cantMayores+1] = usuarioM.getApellidoPat();
                listaCompleta[cantMayores+2] = usuarioM.getApellidoMat();
                listaCompleta[cantMayores+3] = usuarioM.getNickname();
                cantMayores = cantMayores+1;
            }
        }
        return listaCompleta;
    }

    public boolean agregarLibro(String nombre, String autor, String genero1, String genero2, int cantPaginas, int anioPublicacion) {

        int idNew = listaLibros.getCantidadLibros() + 1;

        if (genero2.equals("")) {
            Libro libro = new Libro(idNew, nombre, autor, genero1, cantPaginas, anioPublicacion, 1);
            listaLibros.agregar(libro);
            return true;
        }
        else{
            Libro libro = new Libro(idNew, nombre, autor, genero1, genero2, cantPaginas, anioPublicacion, 1);
            listaLibros.agregar(libro);
            return true;
        }
    }

    public boolean agregarPelicula(String nombre, String director, String genero1, String genero2, int cantHoras, int cantMinutos, int anioEstreno) {

        int idNew = listaPeliculas.getCantidadPeliculas() + 1;

        if (genero2.equals("")) {
            Pelicula pelicula = new Pelicula(idNew, nombre, director, genero1, cantHoras, cantMinutos, anioEstreno, 1);
            listaPeliculas.agregar(pelicula);
            return true;
        }
        else{
            Pelicula pelicula = new Pelicula(idNew, nombre, director, genero1, genero2, cantHoras,cantMinutos,anioEstreno, 1);
            listaPeliculas.agregar(pelicula);
            return true;
        }
    }

    public boolean subirMembresia(String nickname)
    {
        int contador = 0;
        Usuario usuario = listaUsuarios.obtenerNickname(nickname);
        String tipoMembresia = usuario.getMembresia();
        boolean advertensia = usuario.getAdvertencia();
        for (int i = 0; i <= listaTransaccion.getCantTransacciones(); i++)
        {
            Transaccion transaccion = listaTransaccion.buscar(i);
            String nicknameTransaccion = transaccion.getUsuario().getNickname();
            if(nickname.equals(nicknameTransaccion) && !transaccion.getAtraso())
            {
                contador++;
            }
        }
        if(contador >= 5 && tipoMembresia.equals("Normal"))
        {
            tipoMembresia = "Estandar";
            listaUsuarios.obtenerNickname(nickname).setMembresia(tipoMembresia);
            return true;
        }
        if(contador >= 7 && tipoMembresia.equals("Estandar"))
        {
            tipoMembresia = "Premium";
            listaUsuarios.obtenerNickname(nickname).setMembresia(tipoMembresia);
            return true;
        }
        if(contador >= 10 && tipoMembresia.equals("Premium"))
        {
            tipoMembresia = "Vip";
            listaUsuarios.obtenerNickname(nickname).setMembresia(tipoMembresia);
            return true;
        }
        return false;
    }
}
