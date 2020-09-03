package com.demoDomain.teamcity.demoPlugin.controllers;

import jetbrains.buildServer.controllers.BaseController;
import jetbrains.buildServer.serverSide.ProjectManager;
import jetbrains.buildServer.serverSide.SBuildType;
import jetbrains.buildServer.web.openapi.*;
import jetbrains.buildServer.web.openapi.PluginDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SakuraUIPluginController extends BaseController {
    private static final String PLUGIN_NAME = "SakuraUI-Plugin";
    private final PluginDescriptor myPluginDescriptor;
    private final ProjectManager myProjectManager;

    public SakuraUIPluginController(
        @NotNull PluginDescriptor descriptor,
        @NotNull PagePlaces places,
        @NotNull WebControllerManager controllerManager,
        @NotNull ProjectManager projectManager
        ) {
        myPluginDescriptor = descriptor;
        myProjectManager = projectManager;

        String url = "/demoPlugin.html";
        final SimplePageExtension pageExtension = new SimplePageExtension(places);
        pageExtension.setPluginName(PLUGIN_NAME);
        pageExtension.setPlaceId(PlaceId.SAKURA_BEFORE_CONTENT);
        pageExtension.setIncludeUrl(url);
        pageExtension.addCssFile("basic-plugin.css");
        pageExtension.register();

        controllerManager.registerController(url, this);
    }

    @Nullable
    @Override
    protected ModelAndView doHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) throws Exception {
        final ModelAndView mv = new ModelAndView(myPluginDescriptor.getPluginResourcesPath("basic-plugin.jsp"));
        PluginUIContext pluginUIContext = PluginUIContext.getFromRequest(request);
        String btId = pluginUIContext.getBuildTypeId();
        if (btId != null) {
            SBuildType buildType = myProjectManager.findBuildTypeByExternalId(btId);
            mv.getModel().put("buildType", buildType);
        }
        return mv;
    }
}
