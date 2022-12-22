package com.demoDomain.teamcity.demoPlugin.controllers;

import jetbrains.buildServer.web.openapi.PagePlaces;
import jetbrains.buildServer.web.openapi.PlaceId;
import jetbrains.buildServer.web.openapi.PluginDescriptor;
import jetbrains.buildServer.web.openapi.SimpleCustomTab;
import org.jetbrains.annotations.NotNull;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


public class SakuraUIBuildPluginPage extends SimpleCustomTab {
    public SakuraUIBuildPluginPage(@NotNull PagePlaces pagePlaces,
                                   @NotNull PluginDescriptor descriptor) {
        super(pagePlaces,
                new PlaceId("SAKURA_BUILD_RESULTS@TAB"),
                Constants.TAB_ID,
                Constants.INCLUDE_URL,
                Constants.TAB_TITLE);

        register();
        addJsFile(descriptor.getPluginResourcesPath("js/main.js"));
        addCssFile(descriptor.getPluginResourcesPath("css/styles.css"));
    }

    @Override
    public boolean isAvailable(@NotNull HttpServletRequest request) {
        return true;
    }
}
