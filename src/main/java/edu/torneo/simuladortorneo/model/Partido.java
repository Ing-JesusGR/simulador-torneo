package edu.torneo.simuladortorneo.model;
import java.util.Random;

public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    // Guarda los goles marcados por el equipo local
    private int golesLocal;
    // Guarda los goles marcados por el equipo suplente
    private int golesVisitante;
    // Variable resultado
    private String resultado;

    /**
     * Constructor for objects of class Partido
     */
    public Partido(Equipo equipo1, Equipo equipo2)
    {
        this.equipoLocal = equipo1;
        this.equipoVisitante = equipo2;
        // Los goles se setean en -1 por ser valores no validos hasta que se generen
        golesLocal = -1;
        golesVisitante = -1;
    }
    /**
     * Muestra el emparejamiento del partido
     */
    public void showInfo()
    {
        System.out.println(equipoLocal.getNombre() + " - " + equipoVisitante.getNombre());
    }
    /**
     * Devuelve el equipo local
     */
    public Equipo getLocal()
    {
        return equipoLocal;
    }

    /**
     * Devuelve el equipo visitante
     */
    public Equipo getVisitante()
    {
        return equipoVisitante;
    }
    public int getGolesLocal()
    {
        return golesLocal;
    }

    /**
     * Devuelve los goles del equipo visitante. Si aun no se ha simulado el partido devolvera -1
     */
    public int getGolesVisitante()
    {
        return golesVisitante;
    }
    public int simular()
    {
        // Comprueba si el partido ya ha sido simulado
        if(golesLocal == -1 && golesVisitante == -1)
        {
            golesLocal = (int)(Math.random()*8+1);
            golesVisitante = (int)(Math.random()*8+1);
        }
        // Devuelve el resultado como 0 empate, 1 victoria local, 2 victoria visitante
        int codResultado = 0;

        if (golesLocal > golesVisitante)
        {
            codResultado = 1;

        }
        else if (golesVisitante > golesLocal)
        {
            codResultado = 2;
        }
        return codResultado;


    }
}
