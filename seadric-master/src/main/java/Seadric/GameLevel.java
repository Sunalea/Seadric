package Seadric;

import Seadric.entities.Seacreatures.Predator;
import Seadric.entities.Seacreatures.Speler;
import Seadric.entities.Seacreatures.Vis;
import Seadric.entities.enemies.Seamine;
import Seadric.entities.text.HealthText;
import Seadric.entities.text.PointText;
import Seadric.entities.treasure.Treasure;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;

import java.util.Random;

public class GameLevel extends DynamicScene {
    private Waterworld waterworld;
    private Speler speler;
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
//       var swordfish = new Swordfish(new Coordinate2D(getWidth() / 2, getHeight() / 2));

        var pointsText = new PointText(new Coordinate2D(1050, 0));
        var healthText = new HealthText(new Coordinate2D(0, 0));
        var predator = new Predator(200,250, new Coordinate2D(getWidth() / 2, getHeight() /2.8),"sprites/swordfish.png", waterworld);

        var speler = new Speler(
            new Coordinate2D(getWidth() / 2, getHeight() / 2),60,70, image, waterworld, healthText, pointsText
        );
        this.speler = speler;

        for (int i = 0; i < 2; i++) {
            addEntity(new Vis(
                    new Coordinate2D(100 + i * 100, 100 + i * 100),
                    ((int)getWidth() / 8),
                    ((int)getWidth() / 8),
                    "sprites/Grotevis.png",
                    waterworld
            ));
        }

        for (int i = 0; i < 2; i++) {
            addEntity(new Vis(
                    new Coordinate2D(100 + i * 100, 100 + i * 100),
                    ((int)getWidth() / 20),
                    ((int)getWidth() / 20),
                    "sprites/MiddelVis.png",
                    waterworld
            ));
        }

        for (int i = 0; i < 2; i++) {
            addEntity(new Vis(
                    new Coordinate2D(100 + i * 100, 100 + i * 100),
                    ((int)getWidth() / 30),
                    ((int)getWidth() / 30),
                    "sprites/KleineVis.png",
                    waterworld
            ));
        }



        for (int i = 0; i < 3; i++){
            addEntity(new Treasure(
                new Coordinate2D((new Random().nextInt((int) getWidth())) + (i++ + 30), getHeight() / 1.1), healthText, speler
            ));
        }

        addEntity(new Seamine(
                new Coordinate2D(new Random().nextInt((int) getWidth()), getHeight() / 1.6)
        ));

//        addEntity(swordfish);
        addEntity(speler);
        addEntity(healthText);
        addEntity(pointsText);
        addEntity(predator);
    }

    public static void setCharacter(String image) {
        GameLevel.image = image;
    }

}
