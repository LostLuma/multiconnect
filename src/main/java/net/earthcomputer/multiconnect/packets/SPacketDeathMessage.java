package net.earthcomputer.multiconnect.packets;

import net.earthcomputer.multiconnect.ap.MessageVariant;
import net.earthcomputer.multiconnect.ap.Type;
import net.earthcomputer.multiconnect.ap.Types;

@MessageVariant
public class SPacketDeathMessage {
    public int playerId;
    @Type(Types.INT)
    public int entityId;
    public CommonTypes.Text message;
}
