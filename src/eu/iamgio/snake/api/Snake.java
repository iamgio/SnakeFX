package eu.iamgio.snake.api;

import eu.iamgio.snake.game.Main;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

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

    private Rectangle[] parts = new Rectangle[length];

    Snake()
    {
        game = Main.getGame();
    }

    /**
     * Spawns the snake
     */
    void spawn()
    {
        x = 300; y = 200;
        snake = new Rectangle(x, y, 30, 30);
        snake.setFill(Paint.valueOf("FFF"));
        snake.setStrokeWidth(0);
        snake.setId("snake_head");
        game.getRoot().getChildren().add(snake);

        parts[0] = snake;

        setLength(length);
    }

    /**
     * Moves the snake
     */
    public void move()
    {
        final double X_PER_MS = 5;

        for(Rectangle part : parts)
        {
            switch(direction)
            {
                case NORTH:
                    part.setY(part.getY() + X_PER_MS);
                case SOUTH:
                    part.setY(part.getY() - X_PER_MS);
                case WEST:
                    part.setX(part.getX() - X_PER_MS);
                case EAST:
                    part.setX(part.getX() + X_PER_MS);
            }
        }

        x = snake.getX(); y = snake.getY();
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
        parts = new Rectangle[length];

        parts[0] = snake;

        for(int i = 1; i<length; i++)
        {
            Rectangle part = new Rectangle(snake.getX(), snake.getY(), 30, 30);
            part.setFill(Paint.valueOf("FFF"));
            part.setStrokeWidth(0);
            part.setId("snakepart_" + i);

            switch(direction)
            {
                case NORTH: part.setY(part.getY() - (30 * i));
                case SOUTH: part.setY(part.getY() + (30 * i));
                case WEST: part.setX(part.getX() + (30 * i));
                case EAST: part.setX(part.getX() - (30 * i));
            }

            parts[i] = part;
            game.getRoot().getChildren().add(part);
        }
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
    public Rectangle[] getParts()
    {
        return parts;
    }
}
