package edu.torneo.simuladortorneo.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
public class Torneo {
    public class Liga {
        // POR FAVOR REVISAR
        // Equipos que juegan la liga
        private ArrayList<Equipo> equipos;
        // Jornadas que componen la liga
        private ArrayList<Fecha> Fechas;
        // El nombre de los equipos sera "equipo" + un numero
        public static final String NOMBRE = "Equipo";
        // Recoje las puntuaciones de cada equipo para hacer la clasificacion
        private HashMap<Equipo, Equipo> clasificacion;
        // Marca la jornada actual en la que se encuentra la liga
        private int jornadaActual;

        /**
         * Crea la liga con el numero de equipos indicados.
         */
        public Liga(int numEquipos) {
            // Inicializa los atributos
            equipos = new ArrayList();
            Fechas = new ArrayList();
            jornadaActual = 0;
            clasificacion = new HashMap();
            // Si el numero de equipos es impar, suma uno
            if (numEquipos % 2 != 0) {
                numEquipos++;
            }
            // Crea tantos equipos como se hayan introducido
            for (int i = 0; i < numEquipos; i++) {
                Equipo equipo = new Equipo(NOMBRE + " " + (i + 1), 22);
                equipos.add(equipo);
                // Los añade a la vez al diccionario de clasificaciones
                clasificacion.put(equipo, new Equipo());
            }
            // Genera las jornadas de la liga
            generaFechas();
        }

        /**
         * Muestra los emparejamientos de cada jornada.
         */
        public void muestraFechas() {
            for (int i = 0; i < Fechas.size(); i++) {
                System.out.println("Jornada " + (i + 1));
                Fechas.get(i).showInfo();
            }
        }

        /**
         * Simula las jornadas de la liga indicadas y actualiza la clasificacion.
         * Si se introduce un numero mayor al numero de jornadas, se simularan solo las jornadas que existan
         */
        public void simularJornadas(int numero) {
            // Si el numero introducido es mayor que el numero de jornadas que queden, se setea al numero de jornadas
            if ((numero + jornadaActual) > (Fechas.size())) {
                numero = (Fechas.size() - jornadaActual);
            }
            for (int i = 0; i < numero; i++) {
                // Simula la jornada y actualiza la clasificacion
                System.out.println("JORNADA " + (jornadaActual + 1));
                actualizaClasificacion(Fechas.get(i).simularJornada());
                jornadaActual++;


            }
        }

        private void generaFechas()
        {
            int indice = 0;
            int index = 0;
            boolean aniadir = true;
            Fecha jornada = null;
            while(indice < (equipos.size() - 1))
            {
                // Genera una jornada
                jornada = new Fecha(equipos);

            }
        }
        /**
         * Actualiza la clasificacion con los puntos recibidos como parametro
         */
        private void actualizaClasificacion(HashMap<Equipo,Equipo> puntos)
        {
            // Genera un set con las keys para iterar por el hashmap
            Set<Equipo> setEquipos = puntos.keySet();
            for(Equipo equipo: setEquipos)
            {
                // A cada clasificacion del equipo le pasa el resultado en formato ClasificacionEquipo para que la actualize
                Equipo temporal = clasificacion.get(equipo);
                temporal.sumaEstadisticas(puntos.get(equipo));
            }
        }
    }

}
