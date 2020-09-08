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
        new SimplePageExtension(places, PlaceId.SAKURA_PROJECT_BEFORE_CONTENT, PLUGIN_NAME, descriptor.getPluginResourcesPath("controlled-plugin.jsp"))
                .addCssFile("controlled-plugin.css")
                .addJsFile("controlled-plugin-core.js")
                .register();
    }
}
