package me.gv7.woodpecker.plugin;

public class WoodpeckerPluginManager implements IPluginManager{
    @Override
    public void registerPluginManagerCallbacks(IPluginManagerCallbacks iPluginManagerCallbacks) {

        // register helper plugin
        iPluginManagerCallbacks.registerHelperPlugin(new HelperPluginInfo());
    }
}
