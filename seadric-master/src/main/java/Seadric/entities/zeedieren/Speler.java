package Seadric.entities.zeedieren;

import Seadric.Waterworld;
import Seadric.entities.text.HealthText;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Speler extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, Collided {
    // make constructor for player fish
    private HealthText healthText;
    private Waterworld waterworld;
    private int health = 3;

    public Speler(Coordinate2D location, HealthText healthText, Waterworld waterworld) {
        super("sprites/hanny.png", location, new Size(60,80), 1, 2);
        this.waterworld = waterworld;
        this.healthText = healthText;
        healthText.setHealthText(health);
        // lets gooo

        setGravityConstant(0.005);
        setFrictionConstant(0.04);
    }

    @Override
    public void onCollision(Collider collider) {

    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {

    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {

    }
}
