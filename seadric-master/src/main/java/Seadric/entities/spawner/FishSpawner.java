package Seadric.entities.spawner;

import com.github.hanyaeger.api.entities.EntitySpawner;

public class FishSpawner extends EntitySpawner {
    private final double sceneWidth;
    private final double sceneHeight;

    public FishSpawner(double sceneWidth, double sceneHeight) {
        super(100);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }

    @Override
    protected void spawnEntities() {

    }
}
