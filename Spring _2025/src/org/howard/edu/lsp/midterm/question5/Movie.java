public class Movie implements Streamable {
    private String filmTitle;  // Renamed from "title"

    public Movie(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    @Override
    public void play() {
        System.out.println("Playing movie: " + filmTitle);
    }

    @Override
    public void pause() {
        System.out.println("Paused movie: " + filmTitle);
    }

    @Override
    public void stop() {
        System.out.println("Stopped movie: " + filmTitle);
    }

    // Unique method renamed from "rewind"
    public void rollBack(int minutes) {
        System.out.println("Rewinding movie: " + filmTitle + " by " + minutes + " minutes");
    }
}
