package com.tnozamas.minecraftplugin.Commands;

import com.tnozamas.minecraftplugin.Util.HexTranslate;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.regex.Pattern;

import static com.tnozamas.minecraftplugin.Osiris.prefix;

public class ItemRename implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("rename")) {
            if (!(sender instanceof Player)) {
                Bukkit.getConsoleSender().sendMessage(HexTranslate.color(prefix() + "&cThis command can't be executed by a console"));
            }
            else {
                Player player = (Player) sender;

                if (args.length == 0) {
                    player.sendMessage(HexTranslate.color(prefix() + "&cPlis set a name using: /rename [name]"));
                }
                if (args.length >= 1) {

                    ItemStack handItem = player.getItemInHand();
                    ItemMeta itemMeta = handItem.getItemMeta();

                    String renameStr = "";
                    for (int i = 0; i < args.length; i++) {
                        renameStr += args[i] + " ";
                    }
                    try {
                        renameStr = HexTranslate.color(renameStr);
                        itemMeta.setDisplayName(renameStr);
                        player.sendMessage(HexTranslate.color(prefix() + "&aThe item has been successfully renamed"));
                    } catch (Exception e) {
                        player.sendMessage(HexTranslate.color(prefix() + "&cAn error occurred while renaming the item"));
                    }
                }
            }
        }
        return true;
    }

    //Insertar nombre al item
    //Checkear una vez transformado el item si tiene más de 32 chars
    //Si no, sigue normal


}
