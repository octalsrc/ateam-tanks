/*
 * A tank.
 *
 * Not sure why I called it SimpleTank -- I did not
 * have a more complicated form in mind
 * (it might get renamed to Tank)
 */

import java.util.ArrayList;
import java.awt.*;
import java.awt.geom.*;

class SimpleTank extends Sprite
{
    private double speed; //how far a frame of MoveOrder will move the tank
    private double handling; //how far a frame of TurnOrder will turn the tank
    private OrderQueue orders;

    public SimpleTank ( ArrayList<Sprite> sprites, Vector3D position, Direction direction, double speed, double handling )
    {
        super ( sprites, position, direction, new HitBox ( 10, 5, 5 ) );
        this.speed = speed;
        this.handling = handling;
        OrderQueue orders = new OrderQueue ();
    }
    
    public void giveOrders ( OrderQueue newOrders )
    {
        orders = newOrders;
    }

    public double getSpeed ()
    {
        return speed;
    }
    public double getHandling ()
    {
        return handling;
    }

    public int update ()
    {
        orders.exec( this );
        return 0;
    }
    public void paint(Graphics2D g){
        double radius=100;
        g.setColor(Color.red);
        g.fill(Sprite.getCircle(p.getX(),p.getY(),radius));
        g.setColor(Color.blue);
        double direction=d.getValue()*Math.PI/180;
        g.draw(new Line2D.Double(p.getX(),p.getY(),p.getX()+Math.cos(direction)*radius,
                                                   p.getY()+Math.sin(direction)*radius));
    }
    
}