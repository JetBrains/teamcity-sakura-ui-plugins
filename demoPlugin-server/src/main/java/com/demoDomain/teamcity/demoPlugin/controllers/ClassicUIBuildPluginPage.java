package com.demoDomain.teamcity.demoPlugin.controllers;

import jetbrains.buildServer.web.openapi.PagePlaces;
import jetbrains.buildServer.web.openapi.PlaceId;
import jetbrains.buildServer.web.openapi.PluginDescriptor;
import jetbrains.buildServer.web.openapi.SimpleCustomTab;
import org.jetbrains.annotations.NotNull;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


public class ClassicUIBuildPluginPage extends SimpleCustomTab {
    public ClassicUIBuildPluginPage(@NotNull PagePlaces pagePlaces,
                                    @NotNull PluginDescriptor descriptor) {
        super(pagePlaces,
                new PlaceId("BUILD_RESULTS@TAB"),
                "Sakura-Extra",
                descriptor.getPluginResourcesPath("basic-plugin.jsp"),
                "Sakura Related Tab (BT 2)");

        register();
        addJsFile(descriptor.getPluginResourcesPath("js/main.js"));
        addCssFile(descriptor.getPluginResourcesPath("css/styles.css"));
    }

    @Override
    public boolean isAvailable(@NotNull HttpServletRequest request) {
        return true;
    }

    @Override
    public void fillModel(@NotNull Map<String, Object> model, @NotNull HttpServletRequest request) {
        model.put("classicUI", true);
    }
}
