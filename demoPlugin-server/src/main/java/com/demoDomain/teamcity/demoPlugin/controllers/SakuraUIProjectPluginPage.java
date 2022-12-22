package com.demoDomain.teamcity.demoPlugin.controllers;

import com.intellij.openapi.diagnostic.Logger;
import jetbrains.buildServer.controllers.ProjectFinder;
import jetbrains.buildServer.serverSide.ProjectManager;
import jetbrains.buildServer.serverSide.ProjectNotFoundException;
import jetbrains.buildServer.serverSide.SProject;
import jetbrains.buildServer.web.openapi.*;
import org.jetbrains.annotations.NotNull;

import javax.servlet.http.HttpServletRequest;


public class SakuraUIProjectPluginPage extends SimpleCustomTab {
    private final ProjectManager projectManager;
    private static final Logger LOG = Logger.getInstance(SakuraUIProjectPluginPage.class.getName());

    public SakuraUIProjectPluginPage(@NotNull PagePlaces pagePlaces,
                                     @NotNull PluginDescriptor descriptor,
                                     @NotNull ProjectManager projectManager) {
        super(pagePlaces,
                new PlaceId("SAKURA_PROJECT@TAB"),
                Constants.TAB_ID,
                Constants.INCLUDE_URL,
                Constants.TAB_TITLE);

        register();
        addJsFile(descriptor.getPluginResourcesPath("js/main.js"));
        addCssFile(descriptor.getPluginResourcesPath("css/styles.css"));
        this.projectManager = projectManager;
    }

    @Override
    public boolean isAvailable(@NotNull HttpServletRequest request) {
        /*
          This is an example of conditional rendering tabs, depending on the projectId.
          The same approach could be used for the Build, Build Configuration and other places
          Render the plugin only for the projects, which name starts with letter 'A'.
          */

        try {
            final SProject project = new ProjectFinder(request, projectManager).getProject();
            LOG.warn("SAKURA UI TAB: " + project.getName());
            return super.isAvailable(request) && project.getName().startsWith("A");
        } catch (ProjectNotFoundException e) {
            return false;
        }
    }
}
