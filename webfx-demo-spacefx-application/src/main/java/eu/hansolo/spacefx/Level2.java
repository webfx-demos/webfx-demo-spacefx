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


public class Level2 implements Level {
    public final int           index                  = 2;
    public final Difficulty    difficulty             = Difficulty.NORMAL;
    public final ScaledImage   backgroundImg = ScaledImage.createBackground("backgroundL2.jpg", 700, 3379);
    //public final Image      backgroundImg           = isDesktop() ? WebFxUtil.newImage("backgroundL2.jpg"), 700 * BKG_SCALING_FACTOR, 3379 * BKG_SCALING_FACTOR, true, false) : isIOS() ? WebFxUtil.newImage("backgroundL2.jpg"), 700 * BKG_SCALING_FACTOR, 3379 * BKG_SCALING_FACTOR, true, false) : WebFxUtil.newImage("backgroundL2.png"), 700 * BKG_SCALING_FACTOR, 3379 * BKG_SCALING_FACTOR, true, false);
    public final ScaledImage[] enemyImages = new ScaledImage[]{
            ScaledImage.create("enemy1L2.png", 56, 56),
            ScaledImage.create("enemy2L2.png", 50, 50),
            ScaledImage.create("enemy3L2.png", 68, 68),
            ScaledImage.create("enemy4L2.png", 68, 68),
            ScaledImage.create("enemy5L2.png", 68, 68),
            ScaledImage.create("enemy6L2.png", 68, 68)};
    public final ScaledImage   enemyBossImg0 = ScaledImage.create("enemyBoss0L2.png", 100, 100);
    public final ScaledImage   enemyBossImg1 = ScaledImage.create("enemyBoss1L2.png", 100, 100);
    public final ScaledImage   enemyBossImg2 = ScaledImage.create("enemyBoss2L2.png", 100, 100);
    public final ScaledImage   enemyBossImg3 = ScaledImage.create("enemyBoss3L2.png", 100, 100);
    public final ScaledImage   enemyBossImg4 = ScaledImage.create("enemyBoss4L2.png", 100, 100);
    public final ScaledImage   enemyBombImg = ScaledImage.create("enemyBombL2.png", 20, 20);
    public final ScaledImage   enemyTorpedoImg = ScaledImage.create("enemyTorpedoL2.png", 21, 21);
    public final ScaledImage   enemyBossTorpedoImg = ScaledImage.create("enemyBossTorpedoL2.png", 26, 26);
    public final ScaledImage   enemyBossRocketImg = ScaledImage.create("enemyBossRocketL2.png", 17, 42);
    public final ScaledImage   explosionImg = ScaledImage.create("explosionL2.png", 2048, 1792);
    public final ScaledImage   enemyBossHitImg = ScaledImage.create("torpedoHitL2.png", 400, 160);
    public final ScaledImage   enemyBossExplosionImg = ScaledImage.create("enemyBossExplosionL2.png", 800, 1400);
    public final ScaledImage   enemyRocketExplosionImg = ScaledImage.create("enemyRocketExplosionL2.png", 512, 896);
    public final ScaledImage   levelBossImg = ScaledImage.create("levelBossL2.png", 300, 300);
    public final ScaledImage   levelBossTorpedoImg = ScaledImage.create("levelBossTorpedoL2.png", 35, 60);
    public final ScaledImage   levelBossRocketImg = ScaledImage.create("levelBossRocketL2.png", 15, 37);
    public final ScaledImage   levelBossBombImg = ScaledImage.create("levelBossBombL2.png", 30, 30);
    public final ScaledImage   levelBossExplosionImg = ScaledImage.create("levelBossExplosionL2.png", 2048, 768);


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
