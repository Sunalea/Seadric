package Seadric.entities.components;

import Seadric.GameLevel;
import Seadric.Seadric;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;

public class Karakter extends DynamicSpriteEntity implements MouseButtonPressedListener {
    private String image;
    private Seadric seadric;
    public Karakter(String image, Coordinate2D location, Seadric seadric) {
        super(image, location, new Size(100, 100));
        this.image = image;
        this.seadric = seadric;
    }

    public String getImage() {
        return image;
    }


    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        GameLevel.setCharacter(image);
        seadric.setActiveScene(2);
    }
}
