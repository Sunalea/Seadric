package Seadric.entities.buttons;

import Seadric.Seadric;
import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SwitchScene extends Knop {
    private Seadric seadric;
    int sceneID;
    public SwitchScene(Coordinate2D initialLocation, Seadric seadric, String text, int sceneID) {
        super(initialLocation, text, seadric);
        this.seadric = seadric;
        this.sceneID = sceneID;
        setFill(Color.BLACK);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        seadric.setActiveScene(sceneID);
    }

    @Override
    public void onMouseEntered() {
        setFill(Color.DARKGRAY);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(Color.BLACK);
        setCursor(Cursor.DEFAULT);
    }
}
