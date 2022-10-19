package Seadric;

import Seadric.entities.text.CharacterText;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import Seadric.entities.buttons.CharacterScreenButton;
import Seadric.entities.components.Karakter;

import com.github.hanyaeger.api.Coordinate2D;

public class CharacterScreen extends DynamicScene {
    private Waterworld waterworld;

    public CharacterScreen(Waterworld waterworld) {
        this.waterworld = waterworld;
    }
    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/karakterscherm.jpg");
        setBackgroundAudio("audio/waterworld.mp3");
    }

    @Override
    public void setupEntities() {
        // make 3 karakter objects and add them to the scene
        var karakter1 = new Karakter("sprites/karakter1.png", new Coordinate2D(100, 100), waterworld);
        var karakter2 = new Karakter("sprites/karakter2.png", new Coordinate2D(100, 100), waterworld);
        var karakter3 = new Karakter("sprites/karakter3.png", new Coordinate2D(100, 100), waterworld);
        var text      = new CharacterText(new Coordinate2D(getWidth() / 2, getHeight() / 3.5));

        karakter1.setAnchorLocation(new Coordinate2D((getWidth() / 2) - 200, (getHeight() / 2)));
        karakter2.setAnchorLocation(new Coordinate2D((getWidth() / 2), getHeight() / 2));
        karakter3.setAnchorLocation(new Coordinate2D((getWidth() / 2) + 200, getHeight() / 2));

        addEntity(text);
        addEntity(karakter1);
        addEntity(karakter2);
        addEntity(karakter3);
    }
}
