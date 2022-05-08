public class ListaUsuarios {
    private Usuario[] listaUsuario;
    private int cantidadUsuarios;
    private int max;

    public ListaUsuarios(int max) {
        listaUsuario = new Usuario[max];
        this.cantidadUsuarios = 0;
        this.max = max;
    }
    public boolean agregar(Usuario usuario)
    {
        if (this.cantidadUsuarios == this.max)
        {
            return false;
        }

        for (int i = 0; i < this.cantidadUsuarios; i++)
        {
            Usuario usuarioNew = this.listaUsuario[i];
            if (usuarioNew.getRut().equalsIgnoreCase(usuario.getRut()))
            {
                return false;
            }
        }
        this.listaUsuario[this.cantidadUsuarios] = usuario;
        this.cantidadUsuarios++;

        return true;
    }
    public Usuario obtener(String rut)
    {
        for (int i = 0; i<this.cantidadUsuarios;i++)
        {
            Usuario usuario = this.listaUsuario[i];

            if(usuario.getRut().equalsIgnoreCase(rut))
            {
                return usuario;
            }

        }

        return null;
    }

    public Usuario obtenerNickname(String nickname)
    {
        for (int i = 0; i<this.cantidadUsuarios;i++)
        {
            Usuario usuario = this.listaUsuario[i];

            if(usuario.getNickname().equalsIgnoreCase(nickname))
            {
                return usuario;
            }

        }

        return null;
    }

    public Usuario obtener(String nickname, String contrasena)
    {
        for (int i = 0; i<this.cantidadUsuarios;i++)
        {
            Usuario usuario = this.listaUsuario[i];

            if(usuario.getNickname().equals(nickname) && usuario.getContrasena().equals(contrasena))
            {
                return usuario;
            }

        }

        return null;
    }
    public boolean verificarNickname(String nickname)
    {
        for (int i = 0; i < this.cantidadUsuarios; i++)
        {
            Usuario usuario = this.listaUsuario[i];

            if (usuario.getNickname().equals(nickname))
            {
                return true;
            }
        }
        return false;
    }

    public boolean verificarContrasena(String contrasena)
        {
        for (int i = 0; i < this.cantidadUsuarios; i++)
        {
            Usuario usuario = this.listaUsuario[i];

            if (usuario.getContrasena().equals(contrasena));
            {
                return true;
            }
        }
        return false;
    }

    public Usuario[] getListaUsuario()
    {
        return this.listaUsuario;
    }

    public void setListaUsuario(Usuario[] listaUsuario)
    {
        this.listaUsuario = listaUsuario;
    }

    public int getCantidadUsuarios()
    {
        return this.cantidadUsuarios;
    }

    public void setCantidadUsuarios(int cantidadUsuarios)
    {
        this.cantidadUsuarios = cantidadUsuarios;
    }

    public int getMax()
    {
        return this.max;
    }

    public void setMax(int max)
    {
        this.max = max;
    }

}
