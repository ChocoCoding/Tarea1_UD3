package com.example.tarea1_ud3.utilities;


import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;
import java.time.Duration;



public class Temporizador{
    private Boolean activo;
    private Timer timer;
    private LocalTime time,inicio;
    private TimerTask task;
    private int tiempo; //Propiedad que le va a indicar el tiempo a cronometrar

    public Temporizador() {

            this.activo=true;
            this.inicio = LocalTime.now();
            //Le damos una duración al temporizador
            this.tiempo=3;

    }
    public Temporizador(int duracion) {

        this.activo=true;
        this.inicio = LocalTime.now();
        this.tiempo=duracion;

    }


        public int getTiempo() {
            return tiempo;
        }


        public void setTiempo(int tiempo) {
            this.tiempo = tiempo;
        }


        public void setActivo(Boolean activo) {
            this.activo = activo;
        }


        public void setTimer(Timer timer) {
            this.timer = timer;
        }


        public void setTime(LocalTime time) {
            this.time = time;
        }


        public void setInicio(LocalTime inicio) {
            this.inicio = inicio;
        }


        public Boolean getActivo() {
            return activo;
        }


        public Timer getTimer() {
            return timer;
        }


        public LocalTime getTime() {
            return time;
        }


        public LocalTime getInicio() {
            return inicio;
        }


    //Activo propiedad que comprueba si el temporizador está¡ funcionado o no.
        public final void contar(){

            //Inicializar el tiempo que quiero que cronometre para probar la ejecución

            activo=true;

            timer = new Timer();
            task = new TimerTask()
            {

                @Override
                public void run()
                {
                    time = LocalTime.now();
                    Duration d1 = Duration.between(inicio, time);
                    System.out.println(d1.toSeconds());

                    if (tiempo==(int)d1.toSeconds()){
                        activo = false;
                        pararCronometro();
                    }
                }
            };
            timer.schedule(task,0, 1000);
        }




        public void pararCronometro(){
            task.cancel();
        }

}
