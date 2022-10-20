package Seadric.entities.enemies;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import javafx.scene.paint.Color;

public class Seamine extends DynamicSpriteEntity implements Collider {

    public Seamine(Coordinate2D initialLocation) {
        super("sprites/sea-mine.png", initialLocation);
    }
}