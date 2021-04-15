package sample;

public class Alumno {

    public static int size = 0;

    int tiempoCola;
    int id;
    String nombre;
    int tiempoEntrada;
    int tiempoEspera;
    int tiempoTotal;
    boolean atendido;
    String atendidoPor;

    public Alumno(String nombre, int tiempoEntrada, int tiempoCola, String atendidoPor) {
        this.id = size;
        this.nombre = nombre;
        this.tiempoEntrada = tiempoEntrada;
        this.tiempoEspera = tiempoCola;
        this.tiempoCola = tiempoCola;
        this.atendidoPor = atendidoPor;
        size++;
    }

    public Alumno(int tiempoCola, int id, String nombre, int tiempoEntrada, int tiempoEspera, int tiempoTotal, String atendidoPor) {
        this.tiempoCola = tiempoCola;
        this.id = size;
        this.nombre = nombre;
        this.tiempoEntrada = tiempoEntrada;
        this.tiempoEspera = tiempoEspera;
        this.tiempoTotal = tiempoTotal;
        this.atendidoPor = atendidoPor;
        size++;
    }

    public int getTiempoCola() {
        return tiempoCola;
    }

    public void setTiempoCola(int tiempoCola) {
        this.tiempoCola = tiempoCola;
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

    public int getTiempoEntrada() {
        return tiempoEntrada;
    }

    public void setTiempoEntrada(int tiempoEntrada) {
        this.tiempoEntrada = tiempoEntrada;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    public void setTiempoTotal(int tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }

    public String getAtendidoPor() {
        return atendidoPor;
    }

    public void setAtendidoPor(String atendidoPor) {
        this.atendidoPor = atendidoPor;
    }

    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        Alumno.size = size;
    }

    public boolean isAtendido() {
        return atendido;
    }

    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + nombre + '\'' +
                ", entrada=" + tiempoEntrada +
                ", espera=" + tiempoEspera +
                ", total=" + tiempoTotal +
                ", atendido=" + atendido +
                ", psico='" + atendidoPor;
    }
}

