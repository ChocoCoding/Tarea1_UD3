package com.example.tarea1_ud3.modelos;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImagenPersonalizada extends ImageView{
    private int duracion;
    private char tipo;
    private Image img;



    public ImagenPersonalizada(Image img, char tipo) {
        this.img = img;
        this.tipo = tipo;
        if (tipo == 'i'){
            this.duracion = 1;
        } else if (tipo == 'r') {
            this.duracion = 3;
        } else if (tipo == 't') {
            this.duracion = 5;
        }
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
}
