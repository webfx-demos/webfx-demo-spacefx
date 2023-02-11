package eu.hansolo.spacefx;

import dev.webfx.platform.audio.Audio;
import dev.webfx.platform.audio.AudioService;
import dev.webfx.platform.resource.Resource;
import dev.webfx.platform.scheduler.Scheduler;
import dev.webfx.platform.shutdown.Shutdown;
import javafx.scene.image.Image;

/**
 * @author Bruno Salmon
 */
final class WebFxUtil {

    static String toResourceUrl(String resourceName) {
        return Resource.toUrl(resourceName, WebFxUtil.class);
    }

    static Audio newMusic(String resourceName) {
        return AudioService.loadMusic(toResourceUrl(resourceName));
    }

    static Audio newSound(String resourceName) {
        return AudioService.loadSound(toResourceUrl(resourceName));
    }

    static void setLooping(Audio audio, boolean looping) {
        if (audio != null)
            audio.setLooping(looping);
    }

    static void setVolume(Audio audio, double volume) {
        if (audio != null)
            audio.setVolume(volume);
    }

    static void playMusic(Audio music) {
        if (music != null)
            music.play();
    }

    static void pauseMusic(Audio music) {
        if (music != null)
            music.pause();
    }

    static void stopMusic(Audio music) {
        if (music != null)
            music.stop();
    }

    static void playSound(Audio sound) {
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

    static boolean stopWatchPaused;
    private static long stopWatchPauseNanoTime, stopWatchPauseNanoDuration;

    static boolean isStopWatchPaused() {
        return stopWatchPaused;
    }

    static void pauseStopWatch() {
        if (!stopWatchPaused) {
            stopWatchPauseNanoTime = Scheduler.nanoTime();
            stopWatchPaused = true;
        }
    }

    static void resumeStopWatch() {
        if (stopWatchPaused) {
            stopWatchPauseNanoDuration += Scheduler.nanoTime() - stopWatchPauseNanoTime;
            stopWatchPaused = false;
        }
    }

    static long nanoTime() {
        if (stopWatchPaused)
            return stopWatchPauseNanoTime;
        return Scheduler.nanoTime() - stopWatchPauseNanoDuration;
    }

    static void exit(int status) {
/*
        Platform.exit();
        System.exit(status);
*/
        Shutdown.softwareShutdown(true, status);
    }

}
