public class Music implements Streamable {
    private String audioTrack;  // Renamed from "trackName"

    public Music(String audioTrack) {
        this.audioTrack = audioTrack;
    }

    @Override
    public void play() {
        System.out.println("Playing music: " + audioTrack);
    }

    @Override
    public void pause() {
        System.out.println("Paused music: " + audioTrack);
    }

    @Override
    public void stop() {
        System.out.println("Stopped music: " + audioTrack);
    }

    // Unique method renamed from "addToPlaylist"
    public void pushToPlaylist(String playlistTitle) {
        System.out.println("Added " + audioTrack + " to " + playlistTitle + " playlist");
    }
}
