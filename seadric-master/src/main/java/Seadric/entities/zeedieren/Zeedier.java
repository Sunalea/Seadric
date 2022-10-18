package Seadric.entities.zeedieren;

import Seadric.Waterworld;
import Seadric.entities.swordfish.HitBox;
import Seadric.entities.swordfish.SwordfishSprite;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import javafx.scene.paint.Color;

public abstract class Zeedier extends DynamicSpriteEntity implements Collider, Collided {
    protected int Width, Height;
    protected Vis vis;
    protected Speler speler;

    public Zeedier(int Width, int Height, Coordinate2D location, String image, Waterworld waterworld) {
        super(image, location, new Size(Width, Height));
        this.Width = Width;
        this.Height = Height;
    }

    @Override
    public abstract void onCollision(Collider collider);
}