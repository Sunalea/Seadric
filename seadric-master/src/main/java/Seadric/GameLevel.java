package Seadric;

import Seadric.entities.Hanny;
import Seadric.entities.Sharky;
import Seadric.entities.swordfish.Swordfish;
import Seadric.entities.zeedieren.Vis;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import Seadric.entities.text.HealthText;
import java.util.Random;

public class GameLevel extends DynamicScene {
    private Waterworld waterworld;

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
        var swordfish = new Swordfish(
                new Coordinate2D(getWidth() / 2, getHeight() / 2)
        );

        var healthText = new HealthText( new Coordinate2D(0 , 0));

        var hanny = new Hanny(
                new Coordinate2D(getWidth() / 4, getHeight() / 4),
                healthText, waterworld
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
                    ((int)getWidth() / 11),
                    ((int)getWidth() / 11),
                    "sprites/MiddelVis.png",
                    waterworld
            ));
        }

        for (int i = 0; i < 5; i++) {
            addEntity(new Vis(
                    new Coordinate2D(100 + i * 100, 100 + i * 100),
                    ((int)getWidth() / 15),
                    ((int)getWidth() / 15),
                    "sprites/KleineVis.png",
                    waterworld
            ));
        }

        addEntity(swordfish);
        addEntity(hanny);
        addEntity(healthText);
    }
}
