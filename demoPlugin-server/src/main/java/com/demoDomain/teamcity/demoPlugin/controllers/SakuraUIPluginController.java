package com.demoDomain.teamcity.demoPlugin.controllers;

import jetbrains.buildServer.controllers.BaseController;
import jetbrains.buildServer.serverSide.ProjectManager;
import jetbrains.buildServer.serverSide.SBuildType;
import jetbrains.buildServer.web.ContentSecurityPolicyConfig;
import jetbrains.buildServer.web.openapi.*;
import jetbrains.buildServer.web.openapi.PluginDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SakuraUIPluginController extends BaseController {
    private static final String PLUGIN_NAME = "SakuraUI-Plugin";
    private static final String BUNDLE_DEV_URL = "http://localhost:8080";

    private final PluginDescriptor myPluginDescriptor;

    public SakuraUIPluginController(
            @NotNull PluginDescriptor descriptor,
            @NotNull PagePlaces places,
            @NotNull WebControllerManager controllerManager,
            @NotNull final ContentSecurityPolicyConfig contentSecurityPolicyConfig
    ) {
        myPluginDescriptor = descriptor;

        String url = "/reactPlugin.html";
        final SimplePageExtension pageExtension = new SimplePageExtension(places);
        pageExtension.setPluginName(PLUGIN_NAME);
        pageExtension.setPlaceId(PlaceId.ALL_PAGES_FOOTER);
        pageExtension.setIncludeUrl(url);
        pageExtension.addCssFile("dummy-plugin.css");
        pageExtension.register();

        controllerManager.registerController(url, this);
        contentSecurityPolicyConfig.addDirectiveItems("script-src", BUNDLE_DEV_URL);
    }

    @Nullable
    @Override
    protected ModelAndView doHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) throws Exception {
        final ModelAndView mv = new ModelAndView(myPluginDescriptor.getPluginResourcesPath("react-plugin.jsp"));
        mv.getModel().put("BUNDLE_DEV_URL", BUNDLE_DEV_URL);
        return mv;
    }
}



