package net.earthcomputer.multiconnect.packets.v1_16_1;

import it.unimi.dsi.fastutil.longs.LongArrayList;
import net.earthcomputer.multiconnect.ap.Argument;
import net.earthcomputer.multiconnect.ap.Handler;
import net.earthcomputer.multiconnect.ap.MessageVariant;
import net.earthcomputer.multiconnect.ap.Type;
import net.earthcomputer.multiconnect.ap.Types;
import net.earthcomputer.multiconnect.api.Protocols;
import net.earthcomputer.multiconnect.packets.SPacketChunkDeltaUpdate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkSectionPos;

import java.util.ArrayList;
import java.util.List;

@MessageVariant(maxVersion = Protocols.V1_16_1)
public class SPacketChunkDeltaUpdate_1_16_1 {
    @Type(Types.INT)
    public int chunkX;
    @Type(Types.INT)
    public int chunkZ;
    public Update[] updates;

    @MessageVariant(maxVersion = Protocols.V1_16_1)
    public static class Update {
        public short index;
        public int stateId;
    }

    @Handler
    public static List<SPacketChunkDeltaUpdate> handle(
            @Argument("chunkX") int chunkX,
            @Argument("chunkZ") int chunkZ,
            @Argument("updates") Update[] updates
    ) {
        int updatedSectionBitmask = 0;
        for (Update update : updates) {
            int sectionY = (update.index & 255) >> 4;
            updatedSectionBitmask |= 1 << sectionY;
        }

        BlockPos.Mutable pos = new BlockPos.Mutable();
        List<SPacketChunkDeltaUpdate> packets = new ArrayList<>();

        for (int sectionY = 0; sectionY < 16; sectionY++) {
            if ((updatedSectionBitmask & (1 << sectionY)) != 0) {
                SPacketChunkDeltaUpdate packet = new SPacketChunkDeltaUpdate();
                packets.add(packet);

                packet.sectionPos = ((long) chunkX << 42) | ((long) chunkZ << 20) | sectionY;
                packet.noLightUpdates = false;
                packet.blocks = new LongArrayList();
                for (Update update : updates) {
                    int y = update.index & 255;
                    if (y >> 4 == sectionY) {
                        int x = (update.index >> 12) & 15;
                        int z = (update.index >> 8) & 15;
                        packet.blocks.add(((long) update.stateId << 12) | ChunkSectionPos.packLocal(pos.set(x, y & 15, z)));
                    }
                }
            }
        }

        return packets;
    }
}
