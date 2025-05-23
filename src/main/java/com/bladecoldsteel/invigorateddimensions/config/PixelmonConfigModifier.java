package com.bladecoldsteel.invigorateddimensions.config;

import com.bladecoldsteel.invigorateddimensions.config.configscreens.PixelmonConfigNoticeScreen;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Map;

public class PixelmonConfigModifier {

    public static void updatePixelmonConfig(File configDir) {
        if (!InvigoratedDimensionsConfig.SPAWN_REPLACEMENT.get()) {
            System.out.println("[InvigoratedDimensions] Skipped Pixelmon config update (config disabled or already changed).");
            return;
        }

        File pixelmonFile = new File(configDir, "pixelmon/config.yml");

        if (!pixelmonFile.exists()) {
            System.err.println("[InvigoratedDimensions] Pixelmon config not found.");
            return;
        }

        try {
            Yaml yaml = new Yaml();
            InputStream input = new FileInputStream(pixelmonFile);
            Map<String, Object> data = yaml.load(input);
            input.close();

            if (data == null || Boolean.TRUE.equals(data.get("allow-vanilla-mobs"))) {
                System.err.println("[InvigoratedDimensions] Pixelmon config.yml is empty or invalid.");
                return;
            }

            data.put("allow-vanilla-mobs", true);

            DumperOptions options = new DumperOptions();
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            options.setPrettyFlow(true);
            Yaml yamlWriter = new Yaml(options);

            FileWriter writer = new FileWriter(pixelmonFile);
            yamlWriter.dump(data, writer);
            writer.close();

            System.out.println("[InvigoratedDimensions] Updated allow-vanilla-mobs = true in config.yml");

            MinecraftForge.EVENT_BUS.register(PixelmonConfigModifier.class);

        } catch (Exception e) {
            System.err.println("[InvigoratedDimensions] Failed to update config.yml:");
            e.printStackTrace();
        }
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        Minecraft mc = Minecraft.getInstance();

        if (!(mc.screen instanceof PixelmonConfigNoticeScreen)) {
            mc.setScreen(new PixelmonConfigNoticeScreen());
            MinecraftForge.EVENT_BUS.unregister(PixelmonConfigModifier.class);
            System.out.println("[InvigoratedDimensions] Showing config screen.");
        }
    }

}
