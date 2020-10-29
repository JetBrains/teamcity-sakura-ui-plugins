package com.demoDomain.teamcity.demoPlugin.controllers;

import jetbrains.buildServer.web.openapi.*;
import jetbrains.buildServer.web.openapi.PluginDescriptor;
import org.jetbrains.annotations.NotNull;

public class SakuraUIPluginController {
    private static final String PLUGIN_NAME = "SakuraUI-Plugin";

    public SakuraUIPluginController(
            @NotNull PluginDescriptor descriptor,
            @NotNull PagePlaces places
            ) {

        // For the Sakura UI we register the Plugin using the SAKURA-prefixed PlaceIDs. Keep in mind the new syntax:
        // new PlaceID(String) - constructor accepts any string. Plugins for SAKURA-prefixed PlaceIDs are available only
        // in the Sakura UI and are loading asynchronously.
        new SimplePageExtension(places, new PlaceId("SAKURA_BEFORE_CONTENT"), PLUGIN_NAME, descriptor.getPluginResourcesPath("basic-plugin.jsp")).addCssFile("basic-plugin.css").register();

        // For the Classic UI we continue using the regular PlaceIds. Those plugins are rendered on the Server
        // and, generally speaking, stay the same, as they were the last decade
        new SimplePageExtension(places, PlaceId.BEFORE_CONTENT, PLUGIN_NAME, descriptor.getPluginResourcesPath("basic-plugin.jsp")).addCssFile("basic-plugin.css").register();
    }
}
