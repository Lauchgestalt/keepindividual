package com.callmeperky.keepindividualspigot;

import com.sun.org.apache.xpath.internal.operations.Bool;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;
import net.luckperms.api.model.user.UserManager;
import net.luckperms.api.node.Node;
import net.luckperms.api.node.types.PermissionNode;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class LuckPermsHandler {
    RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
    LuckPerms api;
    UserManager userManager;
    public LuckPermsHandler() {
        if (provider != null) {
            api = provider.getProvider();
            userManager = api.getUserManager();
        }
    }

    public Optional<Boolean> hasPermission(UUID uuid, String permission){
        User user = api.getUserManager().loadUser(uuid).join();
        if (user == null) {
            return Optional.empty();
        } else {
            boolean hasPermission = user.getCachedData().getPermissionData().checkPermission(permission).asBoolean();
            return Optional.of(hasPermission);
        }
    }

    public Optional<Boolean> hasPermission(Player player, String permission){
        return hasPermission(player.getUniqueId(), permission);
    }

    public Optional<Boolean> hasPermission(String name, String permission){
        return hasPermission(getUUID(name), permission);
    }

    public UUID getUUID(String name){
        CompletableFuture<UUID> uuid = userManager.lookupUniqueId(name);
        return uuid.join();
    }

    public void setPermission(UUID uuid, String permission, boolean value){
        User user = api.getUserManager().loadUser(uuid).join();
        PermissionNode node = PermissionNode.builder().permission(permission).value(value).build();
        user.data().add(node);
        api.getUserManager().saveUser(user);
    }
}
