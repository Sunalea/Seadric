package Seadric.entities.treasure;

import Seadric.entities.Seacreatures.Speler;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class TreasureSprite extends SpriteEntity {
    public TreasureSprite(final Coordinate2D location) {
        super("sprites/treasure.png", location, new Size(60,80));
    }
}