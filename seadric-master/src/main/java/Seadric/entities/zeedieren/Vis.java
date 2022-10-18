package Seadric.entities.zeedieren;

import Seadric.Waterworld;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.ArrayList;
import java.util.Random;

public class Vis extends Zeedier implements SceneBorderCrossingWatcher {
    ArrayList<Vis> GroteVis     = new ArrayList();
    ArrayList<Vis> MediumVis    = new ArrayList();
    ArrayList<Vis> KleineVis    = new ArrayList();
    private Waterworld waterworld;

    public Vis(Coordinate2D location, int Width, int Height, String Image, Waterworld waterworld) {
        super(Width, Height, location, Image, waterworld);
        this.waterworld = waterworld;

        if (Width == 225) {
            GroteVis.add(this);
            setMotion(1.5, 270d);
        } else if (Width == 163) {
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
        if(collider instanceof Speler) {
            if(collider.getHeight() > this.getHeight()) {
                waterworld.removeEntity(this);
            }
        }
        
    }
}
