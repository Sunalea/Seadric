package Seadric.entities.treasure;
import Seadric.entities.Seacreatures.Speler;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Treasure extends DynamicSpriteEntity implements Collider, Collided {

    Speler speler;
    public Treasure(Coordinate2D initialLocation, Speler speler) {
        super("sprites/treasure.png", initialLocation, new Size(60,80));
        this.speler = speler;
    }

    @Override
    public void onCollision(Collider collider) {
        if(collider instanceof Speler) {
            this.remove();
        }
    }

}