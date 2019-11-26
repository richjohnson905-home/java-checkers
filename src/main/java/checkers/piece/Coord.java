package checkers.piece;

public class Coord {
    int i;
    int j;

    public Coord(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || obj.getClass() != this.getClass())
            return false;

        Coord c = (Coord) obj;
        return (c.i == this.i && c.j == this.j);
    }

    @Override
    public int hashCode() {
        return this.i + this.j;
    }
}