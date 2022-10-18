package Seadric.entities.components;

import Seadric.GameLevel;
import Seadric.Waterworld;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;

public class Karakter extends DynamicSpriteEntity implements MouseButtonPressedListener {
    private String image;
    private Waterworld waterworld;
    public Karakter(String image, Coordinate2D location, Waterworld waterworld) {
        super(image, location, new Size(100, 100));
        this.image = image;
        this.waterworld = waterworld;
    }

    public String getImage() {
        return image;
    }


    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        // When clicked on a character send the image to the gamelevel
        GameLevel.setCharacter(image);
        waterworld.setActiveScene(2);
    }
}
