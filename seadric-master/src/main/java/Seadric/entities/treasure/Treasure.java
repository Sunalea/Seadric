package Seadric.entities.treasure;
import Seadric.entities.Seacreatures.Speler;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
public class Treasure extends DynamicCompositeEntity implements Collider, Collided {

    Speler speler;
    public Treasure(Coordinate2D initialLocation, Speler speler) {
        super(initialLocation);
        this.speler = speler;
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