package eu.hansolo.spacefx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * All images in the original game are replaced with this class as a workaround to a crash issue on iOS. On iOS indeed,
 * loading a scaled image with new Image(url, requestedWidth, requestedHeight) is crashing. So what we do instead, we
 * always load the image in its original size, and we apply the scaling factor at the drawing time (this class also
 * provide drawing methods to help with this).
 *
 * @author Bruno Salmon
 */
public final class ScaledImage {
    private final Image image; // image in its original size
    private final double originalWidth;
    private final double originalHeight;

    private final double scalingFactor;
    private final double width; // final requested scaled width
    private final double height; // final requested scaled height

    public ScaledImage(String imageResourcePath, double naturalWidth, double naturalHeight, double scalingFactor) {
        this(WebFxUtil.newImage(imageResourcePath), naturalWidth, naturalHeight, scalingFactor);
    }

    public ScaledImage(Image image, double originalWidth, double naturalHeight, double scalingFactor) {
        this.image = image;
        this.originalWidth = originalWidth;
        this.originalHeight = naturalHeight;
        this.scalingFactor = scalingFactor;
        this.width = originalWidth * scalingFactor;
        this.height = naturalHeight * scalingFactor;
    }

    public Image getImage() {
        return image;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void drawImage(GraphicsContext ctx) {
        drawImage(ctx, 0, 0);
    }

    public void drawImage(GraphicsContext ctx, double x, double y) {
        ctx.drawImage(image, x, y, width, height);
    }

    public void drawImage(GraphicsContext ctx, double sx, double sy, double dx, double dy) {
        ctx.drawImage(image, sx / scalingFactor, sy / scalingFactor, originalWidth, originalHeight, dx, dy, width, height);
    }

    public void drawFrame(GraphicsContext ctx, double frameWidth, double frameHeight, int frameCountX, double frameCountY, double x, double y, double scale) {
        double naturalFrameWidth = frameWidth / scalingFactor, naturalFrameHeight = frameHeight / scalingFactor;
        ctx.drawImage(image, naturalFrameWidth * frameCountX, naturalFrameHeight * frameCountY, naturalFrameWidth, naturalFrameHeight, x, y, frameWidth * scale, frameHeight * scale);
    }

    static ScaledImage create(String imageResource, double naturalWidth, double naturalHeight, double scalingFactor) {
        return new ScaledImage(imageResource, naturalWidth, naturalHeight, scalingFactor);
    }

    static ScaledImage create(String imageResource, double naturalWidth, double naturalHeight) {
        return create(imageResource, naturalWidth, naturalHeight, Config.SCALING_FACTOR);
    }

    static ScaledImage createBackground(String imageResource, double naturalWidth, double naturalHeight) {
        return create(imageResource, naturalWidth, naturalHeight, Config.BKG_SCALING_FACTOR);
    }
}
