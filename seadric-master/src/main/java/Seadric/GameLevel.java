package Seadric;

import Seadric.entities.Seacreatures.Predator;
import Seadric.entities.Seacreatures.Player;
import Seadric.entities.Seacreatures.Fish;
import Seadric.entities.enemies.Seamine;
import Seadric.entities.text.DynamicText;
import Seadric.entities.treasure.Treasure;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;

import java.util.Random;

public class GameLevel extends DynamicScene {
    private Seadric seadric;
    private Player player;
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

        var speler = new Player(
            new Coordinate2D(getWidth() / 2, getHeight() / 2),60,70, image, seadric, healthText, pointsText
        );
        this.player = speler;

        for (int i = 0; i < 3; i++) {
            addEntity(new Fish(
                    new Coordinate2D(100 + i * 100, 100 + i * 100),
                    ((int)getWidth() / 8),
                    ((int)getWidth() / 8),
                    "sprites/Grotevis.png",
                    seadric
            ));
        }

        for (int i = 0; i < 5; i++) {
            addEntity(new Fish(
                    new Coordinate2D(100 + i * 100, 100 + i * 100),
                    ((int)getWidth() / 20),
                    ((int)getWidth() / 20),
                    "sprites/MiddelVis.png",
                    seadric
            ));
        }

        for (int i = 0; i < 5; i++) {
            addEntity(new Fish(
                    new Coordinate2D(100 + i * 100, 100 + i * 100),
                    ((int)getWidth() / 30),
                    ((int)getWidth() / 30),
                    "sprites/KleineVis.png",
                    seadric
            ));
        }



        for (int i = 0; i < 3; i++){
            addEntity(new Treasure(
               new Coordinate2D((new Random().nextInt((int) getWidth())) + (i++ + 30), getHeight() / 1.1), speler
            ));
        }

        addEntity(new Seamine( new Coordinate2D(new Random().nextInt((int) getWidth()), getHeight() / 1.6)));

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
