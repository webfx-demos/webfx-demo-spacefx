// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.demo.spacefx.css {

    // Direct dependencies modules
    requires javafx.graphics;
    requires webfx.platform.boot;

    // Exported packages
    exports eu.hansolo.spacefx.css;

    // Resources packages
    opens eu.hansolo.spacefx.css;

    // Provided services
    provides dev.webfx.platform.boot.spi.ApplicationJob with eu.hansolo.spacefx.css.SpaceFXFontLoader;

}