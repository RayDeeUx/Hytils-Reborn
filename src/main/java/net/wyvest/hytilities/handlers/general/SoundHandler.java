/*
 * Hytilities Reborn - Hypixel focused Quality of Life mod.
 * Copyright (C) 2021  W-OVERFLOW
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package net.wyvest.hytilities.handlers.general;

import gg.essential.api.EssentialAPI;
import net.minecraft.block.BlockTNT;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.wyvest.hytilities.Hytilities;
import net.wyvest.hytilities.config.HytilitiesConfig;

public class SoundHandler {

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent e) {
        if (e.phase == TickEvent.Phase.START) {
            if (EssentialAPI.getMinecraftUtil().isHypixel() && Minecraft.getMinecraft().thePlayer != null && Minecraft.getMinecraft().theWorld != null && Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem() != null) {
                if (HytilitiesConfig.blockNotify && !Hytilities.INSTANCE.getLobbyChecker().playerIsInLobby()) {
                    if (Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem().getItem() instanceof ItemBlock && !(((ItemBlock) Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem().getItem()).block instanceof BlockTNT)) {
                        if (Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem().stackSize <= HytilitiesConfig.blockNumber && Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem().stackSize > 4) {
                            playSound();
                        }
                    }
                }
            }
        }
    }

    public void playSound() {
        if (!Minecraft.getMinecraft().playerController.gameIsSurvivalOrAdventure()) return;
        switch (HytilitiesConfig.blockNotifySound) {
            case 0:
                Minecraft.getMinecraft().thePlayer.playSound("random.orb", 1f, 1f);
                break;
            case 1:
                Minecraft.getMinecraft().thePlayer.playSound("mob.irongolem.hit", 1f, 1f);
                break;
            case 2:
                Minecraft.getMinecraft().thePlayer.playSound("mob.blaze.hit", 1f, 1f);
                break;
            case 3:
                Minecraft.getMinecraft().thePlayer.playSound("random.anvil_land", 1f, 1f);
                break;
            case 4:
                Minecraft.getMinecraft().thePlayer.playSound("mob.horse.death", 1f, 1f);
                break;
            case 5:
                Minecraft.getMinecraft().thePlayer.playSound("mob.ghast.scream", 1f, 1f);
                break;
            case 6:
                Minecraft.getMinecraft().thePlayer.playSound("mob.guardian.land.hit", 1f, 1f);
                break;
            case 7:
                Minecraft.getMinecraft().thePlayer.playSound("mob.cat.meow", 1f, 1f);
                break;
            case 8:
                Minecraft.getMinecraft().thePlayer.playSound("mob.wolf.bark", 1f, 1f);
        }
    }
}
