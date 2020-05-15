package cn.edu.ncu.quanhao.FiveChess;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * 游戏启动区
 * */
public class GameLaunch extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FiveChess fiveChess = new FiveChess(20,20,25.0);
        ChessPane chessPane = new ChessPane(fiveChess);
        PlayAction playAction = new PlayAction(fiveChess,chessPane,primaryStage);
        chessPane.setOnMouseClicked(playAction);
        Scene scene=new Scene(chessPane,1200,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("五子棋游戏");
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
