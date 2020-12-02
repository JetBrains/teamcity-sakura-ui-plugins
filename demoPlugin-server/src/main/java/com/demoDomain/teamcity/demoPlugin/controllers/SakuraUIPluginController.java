package com.demoDomain.teamcity.demoPlugin.controllers;

import jetbrains.buildServer.controllers.BaseController;
import jetbrains.buildServer.serverSide.ProjectManager;
import jetbrains.buildServer.serverSide.SBuildType;
import jetbrains.buildServer.web.openapi.*;
import jetbrains.buildServer.web.openapi.PluginDescriptor;
import jetbrains.buildServer.web.util.WebUtil;
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

        final SimplePageExtension sakuraPageExtension = new SimplePageExtension(places);
        sakuraPageExtension.setPluginName(PLUGIN_NAME);
        sakuraPageExtension.setPlaceId(new PlaceId("SAKURA_BEFORE_CONTENT"));
        sakuraPageExtension.setIncludeUrl(url);
        sakuraPageExtension.addCssFile("basic-plugin.css");
        sakuraPageExtension.register();

        final SimplePageExtension classicPageExtension = new SimplePageExtension(places);
        classicPageExtension.setPluginName(PLUGIN_NAME);
        classicPageExtension.setPlaceId(PlaceId.BEFORE_CONTENT);
        classicPageExtension.setIncludeUrl(url);
        classicPageExtension.addCssFile("basic-plugin.css");
        classicPageExtension.register();

        controllerManager.registerController(url, this);
    }

    @Nullable
    @Override
    protected ModelAndView doHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) throws Exception {
        final ModelAndView mv = new ModelAndView(myPluginDescriptor.getPluginResourcesPath("basic-plugin.jsp"));
        boolean isSakuraUI = WebUtil.sakuraUIOpened(request);

        String btId;

        if (isSakuraUI) {
            PluginUIContext pluginUIContext = PluginUIContext.getFromRequest(request);
            btId = pluginUIContext.getBuildTypeId();
        } else {
            btId = request.getParameter("buildTypeId");
        }

        if (btId != null) {
            SBuildType buildType = myProjectManager.findBuildTypeByExternalId(btId);
            mv.getModel().put("buildType", buildType);
        }

        return mv;
    }
}
