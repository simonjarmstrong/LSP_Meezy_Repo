public class Audiobook implements Streamable {
    private String storyTitle;  // Renamed from "bookTitle"

    public Audiobook(String storyTitle) {
        this.storyTitle = storyTitle;
    }

    @Override
    public void play() {
        System.out.println("Playing audiobook: " + storyTitle);
    }

    @Override
    public void pause() {
        System.out.println("Paused audiobook: " + storyTitle);
    }

    @Override
    public void stop() {
        System.out.println("Stopped audiobook: " + storyTitle);
    }

    // Unique method renamed from "setPlaybackSpeed"
    public void adjustPlaybackSpeed(double pace) {
        System.out.println("Setting playback speed of audiobook: " + storyTitle + " to " + pace + "x");
    }
}
