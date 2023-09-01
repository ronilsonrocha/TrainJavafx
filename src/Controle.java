
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.util.Duration;

public class Controle {
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
    // movimentar as imagens dos trens

    // Métodos para reiniciar os trens
    @FXML
    public void reiniciarTrains(ActionEvent event) {
        // reiniciar os trens
    }

    // Atributos para as animações
    private PathTransition transition1;
    private PathTransition transition2;

    // Métodos para aumentar a velocidade do trem 1
    @FXML
    public void velocidadeT1(MouseEvent event) {
        // Obtém o valor atual do Slider
        double sliderValue = velocidadeTrain1.getValue();
        // Calcula a nova duração baseada na velocidade selecionada
        double newDuration = 5 / sliderValue;
        // Verifica se a animação do trem 1 está em execução
        if (transition1.getStatus() == Animation.Status.RUNNING) {
            // Pausa a animação
            transition1.pause();
            // Atualiza a duração da animação do trem 1
            transition1.setDuration(Duration.seconds(newDuration));
            // Retoma a animação
            transition1.play();
        }
    }

    // Métodos para aumentar a velocidade do trem 2
    @FXML
    public void velocidadeT2(MouseEvent event) {
        // Obtém o valor atual do Slider
        double sliderValue = velocidadeTrain2.getValue();
        // Calcula a nova duração baseada na velocidade selecionada
        double newDuration = 5 / sliderValue;
        // Verifica se a animação do trem 2 está em execução
        if (transition2.getStatus() == Animation.Status.RUNNING) {
            // Pausa a animação
            transition2.pause();
            // Atualiza a duração da animação do trem 2
            transition2.setDuration(Duration.seconds(newDuration));
            // Retoma a animação
            transition2.play();
        }
    }

    @FXML
    public void iniciarAnimacaoDescendo(ActionEvent event) {
        // Inicia animação descendo dos dois trens
        animacaoTrain1();
        animacaoTrain2();
    }

    @FXML
    public void iniciarAnimacaoSubindo(ActionEvent event) {
        // Inicia animação subindo dos dois trens
        animacaoTrain3();
        animacaoTrain4();
    }

    @FXML
    public void iniciarAnimacaoDescendoSubindo(ActionEvent event) {
        // Inicia animação descendo do trem 1 e subindo do trem 2
        animacaoTrain1();
        animacaoTrain4();
    }

    @FXML
    public void iniciarAnimacaoSubindoDescendo(ActionEvent event) {
        // Inicia animação subindo do trem 1 e descendo do trem 2
        animacaoTrain3();
        animacaoTrain2();
    }

    public void animacaoTrain1() {
        // Criar a animação para os trilhos 1 pra baixo
        Path path1 = new Path();
        path1.getElements().add(new MoveTo(15, 2));// mover o trem
        path1.getElements().add(new VLineTo(100));// Trilho duplo
        path1.getElements().add(new LineTo(50, 138));
        path1.getElements().add(new VLineTo(250));
        path1.getElements().add(new LineTo(15, 300));
        path1.getElements().add(new VLineTo(408));
        path1.getElements().add(new LineTo(50, 446));
        path1.getElements().add(new VLineTo(568));
        path1.getElements().add(new LineTo(15, 608));
        path1.getElements().add(new VLineTo(700));
        transition1 = new PathTransition();
        transition1.setNode(trainCima1);
        transition1.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transition1.setPath(path1);
        transition1.setAutoReverse(false);
        transition1.setCycleCount(PathTransition.INDEFINITE); // execução varias
        velocidadeTrain1.valueProperty().addListener((observable, oldValue, newValue) -> {
            transition1.setRate(newValue.doubleValue());
        });
        transition1.play();// inicia a animação
    }

    public void animacaoTrain2() {
        // Criar a animação para os trilhos 2 pra baixo
        Path path = new Path();
        path.getElements().add(new MoveTo(22, 2));// mover o trem
        path.getElements().add(new VLineTo(100));// Trilho duplo
        path.getElements().add(new LineTo(-10, 138));
        path.getElements().add(new VLineTo(250));
        path.getElements().add(new LineTo(22, 300));
        path.getElements().add(new VLineTo(408));
        path.getElements().add(new LineTo(-10, 446));
        path.getElements().add(new VLineTo(568));
        path.getElements().add(new LineTo(22, 608));
        path.getElements().add(new VLineTo(700));
        transition2 = new PathTransition();
        transition2 = new PathTransition();
        transition2.setNode(trainCima2);
        transition2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transition2.setPath(path);
        transition2.setAutoReverse(false);
        transition2.setCycleCount(PathTransition.INDEFINITE); // execução varias
        velocidadeTrain2.valueProperty().addListener((observable, oldValue, newValue) -> {
            transition2.setRate(newValue.doubleValue());
        });
        transition2.play(); // inicia a animação
    }

    public void animacaoTrain3() {
        // Criar a animação para os trigos 1 subindo
        Path path4 = new Path();
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
        transition1.setNode(trainBaixo1);// pegar a imagem do trem
        transition1.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT); // rotação do trem
        transition1.setPath(path4); // caminho
        transition1.setAutoReverse(false); // não retroceder a animação
        transition1.setCycleCount(PathTransition.INDEFINITE); // execução varias
        velocidadeTrain1.valueProperty().addListener((observable, oldValue, newValue) -> {
            transition1.setRate(newValue.doubleValue());
        });
        transition1.play(); // inicia a animação
    }

    public void animacaoTrain4() {
        // Criar a animação para os trigos 2 subindo
        Path path3 = new Path();
        // subir o trainBaixo2
        path3.getElements().add(new MoveTo(20, 40));// mover o trem
        path3.getElements().add(new VLineTo(-65));// Trilho duplo
        path3.getElements().add(new LineTo(-16, -115));
        path3.getElements().add(new VLineTo(-225));
        path3.getElements().add(new LineTo(20, -280));
        path3.getElements().add(new VLineTo(-360));
        path3.getElements().add(new LineTo(-17, -415));
        path3.getElements().add(new VLineTo(-520));
        path3.getElements().add(new LineTo(20, -580));
        path3.getElements().add(new VLineTo(-650));
        transition2 = new PathTransition();
        transition2.setNode(trainBaixo2);
        transition2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        transition2.setPath(path3);
        transition2.setAutoReverse(false);
        transition2.setCycleCount(PathTransition.INDEFINITE); // execução varias
        velocidadeTrain2.valueProperty().addListener((observable, oldValue, newValue) -> {
            transition2.setRate(newValue.doubleValue());
        });
        transition2.play(); // inicia a animação
    }
}
