package eu.hansolo.spacefx;

import dev.webfx.platform.audio.Audio;
import dev.webfx.platform.audio.AudioService;
import dev.webfx.platform.resource.Resource;
import dev.webfx.platform.scheduler.Scheduler;
import dev.webfx.platform.shutdown.Shutdown;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruno Salmon
 */
final class WebFxUtil {

    private final static String RESOURCE_PATH = "/eu/hansolo/spacefx/";

    static String toResourceUrl(String resourceName) {
        return Resource.toUrl(RESOURCE_PATH + resourceName, WebFxUtil.class);
    }

    static Audio newMusic(String resourceName) {
        return AudioService.loadMusic(Resource.toUrl(resourceName, WebFxUtil.class));
    }

    static Audio newSound(String resourceName) {
        return AudioService.loadSound(Resource.toUrl(resourceName, WebFxUtil.class));
    }

    static Image newImage(String resourceName) {
        return startLoadingImage(new Image(toResourceUrl(resourceName), true));
    }

    static Image newImage(String resourceName, double requestedWidth, double requestedHeight) {
        return startLoadingImage(new Image(toResourceUrl(resourceName), requestedWidth, requestedHeight, true, false, true));
    }

    private static final int MAX_SIMULTANEOUS_LOADING_IMAGES_COUNT = 3;
    private static int loadingImagesCount;
    private static GraphicsContext loadingContext;
    private static final List<Image> toLoadImages = new ArrayList<>();

    static boolean hasImageFinishedLoading(Image image) {
        return image == null || image.getProgress() >= 1;
    }

    private static Image startLoadingImage(Image image) {
        if (!hasImageFinishedLoading(image)) {
            if (loadingContext == null || loadingImagesCount >= MAX_SIMULTANEOUS_LOADING_IMAGES_COUNT) {
                if (!toLoadImages.contains(image))
                    toLoadImages.add(image);
            } else {
                toLoadImages.remove(image);
                loadingImagesCount++;
                //webfx.platform.shared.services.log.Logger.log(loadingImagesCount + " (+1 " + image.getUrl() + ")");
                image.progressProperty().addListener((observableValue, oldProgress, progress) -> {
                    if (progress.doubleValue() == 1) {
                        loadingImagesCount--;
                        //webfx.platform.shared.services.log.Logger.log(loadingImagesCount + " (-1 " + image.getUrl() + ")");
                        doNextLoadingAction();
                    }
                });
                loadingContext.drawImage(image, 50_000, 50_000);  // This will cause the image to load
            }
        }
        return image;
    }

    private static void doNextLoadingAction() {
        if (loadingImagesCount < MAX_SIMULTANEOUS_LOADING_IMAGES_COUNT) {
            for (Image image : new ArrayList<>(toLoadImages))
                startLoadingImage(image);
        }
    }

    public static void setLoadingContext(GraphicsContext loadingContext) {
        WebFxUtil.loadingContext = loadingContext;
        doNextLoadingAction();
    }

    static void onImageLoaded(Image image, Runnable runnable) {
        if (!onImageLoadedIfLoading(image, runnable))
            runnable.run();
    }

    static boolean onImageLoadedIfLoading(Image image, Runnable runnable) {
        if (hasImageFinishedLoading(image))
            return false;
        image.progressProperty().addListener((observableValue, oldProgress, progress) -> {
            if (progress.doubleValue() == 1)
                runnable.run();
        });
        startLoadingImage(image);
        return true;
    }

    static void playMusic(Audio music) {
        music.play();
    }

    static void stopMusic(Audio music) {
        music.stop();
    }

    static void playSound(Audio sound) {
        sound.setVolume(0.5); // SpaceFX sounds are quite loud, so reducing volume (otherwise saturates)
        sound.play();
    }

    static double getImageWidth(Image image) {
        if (image == null)
            return 0;
        double width = image.getWidth();
        if (width <= 0)
            width = image.getRequestedWidth();
        return width;
    }

    static double getImageHeight(Image image) {
        if (image == null)
            return 0;
        double height = image.getHeight();
        if (height <= 0)
            height = image.getRequestedHeight();
        return height;
    }

    static String loadAndGetSpaceBoyFontName() {
        return "Spaceboy";
/*
        try {
            return Font.loadFont(WebFxUtil.class.getResourceAsStream(RESOURCE_PATH + "spaceboy.ttf"), 10).getName();
        } catch (Exception exception) {
            return null;
        }
*/
    }

    static long nanoTime() {
        return Scheduler.nanoTime();
    }

    static void exit(int status) {
/*
        Platform.exit();
        System.exit(status);
*/
        Shutdown.softwareShutdown(true, status);
    }

}
