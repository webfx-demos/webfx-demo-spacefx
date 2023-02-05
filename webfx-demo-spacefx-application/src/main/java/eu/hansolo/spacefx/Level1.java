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

//import static com.gluonhq.attach.util.Platform.isDesktop;
//import static com.gluonhq.attach.util.Platform.isIOS;


public class Level1 implements Level {
    public final int          index                   = 1;
    public final Difficulty   difficulty              = Difficulty.EASY;
    public final ScaledImage  backgroundImg = ScaledImage.createBackground("backgroundL1.jpg", 700, 3379);
    public final ScaledImage[] enemyImages = new ScaledImage[]{
            ScaledImage.create("enemy1L1.png", 56, 56),
            ScaledImage.create("enemy2L1.png", 50, 50),
            ScaledImage.create("enemy3L1.png", 68, 68)};
    public final ScaledImage  explosionImg = ScaledImage.create("explosionL1.png", 2048, 1792);
    public final ScaledImage  enemyTorpedoImg = ScaledImage.create("enemyTorpedoL1.png", 21, 21);
    public final ScaledImage  enemyBossImg0 = ScaledImage.create("enemyBoss0L1.png", 100, 100);
    public final ScaledImage  enemyBossImg1 = ScaledImage.create("enemyBoss1L1.png", 100, 100);
    public final ScaledImage  enemyBossImg2 = ScaledImage.create("enemyBoss2L1.png", 100, 100);
    public final ScaledImage  enemyBossImg3 = ScaledImage.create("enemyBoss3L1.png", 100, 100);
    public final ScaledImage  enemyBossImg4 = ScaledImage.create("enemyBoss4L1.png", 100, 100);
    public final ScaledImage  enemyBombImg = ScaledImage.create("enemyBombL1.png", 20, 20);
    public final ScaledImage  enemyBossTorpedoImg = ScaledImage.create("enemyBossTorpedoL1.png", 26, 26);
    public final ScaledImage  enemyBossRocketImg = ScaledImage.create("enemyBossRocketL1.png", 17, 42);
    public final ScaledImage  enemyBossHitImg = ScaledImage.create("torpedoHitL1.png", 400, 160);
    public final ScaledImage  enemyBossExplosionImg = ScaledImage.create("enemyBossExplosionL1.png", 800, 1400);
    public final ScaledImage  enemyRocketExplosionImg = ScaledImage.create("enemyRocketExplosionL1.png", 512, 896);
    public final ScaledImage  levelBossImg = ScaledImage.create("levelBossL1.png", 268, 289);
    public final ScaledImage  levelBossTorpedoImg = ScaledImage.create("levelBossTorpedoL1.png", 35, 60);
    public final ScaledImage  levelBossRocketImg = ScaledImage.create("levelBossRocketL1.png", 15, 37);
    public final ScaledImage  levelBossBombImg = ScaledImage.create("levelBossBombL1.png", 30, 30);
    public final ScaledImage  levelBossExplosionImg = ScaledImage.create("levelBossExplosionL1.png", 2048, 768);


    @Override public int getIndex() { return index; }

    @Override public Difficulty getDifficulty() { return difficulty; }

    @Override public ScaledImage getBackgroundImg() {
        return backgroundImg;
    }

    @Override public ScaledImage[] getEnemyImages() {
        return enemyImages;
    }

    @Override public ScaledImage getEnemyBossImg0() {
        return enemyBossImg0;
    }

    @Override public ScaledImage getEnemyBossImg1() {
        return enemyBossImg1;
    }

    @Override public ScaledImage getEnemyBossImg2() {
        return enemyBossImg2;
    }

    @Override public ScaledImage getEnemyBossImg3() {
        return enemyBossImg3;
    }

    @Override public ScaledImage getEnemyBossImg4() {
        return enemyBossImg4;
    }

    @Override public ScaledImage getEnemyBombImg() {
        return enemyBombImg;
    }

    @Override public ScaledImage getEnemyTorpedoImg() {
        return enemyTorpedoImg;
    }

    @Override public ScaledImage getEnemyBossTorpedoImg() {
        return enemyBossTorpedoImg;
    }

    @Override public ScaledImage getEnemyBossRocketImg() {
        return enemyBossRocketImg;
    }

    @Override public ScaledImage getExplosionImg() {
        return explosionImg;
    }

    @Override public ScaledImage getEnemyBossHitImg() {
        return enemyBossHitImg;
    }

    @Override public ScaledImage getEnemyBossExplosionImg() {
        return enemyBossExplosionImg;
    }

    @Override public ScaledImage getEnemyRocketExplosionImg() {
        return enemyRocketExplosionImg;
    }

    @Override public ScaledImage getLevelBossImg() {
        return levelBossImg;
    }

    @Override public ScaledImage getLevelBossTorpedoImg() {
        return levelBossTorpedoImg;
    }

    @Override public ScaledImage getLevelBossRocketImg() {
        return levelBossRocketImg;
    }

    @Override public ScaledImage getLevelBossBombImg() {
        return levelBossBombImg;
    }

    @Override public ScaledImage getLevelBossExplosionImg() {
        return levelBossExplosionImg;
    }
}
