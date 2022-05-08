
import java.util.Calendar;
public interface Sistema {
    /**
     * Carga todos los usuarios del archivo.
     *
     * @param nombreArchivo Nombre del archivo.
     * @return True si la carga es exitosa, False en caso contrario.
     */
    boolean lecturaUsuarios(String nombreArchivo);

    /**
     * Carga todos los libros del archivo.
     *
     * @param nombreArchivo Nombre del archivo
     * @return True si la carga es exitosa, False en caso contrario.
     */
    boolean lecturaLibros(String nombreArchivo);

    /**
     * Carga todas las peliculas del archivo.
     *
     * @param nombreArchivo Nombre del archivo.
     * @return True si la carga es exitosa, False en caso contrario.
     */
    boolean lecturaPeliculas(String nombreArchivo);

    /**
     * Inicia la sesion del usuario.
     *
     * @param nickname   Nombre de usuario.
     * @param contrasena Contraseña del usuario.
     * @return True si el ingreso es exitoso, False en caso contrario.
     */
    boolean iniciarSesion(String nickname, String contrasena);

    /**
     * Permite registrar un nuevo usuario al Sistema.
     *
     * @param nombre      Nombre real del usuario.
     * @param apellidoPat Apellido paterno del usuario.
     * @param apellidoMat Apellido materno del usuario.
     * @param rut         Rut del usuario.
     * @param nickname    Nombre de usuario.
     * @param contrasena  Contraseña del usuario.
     * @return
     */
    boolean registrarUsuario(String nombre, String apellidoPat, String apellidoMat, String rut, String nickname, String contrasena);

    /**
     * Permite obtener todos los datos del usuario.
     *
     * @param nickname   Nombre de usaurio.
     * @param contrasena Contraseña del usuario.
     * @return La informacion del usuario.
     */
    Usuario obtenerUsuario(String nickname, String contrasena);

    /**
     * Compureba que la nueva contraseña cumpla los tres parametros acordados, que tenga una letra mayuscula, que tenga una letra minuscula y un numero.
     *
     * @param contrasenaNew Contraseña nueva propuesta por el usuario.
     * @return True si es que cumple las condiciones, False en caso contrario.
     */
    boolean comprobar(String contrasenaNew);

    /**
     * Permite al usuario cambiar su contraseña.
     *
     * @param nickname      Nombre de usuario.
     * @param contrasena    Contraseña anterior del usuario.
     * @param contrasenaNew Contraseña nueva del usuario.
     * @return True si el cambio es exitoso, False en caso contrario.
     */
    boolean cambiarContrasena(String nickname, String contrasena, String contrasenaNew);

    /**
     * Permite al usuario ver el catalogo de libros.
     *
     * @return El catalogo con informacion de cada libro.
     */
    String[] verLibros();

    /**
     * Permite al usuario ver el catalogo de peliculas.
     *
     * @return El catalogo con informacion de cada pelicula.
     */
    String[] verPeliculas();

    /**
     * Verifica si el usuario puede arrendar o no.
     *
     * @param usuario Datos del usuario.
     * @return True en caso de que pueda arrendar, False en caso contrario.
     */
    boolean puedeArrendar(Usuario usuario);

    /**
     * Permite al usuario arrendar un libro.
     *
     * @param nickname         Nombre del usuario.
     * @param idLibro          Id del libro que se quiere arrendar.
     * @param fechaTransaccion Fecha del dia de la transaccion.
     * @return True si el arriendo es exitoso, False en caso contrario.
     */
    boolean arrendarLibro(String nickname, int idLibro, Calendar fechaTransaccion);

    /**
     * Permite al usuario arrendar una pelicula.
     *
     * @param nickname         Nombre del usuario.
     * @param idPelicula       Id de la pelicula que se quiere arrendar.
     * @param fechaTransaccion Fecha del dia de la transaccion.
     * @return True si el arriendo es exitoso, False en caso contrario.
     */
    boolean arrendarPelicula(String nickname, int idPelicula, Calendar fechaTransaccion);

    /**
     * Permite al usuario devolver un libro que arrendo.
     *
     * @param id               Id del libro que se quiere devolver.
     * @param fechaTransaccion Fecha del dia de la transaccion.
     * @return True si la devolucion es exitosa, False en caso contrario.
     */
    boolean devolverLibro(int id, Calendar fechaTransaccion);

    /**
     * Permite al usuario devolver una pelicula que arrendo.
     *
     * @param id               Id de la pelicula que se quiere devolver.
     * @param fechaTransaccion Fecha del dia de la transaccion.
     * @return True si la devolucion es exitosa, False en caso contrario.
     */
    boolean devolverPelicula(int id, Calendar fechaTransaccion);

    /**
     * Da el valor de la cantidad de transacciones ocurridas en 2022.
     *
     * @return El valor de las transacciones durante 2022.
     */
    int estTransacciones2022();

    /**
     * Retorna la al usuario o la lista de usuarios que mas prestamos han realizado sin retraso.
     *
     * @return Usuarios con mas prestamos.
     */
    String[] estadisticas();

    /**
     * Permite agregar un libro nuevo al catalogo.
     *
     * @param nombre          Nombre del libro.
     * @param autor           Autor del libro.
     * @param genero1         Primer genero del libro.
     * @param genero2         Segundo genero del libro.
     * @param cantPaginas     Cantidad de paginas del libro.
     * @param anioPublicacion Año de publicacion del libro.
     * @return True si se agrega exitosamente, False en caso contrario.
     */
    boolean agregarLibro(String nombre, String autor, String genero1, String genero2, int cantPaginas, int anioPublicacion);


    /**
     * Permite agregar una pelicula nueva al catalogo.
     * @param nombre Nombre de la pelicula
     * @param director Director de la pelicula.
     * @param genero1 Primer genero de la pelicula.
     * @param genero2 Segundo genero de la pelicula.
     * @param cantHoras Cantidad de horas de la pelicula.
     * @param cantMinutos Cantidad de minutos de la pelicula.
     * @param anioEstreno Año de estreno de la pelicula
     * @return True si se agrega exitosamente, False en caso contrario.
     */
    boolean agregarPelicula(String nombre, String director, String genero1, String genero2, int cantHoras, int cantMinutos, int anioEstreno);

    /**
     * Permite al usuario poder subir su membresia si cumple una serie de requisitos.
     * @param nickname Nombre de usuario.
     * @return True si subio la membresia exitosamente, False en caso contrario.
     */
    boolean subirMembresia(String nickname);


}

