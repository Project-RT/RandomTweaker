package ink.ikx.rt.impl.client.network;

import ink.ikx.rt.impl.client.capability.PlayerSanityCapability;
import ink.ikx.rt.impl.utils.cap.PlayerSanityHelper;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLEventChannel;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.internal.FMLProxyPacket;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PlayerSanityNetWork {

    public static void register() {
        Sanity.CHANNEL.register(Sanity.class);
    }

    public static class Sanity {

        private static final String NAME = "PLAYERSANITY";
        private static final FMLEventChannel CHANNEL = NetworkRegistry.INSTANCE
            .newEventDrivenChannel(NAME);

        public static void sendClientCustomPacket(EntityPlayer player) {
            PacketBuffer buffer = new PacketBuffer(Unpooled.buffer());
            PlayerSanityCapability sanityCap = PlayerSanityHelper.getPlayerSanity(player);

            buffer.writeFloat(sanityCap.getSanity());
            buffer.writeInt(sanityCap.getOriginalSanity());

            CHANNEL.sendTo(new FMLProxyPacket(buffer, NAME), (EntityPlayerMP) player);
        }

        @SubscribeEvent
        @SideOnly(Side.CLIENT)
        public static void onClientCustomPacket(FMLNetworkEvent.ClientCustomPacketEvent event) {
            ByteBuf buffer = event.getPacket().payload();
            float sanity = buffer.readFloat();
            int oSanity = buffer.readInt();

            Minecraft mc = Minecraft.getMinecraft();
            mc.addScheduledTask(() -> {
                EntityPlayer player = mc.player;
                PlayerSanityCapability sanityCap = PlayerSanityHelper.getPlayerSanity(player);

                sanityCap.setSanity(sanity);
                sanityCap.setOriginalSanity(oSanity);
            });
        }
    }
}
