// noinspection JSUnresolvedVariable

config.devServer?.static?.push(
    __dirname + "/kotlin/"
)

// Workaround for KT-53790
config.externals = ["node:module", "."]; // TODO remove after Kotlin 1.8.20
