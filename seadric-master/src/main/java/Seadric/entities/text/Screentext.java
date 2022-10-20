package Seadric.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Screentext extends TextEntity {
    public Screentext(Coordinate2D initialLocation, String text, int fontSize) {
        super(initialLocation);

        setFont(Font.font("Roboto", FontWeight.NORMAL, fontSize));
        setFill(Color.BLACK);
        setText(text);
    }
}
