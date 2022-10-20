package Seadric.entities.Seacreatures;

import Seadric.Seadric;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public abstract class SeaCreature extends DynamicSpriteEntity implements Collider, Collided {
    protected int Width, Height;

    public SeaCreature(int Width, int Height, Coordinate2D location, String image, Seadric seadric) {
        super(image, location, new Size(Width, Height));
        this.Width = Width;
        this.Height = Height;
    }

    @Override
    public abstract void onCollision(Collider collider);
}
