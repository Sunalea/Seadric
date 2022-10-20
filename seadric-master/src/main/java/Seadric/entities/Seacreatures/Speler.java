package Seadric.entities.Seacreatures;

import java.util.Random;
import java.util.Set;

import Seadric.entities.text.DynamicText;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;

import Seadric.Seadric;
import Seadric.entities.enemies.Seamine;
import Seadric.entities.treasure.Treasure;
import javafx.scene.input.KeyCode;

public class Speler extends Zeedier implements KeyListener, SceneBorderTouchingWatcher, Newtonian {
    private DynamicText healthText, pointsText;

    private Seadric seadric;
    private int health = 3, points = 0;
    private String healthTxt = "Health: ", pointsTxt = "Points:";
    private String image;
    private Coordinate2D location;

    public Speler(Coordinate2D location, int Width, int Height, String image, Seadric seadric,
                  DynamicText healthText, DynamicText pointsText) {
        super(Width, Height, location, image, seadric);
        this.seadric = seadric;
        this.healthText = healthText;
        this.pointsText = pointsText;

        healthText.setText("Health:" + health);
        pointsText.setText("Points:" + points);

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
            setCurrentFrameIndex(2);
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
                break;
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
                healthText.setText(healthTxt + health);
                if (health == 0) {
                    seadric.setActiveScene(3);
                }
            } else if (collider.getHeight() < this.getHeight() && collider.getWidth() < this.getHeight()) {
                if (collider.getWidth() == 150) {
                    points += 30;
<<<<<<< HEAD
                    pointsText.setText(pointsTxt + points);
                } else if (collider.getWidth() == 60) {
                    points += 20;
                    pointsText.setText(pointsTxt + points);
                } else {
                    points += 10;
                    pointsText.setText(pointsTxt + points);
=======
                    pointsText.setPointsText(points);
                    ((Vis) collider).remove();
                } else if (collider.getWidth() == 60) {
                    points += 20;
                    pointsText.setPointsText(points);
                    ((Vis) collider).remove();
                } else {
                    points += 10;
                    pointsText.setPointsText(points);
                    ((Vis) collider).remove();
>>>>>>> 26e4f0e7d3eafc5a0c06688f46a7fcade046dc92
                }
            }
        } else if (collider instanceof Predator) {
            health--;
            healthText.setText(healthTxt + health);
            if (health == 0){
                seadric.setActiveScene(3);
            }
        }

        else if (collider instanceof Treasure) {
            points += ((Treasure) collider).getPoints();
            pointsText.setText(pointsTxt + points);
        }
        if (collider instanceof Seamine) {
            health = 0;
            seadric.setActiveScene(3);
        }
        if (points >= 100) {
            setWidth(Width + 120);
            setHeight(Height + 120);
            this.Width += 120;
            this.Height += 120;
        }
    }

    public double getHeight() {
        return this.Height;
    }

    public void setHeight(int Height) {
        this.Height = Height;
    }

    public void setWidth(int Width) {
        this.Width = Width;
    }

    public void setRandomPos() {
        setAnchorLocation(new Coordinate2D(
                new Random().nextInt((int) (getSceneWidth() - getWidth())),
                new Random().nextInt((int) (getSceneHeight() - getHeight()))));
    }
}
