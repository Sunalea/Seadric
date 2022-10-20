package Seadric.entities.treasure;
import Seadric.entities.Seacreatures.Speler;
import Seadric.entities.text.HealthText;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
public class Treasure extends DynamicCompositeEntity implements Collider, Collided {
    public Treasure(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    protected void setupEntities() {
        var treasure = new TreasureSprite(new Coordinate2D(0, 0));
        addEntity(treasure);
    }

    public int getPoints() {
        return 100;
    }

    @Override
    public void onCollision(Collider collider) {
        if(collider instanceof Speler) {
            this.remove();
        }
    }

}