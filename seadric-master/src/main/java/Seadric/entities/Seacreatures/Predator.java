package Seadric.entities.Seacreatures;

import Seadric.Seadric;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.Random;

public class Predator extends SeaCreature implements SceneBorderCrossingWatcher {
    public Predator(int Width, int Height, Coordinate2D location, String image, Seadric seadric) {
        super(Width, Height, location, image, seadric);
        setMotion(2, 270d);
    }

    @Override
    public void onCollision(Collider collider) {

    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        setAnchorLocationX(getSceneWidth());
        setAnchorLocationY(new Random().nextInt((int) getSceneHeight()-71));
    }

}
