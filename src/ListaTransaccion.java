public class ListaTransaccion {
    private Transaccion[] listaTransaccion;
    private int cantTransacciones;
    private int max;

    public ListaTransaccion(int max) {
        listaTransaccion = new Transaccion[max];
        this.cantTransacciones = 0;
        this.max = max;
    }

    public boolean agregar(Transaccion transaccion)
    {
        if (this.cantTransacciones == this.max)
        {
            return false;
        }

        for(int i = 0; i < this.cantTransacciones; i++)
        {
            Transaccion transaccionNew = this.listaTransaccion[i];

            if (transaccionNew.getId() == transaccion.getId())
            {
                return false;
            }
        }

        this.listaTransaccion[this.cantTransacciones] = transaccion;
        this.cantTransacciones++;

        return true;
    }

    public int getCantTransacciones() {
        return cantTransacciones;
    }

    public void setCantTransacciones(int cantTransacciones) {
        this.cantTransacciones = cantTransacciones;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
