package edu.torneo.simuladortorneo.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Fecha {
    // DAR UNA REVISION SANTIAGO CAMILO
    // Una jornada se compone de una serie de partidos que enfrentan a los equipos entre si
    private ArrayList<Partido> partidos;

    public Fecha(ArrayList<Equipo> equipos)
    {
        // initialise instance variables
        partidos = new ArrayList();
        // Empareja los equipos dos a dos sin repetir de forma aleatoria,
        // mezclando primero los equipos
        Collections.shuffle(equipos);
        int indice = 0;
        // Toma los equipos dos a dos para el emparejamiento
        while(indice < equipos.size())
        {
            partidos.add(new Partido(equipos.get(indice), equipos.get(indice+1)));
            indice += 2;
        }
    }

    /**
     * Simula los partidos de la jornada y devuelve los resultados.
     * @return Los resultados de los partidos
     */
    public HashMap<Equipo,Equipo> simularJornada()
    {
        HashMap<Equipo,Equipo> resultados = new HashMap();
        for(int i = 0; i < partidos.size(); i++)
        {
            // Simula el partido, lo que devuelve un resultado
            Partido partido = partidos.get(i);
            int rdo = partido.simular();
            switch(rdo)
            {
                case 0:
                    // Crea un objeto tipo clasificacion equipo, parametros: puntos, partidos jugados, partidos ganados, partidos empatados, partidos perdidos
                    // goles a favor, goles en contra con la informacion de ESTA jornada.
                    resultados.put(partido.getLocal(), (new Equipo(1, 1, 0, 1, 0, partido.getGolesLocal(), partido.getGolesVisitante())));
                    resultados.put(partido.getVisitante(), (new Equipo(1, 1, 0, 1, 0, partido.getGolesVisitante(), partido.getGolesLocal())));
                    break;
                case 1:
                    resultados.put(partido.getLocal(), (new Equipo(3, 1, 1, 0, 0, partido.getGolesLocal(), partido.getGolesVisitante())));
                    resultados.put(partido.getVisitante(), (new Equipo(0, 1, 0, 0, 1, partido.getGolesVisitante(), partido.getGolesLocal())));
                    break;
                case 2:
                    resultados.put(partido.getLocal(), (new Equipo(0, 1, 0, 0, 1, partido.getGolesLocal(), partido.getGolesVisitante())));
                    resultados.put(partido.getVisitante(), (new Equipo(3, 1, 1, 0, 0, partido.getGolesVisitante(), partido.getGolesLocal())));
            }

        }
        return resultados;
    }
    /**
     * Muestra los emparejamientos de esta jornada
     */
    public void showInfo()
    {
        for(int i = 0; i < partidos.size(); i++)
        {
            partidos.get(i).showInfo();
        }
    }
}
