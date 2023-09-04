
/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor....: RONILSON ROCHA SANTOS
Matricula: 202110848
Inicio...: 25/08/23
Alteracao: 01/09/23
Nome.....: Controle.java
Funcao...: Controla a parte visual da aplicação
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.util.Duration;

public class Controle implements Initializable {
    // Atributos
    @FXML
    private Button reiniciar;

    @FXML
    private Button start1; // iniciar os dois trens descendo

    @FXML
    private Button start2; // iniciar os dois trens subindo

    @FXML
    private Button start3; // iniciar o trem 1 descendo e o trem 2 subindo

    @FXML
    private Button start4; // iniciar o trem 1 subindo e o trem 2 descendo

    @FXML
    private ImageView trainCima1; // Imagem do trem 1 indo para baixo

    @FXML
    private ImageView trainBaixo1;// Imagem do trem 1 indo para cima

    @FXML
    private ImageView trainBaixo2;// Imagem do trem 2 indo para cima

    @FXML
    private ImageView trainCima2;// Imagem do trem 2 indo para baixo

    @FXML
    private Slider velocidadeTrain1; // Slider para controlar a velocidade do trem 1

    @FXML
    private Slider velocidadeTrain2; // Slider para controlar a velocidade do trem 2

    // Atributos para as animações
    private PathTransition transition1;
    private PathTransition transition2;

    @FXML
    public void reiniciarTrains(ActionEvent event) {
        // Reinicia a animação do trem 1
        transition1.stop();
        // Reinicia a animação do trem 2
        transition2.stop();
        // Reinicia os Sliders
        velocidadeTrain1.setValue(15);
        velocidadeTrain2.setValue(15);
        // esconder as imagens dos trens
        trainCima1.setVisible(false);
        trainBaixo1.setVisible(false);
        trainBaixo2.setVisible(false);
        trainCima2.setVisible(false);

    }

    @FXML
    public void velocidadeT1(MouseEvent event) {
        // Obtém o valor atual do Slider
        double sliderValue = velocidadeTrain1.getValue();
        // Defina a velocidade desejada máxima e mínima para o Slider
        double maxSpeed = 30.0; // Velocidade máxima desejada
        double minSpeed = 1.0; // Velocidade mínima desejada
        if (transition1.getStatus() == Animation.Status.RUNNING) {
            transition1.stop();// Pausa a animação
            // Calcule a taxa de reprodução com base na escala do Slider
            double rate = minSpeed + (maxSpeed - minSpeed) * (sliderValue / velocidadeTrain1.getMax());

            // Define a taxa de reprodução da animação do trem 1
            transition1.setRate(rate);

        }
        transition1.play();// inicia a animação

    }

    @FXML
    public void velocidadeT2(MouseEvent event) {
        // Obtém o valor atual do Slider
        double sliderValue = velocidadeTrain2.getValue();
        // Defina a velocidade desejada máxima e mínima para o Slider
        double maxSpeed = 30.0; // Velocidade máxima desejada
        double minSpeed = 0; // Velocidade mínima desejada
        if (transition2.getStatus() == Animation.Status.RUNNING) {
            transition2.stop();// Pausa a animação
            // Calcule a taxa de reprodução com base na escala do Slider
            double rate = minSpeed + (maxSpeed - minSpeed) * (sliderValue / velocidadeTrain2.getMax());
            // Define a taxa de reprodução da animação do trem 2
            transition2.setRate(rate);

        }
        transition2.play();// inicia a animação

    }

    @FXML
    public void iniciarAnimacaoDescendo(ActionEvent event) {
        // Inicia animação, mesma direção descendo
        trainCima1.setVisible(true);// Tornar a imagem do trem visível
        trainCima2.setVisible(true);// Tornar a imagem do trem visível
        animacaoTrain1();// Chamar o método para animar o trem 1
        animacaoTrain2();// Chamar o método para animar o trem 2
    }

    @FXML
    public void iniciarAnimacaoSubindo(ActionEvent event) {
        // Inicia animação, mesma direção subindo
        trainBaixo1.setVisible(true);// Tornar a imagem do trem visível
        trainBaixo2.setVisible(true);// Tornar a imagem do trem visível
        animacaoTrain3();// Chamar o método para animar o trem 1
        animacaoTrain4();// Chamar o método para animar o trem 2
    }

    @FXML
    public void iniciarAnimacaoDescendoSubindo(ActionEvent event) {
        // Inicia animação, um trem desendo e o outro subindo
        trainCima1.setVisible(true);// Tornar a imagem do trem visível
        trainBaixo2.setVisible(true);// Tornar a imagem do trem visível
        animacaoTrain1();// Chamar o método para animar o trem 1
        animacaoTrain4();// Chamar o método para animar o trem 2
    }

    @FXML
    public void iniciarAnimacaoSubindoDescendo(ActionEvent event) {
        // Inicia animação, um subindo e o outro descendo
        trainBaixo1.setVisible(true);// Tornar a imagem do trem visível
        trainCima2.setVisible(true);// Tornar a imagem do trem visível
        animacaoTrain3();// Chamar o método para animar o trem 1
        animacaoTrain2();// Chamar o método para animar o trem 2
    }

    public void animacaoTrain1() {
        // Criar a animação para os trilhos 1 pra baixo
        Path path1 = new Path();
        // Fazer o caminho do trem nos trilhos
        path1.getElements().add(new MoveTo(15, 2));
        path1.getElements().add(new VLineTo(100));
        path1.getElements().add(new LineTo(50, 138));
        path1.getElements().add(new VLineTo(250));
        path1.getElements().add(new LineTo(15, 300));
        path1.getElements().add(new VLineTo(408));
        path1.getElements().add(new LineTo(50, 446));
        path1.getElements().add(new VLineTo(568));
        path1.getElements().add(new LineTo(15, 608));
        path1.getElements().add(new VLineTo(700));
        transition1 = new PathTransition();
        transition1.setNode(trainCima1);// Pegar a imagem do trem
        transition1.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);// Rotação da imagem
        transition1.setPath(path1);// Caminho do trem
        transition1.setAutoReverse(false);// Não retroceder a animação
        transition1.setCycleCount(PathTransition.INDEFINITE);// Execução varias vezes
        transition1.setDuration(Duration.seconds(30));// Velocidade do trem
        velocidadeTrain1.valueProperty().addListener((observable, oldValue, newValue) -> {
            transition1.setRate(newValue.doubleValue());
        });
        transition1.play();// inicia a animação
    }

    public void animacaoTrain2() {
        // Criar a animação para os trilhos 2 pra baixo
        Path path = new Path();
        // Fazer o caminho do trem nos trilhos
        path.getElements().add(new MoveTo(22, 2));
        path.getElements().add(new VLineTo(100));
        path.getElements().add(new LineTo(-10, 138));
        path.getElements().add(new VLineTo(250));
        path.getElements().add(new LineTo(22, 300));
        path.getElements().add(new VLineTo(408));
        path.getElements().add(new LineTo(-10, 446));
        path.getElements().add(new VLineTo(568));
        path.getElements().add(new LineTo(22, 608));
        path.getElements().add(new VLineTo(700));
        transition2 = new PathTransition();
        transition2.setNode(trainCima2);// Pegar a imagem do trem
        transition2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);// Rotação da imagem
        transition2.setPath(path);// Caminho do trem
        transition2.setAutoReverse(false);// Não retroceder a animação
        transition2.setCycleCount(PathTransition.INDEFINITE); // Execução varias vezes
        transition2.setDuration(Duration.seconds(30));// Velocidade do trem
        velocidadeTrain2.valueProperty().addListener((observable, oldValue, newValue) -> {
            transition2.setRate(newValue.doubleValue());
        });
        transition2.play(); // inicia a animação
    }

    public void animacaoTrain3() {
        // Criar a animação para os trigos 1 subindo
        Path path4 = new Path();
        // Fazer o caminho do trem nos trilhos
        path4.getElements().add(new MoveTo(22, 40));// mover o trem
        path4.getElements().add(new VLineTo(-70));// Trilho duplo
        path4.getElements().add(new LineTo(55, -125));
        path4.getElements().add(new VLineTo(-225));
        path4.getElements().add(new LineTo(20, -280));
        path4.getElements().add(new VLineTo(-360));
        path4.getElements().add(new LineTo(55, -415));
        path4.getElements().add(new VLineTo(-520));
        path4.getElements().add(new LineTo(20, -580));
        path4.getElements().add(new VLineTo(-650));
        transition1 = new PathTransition();
        transition1.setNode(trainBaixo1);// Pegar a imagem do trem
        transition1.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT); // rotação do trem
        transition1.setPath(path4); // Caminho do trem
        transition1.setAutoReverse(false);// Não retroceder a animação
        transition1.setCycleCount(PathTransition.INDEFINITE); // Execução varias vezes
        transition1.setDuration(Duration.seconds(30));// Velocidade do trem
        velocidadeTrain1.valueProperty().addListener((observable, oldValue, newValue) -> {
            transition1.setRate(newValue.doubleValue());
        });
        transition1.play(); // inicia a animação
    }

    public void animacaoTrain4() {
        // Criar a animação para os trigos 2 subindo
        Path path3 = new Path();
        // Fazer o caminho do trem nos trilhos
        path3.getElements().add(new MoveTo(20, 40));
        path3.getElements().add(new VLineTo(-65));
        path3.getElements().add(new LineTo(-16, -115));
        path3.getElements().add(new VLineTo(-225));
        path3.getElements().add(new LineTo(20, -280));
        path3.getElements().add(new VLineTo(-360));
        path3.getElements().add(new LineTo(-17, -415));
        path3.getElements().add(new VLineTo(-520));
        path3.getElements().add(new LineTo(20, -580));
        path3.getElements().add(new VLineTo(-650));
        transition2 = new PathTransition();
        transition2.setNode(trainBaixo2);// Pegar a imagem do trem
        transition2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);// Rotação da imagem
        transition2.setPath(path3);// Caminho do trem
        transition2.setAutoReverse(false);// Não retroceder a animação
        transition2.setCycleCount(PathTransition.INDEFINITE); // Execução varias vezes
        transition2.setDuration(Duration.seconds(30));// Velocidade do trem
        velocidadeTrain2.valueProperty().addListener((observable, oldValue, newValue) -> {
            transition2.setRate(newValue.doubleValue());
        });
        transition2.play(); // inicia a animação
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Tornar as imagens de trem invisíveis ao iniciar o programa
        trainCima1.setVisible(false);
        trainBaixo1.setVisible(false);
        trainBaixo2.setVisible(false);
        trainCima2.setVisible(false);
    }
}