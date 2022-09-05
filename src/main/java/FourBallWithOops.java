import processing.core.PApplet;
import processing.core.PConstants;


class Ball{

    PApplet PARENT;
    int DIAMETER, SPEED;
    public Ball(PApplet parent, int diameter, int speed){
        this.PARENT = parent;
        this.DIAMETER = diameter;
        this.SPEED = speed;
    }

    public void drawCircle(float x, float y){
        this.PARENT.ellipse(x, y, this.DIAMETER, this.DIAMETER);
    }

    public static void drawNCircles(float currentX, float currentY, Ball balls[]){

        for(int i = 0; i < balls.length; i++){
            balls[i].drawCircle(currentX*balls[i].SPEED, currentY*(i+1));
        }

    }

}

public class FourBallWithOops extends PApplet{

    Ball balls[];

    int HEIGHT = 480, WIDTH = 640, DIAMETER = 10, NO_OF_BALLS = 4;

    float POSITION_X = 0, POSITION_Y = (float) (HEIGHT/(NO_OF_BALLS+1));

    public static void main(String args[]){
        PApplet.main("FourBallWithOops",args);
        //PApplet.main("Try Processing",args);
    }

    @Override
    public void settings() {
        super.settings();
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        super.setup();
        this.balls = new Ball[NO_OF_BALLS];
        for(int i=0; i<NO_OF_BALLS; i++){
            balls[i] = new Ball(this, DIAMETER, i+1);
        }
    }

    @Override
    public void draw(){
        Ball.drawNCircles(POSITION_X, POSITION_Y, this.balls);
        POSITION_X += 1;
    }
}
