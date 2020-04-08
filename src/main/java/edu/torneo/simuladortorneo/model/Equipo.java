package edu.torneo.simuladortorneo.model;

public class Equipo {
    // Nombre del equipo
    private String nombre;
    // Codigo del equipo
    private int CodigoEquipo;
    // Puntos que tiene el equipo
    private int puntos;
    // Partidos jugados por el equipo
    private int partidosJugados;
    // Partidos ganados por el equipo
    private int partidosGanados;
    // Partidos empatados por el equipo
    private int partidosEmpatados;
    // Partidos perdidos por el equipo
    private int partidosPerdidos;
    // Goles a favor del equipo
    private int golesAFavor;
    // Goles en contra del equipo
    private int golesEnContra;


    /** Contructor del equipo
     */
    public Equipo(String Nombre, int CodigoEquipo){
        this.nombre= nombre;
        this.CodigoEquipo = CodigoEquipo;

    }

    /**
     * Constructor para objetos de Equipo. Este objeto recoje las estadisticas de la clasificacion de el Torneo para un equipo.
     * Este constructor inicializa todas las variables a 0.
     */
    public Equipo()
    {
        // initialise instance variables
        this.puntos = puntos;
        this.partidosJugados = 0;
        this.partidosGanados = 0;
        this.partidosEmpatados = 0;
        this.partidosPerdidos = 0;
        this.golesAFavor = 0;
        this.golesEnContra = 0;
    }

    /**
     * Constructor para objetos Equipo. Este objeto recoje las estadisticas de la clasificacion de la Torneo para un equipo.
     * @param puntos Los puntos del equipo
     * @param partidosJugados Partidos jugados por el equipo
     * @param pg Partidos ganados por el equipo
     * @param pe Partidos empatados por el equipo
     * @param pp Partidos perdidos por el equipo
     * @param gf Goles a favor del equipo
     * @param gc Goles en contra del equipo
     */
    public Equipo(int puntos, int partidosJugados, int pg, int pe, int pp, int gf, int gc)
    {
        // initialise instance variables
        this.puntos = puntos;
        this.partidosJugados = partidosJugados;
        this.partidosGanados = pg;
        this.partidosEmpatados = pe;
        this.partidosPerdidos = pp;
        this.golesAFavor = gf;
        this.golesEnContra = gc;
    }

    /**
     * Devuelve los puntos del equipo
     * @return los puntos del equipo
     */
    public int getPuntos()
    {
        return puntos;
    }

    /**
     * Devuelve los partidos jugados del equipo
     * @return los partidos jugados del equipo
     */
    public int getPartidosJugados()
    {
        return partidosJugados;
    }

    /**
     * Devuelve los partidos ganados del equipo
     * @return los partidos ganados del equipo
     */
    public int getPartidosGanados()
    {
        return partidosGanados;
    }

    /**
     * Devuelve los partidos empatados del equipo
     * @return los partidos empatados del equipo
     */
    public int getPartidosEmpatados()
    {
        return partidosEmpatados;
    }

    /**
     * Devuelve los partidos perdidos del equipo
     * @return los partidos perdidos del equipo
     */
    public int getPartidosPerdidos()
    {
        return partidosPerdidos;
    }

    /**
     * Devuelve los goles a favor del equipo
     * @return los goles a favor del equipo
     */
    public int getGolesAFavor()
    {
        return golesAFavor;
    }

    /**
     * Devuelve los goles en contra del equipo
     * @return los goles en contra del equipo
     */
    public int getGolesEnContra()
    {
        return golesEnContra;
    }

    /**
     * Devuelve la diferencia de goles a favor y en contra del equipo
     * @return la diferencia de goles a favor y en contra del equipo
     */
    public int getDiferenciaDeGoles()
    {
        return (golesAFavor - golesEnContra);
    }

    /**
     * Devuelve la informacion de la clasificacion del equipo
     * @return un String con la informacion de la clasificacion del equipo
     */
    /**
     * Devuelve el nombre del equipo
     */
    public String getNombre()
    {
        return nombre;
    }
    /**
     * Devuelve el Codigo del equipo
     */
    public int getCodigoEquipo()
    {
        return CodigoEquipo;
    }


    public String toString()
    {
        return (puntos + "\t" + partidosJugados + "\t" + +partidosGanados + "\t" + partidosEmpatados + "\t" + partidosPerdidos + "\t" + golesAFavor + "\t" + golesEnContra + "\t" + getDiferenciaDeGoles());
    }
    /**
     * Suma las estadisticas pasadas como parametro a este objeto clasificacion.
     * @param sumaEstadisticas Estadisticas a sumar a este objeto.
     */
    public void sumaEstadisticas(Equipo sumaEstadisticas)
    {
        puntos += sumaEstadisticas.getPuntos();
        partidosJugados += sumaEstadisticas.getPartidosJugados();
        partidosGanados += sumaEstadisticas.getPartidosGanados();
        partidosEmpatados += sumaEstadisticas.getPartidosEmpatados();
        partidosPerdidos += sumaEstadisticas.getPartidosPerdidos();
        golesAFavor += sumaEstadisticas.getGolesAFavor();
        golesEnContra += sumaEstadisticas.getGolesEnContra();
    }
}
