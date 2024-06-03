/*
 * Copyright (c) 2020 by Gerrit Grunwald
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.hansolo.spacefx;

import dev.webfx.kit.util.scene.DeviceSceneUtil;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public final class SpaceFX extends Application {

    public static double WINDOW_WIDTH = 700, WINDOW_HEIGHT = 900; // Default dimensions for desktops

    private SpaceFXView view;

    @Override
    public void start(Stage stage) {

        Scene scene = DeviceSceneUtil.newScene(new Pane(), WINDOW_WIDTH, WINDOW_HEIGHT, Color.BLACK);
        stage.setScene(scene);
        // Reading back the real window size in case we run in the browser
        WINDOW_HEIGHT = scene.getHeight();
        WINDOW_WIDTH = Math.min(scene.getWidth(), WINDOW_HEIGHT / 900 * 700);
        // Note: Config will consider these variables during initialization

        // Now that config is ready, we can instantiate SpaceFXView and make it as root
        scene.setRoot(view = new SpaceFXView(stage));

        //scene.getStylesheets().add(WebFXUtil.toResourceUrl("css/spacefx.css")); // replaced by WebFX CSS

        scene.setOnKeyPressed(e -> {
            view.onKeyPressed(e.getCode(), e.getText());
            view.userInteracted();
        });
        scene.setOnKeyReleased(e -> {
            view.onKeyReleased(e.getCode());
        });

        scene.setOnMouseClicked(e -> {
            view.userInteracted();
            view.onKeyPressed(KeyCode.SPACE, " ");
            view.onKeyReleased(KeyCode.SPACE);
        });

        stage.setTitle("SpaceFX");
        stage.show();
    }

    @Override
    public void stop() {
        WebFXUtil.exit(0);
    }
}
