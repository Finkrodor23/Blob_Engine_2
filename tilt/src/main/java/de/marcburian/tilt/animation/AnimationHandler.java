package de.marcburian.tilt.animation;

import de.marcburian.tilt.sprites.Sprite;

/**
 * Created by Marc on 08.08.2015.
 */
public interface AnimationHandler {
    public void advance(Sprite sprite, float elapsedTime);
}
