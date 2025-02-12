package acme.critical.module.misc;

import net.minecraft.text.Text;
import acme.critical.module.Mod;
import acme.critical.utils.ChatUtils;
import acme.critical.utils.FriendsUtils;
import net.minecraft.entity.player.PlayerEntity;
import acme.critical.module.settings.KeybindSetting;

public class Friend extends Mod {

    public Friend() {
        super("Friend", "Adds/Removes a player from your friends list.", Category.MISC);
        addSetting(new KeybindSetting("Key", 0));
    }

    @Override
    public void onEnable() {
        Boolean added = false;
        String addedstr;
        if(mc.targetedEntity != null && mc.targetedEntity instanceof PlayerEntity) {
            String entityName = mc.targetedEntity.getEntityName();

            if(!FriendsUtils.friends.contains(entityName)) {
                FriendsUtils.friends.add(entityName);
                added = true;
            }
            else if (FriendsUtils.friends.contains(entityName)) {
                FriendsUtils.friends.remove(entityName);
            }

            addedstr = added ? " \u00a7aAdded" : " \u00a74Removed";
            ChatUtils.message(entityName + addedstr);
        } else {ChatUtils.warn("Look at player!");}

        setEnabled(false);
    }
}
