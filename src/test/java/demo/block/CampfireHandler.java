package demo.block;

import net.minestom.server.entity.Player;
import net.minestom.server.instance.Instance;
import net.minestom.server.instance.block.BlockHandler;
import net.minestom.server.item.ItemStack;
import net.minestom.server.item.Material;
import net.minestom.server.registry.Registries;
import net.minestom.server.tag.Tag;
import net.minestom.server.tag.TagReadable;
import net.minestom.server.tag.TagSerializer;
import net.minestom.server.tag.TagWritable;
import net.minestom.server.utils.BlockPosition;
import net.minestom.server.utils.NamespaceID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jglrxavpok.hephaistos.nbt.NBT;
import org.jglrxavpok.hephaistos.nbt.NBTCompound;
import org.jglrxavpok.hephaistos.nbt.NBTList;
import org.jglrxavpok.hephaistos.nbt.NBTTypes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CampfireHandler implements BlockHandler {

    public static final Tag<List<ItemStack>> ITEMS = Tag.Custom("Items", new TagSerializer<>() {

        private final Tag<NBT> internal = Tag.NBT("Items");

        @Override
        public @Nullable List<ItemStack> read(@NotNull TagReadable reader) {
            NBTList<NBTCompound> item = (NBTList<NBTCompound>) reader.getTag(internal);
            List<ItemStack> result = new ArrayList<>();
            assert item != null;
            item.forEach(nbtCompound -> {
                int amount = nbtCompound.getAsByte("Count");
                String id = nbtCompound.getString("id");
                Material material = Registries.getMaterial(id);
                result.add(ItemStack.of(material, amount));
            });
            return result;
        }

        @Override
        public void write(@NotNull TagWritable writer, @NotNull List<ItemStack> value) {
            NBTList<NBTCompound> items = new NBTList<>(NBTTypes.TAG_Compound);
            for (var item : value) {
                NBTCompound compound = new NBTCompound()
                        .setByte("Count", (byte) item.getAmount())
                        .setByte("Slot", (byte) 1)
                        .setString("id", item.getMaterial().getNamespaceID().asString());
                items.add(compound);
            }
            writer.setTag(internal, items);
        }
    });

    @Override
    public void onPlace(@NotNull Instance instance, @NotNull BlockPosition blockPosition) {

    }

    @Override
    public void onDestroy(@NotNull Instance instance, @NotNull BlockPosition blockPosition) {

    }

    @Override
    public boolean onInteract(@NotNull Player player, Player.@NotNull Hand hand, @NotNull BlockPosition blockPosition) {
        return false;
    }

    @Override
    public @NotNull Collection<Tag<?>> getBlockEntityTags() {
        return List.of(ITEMS);
    }

    @Override
    public @NotNull NamespaceID getNamespaceId() {
        return NamespaceID.from("minestom:test");
    }
}
