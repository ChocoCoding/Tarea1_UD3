package com.example.tarea1_ud3.modelos;

import com.example.tarea1_ud3.utilities.Temporizador;

public class HiloComprobarTemporizador extends Thread {

    Temporizador temporizador;

    public HiloComprobarTemporizador(Temporizador temporizador){
        this.temporizador = temporizador;
    }


    public void run ()
    {
        while (true){

            if (!temporizador.getActivo()){
                System.out.println("patata");
                this.stop();
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
