package com.example.tarea1_ud3.controladores;

import com.example.tarea1_ud3.modelos.ImagenPersonalizada;
import com.example.tarea1_ud3.utilities.Temporizador;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class ControladorVentanaPrincipal implements Initializable {

    Image image;

    private Temporizador temporizador;

    private String ruta;

    private char tipo;

    @FXML
    VBox vBox;

    @FXML
    HBox hBox1;

    @FXML
    private ImagenPersonalizada img1;
    @FXML
    private ImagenPersonalizada img2;
    @FXML
    private ImagenPersonalizada img3;

    private ImagenPersonalizada[] arrayImagenes = { img1, img2, img3};

    @FXML
    private Button salir;

    @FXML
    private Button btnReiniciar;

    @FXML
    private Button btnInfantil;

    @FXML
    private Button btnRomantica;

    @FXML
    private Button btnTerror;

    private Timeline timeline;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //image  = new Image("C:\\Users\\Gonzalo\\IdeaProjects\\Tarea1_UD3\\src\\img\\i\\0.jpg");
        //imagen1 = new ImageView();
        //imagen1.setImage(image);
        //imagen1.setFitHeight(500);
        //imagen1.setFitWidth(300);
        //hBox1.getChildren().add(imagen1);


    }

    @FXML
    protected void onSalir(ActionEvent evt) {
        salir = (Button) evt.getSource();
        Stage stage = (Stage) salir.getScene().getWindow();    //Me devuelve la ventana
        stage.close(); //Me cierra la ventana
    }

    @FXML
    protected void onInfantil(ActionEvent evt) throws InterruptedException {
        Button infantil = (Button) evt.getSource();
        infantil.getScene().getRoot().setStyle("-fx-background-image: url('file:///C:/Users/Gonzalo/IdeaProjects/Tarea1_UD3/src/img/css/i_f.jpg'); -fx-background-size: cover;");
        ruta = "C:\\Users\\Gonzalo\\IdeaProjects\\Tarea1_UD3\\src\\img\\i\\";
        tipo = 'i';
        secuenciarImagenes();
    }


    @FXML
    protected void onRomantica(ActionEvent evt) {
        //hBox1.getChildren().clear();
        Button r = (Button) evt.getSource();
        r.getScene().getRoot().setStyle("-fx-background-image: url('file:///C:/Users/Gonzalo/IdeaProjects/Tarea1_UD3/src/img/css/r_f.jpg'); -fx-background-size: cover;");
        ruta = "C:\\Users\\Gonzalo\\IdeaProjects\\Tarea1_UD3\\src\\img\\r\\";
        tipo = 'r';
        secuenciarImagenes();
    }

    @FXML
    protected void onTerror(ActionEvent evt) {
        //hBox1.getChildren().clear();
        Button t = (Button) evt.getSource();
        t.getScene().getRoot().setStyle("-fx-background-image: url('file:///C:/Users/Gonzalo/IdeaProjects/Tarea1_UD3/src/img/css/t_f.jpg'); -fx-background-size: cover;");
        ruta = "C:\\Users\\Gonzalo\\IdeaProjects\\Tarea1_UD3\\src\\img\\t\\";
        tipo = 't';
        secuenciarImagenes();
    }

    private void mostrarImagenes(AtomicInteger contador, ImagenPersonalizada img) {
        hBox1.getChildren().set(Integer.parseInt(String.valueOf(contador)),img);
        //hBox1.getChildren().add(Integer.parseInt(String.valueOf(contador)),img);
    }


    public void secuenciarImagenes(){
        Image image;
        AtomicInteger contador = new AtomicInteger();
        for(int x = 0; x < arrayImagenes.length; x++){
            image = new Image(ruta+x+".jpg");
            arrayImagenes[x] = new ImagenPersonalizada(image,tipo);
            arrayImagenes[x].setImage(image);
            arrayImagenes[x].setFitHeight(400);
            arrayImagenes[x].setFitWidth(300);
        }

        timeline = new Timeline(new KeyFrame(Duration.seconds(arrayImagenes[Integer.parseInt(String.valueOf(contador))].getDuracion()),v ->{
            mostrarImagenes(contador,arrayImagenes[Integer.parseInt(String.valueOf(contador))]);
            contador.getAndIncrement();
        }));
        timeline.setCycleCount(3);
        timeline.play();
    }

    @FXML
    protected void onReiniciar(ActionEvent evt) {
        for (int i = 0; i < arrayImagenes.length; i++) {
            hBox1.getChildren().get(i).setVisible(false);
        }

    }
}