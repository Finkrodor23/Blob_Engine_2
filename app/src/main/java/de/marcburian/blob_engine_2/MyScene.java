package de.marcburian.blob_engine_2;

import de.marcburian.tilt.Scene;
import de.marcburian.tilt.Stage;
import de.marcburian.tilt.animation.AnimationHandler;
import de.marcburian.tilt.animation.ImageAnimation;
import de.marcburian.tilt.sprites.ImageSprite;
import de.marcburian.tilt.types.RGB;

/**
 * Created by Marc on 08.08.2015.
 */
public class MyScene extends Scene {

    public MyScene(Stage parentStage) {
        super(parentStage);
    }

    /**
     * Called when the stage is already loaded and the scene needs to load itself.
     */
    @Override
    public void onLoaded() {
        setBackColor(new RGB("ffffff"));
        ImageSprite.Cutout cutout = new ImageSprite.Cutout(128, 128, 7);
        ImageSprite sprite = new ImageSprite(R.drawable.slime, cutout);
        sprite.setPosition(300, 300);
        add(sprite, 0);

        ImageAnimation animation = new ImageAnimation(
                new int[] {0, 1, 2, 3, 4, 5, 6},
                ImageAnimation.TREND_PINGPONG
        );
        sprite.setAnimation(animation);


        /* Let the stage know that this scene is fully loaded */
        super.onLoaded();
    }
}
