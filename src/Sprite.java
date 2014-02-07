/*
 * This is a general class for anything that might
 * be placed, removed, or move or change in any way
 * on the field during play. The idea is that the main
 * game loop can iterate over a list of these and update
 * each one.
 * And then the graphical interface can iterate over the list
 * and display each one.
 *
 * So far only tanks use them, but the next obvious user would
 * be a bullet
 */

import java.util.ArrayList;

public abstract class Sprite
{
    ArrayList<Sprite> sprites;
    protected Vector3D p;
    protected Direction d;
    protected HitBox h;

    public Sprite ( ArrayList<Sprite> sprites, Vector3D p, Direction d, HitBox h )
    {
        this.sprites = sprites;
        this.sprites.add ( this );

        this.p = new Vector3D ( p );
        this.d = new Direction ( d );
        this.h = new HitBox ( h );
    }

    public abstract int update ();

    public boolean checkCollision ( Sprite other )
    {
        //TODO
        return false;
    }
    public ArrayList<Sprite> getAllCollisions ()
    {
        ArrayList<Sprite> collisions = new ArrayList<Sprite>();
        for ( Sprite sprite : this.sprites )
        {
            collisions.add ( sprite );
        }
        
        return collisions;
    }

    public HitBox getHitBox ()
    {
        return h;
    }
    public void setHitBox ( HitBox other )
    {
        h = new HitBox ( other );
    }
    public Vector3D getPosition ()
    {
        return p;
    }
    public void setPosition ( Vector3D p )
    {
        this.p = p;
    }
    public Direction getDirection ()
    {
        return d;
    }
    public void setDirection ( Direction d )
    {
        this.d = d;
    }

    public void kill ()
    {
        sprites.remove ( this );
    }
}
