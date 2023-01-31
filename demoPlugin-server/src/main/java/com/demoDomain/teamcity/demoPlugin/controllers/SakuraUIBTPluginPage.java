package com.demoDomain.teamcity.demoPlugin.controllers;

import jetbrains.buildServer.web.openapi.PagePlaces;
import jetbrains.buildServer.web.openapi.PlaceId;
import jetbrains.buildServer.web.openapi.PluginDescriptor;
import jetbrains.buildServer.web.openapi.SimpleCustomTab;
import org.jetbrains.annotations.NotNull;

import javax.servlet.http.HttpServletRequest;


public class SakuraUIBTPluginPage extends SimpleCustomTab {
    public SakuraUIBTPluginPage(@NotNull PagePlaces pagePlaces,
                                @NotNull PluginDescriptor descriptor) {
        super(pagePlaces,
                new PlaceId("SAKURA_BUILD_CONF@TAB"),
                "Sakura",
                descriptor.getPluginResourcesPath("basic-plugin.jsp"),
                "Sakura Related Tab (BT)");

        register();
        addJsFile(descriptor.getPluginResourcesPath("js/main.js"));
        addCssFile(descriptor.getPluginResourcesPath("css/styles.css"));
    }

    @Override
    public boolean isAvailable(@NotNull HttpServletRequest request) {
        return true;
    }
}
