
import ucn.StdIn;
import ucn.StdOut;
import java.util.Date;


import java.util.Calendar;

public class Main {
    public static void main(String[] args)
    {
        SistemaImpl sistemaImpl = new SistemaImpl();
        boolean lecturaUsuarios = sistemaImpl.lecturaUsuarios("usuarios.txt");
        if (!lecturaUsuarios) {
            StdOut.println("Error en usuarios.txt");

        }
        boolean lecturalibros = sistemaImpl.lecturaLibros("libros.txt");
        if (!lecturalibros) {
            StdOut.println("Error en libros.txt");

        }
        boolean lecturaPeliculas = sistemaImpl.lecturaPeliculas("peliculas.txt");
        if (!lecturaPeliculas) {
            StdOut.println("Error en peliculas.txt");
        } else {
            menuPrincipal(sistemaImpl);
        }
    }

    public static void menuPrincipal(SistemaImpl sistemaImpl)
    {
        boolean continuar = true;
        StdOut.println("Bienvenido a Movies and Books");
        while (continuar)
        {
            StdOut.println("---------------------------- MENU PRINCIPAL ----------------------------");
            StdOut.println("1.1 Iniciar Seción.");
            StdOut.println("1.2 Registrar usuario");
            StdOut.println("1.3 Salir de la apliclación");
            StdOut.print("Ingrese el segundo numero de la opcion: ");
            String opcion = StdIn.readLine().strip().toUpperCase();
            while (!opcion.equals("1") && !opcion.equals("2") && !opcion.equals("3")) {
                StdOut.print("Opcion invalida, ingrese otra");
                opcion = StdIn.readLine().strip().toUpperCase();
            }
            switch (opcion.toUpperCase()) {
                case "1" -> menuIniciarSecion(sistemaImpl);
                case "2" -> menuRegistrarUsuario(sistemaImpl);
                case "3" -> continuar = false;
            }
        }
        //Actualizar archivos aqui
    }

    private static void menuIniciarSecion(SistemaImpl sistemaImpl)
    {
        boolean iniciarSesion = false;
        String nickname = "";
        String contrasena = "";
        while (!iniciarSesion)
        {
            StdOut.print("Ingrese su nombre de usuario: ");
            nickname = StdIn.readLine();
            StdOut.println("Ingrese su contraseña");
            contrasena = StdIn.readLine();
            iniciarSesion = sistemaImpl.iniciarSesion(nickname, contrasena);
            if (!iniciarSesion) {
                StdOut.println("Nombre de usuario o contraseña invalidos");
            }
        }
        boolean continuar = true;
        while (continuar)
        {
            StdOut.println("---------------------------- MENU SESION INICIADA ----------------------------");
            StdOut.println("1) Arrendar producto.");
            StdOut.println("2) Devolver producto");
            StdOut.println("3) Gestionar cuenta");
            StdOut.println("4) Ver catálogo");
            StdOut.println("5) Ingresar nuevo producto");
            StdOut.println("6) Estadisticas");
            StdOut.println("7) Cerrar sesión");
            StdOut.print("Ingrese numero de la opción: ");
            String opcion = StdIn.readLine().strip().toUpperCase();
            while (!opcion.equals("1") && !opcion.equals("2") && !opcion.equals("3") && !opcion.equals("4") && !opcion.equals("5") && !opcion.equals("6") && !opcion.equals("7")) {
                StdOut.print("Opcion invalida, ingrese otra");
                opcion = StdIn.readLine().toUpperCase();
            }
            switch (opcion.toUpperCase())
            {
                case "1" -> menuArrendarProducto(sistemaImpl, nickname);
                case "2" -> menuDevolverProducto(sistemaImpl,nickname);
                case "3" -> menuGestionarCuenta(sistemaImpl,nickname, contrasena);
                case "4" -> verCatalogo(sistemaImpl);
                case "5" -> menuIngresarNuevoProducto(sistemaImpl);
                case "6" -> menuEstadisticas(sistemaImpl);
                case "7" -> continuar = false;
            }
        }
    }
    private static void menuArrendarProducto(SistemaImpl sistemaImpl, String nickname)
    {
        StdOut.println("1) Libros");
        StdOut.println("2) Peliculas");
        StdOut.print("Ingrese el numero del tipo de producto que desea arrendar: ");
        String tipoProducto = StdIn.readLine().strip().toUpperCase();
        while (!tipoProducto.equals("1") && !tipoProducto.equals("2")) {
            StdOut.print("Opcion invalida, ingrese otra");
            tipoProducto = StdIn.readLine().strip().toUpperCase();
        }
        boolean arrendando = true;
        if (tipoProducto.equals("1")) {
            while (arrendando) {
                sistemaImpl.verLibros();
                StdOut.print("Ingrese la id del libro que desea arrendar: ");
                int idLibro = StdIn.readInt();
                Calendar diaActual = Calendar.getInstance();
                boolean arrendarLibro = sistemaImpl.arrendarLibro(nickname, idLibro, diaActual);

                if (!arrendarLibro) {
                    StdOut.println("No hay stock de ese producto");
                    StdOut.print("¿Desea arrendar otro? responda si o no");
                    String arrendarOtro = StdIn.readLine().toUpperCase();
                    while (!arrendarOtro.equals("SI") && !arrendarOtro.equals("NO")) {
                        StdOut.print("Opción invalida, ingrese otra");
                        arrendarOtro = StdIn.readLine().strip().toUpperCase();
                    }
                    if (arrendarOtro.equals("NO")) {
                        arrendando = false;
                    }


                }
                if (arrendarLibro) {
                    StdOut.println("Libro arrendado");
                    arrendando = false;
                }
            }


        }
        if (tipoProducto.equals("2")) {
            while (arrendando) {
                sistemaImpl.verLibros();
                StdOut.print("Ingrese la id del la pelicula que desea arrendar: ");
                int idPelicula = StdIn.readInt();
                Calendar diaActual = Calendar.getInstance();
                boolean arrendarPelicula = sistemaImpl.arrendarPelicula(nickname, idPelicula, diaActual);

                if (!arrendarPelicula) {
                    StdOut.println("No hay stock de ese producto");
                    StdOut.print("¿Desea arrendar otro? responda si o no");
                    String arrendarOtro = StdIn.readLine().toUpperCase();
                    while (!arrendarOtro.equals("SI") && !arrendarOtro.equals("NO")) {
                        StdOut.print("Opcion invalida, ingrese otra");
                        arrendarOtro = StdIn.readLine().strip().toUpperCase();
                    }
                    if (arrendarOtro.equals("NO")) {
                        arrendando = false;
                    }
                }
                if (arrendarPelicula) {
                    StdOut.println("Pelicula arrendada");
                    arrendando = false;
                }
            }
        }
    }
    private static void menuDevolverProducto(SistemaImpl sistemImpl, String nickname)
    {
        boolean continuar = true;
        boolean devolverProducto = true;
        while(continuar)
        {
            StdOut.println("1) Libros");
            StdOut.println("2) Peliculas");
            StdOut.print("Ingrese el numero del tipo de producto que desea Devolver: ");
            String tipoProducto = StdIn.readLine().strip().toUpperCase();
            while (!tipoProducto.equals("1") && !tipoProducto.equals("2"))
            {
                StdOut.print("Opcion invalida, ingrese otra");
                tipoProducto = StdIn.readLine().strip().toUpperCase();
            }
            StdOut.println("¿Cual es la id del producto que desea devolver?");
            int idProducto = StdIn.readInt();
            StdOut.print("¿Cual es la fecha de entrega?, ingresela en el formato DD/MM/AA");
            Calendar fechaEntrega = Calendar.getInstance();
            if(tipoProducto.equals("1"))
            {
                devolverProducto = sistemImpl.devolverLibro(idProducto,fechaEntrega);
            }
            if(tipoProducto.equals("2"))
            {
                devolverProducto = sistemImpl.devolverPelicula(idProducto,fechaEntrega);
            }
            if(!devolverProducto)
            {
                StdOut.print("No se pudo devolver el producto, ¿Desea intentar denuevo?, responda si o no");
                String devolverOtro = StdIn.readLine().toUpperCase();
                while (!devolverOtro.equals("SI") && !devolverOtro.equals("NO")) {
                    StdOut.print("Opcion invalida, ingrese otra");
                    devolverOtro = StdIn.readLine().strip().toUpperCase();
                }
                if(devolverOtro.equals("NO"))
                {
                    continuar =false;
                }
            }
        }


    }
    private static void menuGestionarCuenta(SistemaImpl sistemaImpl, String nickname, String contrasena)
    {
        Usuario usuario = sistemaImpl.obtenerUsuario(nickname,contrasena);
        boolean continuar = true;
        while (continuar) {
            StdOut.println("1) Consultar datos");
            StdOut.println("2) Subir membresia");
            StdOut.println("3)Cambiar contraseña");
            StdOut.println("4) Regresar al menú anterior");
            StdOut.print("Ingrese el número de la opcion: ");
            String opcion = StdIn.readLine().strip().toUpperCase();
            while (!opcion.equals("1") && !opcion.equals("2") && !opcion.equals("3") && !opcion.equals("4")) {
                StdOut.print("Opcion invalida, ingrese otra");
                opcion = StdIn.readLine().toUpperCase();
                switch (opcion.toUpperCase()) {
                    case "1" -> usuario.toString();
                    case "2" -> menuSubirMembresia(sistemaImpl,nickname,contrasena);
                    case "3" -> menuCambiarContrasena(sistemaImpl, nickname, contrasena);
                    case "4" -> continuar = false;
                }
            }
        }
    }
    private static void menuSubirMembresia(SistemaImpl sistemaImpl,String nickname,String contrasena)
    {
        boolean subirMembresia = sistemaImpl.subirMembresia(nickname);
        Usuario usuario = sistemaImpl.obtenerUsuario(nickname,contrasena);
        String tipoMembresia = usuario.getMembresia();
        if (subirMembresia)
        {
            StdOut.println("Membresia actualizada a:"+tipoMembresia);
        }
        else if (!subirMembresia)
        {
            StdOut.println("No se cumplen los requisitos para actualizar la membresia");
        }
    }
    private static void menuCambiarContrasena(SistemaImpl sistemaImpl,String nickname, String contrasena)
    {
        boolean cambiarContrasena = false;
        while(!cambiarContrasena)
        {
            StdOut.print("Ingrese su nueva contraseña, debe tener almenos una letra mayuscula");
            String contrasenanew = StdIn.readLine();
            cambiarContrasena =sistemaImpl.cambiarContrasena(nickname,contrasena,contrasenanew);
        }


    }
    private static void verCatalogo(SistemaImpl sistemaImpl)
    {
        StdOut.println("1) Libros");
        StdOut.println("2) Peliculas");
        StdOut.print("Ingrese el numero del tipo de catalogo que desea ver: ");
        String tipoProducto = StdIn.readLine().strip().toUpperCase();
        while (!tipoProducto.equals("1") && !tipoProducto.equals("2"))
        {
            StdOut.print("Opcion invalida, ingrese otra");
            tipoProducto = StdIn.readLine().strip().toUpperCase();
        }
        switch (tipoProducto)
        {
            case "1" -> sistemaImpl.verLibros();
            case "2" -> sistemaImpl.verPeliculas();
        }
    }
    private static void menuIngresarNuevoProducto(SistemaImpl sistemaImpl)
    {
        int cantPaginas;
        int publicacionOEstreno;
        int cantMinutos;
        int cantHoras;
        String genero2 = "";
        StdOut.println("1) Libros");
        StdOut.println("2) Peliculas");
        StdOut.print("Ingrese el numero del tipo de producto que desea arrendar: ");
        String tipoProducto = StdIn.readLine().strip().toUpperCase();
        while (!tipoProducto.equals("1") && !tipoProducto.equals("2"))
        {
            StdOut.print("Opcion invalida, ingrese otra");
            tipoProducto = StdIn.readLine().strip().toUpperCase();
        }
        StdOut.print("Ingrese el nombre del producto");
        String nombre = StdIn.readLine();
        StdOut.print("Ingrese el nombre del autor o director");
        String autorODirector = StdIn.readLine();

        while (true)
        {
            try
            {
                StdOut.print("Ingrese el año de publicacion o año de estreno del producto, los numeros negativos seran los años antes de cristo");
                publicacionOEstreno = StdIn.readInt();
                break;

            }
            catch (NumberFormatException e)
            {
                StdOut.println("Ingrese un numero");

            }

        }

        StdOut.print("Ingrese un genero de producto");
        String genero1 = StdIn.readLine();
        StdOut.print("¿Desea agreagar otro genero? responda si o no");
        String agregarOtro = StdIn.readLine().toUpperCase();
        while (!agregarOtro.equals("SI") && !agregarOtro.equals("NO"))
        {
            StdOut.print("Opción invalida, ingrese otra");
            agregarOtro = StdIn.readLine().strip().toUpperCase();
        }
        if (agregarOtro.equals("SI"))
        {
            StdOut.print("Ingrese un genero de producto");
            genero2 = StdIn.readLine();
        }
        if(tipoProducto.equals("1")) {
            while (true) {
                try {
                    StdOut.print("Ingrese la cantidad de paginas del libro");
                    cantPaginas = StdIn.readInt();
                    break;
                } catch (NumberFormatException e) {
                    StdOut.println("Ingrese un numero");
                }
            }
            sistemaImpl.agregarLibro(nombre, autorODirector, genero1, genero2, cantPaginas, publicacionOEstreno);
        }
        if(tipoProducto.equals("2"))
        {
            while (true) {
                try {
                    StdOut.print("Ingrese la cantidad de horas de la pelicula");
                    cantHoras = StdIn.readInt();
                    StdOut.print("Ingrese la cantidad de mintos de la pelicula");
                    cantMinutos = StdIn.readInt();
                    break;
                } catch (NumberFormatException e) {
                    StdOut.println("Ingrese un numero");
                }
            }
           sistemaImpl.agregarPelicula(nombre, autorODirector, genero1, genero2,cantHoras,cantMinutos,publicacionOEstreno);
        }
    }
    private static void menuEstadisticas(SistemaImpl sistemaImpl)
    {
        String[] estadistica = sistemaImpl.estadisticas();
        for(int i = 0; i<= estadistica.length;i=i+4)
        {
            StdOut.println("Nombre completo:"+estadistica[i]+estadistica[i+1]+estadistica[i+2]);
            StdOut.println("Nickname"+estadistica[i+3]);
        }
    }
    private static void menuRegistrarUsuario(SistemaImpl sistemaImpl)
    {
        boolean continuar = true;
        while(continuar)
        StdOut.print("Ingrese nombre: ");
        String nombre = StdIn.readLine();
        StdOut.print("Ingrese apellido paterno: ");
        String apellidoPat = StdIn.readLine();
        StdOut.print("Ingrese apellido materno: ");
        String apellidoMat = StdIn.readLine();
        StdOut.print("Ingrese rut: ");
        String rut = StdIn.readLine();
        StdOut.print("Ingrese nickname: ");
        String nickname = StdIn.readLine();
        StdOut.print("Ingrese contraseña: ");
        String contrasena = StdIn.readLine();
        boolean registrarUsuario = sistemaImpl.registrarUsuario(nombre, apellidoPat, apellidoMat, rut,nickname,contrasena);
        if (registrarUsuario)
        {
            continuar = false;
        }
        if (!registrarUsuario)
        {
            StdOut.print("Nickname ocupado, ¿Desea ingresar los datos denuevo? responda si o no");
            String ingresarDenuevo = StdIn.readLine().toUpperCase();
            while (!ingresarDenuevo.equals("SI") && !ingresarDenuevo.equals("NO"))
            {
                StdOut.print("Opción invalida, ingrese otra");
                ingresarDenuevo = StdIn.readLine().strip().toUpperCase();
            }
            if (ingresarDenuevo.equals("NO"))
            {
                continuar = false;
            }

        }
    }

}