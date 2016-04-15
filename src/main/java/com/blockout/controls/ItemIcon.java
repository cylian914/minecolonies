package com.blockout.controls;

import com.blockout.Pane;
import com.blockout.PaneParams;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemIcon extends Pane
{
    protected static RenderItem itemRender = new RenderItem();

    private ItemStack itemStack;

    public void setItem(ItemStack itemStack) { this.itemStack = itemStack; }

    @Override
    protected void drawSelf(int mx, int my)
    {
        itemRender.renderItemAndEffectIntoGUI(itemStack, x, y);
        itemRender.renderItemOverlayIntoGUI(mc.fontRendererObj, itemStack, x, y, "");
    }
}
