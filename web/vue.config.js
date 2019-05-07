const webpack = require("webpack")
module.exports = {
    outputDir: '../src/main/resources/static',
    baseUrl: '/manager/',
    // devServer: devServer,
    configureWebpack: {
        // devServer : {
        //     port: 8083,
        //     disableHostCheck: true,
        //     proxy: {
        //         '/manager/service': {
        //             target: 'http://localhost:8080/',
        //             changeOrigin: true // target是域名的话，需要这个参数，
        //         }
        //     }
        // },
        plugins: [
            new webpack.ProvidePlugin({
                $: "jquery",
                jQuery: "jquery",
                "windows.jQuery": "jquery"
            })
        ]
    },
}