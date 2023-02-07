package me.gv7.woodpecker.plugin;

import java.util.ArrayList;

public class HelperPluginInfo implements IHelperPlugin {
    public static IHelperPluginCallbacks callbacks;
    public static IPluginHelper pluginHelper;
    @Override
    public void HelperPluginMain(IHelperPluginCallbacks iHelperPluginCallbacks) {
        this.callbacks = iHelperPluginCallbacks;
        this.pluginHelper = callbacks.getPluginHelper();
        callbacks.setHelperPluginName("commonsFileupload");
        callbacks.setHelperPluginAutor("Xm17");
        callbacks.setHelperPluginVersion("v0.0.1");
        ArrayList<IHelper> helperPluginList = new ArrayList<>();
        helperPluginList.add(new Convert());

        callbacks.registerHelper(helperPluginList);
    }
}
