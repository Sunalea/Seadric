package Seadric.entities.text;

import com.github.hanyaeger.api.Coordinate2D;

public class Screentext extends Text {
    public Screentext(Coordinate2D initialLocation, String text, int fontSize) {
        super(initialLocation, fontSize);
        setText(text);
    }
}
