package Seadric;

import Seadric.entities.zeedieren.Vis;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

public class Waterworld extends YaegerGame {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void setupGame() {
        setGameTitle("Waterworld");
        setSize(new Size(1200, 800));

        addScene(0, new TitleScene(this));
        addScene(1, new KarakterScherm(this));
        addScene(2, new GameLevel(this));
        addScene(3, new GameOver(this));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new KarakterScherm(this));
        addScene(2, new GameLevel(this));
        addScene(3, new GameOver(this));
    }

    public void removeEntity(Vis vis) {
    }
}
