
/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor....: RONILSON ROCHA SANTOS
Matricula: 202110848
Inicio...: 25/08/23
Alteracao: 01/09/23
Nome.....: Controle.java
Funcao...: Controla a aplicação
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application {

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Controle controle = new Controle();// Instancia o controle
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View.fxml"));// Carrega o arquivo FXML
        loader.setController(controle); // Seta o controle
        Scene scene = new Scene(loader.load());// Carrega a cena
        primaryStage.setResizable(false); // fixar o tamanho da janela
        primaryStage.setScene(scene);// Seta a cena
        primaryStage.show();// Mostra a cena
    }// Fim do método start
}