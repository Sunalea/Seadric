package Seadric.entities.treasure;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
public class Treasure extends DynamicCompositeEntity implements Collider {
    public Treasure(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    protected void setupEntities() {
        var treasure = new TreasureSprite(new Coordinate2D(0, 0));
        addEntity(treasure);
    }

}