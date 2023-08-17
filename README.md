# KeepIndividual

A Spigot plugin that allows you to keep track of individual users, that should keep their inventory after death.
This allows you to customize your Minecraft experience and fit everyones needs.

### Dependencies

For this plugin to work, you have to use the LuckPerms Permission Manager, since KeepIndividual uses Permissions to track users.

### Commands
*Admins:*
- `/ki toggle <User>` - Adds/removes the user to keep inventory list
- `/ki list` - List all users in your database and the current setting for keepinventory
- `/ki allowself <true/false>` - Allow/Forbid users to add/remove themselves to/from the list of users
- `/ki setdefault <true/false>` - Sets if users should automatically be added to the list upon joining the server for the first time

*Users:*
- `/ki toggleself` - Toggles your own setting. Adds/removes you from the list of users

### Keep in mind
To decide if players should automatically receive the permission to keep their inventory, when installing this plugin for the first time it takes it's default value from the current keepinventory gamerule setting and then sets the gamerule value to false.
You can always change it via the `/ki setdefault <true/false>` command.
If you decide to uninstall this plugin, make sure to check the gamerule setting and turn it back on, if needed.
