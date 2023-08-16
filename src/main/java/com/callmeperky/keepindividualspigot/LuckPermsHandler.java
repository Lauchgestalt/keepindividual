package com.callmeperky.keepindividualspigot;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;
import net.luckperms.api.model.user.UserManager;
import net.luckperms.api.node.types.PermissionNode;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class LuckPermsHandler {
    RegisteredServiceProvider<LuckPerms> provider;
    LuckPerms api;
    UserManager userManager;
    public LuckPermsHandler() {
        provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        assert provider != null;
        api = provider.getProvider();
        userManager = api.getUserManager();
    }

    public UUID getUUID(String name){
        CompletableFuture<UUID> uuid = api.getUserManager().lookupUniqueId(name);
        return uuid.join();
    }

    public void setPermission(UUID uuid, String permission, boolean value){
        User user = api.getUserManager().loadUser(uuid).join();
        PermissionNode node = PermissionNode.builder().permission(permission).value(value).build();
        user.data().add(node);
        api.getUserManager().saveUser(user);
    }

    public CompletableFuture<Boolean> hasPermission(UUID uuid, String permission){
        return api.getUserManager().loadUser(uuid).thenApplyAsync(user -> {
            if (user == null) {
                return false;
            } else {
                return user.getCachedData().getPermissionData().checkPermission(permission).asBoolean();
            }
        });
    }

    public CompletableFuture<Boolean> hasPermission(String player, String permission){
        return hasPermission(getUUID(player), permission);
    }

    public CompletableFuture<List<String>> getUsersWithPermission(String permission) {
        CompletableFuture<List<String>> resultFuture = new CompletableFuture<>();

        api.getGroupManager().loadAllGroups().thenAcceptAsync(groups -> {
            List<String> usersWithPermission = new ArrayList<>();

            for (User user : userManager.getLoadedUsers()) {
                    usersWithPermission.add(user.getUsername() + ": " + user.getCachedData().getPermissionData().checkPermission(permission).asBoolean());
            }

            resultFuture.complete(usersWithPermission);
        });

        return resultFuture;
    }

}
