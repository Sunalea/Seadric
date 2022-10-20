package Seadric;

import Seadric.entities.buttons.SwitchScene;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TitleScreen extends StaticScene {
    private Seadric seadric;

    public TitleScreen(Seadric seadric) {
        this.seadric = seadric;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/ocean.mp3");
        setBackgroundImage("backgrounds/background3.jpg");
    }

    @Override
    public void setupEntities() {
        var waterworldText = new TextEntity(new Coordinate2D(getWidth() / 2, getHeight() / 3.5),"Seadric");

        waterworldText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        waterworldText.setFill(Color.LIGHTBLUE);
        waterworldText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));



        var startBtn = new SwitchScene(new Coordinate2D(getWidth() / 2, getHeight() / 2), seadric, "Start game", 1);

        startBtn.setAnchorPoint(AnchorPoint.CENTER_CENTER);


        addEntity(waterworldText);
        addEntity(startBtn);
    }

}
