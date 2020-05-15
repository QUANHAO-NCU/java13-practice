package Sierpinsky;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Controller {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    public void handle(int i, Color[] colors){
        strategy.initial(i,colors);
    }
    public Pane returnPane(){
        return strategy.returnPane();
    }
}
