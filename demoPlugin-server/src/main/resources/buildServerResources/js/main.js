(function() {
  console.log("Initialize Sakura UI Plugin as a page. Update context");

  const TabPlugin = TeamCityAPI.TabPlugin;

  const plugin = new TabPlugin({
    name: "bla-bla",
    content: "<span>Hello there</span>",
    options: {debug: true}
  });
})()
