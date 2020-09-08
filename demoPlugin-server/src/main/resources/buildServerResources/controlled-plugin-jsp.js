(() => {
    console.log("My Controlled plugin script from a JSP file");

    const plugin = TeamCityAPI.pluginRegistry.searchByPlaceId("SAKURA_PROJECT_BEFORE_CONTENT", "SakuraUI-Plugin")

    const template = (context) => `<div class="controlled-plugin-wrapper">Here is a controlled plugin.${JSON.stringify(context)}</div>`

    plugin.onContextUpdate((context) => {
        plugin.replaceContent(template(context))
    })
})()
