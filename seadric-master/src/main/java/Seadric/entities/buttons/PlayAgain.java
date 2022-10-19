package Seadric.entities.buttons;

import Seadric.Waterworld;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PlayAgain extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private Waterworld waterworld;
    public PlayAgain(Coordinate2D initialLocation, Waterworld waterworld) {
        super(initialLocation, "Play again");
        this.waterworld = waterworld;
        setFill(Color.BLACK);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        waterworld.setActiveScene(2);
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
