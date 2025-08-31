package dev.webfx.platform.boot.gwt;

import com.google.gwt.core.client.EntryPoint;
import dev.webfx.platform.boot.ApplicationBooter;
import dev.webfx.platform.boot.spi.ApplicationBooterProvider;
import elemental2.dom.DomGlobal;
import elemental2.dom.ServiceWorkerContainer;

import static dev.webfx.platform.service.gwtj2cl.ServiceRegistry.*;

public final class GwtEntryPoint implements ApplicationBooterProvider, EntryPoint {

    @Override
    public void onModuleLoad() {
        registerPwa();
        registerArrayConstructors();
        registerServiceProviders();
        ApplicationBooter.start(this, null);
    }

    private static void registerArrayConstructors() {

    }

    private static void registerServiceProviders() {
        register(dev.webfx.kit.launcher.spi.WebFxKitLauncherProvider.class, dev.webfx.kit.launcher.spi.impl.gwtj2cl.GwtJ2clWebFxKitLauncherProvider::new);
        register(dev.webfx.kit.mapper.peers.javafxmedia.spi.WebFxKitMediaMapperProvider.class, dev.webfx.kit.mapper.peers.javafxmedia.spi.gwtj2cl.GwtJ2clWebFxKitMediaMapperProvider::new);
        register(dev.webfx.kit.mapper.spi.WebFxKitMapperProvider.class, dev.webfx.kit.mapper.spi.impl.gwtj2cl.GwtJ2clWebFxKitHtmlMapperProvider::new);
        register(dev.webfx.platform.boot.spi.ApplicationModuleBooter.class, dev.webfx.kit.launcher.WebFxKitLauncherModuleBooter::new, dev.webfx.platform.boot.spi.impl.ApplicationJobsInitializer::new, dev.webfx.platform.boot.spi.impl.ApplicationJobsStarter::new, dev.webfx.platform.resource.spi.impl.gwt.GwtResourceModuleBooter::new);
        register(dev.webfx.platform.console.spi.ConsoleProvider.class, dev.webfx.platform.console.spi.impl.gwtj2cl.GwtJ2clConsoleProvider::new);
        register(dev.webfx.platform.os.spi.OperatingSystemProvider.class, dev.webfx.platform.os.spi.impl.gwtj2cl.GwtJ2clOperatingSystemProvider::new);
        register(dev.webfx.platform.resource.spi.ResourceProvider.class, dev.webfx.platform.resource.spi.impl.gwt.GwtResourceProvider::new);
        register(dev.webfx.platform.resource.spi.impl.gwt.GwtResourceBundle.class, dev.webfx.platform.resource.gwt.GwtEmbedResourcesBundle.ProvidedGwtResourceBundle::new);
        register(dev.webfx.platform.scheduler.spi.SchedulerProvider.class, dev.webfx.platform.uischeduler.spi.impl.gwtj2cl.GwtJ2clUiSchedulerProvider::new);
        register(dev.webfx.platform.shutdown.spi.ShutdownProvider.class, dev.webfx.platform.shutdown.spi.impl.gwtj2cl.GwtJ2clShutdownProvider::new);
        register(dev.webfx.platform.storage.spi.LocalStorageProvider.class, dev.webfx.platform.storage.spi.impl.gwtj2cl.GwtJ2clLocalStorageProvider::new);
        register(dev.webfx.platform.storage.spi.SessionStorageProvider.class, dev.webfx.platform.storage.spi.impl.gwtj2cl.GwtJ2clSessionStorageProvider::new);
        register(dev.webfx.platform.uischeduler.spi.UiSchedulerProvider.class, dev.webfx.platform.uischeduler.spi.impl.gwtj2cl.GwtJ2clUiSchedulerProvider::new);
        register(dev.webfx.platform.useragent.spi.UserAgentProvider.class, dev.webfx.platform.useragent.spi.impl.gwtj2cl.GwtJ2clUserAgentProvider::new);
        register(dev.webfx.platform.visibility.spi.VisibilityProvider.class, dev.webfx.platform.visibility.spi.impl.gwtj2cl.GwtJ2clVisibilityProvider::new);
        register(javafx.application.Application.class, eu.hansolo.spacefx.SpaceFX::new);
    }

    private static void registerPwa() {
        boolean pwa = true;
        ServiceWorkerContainer serviceWorker = DomGlobal.navigator.serviceWorker;
        if (serviceWorker == null) {
            if (pwa)
                DomGlobal.console.warn("❌ PWA service worker registration failed: not supported in this browser or context");
        } else {
            String pwaScriptURL = "./webfx-pwa-service-worker.js";
            if (!pwa) {
                serviceWorker.getRegistrations()
                    .then(registrations -> {
                        registrations.forEach((registration, i) -> registration.unregister());
                        return null;
                    });
            } else {
                serviceWorker.register(pwaScriptURL)
                    .then(registration -> {
                        DomGlobal.console.log("✅ PWA service worker registered");
                        return null;
                    })
                    .catch_(error -> {
                        DomGlobal.console.warn("❌ PWA service worker registration failed: " + error);
                        return null;
                    });
                DomGlobal.window.addEventListener("beforeinstallprompt", event -> {
                    dev.webfx.kit.mapper.peers.javafxgraphics.gwtj2cl.html.UserInteraction.runOnNextUserInteraction(() -> installPWA(event));
                });
                DomGlobal.window.addEventListener("appinstalled", event -> {

                });
            }
        }
    }

    private static native void installPWA(elemental2.dom.Event e) /*-{
        e.prompt();
    }-*/;

}