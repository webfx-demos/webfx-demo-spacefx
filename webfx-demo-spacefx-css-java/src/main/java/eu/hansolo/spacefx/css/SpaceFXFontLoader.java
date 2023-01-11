package eu.hansolo.spacefx.css;

import dev.webfx.platform.boot.spi.ApplicationJob;
import javafx.scene.text.Font;

/**
 * @author Bruno Salmon
 */
public final class SpaceFXFontLoader implements ApplicationJob {

    @Override
    public void onStart() {
        Font.loadFont(getClass().getResourceAsStream("spaceboy.ttf"), 16);
    }
}
