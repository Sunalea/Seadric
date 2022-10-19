package Seadric.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

import Seadric.entities.swordfish.HitBox;
import javafx.scene.paint.Color;

public class Seamine extends DynamicCompositeEntity implements SceneBorderCrossingWatcher, Collider {

    public Seamine(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    protected void setupEntities() {
        var Hitbox = new HitBox(new Coordinate2D(0 , 0));
        Hitbox.setFill(Color.PURPLE);
        var seaMine = new SeamineSprite(new Coordinate2D(0 , 0));
        addEntity(Hitbox);
        addEntity(seaMine);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {

    }
}