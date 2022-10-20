package Seadric;

import Seadric.entities.text.Screentext;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;

import Seadric.entities.buttons.Gameover;
import Seadric.entities.buttons.SwitchScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameOver extends DynamicScene {
    private Seadric seadric;

    public GameOver(Seadric seadric) {
        this.seadric = seadric;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background3.jpg");
        setBackgroundAudio("audio/ocean.mp3");
    }

    @Override
    public void setupEntities() {
        var gameOverText = new Screentext( new Coordinate2D(getWidth() / 2, (getHeight() / 2) - 100),  "Game over", 80);
        var playAgain = new SwitchScene(new Coordinate2D(getWidth() / 2, (getHeight() / 2) ), seadric, "Play again", 2);
        var quitGame = new Gameover(new Coordinate2D(getWidth() / 2, (getHeight() / 2) + 100), seadric);

        gameOverText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        playAgain.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        quitGame.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        addEntity(gameOverText);
        addEntity(playAgain);
        addEntity(quitGame);
    }
}
