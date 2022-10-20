package Seadric.entities.Seacreatures;

import Seadric.Seadric;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.ArrayList;
import java.util.Random;

public class Fish extends SeaCreature implements SceneBorderCrossingWatcher {
    ArrayList<Fish> groteVis = new ArrayList();
    ArrayList<Fish> mediumVis = new ArrayList();
    ArrayList<Fish> kleineVis = new ArrayList();
    private Seadric seadric;
    public Fish(Coordinate2D location, int Width, int Height, String Image, Seadric seadric) {
        super(Width, Height, location, Image, seadric);
        this.seadric = seadric;

        if (Width == 150) {
            groteVis.add(this);
            setMotion(1.5, 270d);
        } else if (Width == 60) {
            mediumVis.add(this);
            setMotion(1.7, 270d);
        } else {
            kleineVis.add(this);
            setMotion(2, 270d);
        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        setAnchorLocationX(getSceneWidth());
        setAnchorLocationY(new Random().nextInt((int) getSceneHeight()-71));
    }

    @Override
    public void onCollision(Collider collider) {
    }
}
