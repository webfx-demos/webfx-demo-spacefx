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

public interface Level {

    int getIndex();

    Difficulty getDifficulty();

    ScaledImage getBackgroundImg();

    ScaledImage[] getEnemyImages();

    ScaledImage getEnemyBossImg0();

    ScaledImage getEnemyBossImg1();

    ScaledImage getEnemyBossImg2();

    ScaledImage getEnemyBossImg3();

    ScaledImage getEnemyBossImg4();

    ScaledImage getEnemyBombImg();

    ScaledImage getEnemyTorpedoImg();

    ScaledImage getEnemyBossTorpedoImg();

    ScaledImage getEnemyBossRocketImg();

    ScaledImage getExplosionImg();

    ScaledImage getEnemyBossHitImg();

    ScaledImage getEnemyBossExplosionImg();

    ScaledImage getEnemyRocketExplosionImg();

    ScaledImage getLevelBossImg();

    ScaledImage getLevelBossTorpedoImg();

    ScaledImage getLevelBossRocketImg();

    ScaledImage getLevelBossBombImg();

    ScaledImage getLevelBossExplosionImg();
}
