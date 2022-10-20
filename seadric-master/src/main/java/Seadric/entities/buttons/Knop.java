package Seadric.entities.buttons;

import Seadric.Seadric;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.input.MouseButton;

public abstract class Knop extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    protected Seadric seadric;
    public Knop(Coordinate2D initialLocation, String text, Seadric seadric) {
        super(initialLocation, text);
        this.seadric = seadric;
    }

    @Override
    public abstract void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D);

    @Override
    public abstract void onMouseEntered();

    @Override
    public abstract void onMouseExited();
}
