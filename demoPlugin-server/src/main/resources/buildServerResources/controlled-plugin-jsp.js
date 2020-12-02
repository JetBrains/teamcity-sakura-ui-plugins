(() => {
    console.log("Controlled Plugin. Script invoked from the controlled-plugin-jsp.js");
    const name = "SakuraUI-Plugin";
    const container = document.getElementById(name);

    const plugin =  new TeamCityAPI.Plugin(["SAKURA_BUILD_OVERVIEW", "BUILD_RESULTS_FRAGMENT"], {
        name,
        content: container,
        options: {debug:true},
    })

    const template = (context) => `<div>There is a location context: ${JSON.stringify(context)}</div>`

    plugin.onContextUpdate((context) => {
        container.classList.remove("hidden");
        const dynamicPart = container.querySelector(".js-dynamic-part");

        if (dynamicPart == null) {
            return;
        }

        while (dynamicPart.firstChild) {
            dynamicPart.firstChild.remove();
        }


        console.log("Controlled Plugin. On Context Update event fired.")
        dynamicPart.insertAdjacentHTML('afterbegin', template(context));
    })
})()
