// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.demo.spacefx.application {

    // Direct dependencies modules
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.media;
    requires webfx.kit.util.scene;
    requires webfx.platform.resource;
    requires webfx.platform.scheduler;
    requires webfx.platform.shutdown;
    requires webfx.platform.storage;
    requires webfx.platform.useragent;
    requires webfx.platform.util;
    requires webfx.platform.visibility;
    requires jdk.jconsole;
    requires webfx.platform.console;

    // Exported packages
    exports eu.hansolo.spacefx;

    // Resources packages
    opens eu.hansolo.spacefx;

    // Provided services
    provides javafx.application.Application with eu.hansolo.spacefx.SpaceFX;

}