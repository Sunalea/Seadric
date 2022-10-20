package Seadric;

import Seadric.entities.Seacreatures.Predator;
import Seadric.entities.Seacreatures.Speler;
import Seadric.entities.Seacreatures.Vis;
import Seadric.entities.enemies.Seamine;
import Seadric.entities.text.DynamicText;
import Seadric.entities.treasure.Treasure;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;

import java.util.Random;

public class GameLevel extends DynamicScene {
    private Seadric seadric;
    private Speler speler;
    private static String image;

    public GameLevel(Seadric seadric) {
        this.seadric = seadric;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background2.jpg");
        setBackgroundAudio("audio/waterworld.mp3");
    }

    @Override
    public void setupEntities() {
//       var swordfish = new Swordfish(new Coordinate2D(getWidth() / 2, getHeight() / 2));

        var pointsText = new DynamicText(new Coordinate2D(1050, 0),30);
        var healthText = new DynamicText(new Coordinate2D(0, 0), 30);
        var predator = new Predator(200,250, new Coordinate2D(getWidth() / 2, getHeight() /2.8),"sprites/swordfish.png", seadric);

        var speler = new Speler(
            new Coordinate2D(getWidth() / 2, getHeight() / 2),60,70, image, seadric, healthText, pointsText
        );
        this.speler = speler;

        for (int i = 0; i < 3; i++) {
            addEntity(new Vis(
                    new Coordinate2D(100 + i * 100, 100 + i * 100),
                    ((int)getWidth() / 8),
                    ((int)getWidth() / 8),
                    "sprites/Grotevis.png",
                    seadric
            ));
        }

        for (int i = 0; i < 5; i++) {
            addEntity(new Vis(
                    new Coordinate2D(100 + i * 100, 100 + i * 100),
                    ((int)getWidth() / 20),
                    ((int)getWidth() / 20),
                    "sprites/MiddelVis.png",
                    seadric
            ));
        }

        for (int i = 0; i < 5; i++) {
            addEntity(new Vis(
                    new Coordinate2D(100 + i * 100, 100 + i * 100),
                    ((int)getWidth() / 30),
                    ((int)getWidth() / 30),
                    "sprites/KleineVis.png",
                    seadric
            ));
        }



        for (int i = 0; i < 3; i++){
            addEntity(new Treasure(
<<<<<<< HEAD
                new Coordinate2D((new Random().nextInt((int) getWidth())) + (i++ + 30), getHeight() / 1.1), speler
=======
                new Coordinate2D((new Random().nextInt((int) getWidth())) + (i++ + 30), getHeight() / 1.1)
>>>>>>> 26e4f0e7d3eafc5a0c06688f46a7fcade046dc92
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
