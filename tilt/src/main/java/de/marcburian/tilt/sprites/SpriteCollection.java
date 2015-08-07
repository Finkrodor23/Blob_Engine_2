package de.marcburian.tilt.sprites;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Marc on 08.08.2015.
 */

public final class SpriteCollection {
    private Sprite[] elementData;
    private int size;

    /**
     * Constructs a {@code SpriteCollection} with the given initial capacity.
     * @param initialCapacity	The initial capacity.
     */
    public SpriteCollection(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);

        elementData = new Sprite[initialCapacity];
    }

    /**
     * Constructs a {@code SpriteCollection} with the default initial capacity of 20.
     */
    public SpriteCollection() {
        this(20);
    }

    /**
     * Gets the {@code Sprite} at the given index of the list.
     * @param index	The list index.
     * @return	The {@code Sprite} at the given index or {@code null} if the index
     * doesn't exist.
     */
    public final Sprite get(int index) {
        if(index < size)
            return elementData[index];

        return null;
    }

    /**
     * Adds a sprite to this collection.
     * @param sprite	The new sprite.
     */
    public final void add(Sprite sprite) {
        ensureCapacity(size + 1);
        elementData[size++] = sprite;
    }

    /**
     * Adds a sprite to this collection at the given index.
     * @param index	The index of the new sprite.
     * @param sprite	The new sprite.
     */
    public final void add(int index, Sprite sprite) {
        if(index >= 0 && index < size) {
            ensureCapacity(size + 1);
            System.arraycopy(elementData, index, elementData, index + 1, size - index);
            elementData[index] = sprite;
            size++;
        }
    }

    /**
     * Removes a sprite from this collection.
     * @param sprite	The sprite to remove.
     * @return	{@code true} if any sprite was removed, and {@code false}
     * if the sprite does not belong to this collection to be removed.
     */
    public final boolean remove(Sprite sprite) {
        for (int index = 0; index < size; index++)
            if (sprite.equals(elementData[index])) {
                final int numMoved = size - index - 1;

                if(numMoved > 0)
                    System.arraycopy(elementData, index+1, elementData, index, numMoved);

                elementData[--size] = null;
                return true;
            }

        return false;
    }

    /**
     * Clears all sprites from this collection. The collection will be empty.
     */
    public final void clear() {
        for(int i = 0; i < size; i++)
            elementData[i] = null;

        size = 0;
    }

    /**
     * Renders all the sprites in the collection onto the given OpenGL context.
     * @param gl	The OpenGL context.
     */
    public final void render(GL10 gl) {
        for(int i = 0; i < size; i++)
            elementData[i].render(gl);
    }

    /**
     * Advances animation for all sprites in the collection.
     * @param elapsedTime Time elapsed since last frame
     */
    public final void advance(float elapsedTime) {
        for(int i = 0; i < size; i++)
            elementData[i].advanceAnimation(elapsedTime);
    }

    /**
     * Makes sure the capacity of the array is enough and makes room if needed.
     * @param minCapacity	The required capacity.
     */
    private void ensureCapacity(int minCapacity) {
        int oldCapacity = elementData.length;

        if (minCapacity > oldCapacity) {
            int newCapacity = (oldCapacity * 3) / 2 + 1;

            if (newCapacity < minCapacity)
                newCapacity = minCapacity;

            final Sprite[] newElementData = new Sprite[newCapacity];
            System.arraycopy(elementData, 0, newElementData, 0, size);
            elementData = newElementData;
        }
    }
}
