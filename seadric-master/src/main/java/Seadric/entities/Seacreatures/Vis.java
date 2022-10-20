package Seadric.entities.Seacreatures;

import Seadric.Seadric;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.ArrayList;
import java.util.Random;

public class Vis extends Zeedier implements SceneBorderCrossingWatcher {
    ArrayList<Vis> GroteVis     = new ArrayList();
    ArrayList<Vis> MediumVis    = new ArrayList();
    ArrayList<Vis> KleineVis    = new ArrayList();
    private Seadric seadric;
    private int Width, Height;
    public Vis(Coordinate2D location, int Width, int Height, String Image, Seadric seadric) {
        super(Width, Height, location, Image, seadric);
        this.Width = Width;
        this.Height = Height;
        this.seadric = seadric;

        if (Width == 150) {
            GroteVis.add(this);
            setMotion(1.5, 270d);
        } else if (Width == 60) {
            MediumVis.add(this);
            setMotion(1.7, 270d);
        } else {
            KleineVis.add(this);
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
