package Seadric;

import Seadric.entities.swordfish.Swordfish;
import Seadric.entities.zeedieren.Speler;
import Seadric.entities.zeedieren.Vis;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import Seadric.entities.text.HealthText;
import Seadric.entities.text.PointText;

import java.util.Random;

public class GameLevel extends DynamicScene {
    private Waterworld waterworld;
    private static String image;

    public GameLevel(Waterworld waterworld) {
        this.waterworld = waterworld;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background2.jpg");
        setBackgroundAudio("audio/waterworld.mp3");
    }

    @Override
    public void setupEntities() {
        var swordfish = new Swordfish(new Coordinate2D(getWidth() / 2, getHeight() / 2));

        var pointsText = new PointText(new Coordinate2D(1050, 0));

        var healthText = new HealthText(new Coordinate2D(0, 0));

        var hanny = new Speler(
            new Coordinate2D(getWidth() / 4, getHeight() / 4),60,70,"sprites/hanny.png", waterworld, healthText, pointsText
        );

        for (int i = 0; i < 5; i++) {
            addEntity(new Vis(
                    new Coordinate2D(100 + i * 100, 100 + i * 100),
                    ((int)getWidth() / 8),
                    ((int)getWidth() / 8),
                    "sprites/Grotevis.png",
                    waterworld
            ));
        }

        for (int i = 0; i < 5; i++) {
            addEntity(new Vis(
                    new Coordinate2D(100 + i * 100, 100 + i * 100),
                    ((int)getWidth() / 20),
                    ((int)getWidth() / 20),
                    "sprites/MiddelVis.png",
                    waterworld
            ));
        }

        for (int i = 0; i < 5; i++) {
            addEntity(new Vis(
                    new Coordinate2D(100 + i * 100, 100 + i * 100),
                    ((int)getWidth() / 25),
                    ((int)getWidth() / 25),
                    "sprites/KleineVis.png",
                    waterworld
            ));
        }

        addEntity(swordfish);
        addEntity(hanny);
        addEntity(healthText);
        addEntity(pointsText);
    }

    public static void setCharacter(String image) {
        GameLevel.image = image;
    }

}
