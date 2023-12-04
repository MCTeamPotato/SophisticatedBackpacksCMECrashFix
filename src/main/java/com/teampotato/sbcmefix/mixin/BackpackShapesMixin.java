package com.teampotato.sbcmefix.mixin;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.p3pp3rf1y.sophisticatedbackpacks.backpack.BackpackShapes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Mixin(value = BackpackShapes.class, remap = false)
public abstract class BackpackShapesMixin {
    @Mutable @Shadow @Final private static Map<Integer, VoxelShape> SHAPES;

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void concurrentMapInitialization(CallbackInfo ci) {
        SHAPES = new ConcurrentHashMap<>(SHAPES);
    }
}
