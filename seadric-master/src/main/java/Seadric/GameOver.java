package Seadric;

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
        var gameOverText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 3.5),
                "Game over"
        );
        gameOverText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        gameOverText.setFill(Color.BLACK);
        gameOverText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));

        var playAgain = new SwitchScene(new Coordinate2D(getWidth() / 2, getHeight() / 2), seadric, 2);
        playAgain.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        var quitGame = new Gameover(new Coordinate2D(getWidth() / 2, (getHeight() / 2) + 100), seadric);
        quitGame.setAnchorPoint(AnchorPoint.CENTER_CENTER);

        addEntity(gameOverText);
        addEntity(playAgain);
        addEntity(quitGame);
    }
}
