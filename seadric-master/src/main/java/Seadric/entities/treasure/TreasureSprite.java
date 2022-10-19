package Seadric.entities.treasure;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class TreasureSprite extends SpriteEntity {
    public TreasureSprite(final Coordinate2D location) {
        super("sprites/treasure.png", location, new Size(60,80));
    }
    protected TreasureSprite(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }
}