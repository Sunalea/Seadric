package Seadric.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class DynamicText extends Text{
    public DynamicText(Coordinate2D location, int fontSize) {
        super(location, fontSize);
    }

    public void setText(String text, int value) {
        setText(text + " " + value);
    }
}
