package me.qKing12.AuctionMaster.Utils;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.qKing12.AuctionMaster.AuctionMaster;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;
import static me.qKing12.AuctionMaster.Utils.HeadDatabase.headApi;




public class SkullTexture {

    private static final Pattern URL_PATTERN = Pattern.compile("\"url\"\\s*:\\s*\"([^\"]+)\"");

    /**
     * takes base64 texture value, textures.minecraft.net url or just the texture hash
     */
    private static String skinUrl(String texture) {
        if (texture.startsWith("http"))
            return texture;
        try {
            final String json = new String(Base64.getDecoder().decode(texture), StandardCharsets.UTF_8);
            final Matcher matcher = URL_PATTERN.matcher(json);
            if (matcher.find())
                return matcher.group(1);
        } catch (IllegalArgumentException ignored) {
        }
        return "https://textures.minecraft.net/texture/" + texture;
    }

    public static ItemStack getSkull(String texture) {
        texture=texture.replace(" ", "");
        if(texture.length()>16) {
            try {
                ItemStack skull;
                if(AuctionMaster.upperVersion) {
                    skull = new ItemStack(Material.getMaterial("PLAYER_HEAD"), 1);
                }
                else {
                    skull = new ItemStack(Material.getMaterial("SKULL_ITEM"), 1, (short) 3);
                }

                final SkullMeta meta = (SkullMeta) skull.getItemMeta();
                try {
                    // old authlib reflection breaks on 26.x (GameProfile is a record now) so using bukkit profile api
                    final PlayerProfile profile = Bukkit.createPlayerProfile(UUID.randomUUID(), UUID.randomUUID().toString().substring(0, 16).replace("-", ""));
                    final PlayerTextures textures = profile.getTextures();
                    textures.setSkin(new URL(skinUrl(texture)));
                    profile.setTextures(textures);
                    meta.setOwnerProfile(profile);
                } catch (Exception e) {
                    System.err.println("Failed to create custom player head:");
                    e.printStackTrace();
                }
                skull.setItemMeta(meta);
                return skull;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            if (texture.contains("hdb-")) {
                try {
                    return headApi.getItemHead(texture.replace("hdb-", ""));
                } catch (Exception e) {
                    texture = "mhf_question";
                }
            }
            ItemStack playerHead;
            if(AuctionMaster.upperVersion) {
                playerHead = new ItemStack(Material.getMaterial("PLAYER_HEAD"), 1);
            }
            else {
                playerHead = new ItemStack(Material.getMaterial("SKULL_ITEM"), 1, (short) 3);
            }
            SkullMeta sm = (SkullMeta) playerHead.getItemMeta();
            sm.setOwner(texture);
            playerHead.setItemMeta(sm);
            return playerHead;
        }
        return null;
    }

}
