public class StreamingServiceDriver {
    public static void main(String[] args) {
        // Create instances of different media types
        Streamable audioMedia = new Music("Still a Friend - Incognito");
        Streamable filmMedia = new Movie("Avengers End Game");
        Streamable bookMedia = new Audiobook("A Promised Land – Barack Obama");

        // Test the common behaviors for all media types
        System.out.println("Testing common behaviors for all media types:\n");

        // Test Music
        System.out.println("Testing Music:");
        audioMedia.play();   // "Playing music: Still a Friend - Incognito"
        audioMedia.pause();  // "Paused music: Still a Friend - Incognito"
        audioMedia.stop();   // "Stopped music: Still a Friend - Incognito"
        System.out.println();

        // Test Movie
        System.out.println("Testing Movie:");
        filmMedia.play();   // "Playing movie: Avengers End Game"
        filmMedia.pause();  // "Paused movie: Avengers End Game"
        filmMedia.stop();   // "Stopped movie: Avengers End Game"
        System.out.println();

        // Test Audiobook
        System.out.println("Testing Audiobook:");
        bookMedia.play();   // "Playing audiobook: A Promised Land – Barack Obama"
        bookMedia.pause();  // "Paused audiobook: A Promised Land – Barack Obama"
        bookMedia.stop();   // "Stopped audiobook: A Promised Land – Barack Obama"
        System.out.println();

        // Test unique behaviors for each media type
        // For Movie: rollBack
        Movie castedMovie = (Movie) filmMedia; 
        castedMovie.rollBack(30); // "Rewinding movie: Avengers End Game by 30 minutes"
        System.out.println();

        // For Audiobook: adjustPlaybackSpeed
        Audiobook castedAudiobook = (Audiobook) bookMedia;
        castedAudiobook.adjustPlaybackSpeed(1.5); // "Setting playback speed of audiobook: ... 1.5x"
        System.out.println();

        // For Music: pushToPlaylist
        Music castedMusic = (Music) audioMedia;
        castedMusic.pushToPlaylist("Favorites"); // "Added Still a Friend - Incognito to Favorites playlist"
        System.out.println();
    }
}
