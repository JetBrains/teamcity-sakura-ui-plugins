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
        new SimplePageExtension(places, PlaceId.ALL_PAGES_FOOTER, PLUGIN_NAME, descriptor.getPluginResourcesPath("controlled-plugin.jsp"))
                .addCssFile("controlled-plugin.css")
                // There is an option to load the script using the Java Controller's 'addJsFile'.
                // We recommend to use the JSP based loading (see the controlled-plugin.jsp) though
                // to make it more clear where the script came from.
                .addJsFile("controlled-plugin-core.js")
                .register();
    }
}
