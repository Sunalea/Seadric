package Seadric;

import Seadric.entities.text.CharacterText;
import com.github.hanyaeger.api.scenes.DynamicScene;
import Seadric.entities.components.Karakter;

import com.github.hanyaeger.api.Coordinate2D;

public class CharacterScreen extends DynamicScene {
    private Seadric seadric;

    public CharacterScreen(Seadric seadric) {
        this.seadric = seadric;
    }
    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/karakterscherm.jpg");
        setBackgroundAudio("audio/waterworld.mp3");
    }

    @Override
    public void setupEntities() {
        // make 3 karakter objects and add them to the scene
        var karakter1 = new Karakter("sprites/karakter1.png", new Coordinate2D(100, 100), seadric);
        var karakter2 = new Karakter("sprites/karakter2.png", new Coordinate2D(100, 100), seadric);
        var karakter3 = new Karakter("sprites/karakter3.png", new Coordinate2D(100, 100), seadric);
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
