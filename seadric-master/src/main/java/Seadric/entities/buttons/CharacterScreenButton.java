package Seadric.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;

import Seadric.Waterworld;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CharacterScreenButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    private Waterworld waterworld;

    public CharacterScreenButton(Coordinate2D initialLocation, Waterworld waterworld) {
        super(initialLocation, "Choose character");
        this.waterworld = waterworld;

        setFill(Color.LIGHTBLUE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        waterworld.setActiveScene(2);
    }

    @Override
    public void onMouseEntered() {
        setFill(Color.DARKCYAN);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(Color.LIGHTBLUE);
        setCursor(Cursor.DEFAULT);
    }
}
