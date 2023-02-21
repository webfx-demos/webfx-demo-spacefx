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


import javafx.scene.paint.Color;

public enum Difficulty {
    EASY(5, 0, Color.web("#3AFE15")), // flashy green
    RELAX(7, 1, Color.YELLOWGREEN),
    FOCUS(10, 2, Color.YELLOW),
    ADVANCED(15, 7, Color.WHITE),
    PRO(20, 10, Color.CYAN),
    HERO(30, 12, Color.ORANGE),
    KING(40, 15, Color.GOLD),
    NINJA(50, 17, Color.ORANGERED),
    JEDI(75, 20, Color.RED),
    NEO(100, 30, Color.BLACK);

    public final int noOfEnemies;
    public final int noOfSmartEnemies;

    public final Color color;

    Difficulty(final int noOfEnemies, final int noOfSmartEnemies, Color color) {
        this.noOfEnemies      = noOfEnemies;
        this.noOfSmartEnemies = noOfSmartEnemies;
        this.color = color;
    }
}
