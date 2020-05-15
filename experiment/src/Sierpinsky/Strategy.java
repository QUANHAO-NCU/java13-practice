package Sierpinsky;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public interface Strategy extends Drawable {
    /**
     * 策略模式
     * */
    public void initial(int level, Color[] colors);
    public Pane returnPane();
}
