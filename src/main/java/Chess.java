import java.util.Random;

class Point {
    private int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // todo do we need this
    @Override
    public boolean equals(Object o) {
        if (o instanceof Point) {
            Point po = (Point) o;
            return this.x == po.x && this.y == po.y;
        }
        return false;
    }
}

// todo use abstract class ?
interface User {
    void move(Figure[][] filed);
}

class Human implements User {
    private String name;
    private boolean isWhite;

    Human(String name, boolean isWhite) {
        this.name = name;
        this.isWhite = isWhite;
    }

    String getName() {
        return this.name;
    }

    public void move(Figure[][] filed) {
        // move request
    }

}

class AI implements User {
    private String name;
    private boolean isWhite;

    AI(boolean isWhite) {
        this.name = "AI";
        this.isWhite = isWhite;
    }

    String getName() {
        return this.name;
    }

    public void move(Figure[][] filed) {
        // calculate best move
    }

}

interface Figure {
    boolean isValidMove(Point position, Point newPosition);
}

// ... King, Queen, Knight, Rook, Pawn, Bishop
class King implements Figure {
    private boolean isWhite;

    King(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isValidMove(Point position, Point newPosition) {
        return true;
    }
}

class Game {
    private final static int size = 8;
    private User[] players;
    private Figure[][] field;

    Game(String username, boolean isWhite) {
        initWithAI(username, isWhite);
    }

    Game(String username) {
        Random r = new Random();
        boolean isWhite = r.nextBoolean();
        initWithAI(username, isWhite);
    }

    Game(String username1, String username2) {
        Random r = new Random();
        boolean isWhite = r.nextBoolean();
        init(username1, isWhite, username2);
    }

    Game(String username1, boolean isWhite, String username2) {
        init(username1, isWhite, username2);
    }

    private void initWithAI(String username, boolean isWhite) {
        players = new User[2];
        if (isWhite) {
            players[0] = new Human(username, true);
            players[1] = new AI(false);
        } else {
            players[0] = new AI(true);
            players[1] = new Human(username, false);
        }
        initField();
    }

    private void init(String username1, boolean isWhite, String username2) {
        players = new User[2];
        if (isWhite) {
            players[0] = new Human(username1, true);
            players[1] = new Human(username2, false);
        } else {
            players[0] = new Human(username2, true);
            players[1] = new Human(username1, false);
        }
        initField();
    }

    private void initField() {
        this.field = new Figure[size][size];
        field[1][1] = new King(true);
        // ...
    }

    void play() {
        boolean i = false;
        while (!isFinished()) {
            i = !i;
            players[(i) ? 1 : 0].move(field);
        }
    }

    private boolean isFinished() {
        return true;
    }
}

public class Chess {

    public static void main(String[] args) {
        Game game = new Game("Katya");
        game.play();
    }
}
