package net.earthcomputer.serverblocktypebreakrestriction.mixin;

import net.earthcomputer.serverblocktypebreakrestriction.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public class PlayerMixin {
    @Inject(method = "blockActionRestricted", at = @At("HEAD"), cancellable = true)
    private void onBlockActionRestricted(Level level, BlockPos pos, GameType gameMode, CallbackInfoReturnable<Boolean> cir) {
        if (level.getBlockState(pos).is(ModTags.RESTRICTED)) {
            cir.setReturnValue(true);
        }
    }
}
