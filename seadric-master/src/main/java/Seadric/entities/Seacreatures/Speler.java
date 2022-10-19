package Seadric.entities.Seacreatures;

import java.util.Random;
import java.util.Set;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;

import Seadric.Waterworld;
import Seadric.entities.enemies.Seamine;
import Seadric.entities.text.HealthText;
import Seadric.entities.text.PointText;
import Seadric.entities.treasure.Treasure;
import javafx.scene.input.KeyCode;

public class Speler extends Zeedier implements KeyListener, SceneBorderTouchingWatcher, Newtonian {
    // make constructor for player fish
    private HealthText healthText;
    private PointText pointsText;
    private Waterworld waterworld;
    private int health = 3;
    private int points = 0;

    public Speler(Coordinate2D location, int Width, int Height, String Image, Waterworld waterworld,
            HealthText healthText, PointText pointsText) {
        super(Width, Height, location, Image, waterworld);
        this.waterworld = waterworld;
        this.healthText = healthText;
        this.pointsText = pointsText;
        healthText.setHealthText(health);
        pointsText.setPointsText(points);

        setGravityConstant(0.005);
        setFrictionConstant(0.04);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.A)) {
            setMotion(3, 270d);
            setCurrentFrameIndex(2);
        } else if (pressedKeys.contains(KeyCode.D)) {
            setMotion(3, 90d);
            setCurrentFrameIndex(1);
        } else if (pressedKeys.contains(KeyCode.W)) {
            setMotion(3, 180d);
        } else if (pressedKeys.contains(KeyCode.S)) {
            setMotion(3, 0d);
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        setSpeed(0);

        switch (border) {
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Vis) {
            if (collider.getHeight() > this.getHeight() && collider.getWidth() > this.getHeight()) {
                setRandomPos();

                health--;
                healthText.setHealthText(health);
                if (health == 0) {
                    waterworld.setActiveScene(3);
                }
            }
        } else if (collider instanceof Treasure) {
            health++;
            healthText.setHealthText(health);
            setRandomPos();
        }

        if (collider instanceof Seamine) {
            health = 0;
            waterworld.setActiveScene(3);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.github.hanyaeger.core.entities.Bounded#getHeight()
     */
    public double getHeight() {
        return this.Height;
    }

    /**
     * @param Height
     */
    public void setHeight(int Height) {
        this.Height = Height;
    }

    /**
     * @return
     */
    public int getPoints() {
        return this.points;
    }

    /**
     * @param points
     */
    public void setPoints(int points) {
        this.points = points;
    }

    public void setRandomPos() {
        setAnchorLocation(new Coordinate2D(
                new Random().nextInt((int) (getSceneWidth() - getWidth())),
                new Random().nextInt((int) (getSceneHeight() - getHeight()))));
    }
}
