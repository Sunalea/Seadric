package Seadric.entities.treasure;
import Seadric.entities.Seacreatures.Player;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Treasure extends DynamicSpriteEntity implements Collider, Collided {

    Player player;
    public Treasure(Coordinate2D initialLocation, Player player) {
        super("sprites/treasure.png", initialLocation, new Size(60,80));
        this.player = player;
    }

    @Override
    public void onCollision(Collider collider) {
        if(collider instanceof Player) {
            this.remove();
        }
    }

}