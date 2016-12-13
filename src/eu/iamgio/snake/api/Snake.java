package eu.iamgio.snake.api;

import eu.iamgio.snake.game.Main;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

/**
 * Created by Gio on 09/12/2016.
 */
public class Snake
{
    private int length = 1;
    private Direction direction = Direction.EAST;

    private Game game;
    private Rectangle snake;

    private double x, y;

    private int points = 0;

    private ArrayList<SnakePart> parts = new ArrayList<>();

    Snake()
    {
        game = Main.getGame();
    }

    /**
     * Spawns the snake
     */
    void spawn()
    {
        x = 300;
        y = 200;

        SnakePart initial = new SnakePart(this, true);
        snake = initial.getValue();
        parts.add(initial);
    }

    /**
     * Moves the snake
     */
    public void move()
    {
        final double DISTANCE_PER_MS = 5;

        switch(direction)
        {
            case NORTH:
                snake.setY(snake.getY() - DISTANCE_PER_MS);
                break;
            case SOUTH:
                snake.setY(snake.getY() + DISTANCE_PER_MS);
                break;
            case WEST:
                snake.setX(snake.getX() - DISTANCE_PER_MS);
                break;
            case EAST:
                snake.setX(snake.getX() + DISTANCE_PER_MS);
                break;
        }

        x = snake.getX();
        y = snake.getY();
    }

    /**
     * @return Snake's length
     */
    public int getLength()
    {
        return length;
    }

    /**
     * Sets the length
     * @param length Length
     */
    public void setLength(int length)
    {
        this.length = length;
    }

    /**
     * Adds a part
     */
    public void addPart()
    {
        parts.add(new SnakePart(this, false));
        length++;
    }

    /**
     * @return Snake's direction
     */
    public Direction getDirection()
    {
        return direction;
    }

    /**
     * Sets the direction
     * @param direction Direction
     */
    public void setDirection(Direction direction)
    {
        if(length > 1)
            if(
                 (this.direction == Direction.NORTH && direction == Direction.SOUTH) ||
                 (this.direction == Direction.SOUTH && direction == Direction.NORTH) ||
                 (this.direction == Direction.EAST && direction == Direction.WEST) ||
                 (this.direction == Direction.WEST && direction == Direction.EAST)
              )
                return;

        this.direction = direction;
    }

    /**
     * @return x
     */
    public double getX()
    {
        return x;
    }

    /**
     * @return y
     */
    public double getY()
    {
        return y;
    }

    /**
     * @return Snake's points
     */
    public int getPoints()
    {
        return points;
    }

    /**
     * Sets the points
     * @param points Points
     */
    public void setPoints(int points)
    {
        this.points = points;
    }

    /**
     * @return Snake's parts
     */
    public ArrayList<SnakePart> getParts()
    {
        return parts;
    }

    /**
     * @return The last part
     */
    public SnakePart getLastPart()
    {
        return getParts().get(getParts().size() - 1);
    }
}
