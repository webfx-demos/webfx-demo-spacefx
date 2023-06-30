package eu.hansolo.spacefx;

import dev.webfx.platform.resource.Resource;
import dev.webfx.platform.shutdown.Shutdown;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * @author Bruno Salmon
 */
final class WebFXUtil {

    static String toResourceUrl(String resourceName) {
        return Resource.toUrl(resourceName, WebFXUtil.class);
    }

    static MediaPlayer newMusic(String resourceName) {
        return new MediaPlayer(new Media(toResourceUrl(resourceName)));
    }

    static AudioClip newSound(String resourceName) {
        return new AudioClip(toResourceUrl(resourceName));
    }

    static void setLooping(MediaPlayer audio, boolean looping) {
        if (audio != null)
            audio.setCycleCount(looping ? AudioClip.INDEFINITE : 1);
    }

    static void setVolume(AudioClip audio, double volume) {
        if (audio != null)
            audio.setVolume(volume);
    }

    static void playMusic(MediaPlayer music) {
        if (music != null)
            music.play();
    }

    static void pauseMusic(MediaPlayer music) {
        if (music != null)
            music.pause();
    }

    static void stopMusic(MediaPlayer music) {
        if (music != null)
            music.stop();
    }

    static void playSound(AudioClip sound) {
        if (sound != null)
            sound.play();
    }

    static Image newImage(String resourceName) {
        return new Image(toResourceUrl(resourceName), true);
    }

    static void onImageLoaded(Image image, Runnable runnable) {
        if (!onImageLoadedIfLoading(image, runnable))
            runnable.run();
    }

    static boolean hasImageFinishedLoading(Image image) {
        return image == null || image.getProgress() >= 1;
    }

    static boolean onImageLoadedIfLoading(Image image, Runnable runnable) {
        if (hasImageFinishedLoading(image))
            return false;
        image.progressProperty().addListener((observableValue, oldProgress, progress) -> {
            if (progress.doubleValue() == 1)
                runnable.run();
        });
        return true;
    }

    static void exit(int status) {
        Shutdown.softwareShutdown(true, status);
    }

}
